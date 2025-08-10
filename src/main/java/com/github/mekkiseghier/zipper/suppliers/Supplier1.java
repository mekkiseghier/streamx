package com.github.mekkiseghier.zipper.suppliers;

/**
 * Represents a supplier of results that takes 1 element argument
 * and is aware of the index position during iteration.
 * @param <T1> the type of the first argument
 * @param <R> the type of results supplied
 */
@FunctionalInterface
public interface Supplier1<T1, R> {
    /**
     * Gets a result for the given index and arguments.
     *
     * @param index the zero-based index in the iteration
     * @param v1 the first argument
     * @return the result
     */
    R get(int index, T1 v1);
}
