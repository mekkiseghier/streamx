package com.github.mekkiseghier.zipper;

import com.github.mekkiseghier.zipper.accumulators.Accumulator3;
import com.github.mekkiseghier.zipper.consumers.Consumer3;
import com.github.mekkiseghier.zipper.functions.Function3;
import com.github.mekkiseghier.zipper.predicates.Predicate3;
import com.github.mekkiseghier.zipper.tuples.Tuple3;

import java.util.ArrayList;
import java.util.List;


/**
 * A type-safe stream-like utility for working with 3 parallel lists of values.
 * <p>
 * {@code Zipper3} enables index-aware, type-safe, and readable iteration over 3 lists in parallel.
 * It provides fluent operations like {@code forEach}, {@code map}, {@code filter}, {@code zipList},
 * and {@code zip}, while maintaining element alignment based on their positions (0-based index).
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
 * Zipper3<T1, T2, T3> stream =
 *     Zipper.zipLists(list1, list2, list3);
 *
 * stream.forEach((i, v1, v2, v3) -> {
 *     System.out.println(i + ": " + v1 + ", " + v2 + ", " + v3");
 * });
 * }</pre>

 * @param <T1> the type of elements in list 1
 * @param <T2> the type of elements in list 2
 * @param <T3> the type of elements in list 3
 * @see com.github.mekkiseghier.zipper.Zipper
 */


public class Zipper3<T1, T2, T3> {
    private final List<T1> list1;
    private final List<T2> list2;
    private final List<T3> list3;
    private final int size;

    public Zipper3(List<T1> list1, List<T2> list2, List<T3> list3) {
        int expectedSize = list1.size();
        if (list2.size() != expectedSize) throw new IllegalArgumentException("List sizes must match");
        if (list3.size() != expectedSize) throw new IllegalArgumentException("List sizes must match");
        this.list1 = list1;
        this.list2 = list2;
        this.list3 = list3;
        this.size = expectedSize;
    }

    /**
     * Adds a new array of elements to this {@link Zipper3}, producing a {@link Zipper4}
     * that enables parallel index-aware iteration over 4 sequences.
     *
     * <p>The number of provided elements must match the size of the existing lists to
     * maintain index alignment.</p>
     *
     * <pre>{@code
     * streamX3.zip(v1, v2, v3)
     *        .forEach((i, ...) -> { ... });
     * }</pre>
     *
     * @param values the array of new elements to include
     * @param <T4> the type of the new elements
     * @return a {@code Zipper4<T1, T2, T3, T4>} representing the parallel lists
     * @throws IllegalArgumentException if the number of elements does not match the existing size
     */
     @SafeVarargs    public final <T4> Zipper4 <T1, T2, T3, T4> zip4( T4... values) {
        if (values.length != size) throw new IllegalArgumentException("List size mismatch");
        List<T4> safeList =new ArrayList<>(values.length);
        for (T4 item :  List.of(values) ) safeList.add(item);
          Zipper4 <T1, T2, T3, T4> stream= new Zipper4 <>(list1, list2, list3, safeList);

          return stream;
    }

    /**
     * Adds a new list to this {@link Zipper3}, producing a {@link Zipper4} that enables
     * parallel index-aware iteration over 4 lists.
     *
     * <p>All lists must have the same size to maintain index alignment.</p>
     *
     * <pre>{@code
     * streamX3.zipList(list4)
     *        .forEach((i, ...) -> { ... });
     * }</pre>
     *
     * @param list the new list to include in the stream
     * @param <T4> the type of elements in the new list
     * @return a {@code Zipper4<T1, T2, T3, T4>} representing the parallel lists
     * @throws IllegalArgumentException if the provided list size does not match existing lists
     */
    public <T4> Zipper4<T1, T2, T3, T4> zipList4(List<T4> list) {
        if (list.size() != size) {
            throw new IllegalArgumentException("List size mismatch");
        }
        return new Zipper4<>(list1, list2, list3, list);
    }



    /**
     * Performs the given action on each set of elements in parallel across 3 lists.
     * The index and corresponding elements are passed to the provided action.
     *
     * <pre>{@code
     * streamX3.forEach((i, a1, ..., a3) -> {
     *     // use i, a1, ..., a3
     * });
     * }</pre>
     *
     * @param action a lambda that receives the index and the 3 elements at that index
     */
    public void forEach3(Consumer3<Integer, T1, T2, T3> action) {
        for (int i = 0; i < size; i++) {
            action.accept(i, list1.get(i), list2.get(i), list3.get(i));
        }
    }

