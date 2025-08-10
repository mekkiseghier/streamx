package com.github.mekkiseghier.zipper.tuples;

/**
 * A tuple containing an index and 1 value.
 * @param <T1> type of the first element
 */
public class Tuple1<T1> {
    public final int index;
    public final T1 t1;

    /**
     * Creates a tuple with index and 1 value.
     * @param index the position index
     * @param t1 the first element
     */
    public Tuple1(int index, T1 t1) {
        this.index = index;
        this.t1 = t1;
    }

    /** @return the tuple's index */
    public int index() { return index; }
    /** @return the first element */
    public T1 get_1st() { return t1; }
}
