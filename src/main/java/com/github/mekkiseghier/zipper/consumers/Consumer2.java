package com.github.mekkiseghier.zipper.consumers;

@FunctionalInterface
public interface Consumer2<I, T1, T2> {
    void accept(I index, T1 v1, T2 v2);
}
