package com.github.mekkiseghier.streamx.functions;

@FunctionalInterface
public interface Function3<I, T1, T2, T3, R> {
    R apply(I index, T1 v1, T2 v2, T3 v3);
}
