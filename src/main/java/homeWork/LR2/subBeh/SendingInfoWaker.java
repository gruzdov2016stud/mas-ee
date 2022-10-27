package homeWork.LR2.subBeh;

import homeWork.LR2.Data;
import jade.core.AID;
import jade.core.Agent;
import jade.core.behaviours.WakerBehaviour;
import jade.domain.DFService;
import jade.domain.FIPAAgentManagement.DFAgentDescription;
import jade.domain.FIPAException;
import jade.lang.acl.ACLMessage;

import java.util.ArrayList;
import java.util.List;

public class SendingInfoWaker extends WakerBehaviour {

    Data data;

    public SendingInfoWaker(Agent a, long timeout, Data data) {
        super(a, timeout);
        this.data = data;
    }

    @Override
    protected void onWake() {
        double resultMin = 0;
        double resultCur = 0;
        double resultPl = 0;

        // Обновление данных полей для последующего расчёта
        data.setResultMin(resultMin);
        data.setResultCur(resultCur);
        data.setResultPl(resultPl);

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
        // Создание листа без агента, выполняющего данное поведение для того чтобы данный агент не отправлял себе сообщение
        List<AID> agentsWithoutMe = new ArrayList<>();
        for (AID aid : agents) {
            if (getAgent().getAID().equals(aid)){
                continue;
            }
            agentsWithoutMe.add(aid);
        }

        // Отправка текущего значения X и delta
        ACLMessage msg = new ACLMessage(ACLMessage.REQUEST);
        msg.setContent(data.getX() + ";" + data.getDelta());
        agentsWithoutMe.forEach(el -> msg.addReceiver(el));
        getAgent().send(msg);

    }
}
