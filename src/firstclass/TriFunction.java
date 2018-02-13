package firstclass;

@FunctionalInterface
public interface TriFunction<U, V, X, R> {
    R apply(U u, V v, X x);
}
