package homeWork.LR3.Behaviors.FirstNode;

import homeWork.LR3.NodeData.DataNode;
import jade.core.Agent;
import jade.core.behaviours.OneShotBehaviour;

public class BestWay extends OneShotBehaviour {
    DataNode data;

    public BestWay(Agent a, DataNode data) {
        super(a);
        this.data = data;
    }

    @Override
    public void action() {
        int min = 0;
        double finalLengthWay = data.getCalculationLengthList().get(min).getFinalLengthWay();
        System.out.println("");
        for (int i = 0; i < data.getCalculationLengthList().size(); i++) {
            System.out.println(data.getCalculationLengthList().get(i).getLengthWay() + " Length way:" + data.getCalculationLengthList().get(i).getFinalLengthWay());
            if (finalLengthWay >= data.getCalculationLengthList().get(i).getFinalLengthWay()) {
                finalLengthWay = data.getCalculationLengthList().get(i).getFinalLengthWay();
                min = i;
            }
        }
        System.out.println("");
        System.out.println("Best:");
        System.out.println("");
        System.out.println(data.getCalculationLengthList().get(min).getLengthWay() + " \n Length way:" + data.getCalculationLengthList().get(min).getFinalLengthWay());
    }
}

