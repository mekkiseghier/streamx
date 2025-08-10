package com.github.mekkiseghier.zipper.tuples;

/**
 * A tuple containing an index and 2 values.
 * @param <T1> type of the first element
 * @param <T2> type of the second element
 */
public class Tuple2<T1, T2> {
    public final int index;
    public final T1 t1;
    public final T2 t2;

    /**
     * Creates a tuple with index and 2 values.
     * @param index the position index
     * @param t1 the first element
     * @param t2 the second element
     */
    public Tuple2(int index, T1 t1, T2 t2) {
        this.index = index;
        this.t1 = t1;
        this.t2 = t2;
    }

    /** @return the tuple's index */
    public int index() { return index; }
    /** @return the first element */
    public T1 get_1st() { return t1; }
    /** @return the second element */
    public T2 get_2nd() { return t2; }
}
