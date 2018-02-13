package firstclass;


/**
 * This functional interface represents a function which accept 2 arguments and return a value
 */
@FunctionalInterface
public interface BiFunction<T, U, R> {
    R apply(T t, U u);
}
