package com.github.mekkiseghier.streamx.accumulators;

@FunctionalInterface
public interface Accumulator3 <I, T1, T2, T3, R> {
    R reduce(I index, T1 v1, T2 v2, T3 v3);
}
