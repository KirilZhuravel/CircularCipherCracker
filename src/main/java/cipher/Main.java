package cipher;

import cipher.logic.FitnessCalculator;

public class Main {
    public static void main(String[] args) {
        FitnessCalculator calculator = new FitnessCalculator();

        String englishText = "The quick brown fox jumps over the lazy dog";
        double scoreEnglish = calculator.calculateScore(englishText);

        String gibberishText = "XQKZ JWYM PVLA RBMQ ZOPL";
        double scoreGibberish = calculator.calculateScore(gibberishText);

        System.out.println("=== Heuristic Analysis Test ===");
        System.out.println("Text 1 (English): " + englishText);
        System.out.println("Score 1 (Error):  " + scoreEnglish);

        System.out.println("\nText 2 (Gibberish): " + gibberishText);
        System.out.println("Score 2 (Error):    " + scoreGibberish);

        if (scoreEnglish < scoreGibberish) {
            System.out.println("\nSUCCESS: Algorithm correctly identified English text.");
        } else {
            System.out.println("\nFAIL: Algorithm is confused.");
        }
    }
}