package hexlet.code;

import java.nio.file.Files;
import java.nio.file.Path;

public class FileReader {
    public static String readFile(String path) throws Exception {
        Path filePath = Path.of(path);
        return Files.readString(filePath);
    }
}
