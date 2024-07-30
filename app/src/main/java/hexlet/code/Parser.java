package hexlet.code;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.Map;

public class Parser {
    public static Map<String, Object> parse (String data) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(data, new TypeReference<>() {});
    }
}
