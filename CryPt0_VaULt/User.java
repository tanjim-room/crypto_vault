import java.io.*;
import java.nio.file.Files;
import java.util.*;

public class User {
    private static final String FILE_PATH = "users.txt";

    public static boolean register(String email, String password) throws IOException {
        File file = new File(FILE_PATH);
        if (!file.exists()) file.createNewFile();

        List<String> lines = new ArrayList<>(Files.readAllLines(file.toPath()));
        for (String line : lines) {
            String[] parts = line.split(":");
            if (parts[0].equalsIgnoreCase(email)) return false; // already registered
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file, true))) {
            writer.write(email + ":" + password);
            writer.newLine();
        }
        return true;
    }

    public static boolean login(String email, String password) throws IOException {
        File file = new File(FILE_PATH);
        if (!file.exists()) return false;

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(":");
                if (parts.length == 2 && parts[0].equalsIgnoreCase(email) && parts[1].equals(password)) {
                    return true;
                }
            }
        }
        return false;
    }
}
