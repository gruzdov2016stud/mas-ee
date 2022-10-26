package classWork.pr4.df;

import jade.core.Agent;

public class SellerAgent extends Agent {
    @Override
    protected void setup() {
        DfHelper.registerAgent(this.getAID(), this, AgentType.Seller.toString());
    }
}
