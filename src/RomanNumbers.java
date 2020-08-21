import java.util.HashMap;
import java.util.Map;

public class RomanNumbers {
    public static int convertRomanToInteger(String str) {

        Map<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);

        int converted = 0;

        for (int i = 0; i < str.length() - 1; i++) {

            if (map.get(str.charAt(i)) >= map.get(str.charAt(i + 1))) {
                converted += map.get(str.charAt(i));
            } else {
                converted -= map.get(str.charAt(i));
            }
        }

        converted += map.get(str.charAt(str.length() - 1));
        return converted;
    }

    public static boolean isRoman(String str) {
        return str.equals("I") || str.equals("II") || str.equals("III") || str.equals("IV") || str.equals("V") ||
                str.equals("VI") || str.equals("VII") || str.equals("VIII") || str.equals("IX") || str.equals("X");
    }
}
