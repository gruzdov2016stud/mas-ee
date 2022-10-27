package homeWork.LR2;

import homeWork.LR2.subBeh.Calculation;
import homeWork.LR2.subBeh.WaitingPropose;
import jade.core.behaviours.Behaviour;
import jade.core.behaviours.WakerBehaviour;
import jade.lang.acl.ACLMessage;
import jade.lang.acl.MessageTemplate;

public class ReceiverBeh extends Behaviour {

    Data data;

    public ReceiverBeh(Data data) {
        this.data = data;
    }

    @Override
    public void action() {
        MessageTemplate mt = MessageTemplate.MatchPerformative(ACLMessage.REQUEST);
        ACLMessage receive = getAgent().receive(mt);
        if (receive != null){
            String content = receive.getContent();
            String[] con = content.split(";");

            Double x = Double.parseDouble(con[0]);
            Double delta = Double.parseDouble(con[1]);

            // Расчёт трёх значений целевой функции
            getAgent().addBehaviour(new Calculation(data, x, delta));
            getAgent().addBehaviour(new WakerBehaviour(getAgent(), 200) { // Waker нужен чтобы успело сработать Calculation Behaviour
                @Override
                protected void onWake() {
                    // Отправка сообщения с тремя значениями целевой функции
                    ACLMessage msg = new ACLMessage(ACLMessage.INFORM);
                    msg.addReceiver(receive.getSender());
                    msg.setContent(data.getResultMinus() + ";" + data.getResult() + ";" + data.getResultPlus());
                    getAgent().send(msg);

                    // Поведение получения сообщения о передачи SenderBeh
                    getAgent().addBehaviour(new WaitingPropose(getAgent(), data));

                }
            });
        } else{
            block();
        }
    }

    @Override
    public boolean done() {
        return data.isEndReceiverBeh();
    }
}
