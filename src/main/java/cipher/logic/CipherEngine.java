package cipher.logic;

import cipher.model.CircularGraph;

public class CipherEngine {

    private final CircularGraph graph;

    public CipherEngine(CircularGraph graph) {
        this.graph = graph;
    }

    public String encrypt(String plaintext) {
        StringBuilder result = new StringBuilder();

        String cleanText = plaintext.toUpperCase().replaceAll("[^A-Z]", "");

        for (char c : cleanText.toCharArray()) {
            int currentIndex = graph.indexOf(c);

            if (currentIndex == -1) continue;

            char encryptedChar = graph.getNode(currentIndex + 1);

            result.append(encryptedChar);
        }
        return result.toString();
    }


    public String decrypt(String cipherText) {
        StringBuilder result = new StringBuilder();

        int size = 26;

        for (char c : cipherText.toCharArray()) {
            int currentIndex = graph.indexOf(c);

            int prevIndex = (currentIndex - 1 + size) % size;

            char decryptedChar = graph.getNode(prevIndex);
            result.append(decryptedChar);
        }
        return result.toString();
    }
}
