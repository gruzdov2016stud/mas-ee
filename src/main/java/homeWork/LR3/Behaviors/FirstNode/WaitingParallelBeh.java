package homeWork.LR3.Behaviors.FirstNode;

import homeWork.LR3.NodeData.DataNode;
import jade.core.Agent;
import jade.core.behaviours.Behaviour;
import jade.core.behaviours.ParallelBehaviour;
import jade.core.behaviours.WakerBehaviour;

public class WaitingParallelBeh extends ParallelBehaviour {
    private Behaviour
            waiting,
            waker;

    public WaitingParallelBeh(Agent a, DataNode data, long timeOut) {
        super(a, WHEN_ANY);

        waiting= new WaitingBehFromLast(getAgent(), data);
        waker = new WakerBehaviour(getAgent(), timeOut) {
            @Override
            protected void onWake() {
                System.out.println("The wait is over");
            }
        };
        addSubBehaviour(waiting);
        addSubBehaviour(waker);
    }

}