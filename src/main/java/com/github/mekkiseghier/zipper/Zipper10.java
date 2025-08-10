package com.github.mekkiseghier.zipper;

import com.github.mekkiseghier.zipper.accumulators.Accumulator10;
import com.github.mekkiseghier.zipper.consumers.Consumer10;
import com.github.mekkiseghier.zipper.functions.Function10;
import com.github.mekkiseghier.zipper.predicates.Predicate10;
import com.github.mekkiseghier.zipper.tuples.Tuple10;

import java.util.ArrayList;
import java.util.List;


/**
 * A type-safe stream-like utility for working with 10 parallel lists of values.
 * <p>
 * {@code Zipper10} enables index-aware, type-safe, and readable iteration over 10 lists in parallel.
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
 * Zipper10<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10> stream =
 *     Zipper.addLists(list1, list2, list3, list4, list5, list6, list7, list8, list9, list10);
 *
 * stream.forEach((i, v1, v2, v3, v4, v5, v6, v7, v8, v9, v10) -> {
 *     System.out.println(i + ": " + v1 + ", " + v2 + ", " + v3 + ", " + v4 + ", " + v5 + ", " + v6 + ", " + v7 + ", " + v8 + ", " + v9 + ", " + v10");
 * });
 * }</pre>

 * @param <T1> the type of elements in list 1
 * @param <T2> the type of elements in list 2
 * @param <T3> the type of elements in list 3
 * @param <T4> the type of elements in list 4
 * @param <T5> the type of elements in list 5
 * @param <T6> the type of elements in list 6
 * @param <T7> the type of elements in list 7
 * @param <T8> the type of elements in list 8
 * @param <T9> the type of elements in list 9
 * @param <T10> the type of elements in list 10
 * @see com.github.mekkiseghier.zipper.Zipper
 */


public class Zipper10<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10> {
    private final List<T1> list1;
    private final List<T2> list2;
    private final List<T3> list3;
    private final List<T4> list4;
    private final List<T5> list5;
    private final List<T6> list6;
    private final List<T7> list7;
    private final List<T8> list8;
    private final List<T9> list9;
    private final List<T10> list10;
    private final int size;

    public Zipper10(List<T1> list1, List<T2> list2, List<T3> list3, List<T4> list4, List<T5> list5, List<T6> list6, List<T7> list7, List<T8> list8, List<T9> list9, List<T10> list10) {
        int expectedSize = list1.size();
        if (list2.size() != expectedSize) throw new IllegalArgumentException("List sizes must match");
        if (list3.size() != expectedSize) throw new IllegalArgumentException("List sizes must match");
        if (list4.size() != expectedSize) throw new IllegalArgumentException("List sizes must match");
        if (list5.size() != expectedSize) throw new IllegalArgumentException("List sizes must match");
        if (list6.size() != expectedSize) throw new IllegalArgumentException("List sizes must match");
        if (list7.size() != expectedSize) throw new IllegalArgumentException("List sizes must match");
        if (list8.size() != expectedSize) throw new IllegalArgumentException("List sizes must match");
        if (list9.size() != expectedSize) throw new IllegalArgumentException("List sizes must match");
        if (list10.size() != expectedSize) throw new IllegalArgumentException("List sizes must match");
        this.list1 = list1;
        this.list2 = list2;
        this.list3 = list3;
        this.list4 = list4;
        this.list5 = list5;
        this.list6 = list6;
        this.list7 = list7;
        this.list8 = list8;
        this.list9 = list9;
        this.list10 = list10;
        this.size = expectedSize;
    }

