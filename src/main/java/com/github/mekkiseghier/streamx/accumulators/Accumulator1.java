package com.github.mekkiseghier.streamx.accumulators;

@FunctionalInterface
public interface Accumulator1 <I, T1, R> {
    R reduce(I index, T1 v1);
}
