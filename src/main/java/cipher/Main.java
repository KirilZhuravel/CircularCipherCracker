package cipher;

import cipher.logic.BruteForceCracker;
import cipher.logic.CipherEngine;
import cipher.model.CircularGraph;

public class Main {
    public static void main(String[] args) {
        CircularGraph secretKey = CircularGraph.createRandom();
        String originalText = "THE QUICK BROWN FOX JUMPS OVER THE LAZY DOG";

        System.out.println("=== 1. Setup ===");
        System.out.println("Secret Key: " + secretKey.getKey());
        System.out.println("Original:   " + originalText);

        CipherEngine engine = new CipherEngine(secretKey);
        String ciphertext = engine.encrypt(originalText);
        System.out.println("Ciphertext: " + ciphertext);

        System.out.println("\n=== 2. Starting Attack ===");
        BruteForceCracker cracker = new BruteForceCracker();

        CircularGraph hackedKey = cracker.solve(ciphertext, 5000);

        if (hackedKey != null) {
            CipherEngine hackedEngine = new CipherEngine(hackedKey);
            String result = hackedEngine.decrypt(ciphertext);

            System.out.println("\n=== Result ===");
            System.out.println("Best Key Found: " + hackedKey.getKey());
            System.out.println("Decrypted Text: " + result);
        } else {
            System.out.println("\nFailed to find any key.");
        }
    }
}