package com.github.mekkiseghier.zipper.predicates;

/**
 * Represents a predicate (boolean-valued function) that tests 3 values
 * and is aware of the index position during iteration.
 *
 * @param <I> the type of the index (usually {@code Integer})
 * @param <T1> the type of the first argument
 * @param <T2> the type of the second argument
 * @param <T3> the type of the third argument
 */
@FunctionalInterface
public interface Predicate3<I, T1, T2, T3> {

    /**
     * Evaluates this predicate on the given arguments.
     *
     * @param index the index position in the iteration
     * @param v1 the first value to test
     * @param v2 the second value to test
     * @param v3 the third value to test
     * @return {@code true} if the input matches the predicate, otherwise {@code false}
     */
    boolean test(I index, T1 v1, T2 v2, T3 v3);
}
