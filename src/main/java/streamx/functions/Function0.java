package streamx.functions;

@FunctionalInterface
public interface Function0<I, R> {
    R apply(I index);
}
