package com.github.mekkiseghier.zipper.consumers;

/**
 * Represents an operation that accepts an index, and returns no result.
 * This is a functional interface
 * whose functional method is {@link #accept(Object)}.
 *
 * @param <I> the type of the index (usually {@code Integer})
 */
@FunctionalInterface
public interface Consumer0<I> {

    /**
     * Performs this operation on the given arguments.
     *
     * @param index the index position in the iteration
     */
    void accept(I index);
}
