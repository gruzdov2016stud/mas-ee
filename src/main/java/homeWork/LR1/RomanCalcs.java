package homeWork.LR1;

public class RomanCalcs extends Calculations{

    private int numberRomanToArabic [] = new int[2];

    @Override
    public String addition(String number1, String number2) {
        Operation operation = (number11, number21) -> number11 + number21;

        numberRomanToArabic = arabicToRoman(number1, number2);
        int resultArabic = operation.execute(numberRomanToArabic[0], numberRomanToArabic[1]);
        String numberArabicToRoman = romanToArabic(resultArabic);
        return numberArabicToRoman;
    }

    @Override
    public String subtraction(String number1, String number2) {
        Operation operation = (number11, number21) -> number11 - number21;

        numberRomanToArabic = arabicToRoman(number1, number2);
        int resultArabic = operation.execute(numberRomanToArabic[0], numberRomanToArabic[1]);
        String numberArabicToRoman = romanToArabic(resultArabic);
        return numberArabicToRoman;
    }

    @Override
    public String multiplication(String number1, String number2) {
        Operation operation = (number11, number21) -> number11 * number21;

        numberRomanToArabic = arabicToRoman(number1, number2);
        int resultArabic = operation.execute(numberRomanToArabic[0], numberRomanToArabic[1]);
        String numberArabicToRoman = romanToArabic(resultArabic);
        return numberArabicToRoman;
    }

    @Override
    public String division(String number1, String number2) {
        Operation operation = (number11, number21) -> number11 / number21;

        numberRomanToArabic = arabicToRoman(number1, number2);
        int resultArabic = operation.execute(numberRomanToArabic[0], numberRomanToArabic[1]);
        String numberArabicToRoman = romanToArabic(resultArabic);
        return numberArabicToRoman;
    }

    private int[] arabicToRoman(String number1, String number2){
        int result [] = new int[2];
//        int prev = 0
//
//        //проходимся по всем символам строки
//        for (i = num.length - 1; i >= 0; i--) {
//            //находим эквивалент арабской цифры в римской системе
//        const current = romanNumber[num[i]]
//            //если текущий символ в арабской системе меньше предыдущего символа в арабской системе, то мы из результата вычитаем текущий символ
//            if (current < prev) {
//                result -= current
//            } else {
//                // то мы из к результату прибавляем текущий символ в арабской системе
//                result += current
//            }
//            //в конце итерации присваиваем текущий символ к предыдущему
//            prev = current
//        }

        return result;
    };

    private String romanToArabic(int resultArabic){
        String result = null;


        return result;
    };
}
