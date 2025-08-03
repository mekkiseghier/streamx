package com.github.mekkiseghier.streamx.functions;

@FunctionalInterface
public interface Function2<I, T1, T2, R> {
    R apply(I index, T1 v1, T2 v2);
}
