package com.github.mekkiseghier.streamx.consumers;

@FunctionalInterface
public interface Consumer1<I, T1> {
    void accept(I index, T1 v1);
}
