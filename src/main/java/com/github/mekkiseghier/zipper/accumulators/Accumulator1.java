package com.github.mekkiseghier.zipper.accumulators;

/**
 * Represents an operation that combines an index and 1 argument into a single result.
 * This is a functional interface
 * whose functional method is {@link #reduce(Object, Object)}.
 *
 * @param <I> the type of the index (usually {@code Integer})
 * @param <T1> the type of the first argument
 * @param <R> the type of the result
 */
@FunctionalInterface
public interface Accumulator1<I, T1, R> {

    /**
     * Combines the provided arguments into a single result.
     *
     * @param index the index position in the iteration
     * @param v1 the first argument
     * @return the result of combining the arguments
     */
    R reduce(I index, T1 v1);
}
