package cipher.logic;

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
    }

    public int getSize() {
        return rainbowTable.size();
    }


    @SuppressWarnings("unchecked")
    public void loadTable() {
        Object data = FileIO.loadObject(TABLE_FILE);
        if (data instanceof Map) {
            this.rainbowTable = (Map<String, String>) data;
            System.out.println("Loaded Rainbow Table with " + rainbowTable.size() + " entries.");
        } else {
            System.out.println("No existing table found. Starting fresh.");
            this.rainbowTable = new HashMap<>();
        }
    }


    public void saveTable() {
        if (rainbowTable.isEmpty()) {
            System.out.println("Table is empty. Skipping save.");
            return;
        }
        FileIO.saveObject(TABLE_FILE, rainbowTable);
        System.out.println("Rainbow Table saved. Size: " + rainbowTable.size());
    }

    // Временный метод для теста (потом уберем)
    public void addDummyEntry(String start, String end) {
        rainbowTable.put(start, end);
    }
}