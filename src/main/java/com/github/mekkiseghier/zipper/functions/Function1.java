package com.github.mekkiseghier.zipper.functions;

@FunctionalInterface
public interface Function1<I, T1, R> {
    R apply(I index, T1 v1);
}
