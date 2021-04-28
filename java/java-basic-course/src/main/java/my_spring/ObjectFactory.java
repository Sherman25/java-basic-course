package my_spring;

import lombok.SneakyThrows;
import org.reflections.Reflections;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class ObjectFactory {

    private static ObjectFactory objectFactory = new ObjectFactory();
    private Config config  = new JavaConfig();
    private Reflections scanner = new Reflections();
    private List<ObjectConfigurator> configurators = new ArrayList<>();

    public static ObjectFactory getInstance(){
        return objectFactory;
    }

    private ObjectFactory(){
        Set<Class<? extends ObjectConfigurator>> classes = scanner.getSubTypesOf(ObjectConfigurator.class);
        for (Class<? extends ObjectConfigurator> aClass : classes) {
            if (!Modifier.isAbstract(aClass.getModifiers())) {
                configurators.add(aClass.getDeclaredConstructor().newInstance());
            }
        }
    }


    @SneakyThrows
    public <T> T createObject(Class<T> type){
        type = resolveImpl(type);
        T t = type.getDeclaredConstructor().newInstance();


        Field[] fields = type.getDeclaredFields();
        for (Field field : fields) {
            InjectRandomInt annotation = field.getAnnotation(InjectRandomInt.class);
            if(annotation != null) {
                int min = annotation.min();
                int max = annotation.max();
                int value = getNumberBetween(min, max);
                field.setAccessible(true);
                field.set(t,value);
            }
        }
        return t;
    }

    private int getNumberBetween(int min, int max) {
        Random random = new Random();
        return random.nextInt(max - min) + min + 1;
    }

    private <T> Class<T> resolveImpl(Class<T> type) {
        if (type.isInterface()) {
            type = config.getImplClass(type);
            Class<T> implClass = config.getImplClass(type);
            if(implClass == null) {
                Set<Class <? extends T>> classes = scanner.getSubTypesOf(type);
                if(classes.size() != 1) {
                    throw new IllegalThreadStateException("0 or more than 1 impl found for type " + type);
                }
                type = (Class<T>) classes.iterator().next();
            } else {
                type = implClass;
            }

        }
        return type;
    }


}
