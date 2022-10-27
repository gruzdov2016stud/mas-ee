package homeWork.LR2.subBeh;

import homeWork.LR2.Data;
import jade.core.behaviours.OneShotBehaviour;

public class Calculation extends OneShotBehaviour {
    Data data;
    double x;
    double delta;

    public Calculation(Data data, Double x, Double delta) {
        this.data = data;
        this.x = x;
        this.delta = delta;
    }

    @Override
    public void action() {
        double resultMinus = 0;
        double result = 0;
        double resultPlus = 0;
        if (getAgent().getLocalName().equals("Giper")) {
            resultMinus = Math.pow(2,(-0.1*(x - delta)));
            result = Math.pow(2,(-0.1*x));
            resultPlus = Math.pow(2,(-0.1*(x + delta)));;
            System.out.println(getAgent().getLocalName() + ": (Вычисления в калькуляторе) " + resultMinus + " " + result + " " + resultPlus);
        }
        if (getAgent().getLocalName().equals("Quadratic")) {
            resultMinus = -0.5 * (x - delta)*(x - delta) - 4;
            result = -0.5 * (x)*(x) - 4;
            resultPlus = -0.5 * (x + delta)*(x + delta) - 4;
            System.out.println(getAgent().getLocalName() + ": (Вычисления в калькуляторе) " + resultMinus + " " + result + " " + resultPlus);
        }
        if (getAgent().getLocalName().equals("Cos")) {
            resultMinus = Math.cos(x - delta);
            result = Math.cos(x);
            resultPlus = Math.cos(x + delta);
            System.out.println(getAgent().getLocalName() + ": (Вычисления в калькуляторе) " + resultMinus + " " + result + " " + resultPlus);
        }
        data.setResultMinus(resultMinus);
        data.setResult(result);
        data.setResultPlus(resultPlus);
    }
}
