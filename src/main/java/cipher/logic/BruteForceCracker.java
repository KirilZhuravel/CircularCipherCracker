package cipher.logic;

import cipher.model.CircularGraph;

public class BruteForceCracker {

    private final FitnessCalculator fitnessCalculator;

    public BruteForceCracker() {
        this.fitnessCalculator = new FitnessCalculator();
    }

    public CircularGraph solve(String ciphertext, long timeoutMillis) {
        long startTime = System.currentTimeMillis();

        CircularGraph bestKey = null;
        double bestScore = Double.MAX_VALUE;

        long attempts = 0;

        System.out.println("Starting Brute Force attack (" + (timeoutMillis / 1000) + "s)...");

        while (System.currentTimeMillis() - startTime < timeoutMillis) {
            attempts++;

            CircularGraph candidateKey = CircularGraph.createRandom();

            CipherEngine engine = new CipherEngine(candidateKey);
            String decryptedAttempt = engine.decrypt(ciphertext);

            double score = fitnessCalculator.calculateScore(decryptedAttempt);

            if (score < bestScore) {
                bestScore = score;
                bestKey = candidateKey;

                if (score < 400) {
                    System.out.println("New Best! Score: " + String.format("%.2f", score) +
                            " | Key: " + candidateKey.getKey());
                }
            }
        }

        System.out.println("Time's up! Total attempts: " + attempts);
        System.out.println("Best Score: " + String.format("%.2f", bestScore));

        return bestKey;
    }
}