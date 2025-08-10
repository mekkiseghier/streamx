package com.github.mekkiseghier.zipper.tuples;

/**
 * A tuple containing an index and 5 values.
 * @param <T1> type of the first element
 * @param <T2> type of the second element
 * @param <T3> type of the third element
 * @param <T4> type of the fourth element
 * @param <T5> type of the fifth element
 */
public class Tuple5<T1, T2, T3, T4, T5> {
    public final int index;
    public final T1 t1;
    public final T2 t2;
    public final T3 t3;
    public final T4 t4;
    public final T5 t5;

    /**
     * Creates a tuple with index and 5 values.
     * @param index the position index
     * @param t1 the first element
     * @param t2 the second element
     * @param t3 the third element
     * @param t4 the fourth element
     * @param t5 the fifth element
     */
    public Tuple5(int index, T1 t1, T2 t2, T3 t3, T4 t4, T5 t5) {
        this.index = index;
        this.t1 = t1;
        this.t2 = t2;
        this.t3 = t3;
        this.t4 = t4;
        this.t5 = t5;
    }

    /** @return the tuple's index */
    public int index() { return index; }
    /** @return the first element */
    public T1 get_1st() { return t1; }
    /** @return the second element */
    public T2 get_2nd() { return t2; }
    /** @return the third element */
    public T3 get_3rd() { return t3; }
    /** @return the fourth element */
    public T4 get_4th() { return t4; }
    /** @return the fifth element */
    public T5 get_5th() { return t5; }
}
