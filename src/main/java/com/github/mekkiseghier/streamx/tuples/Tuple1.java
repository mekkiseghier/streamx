package com.github.mekkiseghier.streamx.tuples;

public class Tuple1<T1> {
    public final int index;
    public final T1 t1;

    public Tuple1(int index, T1 t1) {
        this.index = index;
        this.t1 = t1;
    }

    public int index() { return index; }
    public T1 get_1st() { return t1; }
}
