package com.github.mekkiseghier.zipper;

import com.github.mekkiseghier.zipper.accumulators.Accumulator6;
import com.github.mekkiseghier.zipper.consumers.Consumer6;
import com.github.mekkiseghier.zipper.functions.Function6;
import com.github.mekkiseghier.zipper.predicates.Predicate6;
import com.github.mekkiseghier.zipper.tuples.Tuple6;

import java.util.ArrayList;
import java.util.List;

/**
 * A type-safe stream-like utility for working with 6 parallel lists of values.
 * <p>
 * {@code Zipper6} enables index-aware, type-safe, and readable iteration over 6 lists in parallel.
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
 * Zipper6<T1, T2, T3, T4, T5, T6> stream =
 *     Zipper.zipLists(list1, list2, list3, list4, list5, list6);
 *
 * stream.forEach((i, v1, v2, v3, v4, v5, v6) -> {
 *     System.out.println(i + ": " + v1 + ", " + v2 + ", " + v3 + ", " + v4 + ", " + v5 + ", " + v6");
 * });
 * }</pre>

 * @param <T1> the type of elements in list 1
 * @param <T2> the type of elements in list 2
 * @param <T3> the type of elements in list 3
 * @param <T4> the type of elements in list 4
 * @param <T5> the type of elements in list 5
 * @param <T6> the type of elements in list 6
 * @see com.github.mekkiseghier.zipper.Zipper
 */

public class Zipper6<T1, T2, T3, T4, T5, T6> {
    private final List<T1> list1;
    private final List<T2> list2;
    private final List<T3> list3;
    private final List<T4> list4;
    private final List<T5> list5;
    private final List<T6> list6;
    private final int size;

    public Zipper6(List<T1> list1, List<T2> list2, List<T3> list3, List<T4> list4, List<T5> list5, List<T6> list6) {
        int expectedSize = list1.size();
        if (list2.size() != expectedSize) throw new IllegalArgumentException("List sizes must match");
        if (list3.size() != expectedSize) throw new IllegalArgumentException("List sizes must match");
        if (list4.size() != expectedSize) throw new IllegalArgumentException("List sizes must match");
        if (list5.size() != expectedSize) throw new IllegalArgumentException("List sizes must match");
        if (list6.size() != expectedSize) throw new IllegalArgumentException("List sizes must match");
        this.list1 = list1;
        this.list2 = list2;
        this.list3 = list3;
        this.list4 = list4;
        this.list5 = list5;
        this.list6 = list6;
        this.size = expectedSize;
    }

    /**
     * Adds a new array of elements to this {@link Zipper6}, producing a {@link Zipper7}
     * that enables parallel index-aware iteration over 7 sequences.
     *
     * <p>The number of provided elements must match the size of the existing lists to
     * maintain index alignment.</p>
     *
     * <pre>{@code
     * streamX6.zip(v1, v2, v3)
     *        .forEach((i, ...) -> { ... });
     * }</pre>
     *
     * @param values the array of new elements to include
     * @param <T7> the type of the new elements
     * @return a {@code Zipper7<T1, T2, T3, T4, T5, T6, T7>} representing the parallel lists
     * @throws IllegalArgumentException if the number of elements does not match the existing size
     */
     @SafeVarargs    public final <T7> Zipper7 <T1, T2, T3, T4, T5, T6, T7> zip7( T7... values) {
        if (values.length != size) throw new IllegalArgumentException("List size mismatch");
        List<T7> safeList =new ArrayList<>(values.length);
        for (T7 item :  List.of(values) ) safeList.add(item);
        return new Zipper7 <>(list1, list2, list3, list4, list5, list6, safeList);
    }


    /**
     * Adds a new list to this {@link Zipper6}, producing a {@link Zipper7} that enables
     * parallel index-aware iteration over 7 lists.
     *
     * <p>All lists must have the same size to maintain index alignment.</p>
     *
     * <pre>{@code
     * streamX6.zipList(list7)
     *        .forEach((i, ...) -> { ... });
     * }</pre>
     *
     * @param list the new list to include in the stream
     * @param <T7> the type of elements in the new list
     * @return a {@code Zipper7<T1, T2, T3, T4, T5, T6, T7>} representing the parallel lists
     * @throws IllegalArgumentException if the provided list size does not match existing lists
     */
    public <T7> Zipper7<T1, T2, T3, T4, T5, T6, T7> zipList7(List<T7> list) {
        if (list.size() != size) {
            throw new IllegalArgumentException("List size mismatch");
        }
        return new Zipper7<>(list1, list2, list3, list4, list5, list6, list);
    }


    /**
     * Performs the given action on each set of elements in parallel across 6 lists.
     * The index and corresponding elements are passed to the provided action.
     *
     * <pre>{@code
     * streamX6.forEach((i, a1, ..., a6) -> {
     *     // use i, a1, ..., a6
     * });
     * }</pre>
     *
     * @param action a lambda that receives the index and the 6 elements at that index
     */
    public void forEach6(Consumer6<Integer, T1, T2, T3, T4, T5, T6> action) {
        for (int i = 0; i < size; i++) {
            action.accept(i, list1.get(i), list2.get(i), list3.get(i), list4.get(i), list5.get(i), list6.get(i));
        }
    }

