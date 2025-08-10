package com.github.mekkiseghier.zipper.predicates;

/**
 * Represents a predicate (boolean-valued function) that tests 1 value
 * and is aware of the index position during iteration.
 *
 * @param <I> the type of the index (usually {@code Integer})
 * @param <T1> the type of the first argument
 */
@FunctionalInterface
public interface Predicate1<I, T1> {

    /**
     * Evaluates this predicate on the given arguments.
     *
     * @param index the index position in the iteration
     * @param v1 the first value to test
     * @return {@code true} if the input matches the predicate, otherwise {@code false}
     */
    boolean test(I index, T1 v1);
}
