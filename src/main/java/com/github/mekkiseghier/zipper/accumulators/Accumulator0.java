package com.github.mekkiseghier.zipper.accumulators;

/**
 * Represents an operation that combines an index into a single result.
 * This is a functional interface
 * whose functional method is {@link #reduce(Object)}.
 *
 * @param <I> the type of the index (usually {@code Integer})
 * @param <R> the type of the result
 */
@FunctionalInterface
public interface Accumulator0<I, R> {

    /**
     * Combines the provided arguments into a single result.
     *
     * @param index the index position in the iteration
     * @return the result of combining the arguments
     */
    R reduce(I index);
}
