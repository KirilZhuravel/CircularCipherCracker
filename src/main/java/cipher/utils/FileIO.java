package cipher.utils;

import java.io.*;

public class FileIO {


    public static void saveObject(String filePath, Object object) {
        // Создаем папку data, если её нет
        File file = new File(filePath);
        if (file.getParentFile() != null) {
            file.getParentFile().mkdirs();
        }

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filePath))) {
            oos.writeObject(object);
            System.out.println("Data successfully saved to: " + filePath);
        } catch (IOException e) {
            System.err.println("Error saving file: " + e.getMessage());
            e.printStackTrace();
        }
    }


    public static Object loadObject(String filePath) {
        File file = new File(filePath);
        if (!file.exists()) {
            System.out.println("File not found: " + filePath);
            return null;
        }

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
            System.out.println("Loading data from: " + filePath);
            return ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Error loading file: " + e.getMessage());
            return null;
        }
    }
}