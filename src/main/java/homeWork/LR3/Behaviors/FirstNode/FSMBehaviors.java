package homeWork.LR3.Behaviors.FirstNode;

import homeWork.LR3.NodeData.DataNode;
import homeWork.LR3.UtilXml.AgentConfig;
import homeWork.LR3.UtilXml.XmlHelper;
import jade.core.AID;
import jade.core.Agent;
import jade.core.behaviours.FSMBehaviour;
import jade.core.behaviours.OneShotBehaviour;
import jade.lang.acl.ACLMessage;

import java.util.ArrayList;

public class FSMBehaviors extends FSMBehaviour {

    private final String
            START = "InitFSM", MSG_LAST = "Message FirstAgent from LastAgent", END_BEHAVIOR = " Init best way";

    DataNode data;

    public FSMBehaviors(Agent a, DataNode data) {
        super(a);
        this.data = data;

        registerFirstState(new OneShotBehaviour() {
            ArrayList<String> nodes = new ArrayList<>();
            @Override
            public void action() {
                AgentConfig configNode = XmlHelper.unMarshalAny(AgentConfig.class, getAgent().getLocalName() + ".xml");
                for (int i = 0; i < configNode.getDataNodes().size(); i++){
                    nodes.add(configNode.getDataNodes().get(i).getName());
                }
                ACLMessage request = new ACLMessage(ACLMessage.REQUEST);
                request.setContent(getAgent().getLocalName());
                for (int i = 0; i < nodes.size(); i++) {
                    request.addReceiver(new AID(nodes.get(i), false));
                }
                getAgent().send(request);

            }
        }, START);

        registerState(new WaitingParallelBeh(getAgent(), data, 5000 ), MSG_LAST);
        registerLastState(new BestWay(getAgent(),data), END_BEHAVIOR);

        registerDefaultTransition(START, MSG_LAST);
        registerDefaultTransition(MSG_LAST, END_BEHAVIOR);

    }




}
