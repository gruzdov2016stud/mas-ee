package homeWork.LR2;

import homeWork.LR2.enums.States;
import homeWork.LR2.subBeh.BehaviourTransition;
import homeWork.LR2.subBeh.Calculation;
import homeWork.LR2.subBeh.SendingInfoWaker;
import homeWork.LR2.subBeh.WaitingInfo;
import jade.core.behaviours.FSMBehaviour;
import jade.core.behaviours.OneShotBehaviour;

public class SenderBeh extends FSMBehaviour {

    private Data data;

    public SenderBeh(Data data) {
        this.data = data;
        // Отправка сообщения с текущим значение X и delta
        registerFirstState(new SendingInfoWaker(getAgent(), 3000, data), States.SendingInfo.toString());

        // Ожидание ответа от других агентов с тремя рассчитанными значениями
        registerState(new WaitingInfo(getAgent(), data), States.WaitingInfo.toString());
        registerDefaultTransition(States.SendingInfo.toString(), States.WaitingInfo.toString());

        // При отсутствии ответа, повторно запускает SenderBeh
        registerLastState(new OneShotBehaviour() {
            @Override
            public void action() {
                System.out.println(getAgent().getLocalName() + ": There is no answer");
                getAgent().addBehaviour(new SenderBeh(data));
            }
        }, States.NoAnswer.toString());

        // Если ответ от других агентов был получен, то поведение продолжается
        registerTransition(States.WaitingInfo.toString(), States.Calculation.toString(), 1);
        // Если ответ не получен, то поведение SenderBeh запускается повторно
        registerTransition(States.WaitingInfo.toString(), States.NoAnswer.toString(), 2);

        // Рассчёт трёх значений целевой функции для агента, выполняющего данное поведение
        registerState(new Calculation(data, data.getX(), data.getDelta()), States.Calculation.toString());

        // Получение суммарного значения целевых функций
        registerState(new OneShotBehaviour() {
            @Override
            public void action() {
                double resultMin = data.getResultMin();
                resultMin += data.getResultMinus();
                double resultCur = data.getResultCur();
                resultCur += data.getResult();
                double resultPl = data.getResultPl();
                resultPl += data.getResultPlus();

                data.setResultMin(resultMin);
                data.setResultCur(resultCur);
                data.setResultPl(resultPl);

                System.out.println(getAgent().getLocalName() + ": Минус " + data.getResultMin() + ", Текущее " + data.getResultCur() + ", Плюс " + data.getResultPl());
            }
        }, States.WholeCalculation.toString());
        registerDefaultTransition(States.Calculation.toString(), States.WholeCalculation.toString());


        // Поведение принятия решения
        registerState(new OneShotBehaviour() {

            int end = 0;

            @Override
            public void action() {

                if (data.getResultMin() < data.getResultCur() && data.getResultCur() < data.getResultPl()) {
                    // увеличить Х
                    double x = data.getX();
                    x += data.getDelta();
                    data.setX(x);
                    end = 1;
                    System.out.println(getAgent().getLocalName() + ": Увеличился X");

                } else if (data.getResultPl() < data.getResultCur() && data.getResultCur() < data.getResultMin()) {
                    // уменьшить Х
                    double x = data.getX();
                    x -= data.getDelta();
                    data.setX(x);
                    end = 1;
                    System.out.println(getAgent().getLocalName() + ": Уменьшился X");

                } else if (data.getResultMin() < data.getResultCur() && data.getResultPl() < data.getResultCur()){
                    // уменьшить delta
                    double delta = data.getDelta()/2;
                    if (delta <= 0.01){
                        end = 2;
                    } else if (delta > 0.01){
                        data.setDelta(delta);
                        end = 1;
                        System.out.println(getAgent().getLocalName() + ": Уменьшилась delta");
                    }

                } else if (data.getResultCur() < data.getResultMin() && data.getResultCur() < data.getResultPl()){
                    // Надо изменить x и delta
                    end = 3;
                }
            }
            @Override
            public int onEnd() {
                return end;
            }
        }, States.MakingDecision.toString());
        registerDefaultTransition(States.WholeCalculation.toString(), States.MakingDecision.toString());

        registerTransition(States.MakingDecision.toString(), States.BehaviourTransition.toString(), 1);
        registerTransition(States.MakingDecision.toString(), States.Ending.toString(), 2);
        registerTransition(States.MakingDecision.toString(), States.Minimum.toString(), 3);

        // При удачном выполении всех предыдущих поведений запускается поведение передачи SenderBeh другому агенту
        registerState(new BehaviourTransition(data), States.BehaviourTransition.toString());

        // При достаточной точности переменной delta поведение заканчивается и выводится ответ с окончательными X и delta
        registerLastState(new OneShotBehaviour() {
            @Override
            public void action() {
                System.out.println("\n" + getAgent().getLocalName() + ": Ответ x = " + data.getX() + "\n");
            }
        }, States.Ending.toString());

        // При изначально неудачно выбранных X и delta, поведение заканчивается и предлагает изменить эти параметры
        registerLastState(new OneShotBehaviour() {
            @Override
            public void action() {
                System.out.println("\n" + getAgent().getLocalName() + ": Выберите другие X и Delta" + "\n");
            }
        }, States.Minimum.toString());

        // После передачи поведения SenderBeh запускает у данного агента поведение ReceiverBeh
        registerLastState(new OneShotBehaviour() {
            @Override
            public void action() {
                // Данная строка необходима для тех агентов, которые закончили ReceiverBeh после передачи им SenderBeh,
                //  если не изменить поле endReceiverBeh, то только что запущенное поведение
                // ReceiverBeh сразу же закончится (меняем параметр done();)
                data.setEndReceiverBeh(false);
                getAgent().addBehaviour(new ReceiverBeh(data));
                System.out.println(getAgent().getLocalName() + ": Я не отправитель");
            }
        }, States.DeletingBehaviour.toString());
        registerDefaultTransition(States.BehaviourTransition.toString(), States.DeletingBehaviour.toString());
    }
}