    /**
     * Maps each indexed group of 3 elements into a new result using the provided mapper.
     *
     * <pre>{@code
     * List<R> results = streamX3.map((i, a1, ..., a3) -> {
     *     return ...; // return type R
     * });
     * }</pre>
     *
     * @param mapper a function that receives the index and 3 elements, and returns a result
     * @param <R> the result type of the mapping function
     * @return a list of mapped results
     */
    public <R> List<R> map3(Function3<Integer, T1, T2, T3, R> mapper) {
        List<R> results = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            results.add(mapper.apply(i, list1.get(i), list2.get(i), list3.get(i)));
        }
        return results;
    }

    /**
     * Filters elements based on a predicate applied to the indexed values.
     * Only entries for which the predicate returns true will remain.
     *
     * <pre>{@code
     * streamX3.filter((i, a1, ..., a3) -> condition)
     * }</pre>
     *
     * @param predicate the predicate to test each element group
     * @return a new {@code Zipper3<T1, T2, T3>} with filtered elements
     */
    public Zipper3<T1, T2, T3> filter3(Predicate3<Integer, T1, T2, T3> predicate) {
        List<T1> filtered1 = new ArrayList<>();
        List<T2> filtered2 = new ArrayList<>();
        List<T3> filtered3 = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            if (predicate.test(i, list1.get(i), list2.get(i), list3.get(i))) {
                filtered1.add(list1.get(i));
                filtered2.add(list2.get(i));
                filtered3.add(list3.get(i));
            }
        }
        return new Zipper3<>(filtered1, filtered2, filtered3);
    }
    /**
     * Reduces all elements into a single result using the given accumulator function.
     *
     * <pre>{@code
     * R result = streamX3.reduce(initialValue, (acc, i, a1, ..., a3) -> ...);
     * }</pre>
     *
     * @param identity the initial accumulator value
     * @param accumulator the function to apply to each indexed group and the accumulator
     * @param <R> the result type of the reduction
     * @return the reduced result
     */
    public <R> R reduce3(R identity, Accumulator3<Integer, T1, T2, T3, R> accumulator) {
        R result = identity;
        for (int i = 0; i < size; i++) {
            result = accumulator.reduce(i, list1.get(i), list2.get(i), list3.get(i));
        }
        return result;
    }


    /**
     * Converts this stream into a list of {@code Tuple3} objects,
     * each containing the index and corresponding elements from all lists.
     * <p>
     * Useful for exporting the stream as immutable indexed tuples.
     * </p>
     *
     * @return a list of {@code Tuple3<Integer, T1, T2, T3>} entries.
     */
    public List<Tuple3<T1, T2, T3>> asTupleList3() {
        List<Tuple3<T1, T2, T3>> result = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            result.add(new Tuple3<>(i, list1.get(i), list2.get(i), list3.get(i)));
        }
        return result;
    }
    /**
     * Checks whether all indexed element groups match the given predicate.
     *
     * @param predicate the predicate to apply to each element group and index
     * @return true if all match, false otherwise
     */
    public boolean allMatch3(Predicate3<Integer, T1, T2, T3> predicate) {
        for (int i = 0; i < list1.size(); i++) {
            if (!predicate.test(i, list1.get(i), list2.get(i), list3.get(i))) return false;
        }
        return true;
    }

    /**
     * Checks whether any indexed element group matches the given predicate.
     *
     * @param predicate the predicate to test each group
     * @return true if any match, false otherwise
     */
    public boolean anyMatch3(Predicate3<Integer, T1, T2, T3> predicate) {
        for (int i = 0; i < list1.size(); i++) {
            if (predicate.test(i, list1.get(i), list2.get(i), list3.get(i))) return true;
        }
        return false;
    }

    /**
     * Applies the given action to each indexed element group without modifying the stream.
     *
     * @param action the action to perform on each group
     * @return this stream for further chaining
     */
    public Zipper3<T1, T2, T3> peek3(Consumer3<Integer, T1, T2, T3> action) {
        for (int i = 0; i < list1.size(); i++) {
            action.accept(i, list1.get(i), list2.get(i), list3.get(i));
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
