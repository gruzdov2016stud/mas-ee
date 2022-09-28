package homeWork.LR1;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        ArabicCalcs arabicCalcs = new ArabicCalcs();
        RomanCalcs romanCalcs = new RomanCalcs();
        String result = null;

        Scanner scannerReader = new Scanner(System.in);
        System.out.println("Введите выражение: ");
        String expression = scannerReader.nextLine();
        String[] mass = expression.split("-|/|\\+|\\*");


        if(expression.contains("+")){
            if(NumberIdentifier.isArabicNumber(mass[0]) & NumberIdentifier.isArabicNumber(mass[1]))
                result = arabicCalcs.addition(mass[0], mass[1]);
            if(NumberIdentifier.isRomanNumber(mass[0]) & NumberIdentifier.isRomanNumber(mass[1]))
                result = romanCalcs.addition(mass[0], mass[1]);
        }
        if(expression.contains("-")){
            if(NumberIdentifier.isArabicNumber(mass[0]) & NumberIdentifier.isArabicNumber(mass[1]))
                result = arabicCalcs.subtraction(mass[0], mass[1]);
            if(NumberIdentifier.isRomanNumber(mass[0]) & NumberIdentifier.isRomanNumber(mass[1]))
                result = romanCalcs.subtraction(mass[0], mass[1]);
        }
        if(expression.contains("*")){
            if(NumberIdentifier.isArabicNumber(mass[0]) & NumberIdentifier.isArabicNumber(mass[1]))
                result = arabicCalcs.multiplication(mass[0], mass[1]);
            if(NumberIdentifier.isRomanNumber(mass[0]) & NumberIdentifier.isRomanNumber(mass[1]))
                result = romanCalcs.multiplication(mass[0], mass[1]);
        }
        if(expression.contains("/")){
            if(NumberIdentifier.isArabicNumber(mass[0]) & NumberIdentifier.isArabicNumber(mass[1]))
                result = arabicCalcs.division(mass[0], mass[1]);
            if(NumberIdentifier.isRomanNumber(mass[0]) & NumberIdentifier.isRomanNumber(mass[1]))
                result = romanCalcs.division(mass[0], mass[1]);
        }else errorMessage("Ответ: ");
        System.out.println("Ответ: "+mass);
    }


    public static void errorMessage(String message){
        throw new Error(message);
    }
}
