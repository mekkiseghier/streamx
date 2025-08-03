package com.github.mekkiseghier.streamx.consumers;

@FunctionalInterface
public interface Consumer3<I, T1, T2, T3> {
    void accept(I index, T1 v1, T2 v2, T3 v3);
}
