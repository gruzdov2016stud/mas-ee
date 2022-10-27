package homeWork.LR2.subBeh;

import homeWork.LR2.Data;
import jade.core.AID;
import jade.core.behaviours.OneShotBehaviour;
import jade.domain.DFService;
import jade.domain.FIPAAgentManagement.DFAgentDescription;
import jade.domain.FIPAException;
import jade.lang.acl.ACLMessage;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class BehaviourTransition extends OneShotBehaviour {

    Data data;

    public BehaviourTransition(Data data) {
        this.data = data;
    }

    @Override
    public void action() {
        Random random = new Random();

        List<AID> agents = new ArrayList<>();
        DFAgentDescription dfd = new DFAgentDescription();
        try {
            DFAgentDescription[] result = DFService.search(getAgent(), dfd);
            for (DFAgentDescription res : result) {
                agents.add(res.getName());
            }

        } catch (FIPAException e) {
            e.printStackTrace();
        }

        List<AID> agentsWithoutMe = new ArrayList<>();
        for (AID aid : agents) {
            if (getAgent().getAID().equals(aid)){
                continue;
            }
            agentsWithoutMe.add(aid);
        }

        // Рандомный выбор агента - получателя
        int arraySize = agentsWithoutMe.size();
        int receiver = random.nextInt(arraySize);

        ACLMessage msg = new ACLMessage(ACLMessage.PROPOSE);
        msg.setContent(data.getX() + "; " + data.getDelta());
        msg.addReceiver(agentsWithoutMe.get(receiver));
        getAgent().send(msg);
        System.out.println(getAgent().getLocalName() + ": Я послал дальше " + msg.getContent());


    }
}
