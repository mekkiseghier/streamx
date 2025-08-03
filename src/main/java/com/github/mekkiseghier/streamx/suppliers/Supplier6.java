package com.github.mekkiseghier.streamx.suppliers;

@FunctionalInterface
public interface Supplier6<A1, A2, A3, A4, A5, A6, R> {

    R get(int index, A1 a1, A2 a2, A3 a3, A4 a4, A5 a5, A6 a6);
}
