package homeWork.LR1;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        while (true) {
            Calculations arabicCalcs = new ArabicCalcs();
            Calculations romanCalcs = new RomanCalcs();

            String result = null;

            Scanner scannerReader = new Scanner(System.in);
            System.out.println("Введите выражение: ");
            String expression = scannerReader.nextLine();
            String[] mass = expression.split("-|/|\\+|\\*");

            if (mass.length != 2) errorMessage("Формат оператора не удовлетворяет заданию");

            if (expression.contains("+")) {
                if (NumberIdentifier.isArabicNumber(mass[0]) && NumberIdentifier.isArabicNumber(mass[1])) {
                    result = arabicCalcs.addition(mass[0], mass[1]);
                }
                if (NumberIdentifier.isRomanNumber(mass[0]) && NumberIdentifier.isRomanNumber(mass[1])) {
                    result = romanCalcs.addition(mass[0], mass[1]);
                }
            }
            if (expression.contains("-")) {
                if (NumberIdentifier.isArabicNumber(mass[0]) && NumberIdentifier.isArabicNumber(mass[1])) {
                    result = arabicCalcs.subtraction(mass[0], mass[1]);
                }
                if (NumberIdentifier.isRomanNumber(mass[0]) && NumberIdentifier.isRomanNumber(mass[1])) {
                    result = romanCalcs.subtraction(mass[0], mass[1]);
                }
            }
            if (expression.contains("*")) {
                if (NumberIdentifier.isArabicNumber(mass[0]) && NumberIdentifier.isArabicNumber(mass[1])) {
                    result = arabicCalcs.multiplication(mass[0], mass[1]);
                }
                if (NumberIdentifier.isRomanNumber(mass[0]) && NumberIdentifier.isRomanNumber(mass[1])) {
                    result = romanCalcs.multiplication(mass[0], mass[1]);
                }
            }
            if (expression.contains("/")) {
                if (NumberIdentifier.isArabicNumber(mass[0]) && NumberIdentifier.isArabicNumber(mass[1])) {
                    result = arabicCalcs.division(mass[0], mass[1]);
                }
                if (NumberIdentifier.isRomanNumber(mass[0]) && NumberIdentifier.isRomanNumber(mass[1])) {
                    result = romanCalcs.division(mass[0], mass[1]);
                }
            }
            System.out.println("Ответ: " + result);
        }

    }

    public static void errorMessage(String message) {
        throw new Error(message);
    }
}
