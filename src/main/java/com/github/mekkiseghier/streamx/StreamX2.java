package com.github.mekkiseghier.streamx;

import com.github.mekkiseghier.streamx.accumulators.Accumulator2;
import com.github.mekkiseghier.streamx.consumers.Consumer2;
import com.github.mekkiseghier.streamx.functions.Function2;
import com.github.mekkiseghier.streamx.predicates.Predicate2;
import com.github.mekkiseghier.streamx.tuples.Tuple2;

import java.util.ArrayList;
import java.util.List;

/**
 * A type-safe stream-like utility for working with 2 parallel lists of values.
 * <p>
 * {@code StreamX2} enables index-aware, type-safe, and readable iteration over 2 lists in parallel.
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
 * StreamX2<T1, T2> stream =
 *     StreamX.addLists(list1, list2);
 *
 * stream.forEach((i, v1, v2) -> {
 *     System.out.println(i + ": " + v1 + ", " + v2");
 * });
 * }</pre>

 * @param <T1> the type of elements in list 1
 * @param <T2> the type of elements in list 2
 * @see com.github.mekkiseghier.streamx.StreamX
 */

public class StreamX2 < T1, T2 > {
    private final List < T1 > list1;
    private final List < T2 > list2;
    private final int size;

    public StreamX2( List < T1 > list1, List < T2 > list2 ) {
        int expectedSize = list1.size();
        if ( list2.size() != expectedSize ) {
            throw new IllegalArgumentException( "List sizes must match" );
        }
        this.list1 = list1;
        this.list2 = list2;
        this.size = expectedSize;
    }
    /**
     * Adds a new array of elements to this {@link StreamX2}, producing a {@link StreamX3}
     * that enables parallel index-aware iteration over 3 sequences.
     *
     * <p>The number of provided elements must match the size of the existing lists to
     * maintain index alignment.</p>
     *
     * <pre>{@code
     * streamX2.addElements(v1, v2, v3)
     *        .forEach((i, ...) -> { ... });
     * }</pre>
     *
     * @param values the array of new elements to include
     * @param <T3> the type of the new elements
     * @return a {@code StreamX3<T1, T2, T3>} representing the parallel lists
     * @throws IllegalArgumentException if the number of elements does not match the existing size
     */
    @SafeVarargs public final < T3 > StreamX3 < T1, T2, T3 > addElements( T3... values ) {
        if ( values.length != size ) {
            throw new IllegalArgumentException( "List size mismatch" );
        }
        return new StreamX3( list1, list2, List.of( values ) );
    }

    /**
     * Adds a new list to this {@link StreamX2}, producing a {@link StreamX3} that enables
     * parallel index-aware iteration over 3 lists.
     *
     * <p>All lists must have the same size to maintain index alignment.</p>
     *
     * <pre>{@code
     * streamX2.addList(list3)
     *        .forEach((i, ...) -> { ... });
     * }</pre>
     *
     * @param list the new list to include in the stream
     * @param <T3> the type of elements in the new list
     * @return a {@code StreamX3<T1, T2, T3>} representing the parallel lists
     * @throws IllegalArgumentException if the provided list size does not match existing lists
     */
    public <T3> StreamX3<T1, T2, T3> addList(List<T3> list) {
        if (list.size() != size) {
            throw new IllegalArgumentException("List size mismatch");
        }
        return new StreamX3<>(list1, list2, list);
    }


    /**
     * Performs the given action on each set of elements in parallel across 2 lists.
     * The index and corresponding elements are passed to the provided action.
     *
     * <pre>{@code
     * streamX2.forEach((i, a1, ..., a2) -> {
     *     // use i, a1, ..., a2
     * });
     * }</pre>
     *
     * @param action a lambda that receives the index and the 2 elements at that index
     */
    public void forEach(Consumer2<Integer, T1, T2> action) {
        for (int i = 0; i < size; i++) {
            action.accept(i, list1.get(i), list2.get(i));
        }
    }