    /**
     * Adds a new array of elements to this {@link Zipper10}, producing a {@link Zipper11}
     * that enables parallel index-aware iteration over 11 sequences.
     *
     * <p>The number of provided elements must match the size of the existing lists to
     * maintain index alignment.</p>
     *
     * <pre>{@code
     * streamX10.addElements(v1, v2, v3)
     *        .forEach((i, ...) -> { ... });
     * }</pre>
     *
     * @param values the array of new elements to include
     * @param <T11> the type of the new elements
     * @return a {@code Zipper11<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11>} representing the parallel lists
     * @throws IllegalArgumentException if the number of elements does not match the existing size
     */
     @SafeVarargs    public final <T11> Zipper11 <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11> addElements( T11... values) {
        if (values.length != size) throw new IllegalArgumentException("List size mismatch");
        List<T11> safeList =new ArrayList<>(values.length);
        for (T11 item :  List.of(values) ) safeList.add(item);
        return new Zipper11 <>(list1, list2, list3, list4, list5, list6, list7, list8, list9, list10, safeList);
    }

    /**
     * Adds a new list to this {@link Zipper10}, producing a {@link Zipper11} that enables
     * parallel index-aware iteration over 11 lists.
     *
     * <p>All lists must have the same size to maintain index alignment.</p>
     *
     * <pre>{@code
     * streamX10.addList(list11)
     *        .forEach((i, ...) -> { ... });
     * }</pre>
     *
     * @param list the new list to include in the stream
     * @param <T11> the type of elements in the new list
     * @return a {@code Zipper11<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11>} representing the parallel lists
     * @throws IllegalArgumentException if the provided list size does not match existing lists
     */
    public <T11> Zipper11<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11> addList(List<T11> list) {
        if (list.size() != size) {
            throw new IllegalArgumentException("List size mismatch");
        }
        return new Zipper11<>(list1, list2, list3, list4, list5, list6, list7, list8, list9, list10, list);
    }

    /**
     * Performs the given action on each set of elements in parallel across 10 lists.
     * The index and corresponding elements are passed to the provided action.
     *
     * <pre>{@code
     * streamX10.forEach((i, a1, ..., a10) -> {
     *     // use i, a1, ..., a10
     * });
     * }</pre>
     *
     * @param action a lambda that receives the index and the 10 elements at that index
     */
    public void forEach(Consumer10<Integer, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10> action) {
        for (int i = 0; i < size; i++) {
            action.accept(i, list1.get(i), list2.get(i), list3.get(i), list4.get(i), list5.get(i), list6.get(i), list7.get(i), list8.get(i), list9.get(i), list10.get(i));
        }
    }

