package homeWork.LR3.Behaviors.IntermediaNode;

import homeWork.LR3.UtilXml.AgentConfig;
import homeWork.LR3.UtilXml.XmlHelper;
import jade.core.AID;
import jade.core.behaviours.Behaviour;
import jade.lang.acl.ACLMessage;
import jade.lang.acl.MessageTemplate;

import java.util.ArrayList;

public class BehPgDn extends Behaviour {
    @Override
    public void action() {
        AgentConfig config = XmlHelper.unMarshalAny(AgentConfig.class, getAgent().getLocalName() + ".xml");
        MessageTemplate request = MessageTemplate.MatchPerformative(ACLMessage.REQUEST);
        ACLMessage msg = getAgent().receive(request);

        if (msg != null) {
            /*Создадим и заполним листы имён и веса узлов*/
            ArrayList<String> nameNodes = new ArrayList<>();
            ArrayList<Double> lengthWay = new ArrayList<>();
            for (int i = 0; i < config.getDataNodes().size(); i++) {
                nameNodes.add(config.getDataNodes().get(i).getName());
                lengthWay.add(config.getDataNodes().get(i).getLengthWay());
            }

            String commonReqTosplit = msg.getContent().replace("[", "");
            commonReqTosplit = commonReqTosplit.replace("]", "");
            String[] splitedReq = commonReqTosplit.split("\\,\\ ");

            /*Создать лист и заполнить*/
            ArrayList<String> namesList = new ArrayList<>();
            for (int i = 0; i < splitedReq.length; i++) {
                namesList.add(splitedReq[i]);
            }

            namesList.add(getAgent().getLocalName());
            ACLMessage commonSend = new ACLMessage(ACLMessage.REQUEST);
            commonSend.setContent(namesList.toString());
            ArrayList<String> namesToSend;
            namesToSend = nameNodes;

            try {// Избавимся от зацикливания
                if (namesToSend.size() > 1) {
                    for (int i = 0; i < namesList.size(); i++) {
                        for (int j = 0; j < namesToSend.size(); j++) {
                            if (namesToSend.get(j).equals(namesList.get(i))) {
                                namesToSend.remove(namesList.get(i));
                            }
                        }
                    }
                    if (namesToSend.size() > 0) {
                        for (int i = 0; i < namesToSend.size(); i++) {
                            commonSend.addReceiver(new AID(namesToSend.get(i), false));
                        }
                        getAgent().send(commonSend);
                    } else {
                        block();
                    }
                } else {
                    block();
                }
            } catch (IndexOutOfBoundsException e) {
                block();
            }
        } else {
            block();
        }
    }

    @Override
    public boolean done() {
        return false;
    }
}