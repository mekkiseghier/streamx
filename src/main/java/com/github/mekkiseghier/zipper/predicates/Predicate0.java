package com.github.mekkiseghier.zipper.predicates;

/**
 * Represents a predicate (boolean-valued function) with no element arguments
 * and is aware of the index position during iteration.
 *
 * @param <I> the type of the index (usually {@code Integer})
 */
@FunctionalInterface
public interface Predicate0<I> {

    /**
     * Evaluates this predicate on the given arguments.
     *
     * @param index the index position in the iteration
     * @return {@code true} if the input matches the predicate, otherwise {@code false}
     */
    boolean test(I index);
}
