package com.github.mekkiseghier.zipper;

import com.github.mekkiseghier.zipper.accumulators.Accumulator19;
import com.github.mekkiseghier.zipper.consumers.Consumer19;
import com.github.mekkiseghier.zipper.functions.Function19;
import com.github.mekkiseghier.zipper.predicates.Predicate19;
import com.github.mekkiseghier.zipper.tuples.Tuple19;

import java.util.ArrayList;
import java.util.List;
/**
 * A type-safe stream-like utility for working with 19 parallel lists of values.
 * <p>
 * {@code Zipper19} enables index-aware, type-safe, and readable iteration over 19 lists in parallel.
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
 * Zipper19<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19> stream =
 *     Zipper.addLists(list1, list2, list3, list4, list5, list6, list7, list8, list9, list10, list11, list12, list13, list14, list15, list16, list17, list18, list19);
 *
 * stream.forEach((i, v1, v2, v3, v4, v5, v6, v7, v8, v9, v10, v11, v12, v13, v14, v15, v16, v17, v18, v19) -> {
 *     System.out.println(i + ": " + v1 + ", " + v2 + ", " + v3 + ", " + v4 + ", " + v5 + ", " + v6 + ", " + v7 + ", " + v8 + ", " + v9 + ", " + v10 + ", " + v11 + ", " + v12 + ", " + v13 + ", " + v14 + ", " + v15 + ", " + v16 + ", " + v17 + ", " + v18 + ", " + v19");
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
 * @param <T11> the type of elements in list 11
 * @param <T12> the type of elements in list 12
 * @param <T13> the type of elements in list 13
 * @param <T14> the type of elements in list 14
 * @param <T15> the type of elements in list 15
 * @param <T16> the type of elements in list 16
 * @param <T17> the type of elements in list 17
 * @param <T18> the type of elements in list 18
 * @param <T19> the type of elements in list 19
 * @see com.github.mekkiseghier.zipper.Zipper
 */

public class Zipper19<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19> {
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
    private final List<T11> list11;
    private final List<T12> list12;
    private final List<T13> list13;
    private final List<T14> list14;
    private final List<T15> list15;
    private final List<T16> list16;
    private final List<T17> list17;
    private final List<T18> list18;
    private final List<T19> list19;
    private final int size;

    public Zipper19(List<T1> list1, List<T2> list2, List<T3> list3, List<T4> list4, List<T5> list5, List<T6> list6, List<T7> list7, List<T8> list8, List<T9> list9, List<T10> list10, List<T11> list11, List<T12> list12, List<T13> list13, List<T14> list14, List<T15> list15, List<T16> list16, List<T17> list17, List<T18> list18, List<T19> list19) {
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
        if (list11.size() != expectedSize) throw new IllegalArgumentException("List sizes must match");
        if (list12.size() != expectedSize) throw new IllegalArgumentException("List sizes must match");
        if (list13.size() != expectedSize) throw new IllegalArgumentException("List sizes must match");
        if (list14.size() != expectedSize) throw new IllegalArgumentException("List sizes must match");
        if (list15.size() != expectedSize) throw new IllegalArgumentException("List sizes must match");
        if (list16.size() != expectedSize) throw new IllegalArgumentException("List sizes must match");
        if (list17.size() != expectedSize) throw new IllegalArgumentException("List sizes must match");
        if (list18.size() != expectedSize) throw new IllegalArgumentException("List sizes must match");
        if (list19.size() != expectedSize) throw new IllegalArgumentException("List sizes must match");
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
        this.list11 = list11;
        this.list12 = list12;
        this.list13 = list13;
        this.list14 = list14;
        this.list15 = list15;
        this.list16 = list16;
        this.list17 = list17;
        this.list18 = list18;
        this.list19 = list19;
        this.size = expectedSize;
    }

    /**
     * Adds a new array of elements to this {@link Zipper19}, producing a {@link Zipper20}
     * that enables parallel index-aware iteration over 20 sequences.
     *
     * <p>The number of provided elements must match the size of the existing lists to
     * maintain index alignment.</p>
     *
     * <pre>{@code
     * streamX19.addElements(v1, v2, v3)
     *        .forEach((i, ...) -> { ... });
     * }</pre>
     *
     * @param values the array of new elements to include
     * @param <T20> the type of the new elements
     * @return a {@code Zipper20<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20>} representing the parallel lists
     * @throws IllegalArgumentException if the number of elements does not match the existing size
     */

