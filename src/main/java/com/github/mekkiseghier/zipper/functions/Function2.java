package com.github.mekkiseghier.zipper.functions;

/**
 * Represents a function that accepts an index and 2 arguments,
 * and produces a result.
 *
 * @param <I> the type of the index (usually {@code Integer})
 * @param <T1> the type of the first argument
 * @param <T2> the type of the second argument
 * @param <R> the type of the result
 */
@FunctionalInterface
public interface Function2<I, T1, T2, R> {

    /**
     * Applies this function to the given arguments.
     *
     * @param index the index position in the iteration
     * @param v1 the first argument
     * @param v2 the second argument
     * @return the function result
     */
    R apply(I index, T1 v1, T2 v2);
}
