package com.github.mekkiseghier.zipper.suppliers;

@FunctionalInterface
public interface Supplier2<A1, A2, R> {

    R get(int index, A1 a1, A2 a2);
}