    /**
     * Maps each indexed group of 2 elements into a new result using the provided mapper.
     *
     * <pre>{@code
     * List<R> results = streamX2.map((i, a1, ..., a2) -> {
     *     return ...; // return type R
     * });
     * }</pre>
     *
     * @param mapper a function that receives the index and 2 elements, and returns a result
     * @param <R> the result type of the mapping function
     * @return a list of mapped results
     */
    /**
     * Maps each indexed group of 2 elements into a new result using the provided mapper.
     *
     * <pre>{@code
     * List<R> results = streamX2.map((i, a1, ..., a2) -> {
     *     return ...; // return type R
     * });
     * }</pre>
     *
     * @param mapper a function that receives the index and 2 elements, and returns a result
     * @param <R> the result type of the mapping function
     * @return a list of mapped results
     */
    public <R> List<R> map(Function2<Integer, T1, T2, R> mapper) {
        List<R> results = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            results.add(mapper.apply(i, list1.get(i), list2.get(i)));
        }
        return results;
    }
    /**
     * Filters elements based on a predicate applied to the indexed values.
     * Only entries for which the predicate returns true will remain.
     *
     * <pre>{@code
     * streamX2.filter((i, a1, ..., a2) -> condition)
     * }</pre>
     *
     * @param predicate the predicate to test each element group
     * @return a new {@code StreamX2<T1, T2>} with filtered elements
     */
    public StreamX2 < T1, T2 > filter( Predicate2 < Integer, T1, T2 > predicate ) {
        List < T1 > filtered1 = new ArrayList <>();
        List < T2 > filtered2 = new ArrayList <>();
        for ( int i = 0; i < size; i++ ) {
            if ( predicate.test( i, list1.get( i ), list2.get( i ) ) ) {
                filtered1.add( list1.get( i ) );
                filtered2.add( list2.get( i ) );
            }
        }
        return new StreamX2 <>( filtered1, filtered2 );
    }
    /**
     * Reduces all elements into a single result using the given accumulator function.
     *
     * <pre>{@code
     * R result = streamX2.reduce(initialValue, (acc, i, a1, ..., a2) -> ...);
     * }</pre>
     *
     * @param identity the initial accumulator value
     * @param accumulator the function to apply to each indexed group and the accumulator
     * @param <R> the result type of the reduction
     * @return the reduced result
     */
    public < R > R reduce( R identity, Accumulator2 < Integer, T1, T2, R > accumulator ) {
        R result = identity;
        for ( int i = 0; i < size; i++ ) {
            result = accumulator.reduce( i, list1.get( i ), list2.get( i ) );
        }
        return result;
    }

    /**
     * Converts this stream into a list of {@code Tuple2} objects,
     * each containing the index and corresponding elements from all lists.
     * <p>
     * Useful for exporting the stream as immutable indexed tuples.
     * </p>
     *
     * @return a list of {@code Tuple2<Integer, T1, T2>} entries.
     */
    public List<Tuple2<T1, T2>> asTupleList() {
        List<Tuple2<T1, T2>> result = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            result.add(new Tuple2<>(i, list1.get(i), list2.get(i)));
        }
        return result;
    }


    /**
     * Checks whether all indexed element groups match the given predicate.
     *
     * @param predicate the predicate to apply to each element group and index
     * @return true if all match, false otherwise
     */
    public boolean allMatch(Predicate2<Integer, T1, T2> predicate) {
        for (int i = 0; i < list1.size(); i++) {
            if (!predicate.test(i, list1.get(i), list2.get(i))) return false;
        }
        return true;
    }

    /**
     * Checks whether any indexed element group matches the given predicate.
     *
     * @param predicate the predicate to test each group
     * @return true if any match, false otherwise
     */
    public boolean anyMatch(Predicate2<Integer, T1, T2> predicate) {
        for (int i = 0; i < list1.size(); i++) {
            if (predicate.test(i, list1.get(i), list2.get(i))) return true;
        }
        return false;
    }

    /**
     * Applies the given action to each indexed element group without modifying the stream.
     *
     * @param action the action to perform on each group
     * @return this stream for further chaining
     */
    public StreamX2<T1, T2> peek(Consumer2<Integer, T1, T2> action) {
        for (int i = 0; i < list1.size(); i++) {
            action.accept(i, list1.get(i), list2.get(i));
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
