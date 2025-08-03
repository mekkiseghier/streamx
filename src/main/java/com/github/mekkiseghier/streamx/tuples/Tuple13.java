package com.github.mekkiseghier.streamx.tuples;

public class Tuple13<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13> {
    public final int index;
    public final T1 t1;
    public final T2 t2;
    public final T3 t3;
    public final T4 t4;
    public final T5 t5;
    public final T6 t6;
    public final T7 t7;
    public final T8 t8;
    public final T9 t9;
    public final T10 t10;
    public final T11 t11;
    public final T12 t12;
    public final T13 t13;

    public Tuple13(int index, T1 t1, T2 t2, T3 t3, T4 t4, T5 t5, T6 t6, T7 t7, T8 t8, T9 t9, T10 t10, T11 t11, T12 t12, T13 t13) {
        this.index = index;
        this.t1 = t1;
        this.t2 = t2;
        this.t3 = t3;
        this.t4 = t4;
        this.t5 = t5;
        this.t6 = t6;
        this.t7 = t7;
        this.t8 = t8;
        this.t9 = t9;
        this.t10 = t10;
        this.t11 = t11;
        this.t12 = t12;
        this.t13 = t13;
    }

    public int index() { return index; }
    public T1 get_1st() { return t1; }
    public T2 get_2nd() { return t2; }
    public T3 get_3rd() { return t3; }
    public T4 get_4th() { return t4; }
    public T5 get_5th() { return t5; }
    public T6 get_6th() { return t6; }
    public T7 get_7th() { return t7; }
    public T8 get_8th() { return t8; }
    public T9 get_9th() { return t9; }
    public T10 get_10th() { return t10; }
    public T11 get_11th() { return t11; }
    public T12 get_12th() { return t12; }
    public T13 get_13th() { return t13; }
}
