package com.github.mekkiseghier.zipper.suppliers;

/**
 * Represents a supplier of results that takes 6 element arguments
 * and is aware of the index position during iteration.
 * @param <T1> the type of the first argument
 * @param <T2> the type of the second argument
 * @param <T3> the type of the third argument
 * @param <T4> the type of the fourth argument
 * @param <T5> the type of the fifth argument
 * @param <T6> the type of the sixth argument
 * @param <R> the type of results supplied
 */
@FunctionalInterface
public interface Supplier6<T1, T2, T3, T4, T5, T6, R> {
    /**
     * Gets a result for the given index and arguments.
     *
     * @param index the zero-based index in the iteration
     * @param v1 the first argument
     * @param v2 the second argument
     * @param v3 the third argument
     * @param v4 the fourth argument
     * @param v5 the fifth argument
     * @param v6 the sixth argument
     * @return the result
     */
    R get(int index, T1 v1, T2 v2, T3 v3, T4 v4, T5 v5, T6 v6);
}
