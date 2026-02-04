package cipher;

import cipher.logic.RainbowTableManager;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== Stage 4: Infrastructure Test ===");

        RainbowTableManager manager = new RainbowTableManager();


        System.out.println("\n--- Step 1: Initial Load ---");
        manager.loadTable();
        System.out.println("Current Size: " + manager.getSize());


        System.out.println("\n--- Step 2: Adding Dummy Data ---");
        manager.addDummyEntry("AAAAA", "ZZZZZ");
        manager.addDummyEntry("BBBBB", "YYYYY");
        System.out.println("Added 2 entries.");


        System.out.println("\n--- Step 3: Saving ---");
        manager.saveTable();


        System.out.println("\n--- Step 4: Clearing Memory ---");
        manager.clearTable();
        System.out.println("Size after clear: " + manager.getSize());


        System.out.println("\n--- Step 5: Reloading ---");
        manager.loadTable();
        System.out.println("Final Size: " + manager.getSize());

        if (manager.getSize() == 2) {
            System.out.println("\n✅ SUCCESS: Infrastructure is ready for Stage 5!");
        } else {
            System.out.println("\n❌ ERROR: Persistence failed.");
        }
    }
}