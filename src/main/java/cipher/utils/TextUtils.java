package cipher.utils;

public class TextUtils {

    public static String clean(String input) {
        if (input == null) return "";
        return input.toUpperCase().replaceAll("[^A-Z]", "");
    }

    public static double[] getFrequencies(String text) {
        double[] frequencies = new double[26];
        String cleanText = clean(text);
        int length = cleanText.length();

        if (length == 0) return frequencies;

        for (char c : cleanText.toCharArray()) {
            frequencies[c - 'A']++;
        }

        for (int i = 0; i < 26; i++) {
            frequencies[i] = (frequencies[i] / length) * 100.0;
        }

        return frequencies;
    }
}