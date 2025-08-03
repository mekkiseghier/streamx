package streamx.accumulators;

@FunctionalInterface
public interface Accumulator4 <I, T1, T2, T3, T4, R> {
    R reduce(I index, T1 v1, T2 v2, T3 v3, T4 v4);
}
