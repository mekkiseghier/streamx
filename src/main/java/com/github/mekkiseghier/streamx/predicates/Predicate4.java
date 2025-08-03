package com.github.mekkiseghier.streamx.predicates;

@FunctionalInterface
public interface Predicate4<I, T1, T2, T3, T4> {
    boolean test(I index, T1 v1, T2 v2, T3 v3, T4 v4);
}
