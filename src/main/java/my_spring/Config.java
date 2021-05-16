package my_spring;

import java.util.Map;

public interface Config {

    <T> Class<T> getImplClass(Class<T> type);
}
