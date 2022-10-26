package homeWork.LR1;

import java.util.HashMap;
import java.util.Map;

public class RomanCalcs extends Calculations {

    private int numberRomanToArabic[] = new int[2];

    @Override
    public String addition(String number1, String number2) {
        Operation operation = (number11, number21) -> number11 + number21;

        numberRomanToArabic[0] = romanToInt(number1);
        numberRomanToArabic[1] = romanToInt(number2);
        int resultArabic = operation.execute(numberRomanToArabic[0], numberRomanToArabic[1]);
        String romanNumber = intToRoman(resultArabic);
        return romanNumber;
    }

    @Override
    public String subtraction(String number1, String number2) {
        Operation operation = (number11, number21) -> number11 - number21;

        numberRomanToArabic[0] = romanToInt(number1);
        numberRomanToArabic[1] = romanToInt(number2);
        int resultArabic = operation.execute(numberRomanToArabic[0], numberRomanToArabic[1]);
        String romanNumber = intToRoman(resultArabic);
        return romanNumber;
    }

    @Override
    public String multiplication(String number1, String number2) {
        Operation operation = (number11, number21) -> number11 * number21;

        numberRomanToArabic[0] = romanToInt(number1);
        numberRomanToArabic[1] = romanToInt(number2);
        int resultArabic = operation.execute(numberRomanToArabic[0], numberRomanToArabic[1]);
        String romanNumber = intToRoman(resultArabic);
        return romanNumber;
    }

    @Override
    public String division(String number1, String number2) {
        Operation operation = (number11, number21) -> number11 / number21;

        numberRomanToArabic[0] = romanToInt(number1);
        numberRomanToArabic[1] = romanToInt(number2);
        int resultArabic = operation.execute(numberRomanToArabic[0], numberRomanToArabic[1]);
        String romanNumber = intToRoman(resultArabic);
        return romanNumber;
    }

    private int romanToInt(String number) {
        Map<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);

        int result = 0;
        int prev = 0;
        //проходимся по всем символам строки
            for (int j = number.length()-1; j >= 0; j--) {
                //находим эквивалент арабской цифры в римской системе
                int current = map.get(number.charAt(j));
                //если текущий символ в арабской системе меньше предыдущего символа в арабской системе, то мы из результата вычитаем текущий символ
                if (current < prev){
                    result -= current;
                    // то мы к результату прибавляем текущий символ в арабской системе
                }else {
                    result += current;
                }
                //в конце итерации присваиваем текущий символ к предыдущему
                prev = current;
            }
        return result;
    }

    private String intToRoman(int resultArabic) {
        int[] arabic = new int[]{100,90,50,40,10,9,5,4,1};
        String[] roman = new String[]{"C","XC","L","XL","X","IX","V","IV","I"};
        if(resultArabic < 1 || resultArabic>=100) throw new Error("Неположительный результат");
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arabic.length && resultArabic > 0; i++) {
            while (resultArabic>=arabic[i]){
                resultArabic -= arabic[i];
                sb.append(roman[i]);
            }
        }
        return sb.toString();
    }
}
