package com.github.mekkiseghier.streamx.predicates;

@FunctionalInterface
public interface Predicate2<I, T1, T2> {
    boolean test(I index, T1 v1, T2 v2);
}