    /**
     * Maps each indexed group of 6 elements into a new result using the provided mapper.
     *
     * <pre>{@code
     * List<R> results = streamX6.map((i, a1, ..., a6) -> {
     *     return ...; // return type R
     * });
     * }</pre>
     *
     * @param mapper a function that receives the index and 6 elements, and returns a result
     * @param <R> the result type of the mapping function
     * @return a list of mapped results
     */
    public <R> List<R> map6(Function6<Integer, T1, T2, T3, T4, T5, T6, R> mapper) {
        List<R> results = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            results.add(mapper.apply(i, list1.get(i), list2.get(i), list3.get(i), list4.get(i), list5.get(i), list6.get(i)));
        }
        return results;
    }

    /**
     * Filters elements based on a predicate applied to the indexed values.
     * Only entries for which the predicate returns true will remain.
     *
     * <pre>{@code
     * streamX6.filter((i, a1, ..., a6) -> condition)
     * }</pre>
     *
     * @param predicate the predicate to test each element group
     * @return a new {@code Zipper6<T1, T2, T3, T4, T5, T6>} with filtered elements
     */
    public Zipper6<T1, T2, T3, T4, T5, T6> filter6(Predicate6<Integer, T1, T2, T3, T4, T5, T6> predicate) {
        List<T1> filtered1 = new ArrayList<>();
        List<T2> filtered2 = new ArrayList<>();
        List<T3> filtered3 = new ArrayList<>();
        List<T4> filtered4 = new ArrayList<>();
        List<T5> filtered5 = new ArrayList<>();
        List<T6> filtered6 = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            if (predicate.test(i, list1.get(i), list2.get(i), list3.get(i), list4.get(i), list5.get(i), list6.get(i))) {
                filtered1.add(list1.get(i));
                filtered2.add(list2.get(i));
                filtered3.add(list3.get(i));
                filtered4.add(list4.get(i));
                filtered5.add(list5.get(i));
                filtered6.add(list6.get(i));
            }
        }
        return new Zipper6<>(filtered1, filtered2, filtered3, filtered4, filtered5, filtered6);
    }
    /**
     * Reduces all elements into a single result using the given accumulator function.
     *
     * <pre>{@code
     * R result = streamX6.reduce(initialValue, (acc, i, a1, ..., a6) -> ...);
     * }</pre>
     *
     * @param identity the initial accumulator value
     * @param accumulator the function to apply to each indexed group and the accumulator
     * @param <R> the result type of the reduction
     * @return the reduced result
     */
    public <R> R reduce6(R identity, Accumulator6<Integer, T1, T2, T3, T4, T5, T6, R> accumulator) {
        R result = identity;
        for (int i = 0; i < size; i++) {
            result = accumulator.reduce(i, list1.get(i), list2.get(i), list3.get(i), list4.get(i), list5.get(i), list6.get(i));
        }
        return result;
    }

    /**
     * Converts this stream into a list of {@code Tuple6} objects,
     * each containing the index and corresponding elements from all lists.
     * <p>
     * Useful for exporting the stream as immutable indexed tuples.
     * </p>
     *
     * @return a list of {@code Tuple6<Integer, T1, T2, T3, T4, T5, T6>} entries.
     */
    public List<Tuple6<T1, T2, T3, T4, T5, T6>> asTupleList6() {
        List<Tuple6<T1, T2, T3, T4, T5, T6>> result = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            result.add(new Tuple6<>(i, list1.get(i), list2.get(i), list3.get(i), list4.get(i), list5.get(i), list6.get(i)));
        }
        return result;
    }
    /**
     * Checks whether all indexed element groups match the given predicate.
     *
     * @param predicate the predicate to apply to each element group and index
     * @return true if all match, false otherwise
     */
    public boolean allMatch6(Predicate6<Integer, T1, T2, T3, T4, T5, T6> predicate) {
        for (int i = 0; i < list1.size(); i++) {
            if (!predicate.test(i, list1.get(i), list2.get(i), list3.get(i), list4.get(i), list5.get(i), list6.get(i))) return false;
        }
        return true;
    }

    /**
     * Checks whether any indexed element group matches the given predicate.
     *
     * @param predicate the predicate to test each group
     * @return true if any match, false otherwise
     */
    public boolean anyMatch6(Predicate6<Integer, T1, T2, T3, T4, T5, T6> predicate) {
        for (int i = 0; i < list1.size(); i++) {
            if (predicate.test(i, list1.get(i), list2.get(i), list3.get(i), list4.get(i), list5.get(i), list6.get(i))) return true;
        }
        return false;
    }

    /**
     * Applies the given action to each indexed element group without modifying the stream.
     *
     * @param action the action to perform on each group
     * @return this stream for further chaining
     */
    public Zipper6<T1, T2, T3, T4, T5, T6> peek6(Consumer6<Integer, T1, T2, T3, T4, T5, T6> action) {
        for (int i = 0; i < list1.size(); i++) {
            action.accept(i, list1.get(i), list2.get(i), list3.get(i), list4.get(i), list5.get(i), list6.get(i));
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
