package com.github.mekkiseghier.zipper.tuples;

/**
 * A tuple containing an index and 4 values.
 * @param <T1> type of the first element
 * @param <T2> type of the second element
 * @param <T3> type of the third element
 * @param <T4> type of the fourth element
 */
public class Tuple4<T1, T2, T3, T4> {
    public final int index;
    public final T1 t1;
    public final T2 t2;
    public final T3 t3;
    public final T4 t4;

    /**
     * Creates a tuple with index and 4 values.
     * @param index the position index
     * @param t1 the first element
     * @param t2 the second element
     * @param t3 the third element
     * @param t4 the fourth element
     */
    public Tuple4(int index, T1 t1, T2 t2, T3 t3, T4 t4) {
        this.index = index;
        this.t1 = t1;
        this.t2 = t2;
        this.t3 = t3;
        this.t4 = t4;
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
}
