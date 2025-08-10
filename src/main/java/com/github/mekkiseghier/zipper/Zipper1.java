package com.github.mekkiseghier.zipper;

import com.github.mekkiseghier.zipper.accumulators.Accumulator1;
import com.github.mekkiseghier.zipper.consumers.Consumer1;
import com.github.mekkiseghier.zipper.functions.Function1;
import com.github.mekkiseghier.zipper.predicates.Predicate1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * A type-safe stream-like utility for working with 1 parallel lists of values.
 * <p>
 * {@code Zipper1} enables index-aware, type-safe, and readable iteration over 1 lists in parallel.
 * It provides fluent operations like {@code forEach}, {@code map}, {@code filter}, {@code addList},
 * and {@code addElements}, while maintaining element alignment based on their positions (0-based index).
 * </p>

 * <p>
 * Each operation enforces size equality across all lists at runtime,
 * ensuring consistency of the parallel stream.
 * </p>

 * <p>
 * Example usage:
 * </p>
 *
 * <pre>{@code
 * Zipper1<T1> stream =
 *     Zipper.addLists(list1);
 *
 * stream.forEach((i, v1) -> {
 *     System.out.println(i + ": " + v1");
 * });
 * }</pre>

 * @param <T1> the type of elements in list 1
 * @see com.github.mekkiseghier.zipper.Zipper
 */


public class Zipper1 < T1 > {
    private final List <  T1 > list1;

    Zipper1( List < T1 > list1 ) {
        this.list1 = list1;
    }
    /**
     * Adds a new array of elements to this {@link Zipper1}, producing a {@link Zipper2}
     * that enables parallel index-aware iteration over 2 sequences.
     *
     * <p>The number of provided elements must match the size of the existing lists to
     * maintain index alignment.</p>
     *
     * <pre>{@code
     * streamX1.addElements(v1, v2, v3)
     *        .forEach((i, ...) -> { ... });
     * }</pre>
     *
     * @param values the array of new elements to include
     * @param <T2> the type of the new elements
     * @return a {@code Zipper2<T1, T2>} representing the parallel lists
     * @throws IllegalArgumentException if the number of elements does not match the existing size
     */
    @SafeVarargs public final < T2 > Zipper2 < T1, T2 > addElements( T2... values ) {
        return new Zipper2 <>( list1, List.of( values ) );
    }
    /**
     * Adds a new list to this {@link Zipper1}, producing a {@link Zipper2} that enables
     * parallel index-aware iteration over 2 lists.
     *
     * <p>All lists must have the same size to maintain index alignment.</p>
     *
     * <pre>{@code
     * streamX1.addList(list)
     *        .forEach((i, ...) -> { ... });
     * }</pre>
     *
     * @param list the new list to include in the stream
     * @param <T2> the type of elements in the new list
     * @return a {@code Zipper2<T1, T2>} representing the parallel lists
     * @throws IllegalArgumentException if the provided list size does not match existing lists
     */
    public < T2 > Zipper2 < T1, T2 > addList( List < T2 > list ) {
        return new Zipper2 <>( list1, list );
    }
    /**
     * Performs the given action on the set of elements across 1 list.
     * The index and corresponding elements are passed to the provided action.
     *
     * <pre>{@code
     * streamX1.forEach((i, a1) -> {
     *     // use i, a1
     * });
     * }</pre>
     *
     * @param action a lambda that receives the index and the 1 element at that index
     */
    public void forEach( Consumer1 < Integer, T1 > action ) {
        int size = Collections.min( List.of( list1.size() ) );
        for ( int i = 0; i < size; i++ ) {
            action.accept( i, list1.get( i ) );
        }
    }
    /**
     * Filters elements based on a predicate applied to the indexed values.
     * Only entries for which the predicate returns true will remain.
     *
     * <pre>{@code
     * streamX1.filter((i, a1, ..., a1) -> condition)
     * }</pre>
     *
     * @param predicate the predicate to test each element group
     * @return a new {@code Zipper1<T1>} with filtered elements
     */
    public Zipper1 < T1 > filter( Predicate1 < Integer, T1 > predicate ) {
        List < T1 > filtered1 = new ArrayList <>();
        for ( int i = 0; i < list1.size(); i++ ) {
            if ( predicate.test( i, list1.get( i ) ) ) {
                filtered1.add( list1.get( i ) );
            }
        }
        return new Zipper1 <>( filtered1 );
    }/**
     * Reduces all elements into a single result using the given reducer function.
     *
     * <pre>{@code
     * R result = streamX1.reduce(initialValue, (acc, i, a1, ..., a1) -> ...);
     * }</pre>
     *
     * @param identity the initial accumulator value
     * @param accumulator the function to apply to each indexed group and the accumulator
     * @param <R> the result type of the reduction
     * @return the reduced result
     */
    public < R > R reduce( R identity, Accumulator1 < Integer, T1, R > accumulator ) {
        R result = identity;
        for ( int i = 0; i < list1.size(); i++ ) {
            result = accumulator.reduce( i, list1.get( i ) );
        }
        return result;
    }




    public List < T1 > asList() {
        return list1;
    }


    /**
     * Maps the indexed group of an element into a new result using the provided mapper.
     *
     * <pre>{@code
     * List<R> results = streamX2.map((i, a1) -> {
     *     return ...; // return type R
     * });
     * }</pre>
     *
     * @param mapper a function that receives the index and 1 elements, and returns a result
     * @param <R> the result type of the mapping function
     * @return a list of mapped results
     */
    /**
     * Maps each indexed group of an element into a new result using the provided mapper.
     *
     * <pre>{@code
     * List<R> results = streamX1.map((i, a1) -> {
     *     return ...; // return type R
     * });
     * }</pre>
     *
     * @param mapper a function that receives the index and 1 element, and returns a result
     * @param <R> the result type of the mapping function
     * @return a list of mapped results
     */
    public < R > List < R > map( Function1 < Integer, T1, R > mapper ) {
        List < R > mapped1 = new ArrayList <>();
        for ( int i = 0; i < list1.size(); i++ ) {
            mapped1.add( mapper.apply( i, list1.get( i ) ) );
        }
        return mapped1;
    }

    public Zipper1 < T1 > sortedBy( Comparator < T1 > comparator ) {
        list1.sort( comparator );
        return new Zipper1 <>( list1 );
    }


    /**
     * Checks whether all indexed element groups match the given predicate.
     *
     * @param predicate the predicate to apply to each element group and index
     * @return true if all match, false otherwise
     */
    public boolean allMatch(Predicate1<Integer, T1> predicate) {
        for (int i = 0; i < list1.size(); i++) {
            if (!predicate.test(i, list1.get(i))) return false;
        }
        return true;
    }

    /**
     * Checks whether any indexed element group matches the given predicate.
     *
     * @param predicate the predicate to test each group
     * @return true if any match, false otherwise
     */
    public boolean anyMatch(Predicate1<Integer, T1> predicate) {
        for (int i = 0; i < list1.size(); i++) {
            if (predicate.test(i, list1.get(i))) return true;
        }
        return false;
    }

    /**
     * Applies the given action to each indexed element group without modifying the stream.
     *
     * @param action the action to perform on each group
     * @return this stream for further chaining
     */
    public Zipper1<T1> peek(Consumer1<Integer, T1> action) {
        for (int i = 0; i < list1.size(); i++) {
            action.accept(i, list1.get(i));
        }
        return this;
    }

    /**
     * @return the number of elements in the stream
     */
    public int size() {
        return list1.size();
    }





}

