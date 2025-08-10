package com.github.mekkiseghier.zipper.suppliers;

/**
 * Represents a supplier of results that takes 3 element arguments
 * and is aware of the index position during iteration.
 * @param <T1> the type of the first argument
 * @param <T2> the type of the second argument
 * @param <T3> the type of the third argument
 * @param <R> the type of results supplied
 */
@FunctionalInterface
public interface Supplier3<T1, T2, T3, R> {
    /**
     * Gets a result for the given index and arguments.
     *
     * @param index the zero-based index in the iteration
     * @param v1 the first argument
     * @param v2 the second argument
     * @param v3 the third argument
     * @return the result
     */
    R get(int index, T1 v1, T2 v2, T3 v3);
}
