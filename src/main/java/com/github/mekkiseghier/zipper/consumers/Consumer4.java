package com.github.mekkiseghier.zipper.consumers;

/**
 * Represents an operation that accepts an index and 4 arguments, and returns no result.
 * This is a functional interface
 * whose functional method is {@link #accept(Object, Object, Object, Object, Object)}.
 *
 * @param <I> the type of the index (usually {@code Integer})
 * @param <T1> the type of the first argument
 * @param <T2> the type of the second argument
 * @param <T3> the type of the third argument
 * @param <T4> the type of the fourth argument
 */
@FunctionalInterface
public interface Consumer4<I, T1, T2, T3, T4> {

    /**
     * Performs this operation on the given arguments.
     *
     * @param index the index position in the iteration
     * @param v1 the first argument
     * @param v2 the second argument
     * @param v3 the third argument
     * @param v4 the fourth argument
     */
    void accept(I index, T1 v1, T2 v2, T3 v3, T4 v4);
}
