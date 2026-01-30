package cipher;


import cipher.logic.CipherEngine;
import cipher.model.CircularGraph;
public class Main {
    public static void main(String[] args) {
        System.out.println("=== 1. Initialization ===");


        CircularGraph secretKey = CircularGraph.createRandom();
        System.out.println("Generated Key (The Graph): " + secretKey.getKey());


        CipherEngine engine = new CipherEngine(secretKey);

        System.out.println("\n=== 2. Encryption Test ===");
        String originalText = "HELLO WORLD";
        System.out.println("Original Text:  " + originalText);


        String encryptedText = engine.encrypt(originalText);
        System.out.println("Encrypted Text: " + encryptedText);

        System.out.println("\n=== 3. Decryption Test ===");

        String decryptedText = engine.decrypt(encryptedText);
        System.out.println("Decrypted Text: " + decryptedText);


        if ("HELLOWORLD".equals(decryptedText)) {
            System.out.println("\n SUCCESS: The system works correctly!");
        } else {
            System.out.println("\n ERROR: Something went wrong.");
        }
    }
}