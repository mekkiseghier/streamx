package com.github.mekkiseghier.zipper.accumulators;

/**
 * Represents an operation that combines an index and 3 arguments into a single result.
 * This is a functional interface
 * whose functional method is {@link #reduce(Object, Object, Object, Object)}.
 *
 * @param <I> the type of the index (usually {@code Integer})
 * @param <T1> the type of the first argument
 * @param <T2> the type of the second argument
 * @param <T3> the type of the third argument
 * @param <R> the type of the result
 */
@FunctionalInterface
public interface Accumulator3<I, T1, T2, T3, R> {

    /**
     * Combines the provided arguments into a single result.
     *
     * @param index the index position in the iteration
     * @param v1 the first argument
     * @param v2 the second argument
     * @param v3 the third argument
     * @return the result of combining the arguments
     */
    R reduce(I index, T1 v1, T2 v2, T3 v3);
}