     @SafeVarargs    public final <T20> Zipper20 <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20> addElements( T20... values) {
        if (values.length != size) throw new IllegalArgumentException("List size mismatch");
        List<T20> safeList =new ArrayList<>(values.length);
        for (T20 item :  List.of(values) ) safeList.add(item);
        return new Zipper20 <>(list1, list2, list3, list4, list5, list6, list7, list8, list9, list10, list11, list12, list13, list14, list15, list16, list17, list18, list19, safeList);
    }


    /**
     * Adds a new list to this {@link Zipper19}, producing a {@link Zipper20} that enables
     * parallel index-aware iteration over 20 lists.
     *
     * <p>All lists must have the same size to maintain index alignment.</p>
     *
     * <pre>{@code
     * streamX19.addList(list20)
     *        .forEach((i, ...) -> { ... });
     * }</pre>
     *
     * @param list the new list to include in the stream
     * @param <T20> the type of elements in the new list
     * @return a {@code Zipper20<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20>} representing the parallel lists
     * @throws IllegalArgumentException if the provided list size does not match existing lists
     */
    public <T20> Zipper20<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20> addList(List<T20> list) {
        if (list.size() != size) {
            throw new IllegalArgumentException("List size mismatch");
        }
        return new Zipper20<>(list1, list2, list3, list4, list5, list6, list7, list8, list9, list10, list11, list12, list13, list14, list15, list16, list17, list18, list19, list);
    }



    /**
     * Performs the given action on each set of elements in parallel across 19 lists.
     * The index and corresponding elements are passed to the provided action.
     *
     * <pre>{@code
     * streamX19.forEach((i, a1, ..., a19) -> {
     *     // use i, a1, ..., a19
     * });
     * }</pre>
     *
     * @param action a lambda that receives the index and the 19 elements at that index
     */
    public void forEach(Consumer19<Integer, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19> action) {
        for (int i = 0; i < size; i++) {
            action.accept(i, list1.get(i), list2.get(i), list3.get(i), list4.get(i), list5.get(i), list6.get(i), list7.get(i), list8.get(i), list9.get(i), list10.get(i), list11.get(i), list12.get(i), list13.get(i), list14.get(i), list15.get(i), list16.get(i), list17.get(i), list18.get(i), list19.get(i));
        }
    }

