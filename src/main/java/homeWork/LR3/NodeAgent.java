package homeWork.LR3;

import classWork.pr4.serialization.XmlHelper;
import homeWork.LR3.Behaviors.FirstNode.FSMBehaviors;
import homeWork.LR3.Behaviors.IntermediaNode.BehPgDn;
import homeWork.LR3.Behaviors.IntermediaNode.BehPgUP;
import homeWork.LR3.Behaviors.LastNode.ReceiverBehLastNode;
import homeWork.LR3.NodeData.DataNode;
import homeWork.LR3.UtilXml.AgentConfig;
import jade.core.Agent;

public class NodeAgent extends Agent {

    private DataNode dataNode = new DataNode();

    @Override
    protected void setup() {
        AgentConfig ConfigAgent = XmlHelper.unMarshalAny(
                AgentConfig.class, getLocalName()+".xml");

        if (ConfigAgent.getStart() && !ConfigAgent.getEnd()){
            addBehaviour(new FSMBehaviors(this, dataNode));
        }
        if (!ConfigAgent.getStart() && !ConfigAgent.getEnd()) {
            addBehaviour(new BehPgDn());
            addBehaviour(new BehPgUP());
        }
        if (!ConfigAgent.getStart() && ConfigAgent.getEnd()) {
            addBehaviour(new ReceiverBehLastNode());
        }

    }
}
