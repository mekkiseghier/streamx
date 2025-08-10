package com.github.mekkiseghier.zipper.consumers;

/**
 * Represents an operation that accepts an index and 1 argument, and returns no result.
 * This is a functional interface
 * whose functional method is {@link #accept(Object, Object)}.
 *
 * @param <I> the type of the index (usually {@code Integer})
 * @param <T1> the type of the first argument
 */
@FunctionalInterface
public interface Consumer1<I, T1> {

    /**
     * Performs this operation on the given arguments.
     *
     * @param index the index position in the iteration
     * @param v1 the first argument
     */
    void accept(I index, T1 v1);
}
