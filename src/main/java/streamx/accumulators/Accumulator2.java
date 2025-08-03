package streamx.accumulators;

@FunctionalInterface
public interface Accumulator2 <I, T1, T2, R> {
    R reduce(I index, T1 v1, T2 v2);
}
