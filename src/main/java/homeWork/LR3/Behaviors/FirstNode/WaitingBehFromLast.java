package homeWork.LR3.Behaviors.FirstNode;
import homeWork.LR3.NodeData.CalcLength;
import homeWork.LR3.NodeData.DataNode;
import homeWork.LR3.UtilXml.AgentConfig;
import homeWork.LR3.UtilXml.XmlHelper;
import jade.core.Agent;
import jade.core.behaviours.Behaviour;
import jade.lang.acl.ACLMessage;
import jade.lang.acl.MessageTemplate;

import java.util.ArrayList;

public class WaitingBehFromLast extends Behaviour {
    DataNode data;

    public WaitingBehFromLast(Agent a, DataNode data) {
        super(a);
        this.data = data;
    }

    ArrayList<String> nodesName = new ArrayList<>();
    ArrayList<Double> lengthWayNeighbors = new ArrayList<>();

    @Override
    public void action() {
        AgentConfig configAgent = XmlHelper.unMarshalAny(AgentConfig.class, getAgent().getLocalName() + ".xml");
        for(int i = 0; i< configAgent.getDataNodes().size(); i++){
            nodesName.add(configAgent.getDataNodes().get(i).getName());
            lengthWayNeighbors.add(configAgent.getDataNodes().get(i).getLengthWay());
        }
        /*Ожидание сообщения от последнего узла*/
        MessageTemplate inform = MessageTemplate.MatchPerformative(ACLMessage.INFORM);
        ACLMessage msgInform =getAgent().receive(inform);

        if(msgInform != null){
            String splitMessage = msgInform.getContent().replace("[", "");
            splitMessage = splitMessage.replace("]", "");
            String[] splitMessageFirst = splitMessage.split("\\*");

            double sumLengthWay = Double.parseDouble(splitMessageFirst[1]);
            String[] splitedMessageSecond = splitMessageFirst[0].split("\\,\\ ");

            ArrayList<String> ListNameNodes = new ArrayList<>();
            for (int b = 0; b < splitedMessageSecond.length; b++) {
                ListNameNodes.add(splitedMessageSecond[b]);
            }

            /*Определим положение агента в листе*/
            int myPlaceInThisList = 0;
            int sendersNameInNodesList = 0;
            for (int i = 0; i < ListNameNodes.size(); i++) {
                if (getAgent().getLocalName().equals(ListNameNodes.get(i))) {
                    myPlaceInThisList = i;
                }
            }
            int sendersPlaceInThisList = myPlaceInThisList + 1;
            for (int i = 0; i < nodesName.size(); i++) {
                if (nodesName.get(i).equals(ListNameNodes.get(sendersPlaceInThisList))) {
                    sendersNameInNodesList = i;
                }
            }
            /*Новая длина*/
            double newSumLengthWay = sumLengthWay + lengthWayNeighbors.get(sendersNameInNodesList);

            CalcLength calculationLength = new CalcLength();
            calculationLength.setLengthWay(msgInform.getContent());
            calculationLength.setFinalLengthWay(newSumLengthWay);

            ArrayList<CalcLength> LengthList = data.getCalculationLengthList();
            LengthList.add(calculationLength);
        } else {
            block();
        }
    }

    @Override
    public boolean done() {
        return false;
    }
}