package homeWork.LR2.subBeh;

import homeWork.LR2.Data;
import jade.core.Agent;
import jade.core.behaviours.Behaviour;
import jade.core.behaviours.ParallelBehaviour;
import jade.core.behaviours.WakerBehaviour;
import jade.lang.acl.ACLMessage;
import jade.lang.acl.MessageTemplate;


public class WaitingInfo extends ParallelBehaviour {

    Behaviour waiting, waker;

    Data data;

    private boolean end = false;

    public WaitingInfo(Agent a, Data data) {
        super(a, WHEN_ANY);
        this.data = data;

        waiting = new Behaviour() {
            @Override
            public void action() {

                MessageTemplate mt = MessageTemplate.MatchPerformative(ACLMessage.INFORM);
                ACLMessage receive = getAgent().receive(mt);
                if (receive != null) {

                    String[] content = receive.getContent().split(";");

                    double resultMin = data.getResultMin();
                    double resultCur = data.getResultCur();
                    double resultPl = data.getResultPl();

                    System.out.println(getAgent().getLocalName() + ": полученные " + content[0] + " " + content[1] + " " + content[2]);
                    System.out.println(getAgent().getLocalName() + ": resultMin перед изменением " + resultMin);

                    // Прибавление полученного значения к общей сумме
                    resultMin += Double.parseDouble(content[0]);
                    resultCur += Double.parseDouble(content[1]);
                    resultPl += Double.parseDouble(content[2]);

                    data.setResultMin(resultMin);
                    System.out.println(getAgent().getLocalName() +": resultMin после изменения " + resultMin);
                    data.setResultCur(resultCur);
                    data.setResultPl(resultPl);

                    // При получении хотя бы одного ответа данная переменная изменяет своё значение, что свидетельствует о получении ответа
                    end = true;
                }
            }

            @Override
            public boolean done() {
                return false;
            }
        };
        waker = new WakerBehaviour(getAgent(), 1000) {
            @Override
            protected void onWake() {
                System.out.println(getAgent().getLocalName() + ": время для ответа закончилось");
            }
        };
        addSubBehaviour(waiting);
        addSubBehaviour(waker);
    }

    @Override
    public int onEnd() {
        return end ? 1 : 2;
    }
}
