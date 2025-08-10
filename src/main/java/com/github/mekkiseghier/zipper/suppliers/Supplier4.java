package com.github.mekkiseghier.zipper.suppliers;

@FunctionalInterface
public interface Supplier4<A1, A2, A3, A4, R> {

    R get(int index, A1 a1, A2 a2, A3 a3, A4 a4);
}
