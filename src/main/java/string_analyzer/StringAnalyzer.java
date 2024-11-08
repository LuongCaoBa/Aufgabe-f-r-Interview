package string_analyzer;

import java.util.HashMap;
import java.util.Map;

public class StringAnalyzer {

    public static Map<String, Integer> analyzeString(String input) {
        Map<String, Integer> result = new HashMap<>();
        int vowelCount = 0;
        int consonantCount = 0;
        int digitCount = 0;

        // Überprüfung der Länge und Zeichenbeschränkungen
        if (input == null || input.length() < 3 || !input.matches("[A-Za-z0-9]+")) {
            throw new IllegalArgumentException("Der String muss mindestens 3 Zeichen lang sein und darf nur Buchstaben und Ziffern enthalten.");
        }

        // Zählen von Konsonanten, Vokalen und Ziffern
        for (char ch : input.toCharArray()) {
            if (Character.isDigit(ch)) {
                digitCount++;
            } else if ("AEIOUaeiou".indexOf(ch) != -1) {
                vowelCount++;
            } else {
                consonantCount++;
            }
        }

        result.put("Vokale", vowelCount);
        result.put("Konsonanten", consonantCount);
        result.put("Ziffern", digitCount);

        return result;
    }
}
