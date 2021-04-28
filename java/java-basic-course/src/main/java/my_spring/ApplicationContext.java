package my_spring;

public class ApplicationContext {

    private static final ApplicationContext applicationContext = new ApplicationContext();

    public ApplicationContext getInstance(){
        return applicationContext;
    }

    private ApplicationContext(){}



    public static Object getObject(Class type) {
        //todo finish this
        // context should cache all objects, which class marked by @Singleton
        // in case object is not singleton, or still not present in cache
        // use ObjectFactory to create
        return null;
    }
}
