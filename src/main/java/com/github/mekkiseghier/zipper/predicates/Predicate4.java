package com.github.mekkiseghier.zipper.predicates;

/**
 * Represents a predicate (boolean-valued function) that tests 4 values
 * and is aware of the index position during iteration.
 *
 * @param <I> the type of the index (usually {@code Integer})
 * @param <T1> the type of the first argument
 * @param <T2> the type of the second argument
 * @param <T3> the type of the third argument
 * @param <T4> the type of the fourth argument
 */
@FunctionalInterface
public interface Predicate4<I, T1, T2, T3, T4> {

    /**
     * Evaluates this predicate on the given arguments.
     *
     * @param index the index position in the iteration
     * @param v1 the first value to test
     * @param v2 the second value to test
     * @param v3 the third value to test
     * @param v4 the fourth value to test
     * @return {@code true} if the input matches the predicate, otherwise {@code false}
     */
    boolean test(I index, T1 v1, T2 v2, T3 v3, T4 v4);
}
