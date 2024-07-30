package hexlet.code;

import java.nio.file.Files;
import java.nio.file.Path;

public class FileReader {
    public static String readFile(String filePath) throws Exception {
        Path path = Path.of(filePath);
        return Files.readString(path);
    }
}
