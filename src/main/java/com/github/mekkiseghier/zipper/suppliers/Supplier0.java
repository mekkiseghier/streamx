package com.github.mekkiseghier.zipper.suppliers;

/**
 * Represents a supplier of results that takes no element arguments
 * and is aware of the index position during iteration.
 * @param <R> the type of results supplied
 */
@FunctionalInterface
public interface Supplier0<R> {
    /**
     * Gets a result for the given index.
     *
     * @param index the zero-based index in the iteration
     * @return the result
     */
    R get(int index);
}
