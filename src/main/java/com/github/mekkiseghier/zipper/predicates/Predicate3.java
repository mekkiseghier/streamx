package com.github.mekkiseghier.zipper.predicates;

@FunctionalInterface
public interface Predicate3<I, T1, T2, T3> {
    boolean test(I index, T1 v1, T2 v2, T3 v3);
}
