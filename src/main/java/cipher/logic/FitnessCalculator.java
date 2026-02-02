package cipher.logic;

import cipher.utils.TextUtils;

public class FitnessCalculator {

    private static final double[] ENGLISH_FREQUENCIES = {
            8.2, 1.5, 2.8, 4.3, 12.7, 2.2, 2.0, 6.1, 7.0, 0.2, 0.8, 4.0, 2.4,
            6.7, 7.5, 1.9, 0.1, 6.0, 6.3, 9.1, 2.8, 1.0, 2.4, 0.2, 2.0, 0.1
    };

    public double calculateScore(String text) {
        double[] observed = TextUtils.getFrequencies(text);
        double errorScore = 0.0;

        for (int i = 0; i < 26; i++) {
            double difference = observed[i] - ENGLISH_FREQUENCIES[i];
            errorScore += (difference * difference);
        }

        return errorScore;
    }

    public boolean isEnglish(String text) {
        return calculateScore(text) < 500.0;
    }
}