    /**
     * Maps each indexed group of 19 elements into a new result using the provided mapper.
     *
     * <pre>{@code
     * List<R> results = streamX19.map((i, a1, ..., a19) -> {
     *     return ...; // return type R
     * });
     * }</pre>
     *
     * @param mapper a function that receives the index and 19 elements, and returns a result
     * @param <R> the result type of the mapping function
     * @return a list of mapped results
     */
    public <R> List<R> map(Function19<Integer, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, R> mapper) {
        List<R> results = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            results.add(mapper.apply(i, list1.get(i), list2.get(i), list3.get(i), list4.get(i), list5.get(i), list6.get(i), list7.get(i), list8.get(i), list9.get(i), list10.get(i), list11.get(i), list12.get(i), list13.get(i), list14.get(i), list15.get(i), list16.get(i), list17.get(i), list18.get(i), list19.get(i)));
        }
        return results;
    }

    /**
     * Filters elements based on a predicate applied to the indexed values.
     * Only entries for which the predicate returns true will remain.
     *
     * <pre>{@code
     * streamX19.filter((i, a1, ..., a19) -> condition)
     * }</pre>
     *
     * @param predicate the predicate to test each element group
     * @return a new {@code Zipper19<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19>} with filtered elements
     */
    public Zipper19<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19> filter(Predicate19<Integer, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19> predicate) {
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
        List<T11> filtered11 = new ArrayList<>();
        List<T12> filtered12 = new ArrayList<>();
        List<T13> filtered13 = new ArrayList<>();
        List<T14> filtered14 = new ArrayList<>();
        List<T15> filtered15 = new ArrayList<>();
        List<T16> filtered16 = new ArrayList<>();
        List<T17> filtered17 = new ArrayList<>();
        List<T18> filtered18 = new ArrayList<>();
        List<T19> filtered19 = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            if (predicate.test(i, list1.get(i), list2.get(i), list3.get(i), list4.get(i), list5.get(i), list6.get(i), list7.get(i), list8.get(i), list9.get(i), list10.get(i), list11.get(i), list12.get(i), list13.get(i), list14.get(i), list15.get(i), list16.get(i), list17.get(i), list18.get(i), list19.get(i))) {
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
                filtered11.add(list11.get(i));
                filtered12.add(list12.get(i));
                filtered13.add(list13.get(i));
                filtered14.add(list14.get(i));
                filtered15.add(list15.get(i));
                filtered16.add(list16.get(i));
                filtered17.add(list17.get(i));
                filtered18.add(list18.get(i));
                filtered19.add(list19.get(i));
            }
        }
        return new Zipper19<>(filtered1, filtered2, filtered3, filtered4, filtered5, filtered6, filtered7, filtered8, filtered9, filtered10, filtered11, filtered12, filtered13, filtered14, filtered15, filtered16, filtered17, filtered18, filtered19);
    }
    /**
     * Reduces all elements into a single result using the given accumulator function.
     *
     * <pre>{@code
     * R result = streamX19.reduce(initialValue, (acc, i, a1, ..., a19) -> ...);
     * }</pre>
     *
     * @param identity the initial accumulator value
     * @param accumulator the function to apply to each indexed group and the accumulator
     * @param <R> the result type of the reduction
     * @return the reduced result
     */
    public <R> R reduce(R identity, Accumulator19<Integer, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, R> accumulator) {
        R result = identity;
        for (int i = 0; i < size; i++) {
            result = accumulator.reduce(i, list1.get(i), list2.get(i), list3.get(i), list4.get(i), list5.get(i), list6.get(i), list7.get(i), list8.get(i), list9.get(i), list10.get(i), list11.get(i), list12.get(i), list13.get(i), list14.get(i), list15.get(i), list16.get(i), list17.get(i), list18.get(i), list19.get(i));
        }
        return result;
    }


    /**
     * Converts this stream into a list of {@code Tuple19} objects,
     * each containing the index and corresponding elements from all lists.
     * <p>
     * Useful for exporting the stream as immutable indexed tuples.
     * </p>
     *
     * @return a list of {@code Tuple19<Integer, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19>} entries.
     */
    public List<Tuple19<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19>> asTupleList() {
        List<Tuple19<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19>> result = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            result.add(new Tuple19<>(i, list1.get(i), list2.get(i), list3.get(i), list4.get(i), list5.get(i), list6.get(i), list7.get(i), list8.get(i), list9.get(i), list10.get(i), list11.get(i), list12.get(i), list13.get(i), list14.get(i), list15.get(i), list16.get(i), list17.get(i), list18.get(i), list19.get(i)));
        }
        return result;
    }

    /**
     * Checks whether all indexed element groups match the given predicate.
     *
     * @param predicate the predicate to apply to each element group and index
     * @return true if all match, false otherwise
     */
    public boolean allMatch(Predicate19<Integer, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19> predicate) {
        for (int i = 0; i < list1.size(); i++) {
            if (!predicate.test(i, list1.get(i), list2.get(i), list3.get(i), list4.get(i), list5.get(i), list6.get(i), list7.get(i), list8.get(i), list9.get(i), list10.get(i), list11.get(i), list12.get(i), list13.get(i), list14.get(i), list15.get(i), list16.get(i), list17.get(i), list18.get(i), list19.get(i))) return false;
        }
        return true;
    }

    /**
     * Checks whether any indexed element group matches the given predicate.
     *
     * @param predicate the predicate to test each group
     * @return true if any match, false otherwise
     */
    public boolean anyMatch(Predicate19<Integer, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19> predicate) {
        for (int i = 0; i < list1.size(); i++) {
            if (predicate.test(i, list1.get(i), list2.get(i), list3.get(i), list4.get(i), list5.get(i), list6.get(i), list7.get(i), list8.get(i), list9.get(i), list10.get(i), list11.get(i), list12.get(i), list13.get(i), list14.get(i), list15.get(i), list16.get(i), list17.get(i), list18.get(i), list19.get(i))) return true;
        }
        return false;
    }

    /**
     * Applies the given action to each indexed element group without modifying the stream.
     *
     * @param action the action to perform on each group
     * @return this stream for further chaining
     */
    public Zipper19<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19> peek(Consumer19<Integer, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19> action) {
        for (int i = 0; i < list1.size(); i++) {
            action.accept(i, list1.get(i), list2.get(i), list3.get(i), list4.get(i), list5.get(i), list6.get(i), list7.get(i), list8.get(i), list9.get(i), list10.get(i), list11.get(i), list12.get(i), list13.get(i), list14.get(i), list15.get(i), list16.get(i), list17.get(i), list18.get(i), list19.get(i));
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
