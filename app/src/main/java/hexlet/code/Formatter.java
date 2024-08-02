package hexlet.code;

import java.util.List;
import java.util.Map;

public class Formatter {
    public static String buildResult(List<Map<String, Object>> inputList) {
        StringBuilder result = new StringBuilder("{\n");
        for (Map<String, Object> map : inputList) {
            if (map.containsValue("not changed")) {
                result.append("    ")
                        .append(map.get("key"))
                        .append(": ")
                        .append(map.get("value1"))
                        .append("\n");
            } else if (map.containsValue("changed")) {
                result.append("  - ")
                        .append(map.get("key"))
                        .append(": ")
                        .append(map.get("value1"))
                        .append("\n")
                        .append("  + ")
                        .append(map.get("key"))
                        .append(": ")
                        .append(map.get("value2"))
                        .append("\n");
            } else if (map.containsValue("added")) {
                result.append("  + ")
                        .append(map.get("key"))
                        .append(": ")
                        .append(map.get("value2"))
                        .append("\n");
            } else if (map.containsValue("deleted")) {
                result.append("  - ")
                        .append(map.get("key"))
                        .append(": ")
                        .append(map.get("value1"))
                        .append("\n");
            }
        }
        result.append("}");
        return result.toString();
    }
}
