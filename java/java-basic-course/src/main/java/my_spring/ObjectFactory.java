import lombok.SneakyThrows;

package my_spring;

public class ObjectFactory {
    private static ObjectFactory objectFactory = new ObjectFactory();

    public static ObjectFactory getInstance(){
        return objectFactory;
    }

    private ObjectFactory(){

    }

    @SneakyThrows
    public <T> T createObject(Class<T> type){
        if(type.isInterface()){
            type = realImpl;
        }
        T t = type.getDeclaredConstructor().getInstance();
    }
}
