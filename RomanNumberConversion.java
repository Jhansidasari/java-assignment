import java.util.HashMap;
import java.util.Map;

public class RomanNumberConversion {
    // I, II, III, IV, V, VI, VII, VIII, IX, X
    // XI, XII, XIII, XIV, XV, XVI, XVII, XVIII, XIX, XX

    static Map<Character, Integer> romanConversionMap = new HashMap<>();

    public static void main(String[] args) {
        setupRomanConversionMap();

        String input = "MMMDCCCL";
        int result = 0;
        for (int i = 0; i < input.length();) {
            String operation = getOperation(input, i);
            switch (operation) {
                case "NORMAL":
                    result += romanConversionMap.get(input.charAt(i));
                    i++;
                    break;
                case "SUBTRACT":
                    result += (romanConversionMap.get(input.charAt(i + 1))
                            - romanConversionMap.get(input.charAt(i)));
                    i += 2;
                    break;
            }
        }

        System.out.println("Result is " + result);
    }

    private static void setupRomanConversionMap() {
        romanConversionMap.put('I', 1);
        romanConversionMap.put('V', 5);
        romanConversionMap.put('X', 10);
        romanConversionMap.put('L', 50);
        romanConversionMap.put('C', 100);
        romanConversionMap.put('D', 500);
        romanConversionMap.put('M', 1000);
    }

    private static String getOperation(String input, int i) {
        if (i + 1 == input.length()) {
            return "NORMAL";
        }

        int current = romanConversionMap.get(input.charAt(i));
        int next = romanConversionMap.get(input.charAt(i + 1));

        if (current < next) {
            return "SUBTRACT";
        }

        return "NORMAL";
    }
}
