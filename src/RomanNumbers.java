import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

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

    public static String convertIntegerToRoman(int number) {
        TreeMap<Integer, String> map = new TreeMap<Integer, String>();

        map.put(10, "X");
        map.put(9, "IX");
        map.put(5, "V");
        map.put(4, "IV");
        map.put(1, "I");

        int l = map.floorKey(number);
        if (number == l) {
            return map.get(number);
        }
        return map.get(l) + convertIntegerToRoman(number - l);
    }

    public static boolean isRoman(String str) {
        str = str.toUpperCase();
        return str.equals("I") || str.equals("II") || str.equals("III") || str.equals("IV") || str.equals("V") ||
                str.equals("VI") || str.equals("VII") || str.equals("VIII") || str.equals("IX") || str.equals("X");
    }
}
