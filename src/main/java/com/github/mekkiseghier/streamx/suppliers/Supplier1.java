package com.github.mekkiseghier.streamx.suppliers;

@FunctionalInterface
public interface Supplier1<A1, R> {

    R get(int index, A1 a1);
}
