package homeWork.LR2;

import jade.core.Agent;
import jade.core.behaviours.WakerBehaviour;
import jade.domain.DFService;
import jade.domain.FIPAAgentManagement.DFAgentDescription;
import jade.domain.FIPAException;

public class Agents extends Agent {


    @Override
    protected void setup() {
        Double x = -40.0;
        Double delta = 5.0;

        System.out.println(this.getLocalName() + ": I am here");

        Data data = new Data();

        data.setX(x);
        data.setDelta(delta);
        if (this.getLocalName().equals("Giper")) {
            addBehaviour(new WakerBehaviour(this, 1000) { // Для того чтобы успеть открыть Sniffer в GUI
                @Override
                protected void onWake() {
                    addBehaviour(new SenderBeh(data));
                }
            });
        }
        if (this.getLocalName().equals("Quadratic")) {
            addBehaviour(new ReceiverBeh(data));
        }
        if (this.getLocalName().equals("Cos")) {
            addBehaviour(new ReceiverBeh(data));
        }

        this.registration();

    }

    public void registration() {
        DFAgentDescription dfd = new DFAgentDescription();
        dfd.setName(getAID());
        try {
            DFService.register(this, dfd);
        } catch (FIPAException e) {
            e.printStackTrace();
        }
    }
}
