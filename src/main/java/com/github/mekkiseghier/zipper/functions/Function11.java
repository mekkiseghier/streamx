package com.github.mekkiseghier.zipper.functions;

@FunctionalInterface
public interface Function11<I, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, R> {
    R apply(I index, T1 v1, T2 v2, T3 v3, T4 v4, T5 v5, T6 v6, T7 v7, T8 v8, T9 v9, T10 v10, T11 v11);
}
