package homeWork.LR1;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class NumberIdentifier {

    public static boolean isArabicNumber(String number) {
        List<String> arabic = List.of("10","1","2","3","4","5","6","7","8","9");
        return arabic.contains(number);
    }

    public static boolean isRomanNumber(String number) {
        List<String> roman = List.of("X", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX");
        return roman.contains(number);
    }

}
