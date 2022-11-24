package homeWork.LR3.Behaviors.LastNode;

import jade.core.AID;
import jade.core.behaviours.Behaviour;
import jade.lang.acl.ACLMessage;
import jade.lang.acl.MessageTemplate;

import java.util.ArrayList;

public class ReceiverBehLastNode extends Behaviour {

    @Override
    public void action() {
        MessageTemplate request = MessageTemplate.MatchPerformative(ACLMessage.REQUEST);
        ACLMessage msgRequest = getAgent().receive(request);
        if(msgRequest != null){
            String requestMsgTosplit = msgRequest.getContent().replace("[", "");
            requestMsgTosplit = requestMsgTosplit.replace("]", "");
            String[] splitedRequestMsg = requestMsgTosplit.split("\\,\\ ");

            ArrayList<String> namesList = new ArrayList<>();
            for (int i = 0; i < splitedRequestMsg.length; i++) {
                namesList.add(splitedRequestMsg[i]);
            }
            namesList.add(getAgent().getLocalName());

            ACLMessage sendMsg = new ACLMessage(ACLMessage.INFORM);
            sendMsg.setContent(namesList + "*0");
            sendMsg.addReceiver(new AID(namesList.get(namesList.size() - 2), false));
            getAgent().send(sendMsg);

        } else {
            block();
        }
    }

    @Override
    public boolean done() {
        return false;
    }
}
