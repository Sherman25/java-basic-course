package my_spring;

import java.lang.reflect.Field;
import java.util.Random;

public class InjectRandomIntAnnotationObjectConfigurator implements ObjectConfigurator {

    public void configure(Object t) {
        Class<?> type = t.getClass();
        Field[] fields = type.getDeclaredFields();
        for (Field field : fields) {
            InjectRandomInt annotation = field.getAnnotation(InjectRandomInt.class);
            if(annotation != null) {
                int min = annotation.min();
                int max = annotation.max();
                int value = getNumberBetween(min, max);
                field.setAccessible(true);
                try {
                    field.set(t,value);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private int getNumberBetween(int min, int max) {
        Random random = new Random();
        return random.nextInt(max - min) + min + 1;
    }
}
