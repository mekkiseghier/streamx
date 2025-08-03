package com.github.mekkiseghier.streamx.tuples;

public class Tuple6<T1, T2, T3, T4, T5, T6> {
    public final int index;
    public final T1 t1;
    public final T2 t2;
    public final T3 t3;
    public final T4 t4;
    public final T5 t5;
    public final T6 t6;

    public Tuple6(int index, T1 t1, T2 t2, T3 t3, T4 t4, T5 t5, T6 t6) {
        this.index = index;
        this.t1 = t1;
        this.t2 = t2;
        this.t3 = t3;
        this.t4 = t4;
        this.t5 = t5;
        this.t6 = t6;
    }

    public int index() { return index; }
    public T1 get_1st() { return t1; }
    public T2 get_2nd() { return t2; }
    public T3 get_3rd() { return t3; }
    public T4 get_4th() { return t4; }
    public T5 get_5th() { return t5; }
    public T6 get_6th() { return t6; }
}
