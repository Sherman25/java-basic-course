package java_8;

@FunctionalInterface
public interface Equalator<T> {
    boolean myEquals(T t1, T t2);
}
