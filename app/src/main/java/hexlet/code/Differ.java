package hexlet.code;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Differ {
    public static String generate(String filePath1, String filePath2) throws Exception {
        var file1 = FileReader.readFile(filePath1);
        var file2 = FileReader.readFile(filePath2);
        var file1Parsed = Parser.parse(file1);
        var file2Parsed = Parser.parse(file2);
        var comparison = generateDifferenceList(file1Parsed, file2Parsed);
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(comparison);
    }

    public static List<Map<String, Object>> generateDifferenceList (Map<String, Object> data1,
                                                                    Map<String, Object> data2) {
        TreeMap<String, Object> mixData = new TreeMap<>();
        mixData.putAll(data1);
        mixData.putAll(data2);
        List<Map<String, Object>> differenceList = new LinkedList<>();
        for (String key : mixData.keySet()) {
            Map<String, Object> node = new HashMap<>();
            node.put("key", key);
            if (data1.containsKey(key) && data2.containsKey(key)) {
                if (data1.get(key).equals(data2.get(key))) {
                    node.put("status", "not changed");
                    node.put("value1", data1.get(key));
                }
                else {
                    node.put("status", "changed");
                    node.put("value1", data1.get(key));
                    node.put("value2", data2.get(key));
                }
            } else if (data1.containsKey(key)) {
                node.put("status", "deleted");
                node.put("value1", data1.get(key));
            } else {
                node.put("status", "added");
                node.put("value2", data2.get(key));
            }
            differenceList.add(node);
        }
        return differenceList;
    }
}