    /**
     * Maps each indexed group of 10 elements into a new result using the provided mapper.
     *
     * <pre>{@code
     * List<R> results = streamX10.map((i, a1, ..., a10) -> {
     *     return ...; // return type R
     * });
     * }</pre>
     *
     * @param mapper a function that receives the index and 10 elements, and returns a result
     * @param <R> the result type of the mapping function
     * @return a list of mapped results
     */
    public <R> List<R> map(Function10<Integer, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, R> mapper) {
        List<R> results = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            results.add(mapper.apply(i, list1.get(i), list2.get(i), list3.get(i), list4.get(i), list5.get(i), list6.get(i), list7.get(i), list8.get(i), list9.get(i), list10.get(i)));
        }
        return results;
    }

    /**
     * Filters elements based on a predicate applied to the indexed values.
     * Only entries for which the predicate returns true will remain.
     *
     * <pre>{@code
     * streamX10.filter((i, a1, ..., a10) -> condition)
     * }</pre>
     *
     * @param predicate the predicate to test each element group
     * @return a new {@code Zipper10<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10>} with filtered elements
     */
    public Zipper10<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10> filter(Predicate10<Integer, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10> predicate) {
        List<T1> filtered1 = new ArrayList<>();
        List<T2> filtered2 = new ArrayList<>();
        List<T3> filtered3 = new ArrayList<>();
        List<T4> filtered4 = new ArrayList<>();
        List<T5> filtered5 = new ArrayList<>();
        List<T6> filtered6 = new ArrayList<>();
        List<T7> filtered7 = new ArrayList<>();
        List<T8> filtered8 = new ArrayList<>();
        List<T9> filtered9 = new ArrayList<>();
        List<T10> filtered10 = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            if (predicate.test(i, list1.get(i), list2.get(i), list3.get(i), list4.get(i), list5.get(i), list6.get(i), list7.get(i), list8.get(i), list9.get(i), list10.get(i))) {
                filtered1.add(list1.get(i));
                filtered2.add(list2.get(i));
                filtered3.add(list3.get(i));
                filtered4.add(list4.get(i));
                filtered5.add(list5.get(i));
                filtered6.add(list6.get(i));
                filtered7.add(list7.get(i));
                filtered8.add(list8.get(i));
                filtered9.add(list9.get(i));
                filtered10.add(list10.get(i));
            }
        }
        return new Zipper10<>(filtered1, filtered2, filtered3, filtered4, filtered5, filtered6, filtered7, filtered8, filtered9, filtered10);
    }
    /**
     * Reduces all elements into a single result using the given accumulator function.
     *
     * <pre>{@code
     * R result = streamX10.reduce(initialValue, (acc, i, a1, ..., a10) -> ...);
     * }</pre>
     *
     * @param identity the initial accumulator value
     * @param accumulator the function to apply to each indexed group and the accumulator
     * @param <R> the result type of the reduction
     * @return the reduced result
     */
    public <R> R reduce(R identity, Accumulator10<Integer, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, R> accumulator) {
        R result = identity;
        for (int i = 0; i < size; i++) {
            result = accumulator.reduce(i, list1.get(i), list2.get(i), list3.get(i), list4.get(i), list5.get(i), list6.get(i), list7.get(i), list8.get(i), list9.get(i), list10.get(i));
        }
        return result;
    }

    /**
     * Converts this stream into a list of {@code Tuple10} objects,
     * each containing the index and corresponding elements from all lists.
     * <p>
     * Useful for exporting the stream as immutable indexed tuples.
     * </p>
     *
     * @return a list of {@code Tuple10<Integer, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10>} entries.
     */
    public List<Tuple10<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10>> asTupleList() {
        List<Tuple10<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10>> result = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            result.add(new Tuple10<>(i, list1.get(i), list2.get(i), list3.get(i), list4.get(i), list5.get(i), list6.get(i), list7.get(i), list8.get(i), list9.get(i), list10.get(i)));
        }
        return result;
    }
    /**
     * Checks whether all indexed element groups match the given predicate.
     *
     * @param predicate the predicate to apply to each element group and index
     * @return true if all match, false otherwise
     */
    public boolean allMatch(Predicate10<Integer, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10> predicate) {
        for (int i = 0; i < list1.size(); i++) {
            if (!predicate.test(i, list1.get(i), list2.get(i), list3.get(i), list4.get(i), list5.get(i), list6.get(i), list7.get(i), list8.get(i), list9.get(i), list10.get(i))) return false;
        }
        return true;
    }

    /**
     * Checks whether any indexed element group matches the given predicate.
     *
     * @param predicate the predicate to test each group
     * @return true if any match, false otherwise
     */
    public boolean anyMatch(Predicate10<Integer, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10> predicate) {
        for (int i = 0; i < list1.size(); i++) {
            if (predicate.test(i, list1.get(i), list2.get(i), list3.get(i), list4.get(i), list5.get(i), list6.get(i), list7.get(i), list8.get(i), list9.get(i), list10.get(i))) return true;
        }
        return false;
    }

    /**
     * Applies the given action to each indexed element group without modifying the stream.
     *
     * @param action the action to perform on each group
     * @return this stream for further chaining
     */
    public Zipper10<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10> peek(Consumer10<Integer, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10> action) {
        for (int i = 0; i < list1.size(); i++) {
            action.accept(i, list1.get(i), list2.get(i), list3.get(i), list4.get(i), list5.get(i), list6.get(i), list7.get(i), list8.get(i), list9.get(i), list10.get(i));
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
