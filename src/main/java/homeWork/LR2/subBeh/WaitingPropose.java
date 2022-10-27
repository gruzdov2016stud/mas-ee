package homeWork.LR2.subBeh;

import homeWork.LR2.Data;
import homeWork.LR2.SenderBeh;
import jade.core.Agent;
import jade.core.behaviours.Behaviour;
import jade.core.behaviours.ParallelBehaviour;
import jade.core.behaviours.WakerBehaviour;
import jade.lang.acl.ACLMessage;
import jade.lang.acl.MessageTemplate;

public class WaitingPropose extends ParallelBehaviour {

    Data data;

    Behaviour waiting, waker;

    boolean end = false;

    public WaitingPropose(Agent agent, Data data) {
        super(agent, WHEN_ANY);
        this.data = data;

        waiting = new Behaviour() {
            @Override
            public void action() {
                MessageTemplate mt = MessageTemplate.MatchPerformative(ACLMessage.PROPOSE);
                ACLMessage receive = getAgent().receive(mt);
                if (receive != null){
                    String[] content = receive.getContent().split(";");
                    double x = Double.parseDouble(content[0]);
                    double delta = Double.parseDouble(content[1]);

                    data.setX(x);
                    data.setDelta(delta);

                    getAgent().addBehaviour(new SenderBeh(data));

                    // Данное действие заканчивает поведение ReceiverBeh
                    data.setEndReceiverBeh(true);
                }
            }

            @Override
            public boolean done() {
                return end;
            }
        };

        waker = new WakerBehaviour(getAgent(), 2000) {
            @Override
            protected void onWake() {
                System.out.println(getAgent().getLocalName() + ": Нет перехода поведения");
            }
        };

        addSubBehaviour(waiting);
        addSubBehaviour(waker);


    }
}
