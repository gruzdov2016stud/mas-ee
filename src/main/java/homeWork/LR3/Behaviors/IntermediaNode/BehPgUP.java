package homeWork.LR3.Behaviors.IntermediaNode;

import homeWork.LR3.UtilXml.AgentConfig;
import homeWork.LR3.UtilXml.XmlHelper;
import jade.core.AID;
import jade.core.behaviours.Behaviour;
import jade.lang.acl.ACLMessage;
import jade.lang.acl.MessageTemplate;

import java.util.ArrayList;

public class BehPgUP extends Behaviour {
    @Override
    public void action() {
        AgentConfig config = XmlHelper.unMarshalAny(AgentConfig.class, getAgent().getLocalName() + ".xml");
        MessageTemplate inform = MessageTemplate.MatchPerformative(ACLMessage.INFORM);
        ACLMessage informMsg = getAgent().receive(inform);

        if(informMsg != null) {
            ArrayList<String> nameNodes = new ArrayList<>();
            ArrayList<Double> lengthWay = new ArrayList<>();
            for (int i = 0; i < config.getDataNodes().size(); i++) {
                nameNodes.add(config.getDataNodes().get(i).getName());
                lengthWay.add(config.getDataNodes().get(i).getLengthWay());
            }

            String informMsgsplit = informMsg.getContent().replace("[", "");
            informMsgsplit = informMsgsplit.replace("]", "");
            String[] Msgsplit = informMsgsplit.split("\\*");
            double sumLengthWay = Double.parseDouble(Msgsplit[1]);
            String[] splitList = Msgsplit[0].split("\\,\\ ");

            ArrayList<String> informnamesList = new ArrayList<>();
            for (int i = 0; i < splitList.length; i++) {
                informnamesList.add(splitList[i]);
            }

            int myPlaceInThisList = 0;
            int sendersNameInneighborsNodesList = 0;
            for (int i = 0; i < informnamesList.size(); i++) {
                if (getAgent().getLocalName().equals(informnamesList.get(i))) {
                    myPlaceInThisList = i;
                }
            }

            int sendersPlaceInThisList = myPlaceInThisList + 1;
            for (int i = 0; i < nameNodes.size(); i++) {
                if (nameNodes.get(i).equals(informnamesList.get(sendersPlaceInThisList))) {
                    sendersNameInneighborsNodesList = i;
                }
            }
            double newSumLengthWay = sumLengthWay + lengthWay.get(sendersNameInneighborsNodesList);

            ACLMessage informSend = new ACLMessage(ACLMessage.INFORM);
            informSend.setContent(informnamesList + "*" + newSumLengthWay);
            informSend.addReceiver(new AID(informnamesList.get(myPlaceInThisList - 1), false));
            getAgent().send(informSend);
        } else {
            block();
        }
    }

    @Override
    public boolean done() {
        return false;
    }
}
