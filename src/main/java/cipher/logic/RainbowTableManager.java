package cipher.logic;

import cipher.model.Candidate;
import cipher.utils.FileIO;

import java.util.HashMap;
import java.util.Map;

public class RainbowTableManager {

    private static final String TABLE_FILE = "data/rainbow_table.dat";


    private Map<String, String> rainbowTable;

    public RainbowTableManager() {
        this.rainbowTable = new HashMap<>();
    }


    public void clearTable() {
        this.rainbowTable.clear();
        System.out.println("Rainbow Table memory cleared.");
    }

    public int getSize() {
        return rainbowTable.size();
    }
}