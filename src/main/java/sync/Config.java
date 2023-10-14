package sync;

import java.io.File;
import java.io.FileReader;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class Config {

    public static void loadConfig() {
        loadConfig("config.json");
    }

    public static void loadConfig(String path) {
        JSONParser parser = new JSONParser();
        
        try {
            JSONObject obj = (JSONObject) parser.parse(new FileReader("./config.json"));
            System.out.println(obj.toJSONString());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
