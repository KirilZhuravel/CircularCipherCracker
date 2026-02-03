package cipher.model;

public class Candidate implements Comparable<Candidate> {

    private final String key;
    private final String decryptedText;
    private final double fitnessScore;

    public Candidate(String key, String decryptedText, double fitnessScore) {
        this.key = key;
        this.decryptedText = decryptedText;
        this.fitnessScore = fitnessScore;
    }

    public String getKey() {
        return key;
    }

    public String getDecryptedText() {
        return decryptedText;
    }

    public double getFitnessScore() {
        return fitnessScore;
    }

    @Override
    public String toString() {
        return String.format("Score: %.2f | Key: %s...", fitnessScore, key.substring(0, 10));
    }

    @Override
    public int compareTo(Candidate other) {
        return Double.compare(this.fitnessScore, other.fitnessScore);
    }
}