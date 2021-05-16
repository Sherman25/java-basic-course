package reflections_home_work;

import lombok.SneakyThrows;
import java.lang.reflect.Method;


public class JsonMapper {
    @SneakyThrows
    public static <T> T convertFromJson(String json, Class<T> type) {
        String[] split = json.replaceAll("[{} \"]", "").split(",");
        String[] name = split[0].split(":");
        String[] age = split[1].split(":");
        T object = type.getConstructor(String.class, int.class).newInstance(name[1], Integer.parseInt(age[1]));
        return object;
    }

    @SneakyThrows
    public static String convertToJson(Object object) {
        Class c = object.getClass();
        Method[] methods = c.getDeclaredMethods();
        return String.format("{\"name\": \"%s\", \"age\": %d}", methods[0].invoke(object), methods[1].invoke(object));
    }
}
