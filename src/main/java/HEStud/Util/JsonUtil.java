package HEStud.Util;

import com.google.gson.GsonBuilder;

import java.util.List;

public class JsonUtil {

    private JsonUtil() {
    }

    public static String writeJson(List<?> list) {
        return new GsonBuilder().setPrettyPrinting().create().toJson(list);
    }
}