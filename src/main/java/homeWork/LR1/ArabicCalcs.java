package homeWork.LR1;

public class ArabicCalcs extends Calculations{

    @Override
    public String addition(String number1, String number2) {
        Operation operation = (number11, number21) -> number11 + number21;
        return String.valueOf(operation.execute(Integer.parseInt(number1), Integer.parseInt(number2)));
    }

    @Override
    public String subtraction(String number1, String number2) {
        Operation operation = (number11, number21) -> number11 - number21;
        return String.valueOf(operation.execute(Integer.parseInt(number1), Integer.parseInt(number2)));
    }

    @Override
    public String multiplication(String number1, String number2) {
        Operation operation = (number11, number21) -> number11 * number21;
        return String.valueOf(operation.execute(Integer.parseInt(number1), Integer.parseInt(number2)));
    }

    @Override
    public String division(String number1, String number2) {
        Operation operation = (number11, number21) -> number11 / number21;
        return String.valueOf(operation.execute(Integer.parseInt(number1), Integer.parseInt(number2)));
    }
}
