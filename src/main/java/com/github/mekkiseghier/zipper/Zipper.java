package com.github.mekkiseghier.zipper;

import com.github.mekkiseghier.zipper.suppliers.Supplier0;

import java.util.ArrayList;
import java.util.List;

/**
 * Zipper — Main factory class for creating index-aware parallel streams of lists.
 * Entry point to construct parallel, index-aware streams using {@code Zipper1} through {@code Zipper20}.
 * <p>
 * Each static method here initializes a stream of typed lists — supporting from 1 up to 20 parallel lists —
 * enabling functional-style processing with full type safety and index awareness.
 * </p>
 * <p>
 * This class avoids reflection, casts, and external dependencies.
 * </p>
 * <p><strong>Usage Examples:</strong></p>
 * <pre>{@code
 * // From values
 * Zipper.addElements("A", "B", "C")
 *        .forEach((i, v) -> System.out.println(i + ": " + v));
 *
 * // From multiple lists
 * Zipper.addLists(List.of("A", "B"), List.of(1, 2))
 *        .map((i, a, b) -> a + b);
 * }</pre>
 * Developed by Mekki Seghier as part of the Zipper utility library.
 *
 * @author Mekki Seghier
 * @since 1.0
 */

public class Zipper {
    public static void main( String[] args ) {
        Zipper.addElements("A","B","C" ).addElements(10,20,30 ).addElements(true,false,true )
                .forEach((i, str, num, flag) ->
                                System.out.println(i + ": " + str + ", " + num + ", " + flag)
//  Type-checked, no casting required
                );
    }

    /**
     * Creates a {@link Zipper1} from given values.
     *
     * @param values the elements to wrap in a stream
     * @param <T1>   type of elements
     * @return {@code Zipper1<T1>} representing the stream
     */
    public static < T1 > Zipper1 < T1 > addElements( T1... values ) {
        return new Zipper1 <>( List.of( values ) );
    }

    /**
     * Creates a {@link Zipper1} from a single list.
     *
     * @param list1 source list
     * @param <T1>  type of elements
     * @return {@code Zipper1<T1>}
     */
    public static < T1 > Zipper1 < T1 > addList( List < ? extends T1 > list1 ) {
        return new Zipper1 <>( new ArrayList <>( list1 ) );
    }
    /**
     * Creates a {@code Zipper2} by combining 2 parallel lists.
     * Each list must have the same size.
     *
     * @param list1 the list of type {@code T1}
     * @param list2 the list of type {@code T2}
     * @return a {@code Zipper2} instance with the provided lists
     * @throws IllegalArgumentException if list sizes are not equal
     */
    public static <T1, T2> Zipper2<T1, T2> addLists(List<? extends T1> list1, List<? extends T2> list2) {
        int size = list1.size();
        if (list2.size() != size) throw new IllegalArgumentException("List size mismatch");
        return new Zipper2<>(new ArrayList<>(list1), new ArrayList<>(list2));
    }

    /**
     * Creates a {@code Zipper3} by combining 3 parallel lists.
     * Each list must have the same size.
     *
     * @param list1 the list of type {@code T1}
     * @param list2 the list of type {@code T2}
     * @param list3 the list of type {@code T3}
     * @return a {@code Zipper3} instance with the provided lists
     * @throws IllegalArgumentException if list sizes are not equal
     */
    public static <T1, T2, T3> Zipper3<T1, T2, T3> addLists(List<? extends T1> list1, List<? extends T2> list2, List<? extends T3> list3) {
        int size = list1.size();
        if (list2.size() != size) throw new IllegalArgumentException("List size mismatch");
        if (list3.size() != size) throw new IllegalArgumentException("List size mismatch");
        return new Zipper3<>(new ArrayList<>(list1), new ArrayList<>(list2), new ArrayList<>(list3));
    }

    /**
     * Creates a {@code Zipper4} by combining 4 parallel lists.
     * Each list must have the same size.
     *
     * @param list1 the list of type {@code T1}
     * @param list2 the list of type {@code T2}
     * @param list3 the list of type {@code T3}
     * @param list4 the list of type {@code T4}
     * @return a {@code Zipper4} instance with the provided lists
     * @throws IllegalArgumentException if list sizes are not equal
     */
    public static <T1, T2, T3, T4> Zipper4<T1, T2, T3, T4> addLists(List<? extends T1> list1, List<? extends T2> list2, List<? extends T3> list3, List<? extends T4> list4) {
        int size = list1.size();
        if (list2.size() != size) throw new IllegalArgumentException("List size mismatch");
        if (list3.size() != size) throw new IllegalArgumentException("List size mismatch");
        if (list4.size() != size) throw new IllegalArgumentException("List size mismatch");
        return new Zipper4<>(new ArrayList<>(list1), new ArrayList<>(list2), new ArrayList<>(list3), new ArrayList<>(list4));
    }

    /**
     * Creates a {@code Zipper5} by combining 5 parallel lists.
     * Each list must have the same size.
     *
     * @param list1 the list of type {@code T1}
     * @param list2 the list of type {@code T2}
     * @param list3 the list of type {@code T3}
     * @param list4 the list of type {@code T4}
     * @param list5 the list of type {@code T5}
     * @return a {@code Zipper5} instance with the provided lists
     * @throws IllegalArgumentException if list sizes are not equal
     */
    public static <T1, T2, T3, T4, T5> Zipper5<T1, T2, T3, T4, T5> addLists(List<? extends T1> list1, List<? extends T2> list2, List<? extends T3> list3, List<? extends T4> list4, List<? extends T5> list5) {
        int size = list1.size();
        if (list2.size() != size) throw new IllegalArgumentException("List size mismatch");
        if (list3.size() != size) throw new IllegalArgumentException("List size mismatch");
        if (list4.size() != size) throw new IllegalArgumentException("List size mismatch");
        if (list5.size() != size) throw new IllegalArgumentException("List size mismatch");
        return new Zipper5<>(new ArrayList<>(list1), new ArrayList<>(list2), new ArrayList<>(list3), new ArrayList<>(list4), new ArrayList<>(list5));
    }

    /**
     * Creates a {@code Zipper6} by combining 6 parallel lists.
     * Each list must have the same size.
     *
     * @param list1 the list of type {@code T1}
     * @param list2 the list of type {@code T2}
     * @param list3 the list of type {@code T3}
     * @param list4 the list of type {@code T4}
     * @param list5 the list of type {@code T5}
     * @param list6 the list of type {@code T6}
     * @return a {@code Zipper6} instance with the provided lists
     * @throws IllegalArgumentException if list sizes are not equal
     */
    public static <T1, T2, T3, T4, T5, T6> Zipper6<T1, T2, T3, T4, T5, T6> addLists(List<? extends T1> list1, List<? extends T2> list2, List<? extends T3> list3, List<? extends T4> list4, List<? extends T5> list5, List<? extends T6> list6) {
        int size = list1.size();
        if (list2.size() != size) throw new IllegalArgumentException("List size mismatch");
        if (list3.size() != size) throw new IllegalArgumentException("List size mismatch");
        if (list4.size() != size) throw new IllegalArgumentException("List size mismatch");
        if (list5.size() != size) throw new IllegalArgumentException("List size mismatch");
        if (list6.size() != size) throw new IllegalArgumentException("List size mismatch");
        return new Zipper6<>(new ArrayList<>(list1), new ArrayList<>(list2), new ArrayList<>(list3), new ArrayList<>(list4), new ArrayList<>(list5), new ArrayList<>(list6));
    }

    /**
     * Creates a {@code Zipper7} by combining 7 parallel lists.
     * Each list must have the same size.
     *
     * @param list1 the list of type {@code T1}
     * @param list2 the list of type {@code T2}
     * @param list3 the list of type {@code T3}
     * @param list4 the list of type {@code T4}
     * @param list5 the list of type {@code T5}
     * @param list6 the list of type {@code T6}
     * @param list7 the list of type {@code T7}
     * @return a {@code Zipper7} instance with the provided lists
     * @throws IllegalArgumentException if list sizes are not equal
     */
    public static <T1, T2, T3, T4, T5, T6, T7> Zipper7<T1, T2, T3, T4, T5, T6, T7> addLists(List<? extends T1> list1, List<? extends T2> list2, List<? extends T3> list3, List<? extends T4> list4, List<? extends T5> list5, List<? extends T6> list6, List<? extends T7> list7) {
        int size = list1.size();
        if (list2.size() != size) throw new IllegalArgumentException("List size mismatch");
        if (list3.size() != size) throw new IllegalArgumentException("List size mismatch");
        if (list4.size() != size) throw new IllegalArgumentException("List size mismatch");
        if (list5.size() != size) throw new IllegalArgumentException("List size mismatch");
        if (list6.size() != size) throw new IllegalArgumentException("List size mismatch");
        if (list7.size() != size) throw new IllegalArgumentException("List size mismatch");
        return new Zipper7<>(new ArrayList<>(list1), new ArrayList<>(list2), new ArrayList<>(list3), new ArrayList<>(list4), new ArrayList<>(list5), new ArrayList<>(list6), new ArrayList<>(list7));
    }

    /**
     * Creates a {@code Zipper8} by combining 8 parallel lists.
     * Each list must have the same size.
     *
     * @param list1 the list of type {@code T1}
     * @param list2 the list of type {@code T2}
     * @param list3 the list of type {@code T3}
     * @param list4 the list of type {@code T4}
     * @param list5 the list of type {@code T5}
     * @param list6 the list of type {@code T6}
     * @param list7 the list of type {@code T7}
     * @param list8 the list of type {@code T8}
     * @return a {@code Zipper8} instance with the provided lists
     * @throws IllegalArgumentException if list sizes are not equal
     */
    public static <T1, T2, T3, T4, T5, T6, T7, T8> Zipper8<T1, T2, T3, T4, T5, T6, T7, T8> addLists(List<? extends T1> list1, List<? extends T2> list2, List<? extends T3> list3, List<? extends T4> list4, List<? extends T5> list5, List<? extends T6> list6, List<? extends T7> list7, List<? extends T8> list8) {
        int size = list1.size();
        if (list2.size() != size) throw new IllegalArgumentException("List size mismatch");
        if (list3.size() != size) throw new IllegalArgumentException("List size mismatch");
        if (list4.size() != size) throw new IllegalArgumentException("List size mismatch");
        if (list5.size() != size) throw new IllegalArgumentException("List size mismatch");
        if (list6.size() != size) throw new IllegalArgumentException("List size mismatch");
        if (list7.size() != size) throw new IllegalArgumentException("List size mismatch");
        if (list8.size() != size) throw new IllegalArgumentException("List size mismatch");
        return new Zipper8<>(new ArrayList<>(list1), new ArrayList<>(list2), new ArrayList<>(list3), new ArrayList<>(list4), new ArrayList<>(list5), new ArrayList<>(list6), new ArrayList<>(list7), new ArrayList<>(list8));
    }

    /**
     * Creates a {@code Zipper9} by combining 9 parallel lists.
     * Each list must have the same size.
     *
     * @param list1 the list of type {@code T1}
     * @param list2 the list of type {@code T2}
     * @param list3 the list of type {@code T3}
     * @param list4 the list of type {@code T4}
     * @param list5 the list of type {@code T5}
     * @param list6 the list of type {@code T6}
     * @param list7 the list of type {@code T7}
     * @param list8 the list of type {@code T8}
     * @param list9 the list of type {@code T9}
     * @return a {@code Zipper9} instance with the provided lists
     * @throws IllegalArgumentException if list sizes are not equal
     */
    public static <T1, T2, T3, T4, T5, T6, T7, T8, T9> Zipper9<T1, T2, T3, T4, T5, T6, T7, T8, T9> addLists(List<? extends T1> list1, List<? extends T2> list2, List<? extends T3> list3, List<? extends T4> list4, List<? extends T5> list5, List<? extends T6> list6, List<? extends T7> list7, List<? extends T8> list8, List<? extends T9> list9) {
        int size = list1.size();
        if (list2.size() != size) throw new IllegalArgumentException("List size mismatch");
        if (list3.size() != size) throw new IllegalArgumentException("List size mismatch");
        if (list4.size() != size) throw new IllegalArgumentException("List size mismatch");
        if (list5.size() != size) throw new IllegalArgumentException("List size mismatch");
        if (list6.size() != size) throw new IllegalArgumentException("List size mismatch");
        if (list7.size() != size) throw new IllegalArgumentException("List size mismatch");
        if (list8.size() != size) throw new IllegalArgumentException("List size mismatch");
        if (list9.size() != size) throw new IllegalArgumentException("List size mismatch");
        return new Zipper9<>(new ArrayList<>(list1), new ArrayList<>(list2), new ArrayList<>(list3), new ArrayList<>(list4), new ArrayList<>(list5), new ArrayList<>(list6), new ArrayList<>(list7), new ArrayList<>(list8), new ArrayList<>(list9));
    }

    /**
     * Creates a {@code Zipper10} by combining 10 parallel lists.
     * Each list must have the same size.
     *
     * @param list1 the list of type {@code T1}
     * @param list2 the list of type {@code T2}
     * @param list3 the list of type {@code T3}
     * @param list4 the list of type {@code T4}
     * @param list5 the list of type {@code T5}
     * @param list6 the list of type {@code T6}
     * @param list7 the list of type {@code T7}
     * @param list8 the list of type {@code T8}
     * @param list9 the list of type {@code T9}
     * @param list10 the list of type {@code T10}
     * @return a {@code Zipper10} instance with the provided lists
     * @throws IllegalArgumentException if list sizes are not equal
     */
    public static <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10> Zipper10<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10> addLists(List<? extends T1> list1, List<? extends T2> list2, List<? extends T3> list3, List<? extends T4> list4, List<? extends T5> list5, List<? extends T6> list6, List<? extends T7> list7, List<? extends T8> list8, List<? extends T9> list9, List<? extends T10> list10) {
        int size = list1.size();
        if (list2.size() != size) throw new IllegalArgumentException("List size mismatch");
        if (list3.size() != size) throw new IllegalArgumentException("List size mismatch");
        if (list4.size() != size) throw new IllegalArgumentException("List size mismatch");
        if (list5.size() != size) throw new IllegalArgumentException("List size mismatch");
        if (list6.size() != size) throw new IllegalArgumentException("List size mismatch");
        if (list7.size() != size) throw new IllegalArgumentException("List size mismatch");
        if (list8.size() != size) throw new IllegalArgumentException("List size mismatch");
        if (list9.size() != size) throw new IllegalArgumentException("List size mismatch");
        if (list10.size() != size) throw new IllegalArgumentException("List size mismatch");
        return new Zipper10<>(new ArrayList<>(list1), new ArrayList<>(list2), new ArrayList<>(list3), new ArrayList<>(list4), new ArrayList<>(list5), new ArrayList<>(list6), new ArrayList<>(list7), new ArrayList<>(list8), new ArrayList<>(list9), new ArrayList<>(list10));
    }

    /**
     * Creates a {@code Zipper11} by combining 11 parallel lists.
     * Each list must have the same size.
     *
     * @param list1 the list of type {@code T1}
     * @param list2 the list of type {@code T2}
     * @param list3 the list of type {@code T3}
     * @param list4 the list of type {@code T4}
     * @param list5 the list of type {@code T5}
     * @param list6 the list of type {@code T6}
     * @param list7 the list of type {@code T7}
     * @param list8 the list of type {@code T8}
     * @param list9 the list of type {@code T9}
     * @param list10 the list of type {@code T10}
     * @param list11 the list of type {@code T11}
     * @return a {@code Zipper11} instance with the provided lists
     * @throws IllegalArgumentException if list sizes are not equal
     */
    public static <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11> Zipper11<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11> addLists(List<? extends T1> list1, List<? extends T2> list2, List<? extends T3> list3, List<? extends T4> list4, List<? extends T5> list5, List<? extends T6> list6, List<? extends T7> list7, List<? extends T8> list8, List<? extends T9> list9, List<? extends T10> list10, List<? extends T11> list11) {
        int size = list1.size();
        if (list2.size() != size) throw new IllegalArgumentException("List size mismatch");
        if (list3.size() != size) throw new IllegalArgumentException("List size mismatch");
        if (list4.size() != size) throw new IllegalArgumentException("List size mismatch");
        if (list5.size() != size) throw new IllegalArgumentException("List size mismatch");
        if (list6.size() != size) throw new IllegalArgumentException("List size mismatch");
        if (list7.size() != size) throw new IllegalArgumentException("List size mismatch");
        if (list8.size() != size) throw new IllegalArgumentException("List size mismatch");
        if (list9.size() != size) throw new IllegalArgumentException("List size mismatch");
        if (list10.size() != size) throw new IllegalArgumentException("List size mismatch");
        if (list11.size() != size) throw new IllegalArgumentException("List size mismatch");
        return new Zipper11<>(new ArrayList<>(list1), new ArrayList<>(list2), new ArrayList<>(list3), new ArrayList<>(list4), new ArrayList<>(list5), new ArrayList<>(list6), new ArrayList<>(list7), new ArrayList<>(list8), new ArrayList<>(list9), new ArrayList<>(list10), new ArrayList<>(list11));
    }

    /**
     * Creates a {@code Zipper12} by combining 12 parallel lists.
     * Each list must have the same size.
     *
     * @param list1 the list of type {@code T1}
     * @param list2 the list of type {@code T2}
     * @param list3 the list of type {@code T3}
     * @param list4 the list of type {@code T4}
     * @param list5 the list of type {@code T5}
     * @param list6 the list of type {@code T6}
     * @param list7 the list of type {@code T7}
     * @param list8 the list of type {@code T8}
     * @param list9 the list of type {@code T9}
     * @param list10 the list of type {@code T10}
     * @param list11 the list of type {@code T11}
     * @param list12 the list of type {@code T12}
     * @return a {@code Zipper12} instance with the provided lists
     * @throws IllegalArgumentException if list sizes are not equal
     */
    public static <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12> Zipper12<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12> addLists(List<? extends T1> list1, List<? extends T2> list2, List<? extends T3> list3, List<? extends T4> list4, List<? extends T5> list5, List<? extends T6> list6, List<? extends T7> list7, List<? extends T8> list8, List<? extends T9> list9, List<? extends T10> list10, List<? extends T11> list11, List<? extends T12> list12) {
        int size = list1.size();
        if (list2.size() != size) throw new IllegalArgumentException("List size mismatch");
        if (list3.size() != size) throw new IllegalArgumentException("List size mismatch");
        if (list4.size() != size) throw new IllegalArgumentException("List size mismatch");
        if (list5.size() != size) throw new IllegalArgumentException("List size mismatch");
        if (list6.size() != size) throw new IllegalArgumentException("List size mismatch");
        if (list7.size() != size) throw new IllegalArgumentException("List size mismatch");
        if (list8.size() != size) throw new IllegalArgumentException("List size mismatch");
        if (list9.size() != size) throw new IllegalArgumentException("List size mismatch");
        if (list10.size() != size) throw new IllegalArgumentException("List size mismatch");
        if (list11.size() != size) throw new IllegalArgumentException("List size mismatch");
        if (list12.size() != size) throw new IllegalArgumentException("List size mismatch");
        return new Zipper12<>(new ArrayList<>(list1), new ArrayList<>(list2), new ArrayList<>(list3), new ArrayList<>(list4), new ArrayList<>(list5), new ArrayList<>(list6), new ArrayList<>(list7), new ArrayList<>(list8), new ArrayList<>(list9), new ArrayList<>(list10), new ArrayList<>(list11), new ArrayList<>(list12));
    }

    /**
     * Creates a {@code Zipper13} by combining 13 parallel lists.
     * Each list must have the same size.
     *
     * @param list1 the list of type {@code T1}
     * @param list2 the list of type {@code T2}
     * @param list3 the list of type {@code T3}
     * @param list4 the list of type {@code T4}
     * @param list5 the list of type {@code T5}
     * @param list6 the list of type {@code T6}
     * @param list7 the list of type {@code T7}
     * @param list8 the list of type {@code T8}
     * @param list9 the list of type {@code T9}
     * @param list10 the list of type {@code T10}
     * @param list11 the list of type {@code T11}
     * @param list12 the list of type {@code T12}
     * @param list13 the list of type {@code T13}
     * @return a {@code Zipper13} instance with the provided lists
     * @throws IllegalArgumentException if list sizes are not equal
     */
    public static <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13> Zipper13<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13> addLists(List<? extends T1> list1, List<? extends T2> list2, List<? extends T3> list3, List<? extends T4> list4, List<? extends T5> list5, List<? extends T6> list6, List<? extends T7> list7, List<? extends T8> list8, List<? extends T9> list9, List<? extends T10> list10, List<? extends T11> list11, List<? extends T12> list12, List<? extends T13> list13) {
        int size = list1.size();
        if (list2.size() != size) throw new IllegalArgumentException("List size mismatch");
        if (list3.size() != size) throw new IllegalArgumentException("List size mismatch");
        if (list4.size() != size) throw new IllegalArgumentException("List size mismatch");
        if (list5.size() != size) throw new IllegalArgumentException("List size mismatch");
        if (list6.size() != size) throw new IllegalArgumentException("List size mismatch");
        if (list7.size() != size) throw new IllegalArgumentException("List size mismatch");
        if (list8.size() != size) throw new IllegalArgumentException("List size mismatch");
        if (list9.size() != size) throw new IllegalArgumentException("List size mismatch");
        if (list10.size() != size) throw new IllegalArgumentException("List size mismatch");
        if (list11.size() != size) throw new IllegalArgumentException("List size mismatch");
        if (list12.size() != size) throw new IllegalArgumentException("List size mismatch");
        if (list13.size() != size) throw new IllegalArgumentException("List size mismatch");
        return new Zipper13<>(new ArrayList<>(list1), new ArrayList<>(list2), new ArrayList<>(list3), new ArrayList<>(list4), new ArrayList<>(list5), new ArrayList<>(list6), new ArrayList<>(list7), new ArrayList<>(list8), new ArrayList<>(list9), new ArrayList<>(list10), new ArrayList<>(list11), new ArrayList<>(list12), new ArrayList<>(list13));
    }

    /**
     * Creates a {@code Zipper14} by combining 14 parallel lists.
     * Each list must have the same size.
     *
     * @param list1 the list of type {@code T1}
     * @param list2 the list of type {@code T2}
     * @param list3 the list of type {@code T3}
     * @param list4 the list of type {@code T4}
     * @param list5 the list of type {@code T5}
     * @param list6 the list of type {@code T6}
     * @param list7 the list of type {@code T7}
     * @param list8 the list of type {@code T8}
     * @param list9 the list of type {@code T9}
     * @param list10 the list of type {@code T10}
     * @param list11 the list of type {@code T11}
     * @param list12 the list of type {@code T12}
     * @param list13 the list of type {@code T13}
     * @param list14 the list of type {@code T14}
     * @return a {@code Zipper14} instance with the provided lists
     * @throws IllegalArgumentException if list sizes are not equal
     */
    public static <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14> Zipper14<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14> addLists(List<? extends T1> list1, List<? extends T2> list2, List<? extends T3> list3, List<? extends T4> list4, List<? extends T5> list5, List<? extends T6> list6, List<? extends T7> list7, List<? extends T8> list8, List<? extends T9> list9, List<? extends T10> list10, List<? extends T11> list11, List<? extends T12> list12, List<? extends T13> list13, List<? extends T14> list14) {
        int size = list1.size();
        if (list2.size() != size) throw new IllegalArgumentException("List size mismatch");
        if (list3.size() != size) throw new IllegalArgumentException("List size mismatch");
        if (list4.size() != size) throw new IllegalArgumentException("List size mismatch");
        if (list5.size() != size) throw new IllegalArgumentException("List size mismatch");
        if (list6.size() != size) throw new IllegalArgumentException("List size mismatch");
        if (list7.size() != size) throw new IllegalArgumentException("List size mismatch");
        if (list8.size() != size) throw new IllegalArgumentException("List size mismatch");
        if (list9.size() != size) throw new IllegalArgumentException("List size mismatch");
        if (list10.size() != size) throw new IllegalArgumentException("List size mismatch");
        if (list11.size() != size) throw new IllegalArgumentException("List size mismatch");
        if (list12.size() != size) throw new IllegalArgumentException("List size mismatch");
        if (list13.size() != size) throw new IllegalArgumentException("List size mismatch");
        if (list14.size() != size) throw new IllegalArgumentException("List size mismatch");
        return new Zipper14<>(new ArrayList<>(list1), new ArrayList<>(list2), new ArrayList<>(list3), new ArrayList<>(list4), new ArrayList<>(list5), new ArrayList<>(list6), new ArrayList<>(list7), new ArrayList<>(list8), new ArrayList<>(list9), new ArrayList<>(list10), new ArrayList<>(list11), new ArrayList<>(list12), new ArrayList<>(list13), new ArrayList<>(list14));
    }

    /**
     * Creates a {@code Zipper15} by combining 15 parallel lists.
     * Each list must have the same size.
     *
     * @param list1 the list of type {@code T1}
     * @param list2 the list of type {@code T2}
     * @param list3 the list of type {@code T3}
     * @param list4 the list of type {@code T4}
     * @param list5 the list of type {@code T5}
     * @param list6 the list of type {@code T6}
     * @param list7 the list of type {@code T7}
     * @param list8 the list of type {@code T8}
     * @param list9 the list of type {@code T9}
     * @param list10 the list of type {@code T10}
     * @param list11 the list of type {@code T11}
     * @param list12 the list of type {@code T12}
     * @param list13 the list of type {@code T13}
     * @param list14 the list of type {@code T14}
     * @param list15 the list of type {@code T15}
     * @return a {@code Zipper15} instance with the provided lists
     * @throws IllegalArgumentException if list sizes are not equal
     */
    public static <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15> Zipper15<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15> addLists(List<? extends T1> list1, List<? extends T2> list2, List<? extends T3> list3, List<? extends T4> list4, List<? extends T5> list5, List<? extends T6> list6, List<? extends T7> list7, List<? extends T8> list8, List<? extends T9> list9, List<? extends T10> list10, List<? extends T11> list11, List<? extends T12> list12, List<? extends T13> list13, List<? extends T14> list14, List<? extends T15> list15) {
        int size = list1.size();
        if (list2.size() != size) throw new IllegalArgumentException("List size mismatch");
        if (list3.size() != size) throw new IllegalArgumentException("List size mismatch");
        if (list4.size() != size) throw new IllegalArgumentException("List size mismatch");
        if (list5.size() != size) throw new IllegalArgumentException("List size mismatch");
        if (list6.size() != size) throw new IllegalArgumentException("List size mismatch");
        if (list7.size() != size) throw new IllegalArgumentException("List size mismatch");
        if (list8.size() != size) throw new IllegalArgumentException("List size mismatch");
        if (list9.size() != size) throw new IllegalArgumentException("List size mismatch");
        if (list10.size() != size) throw new IllegalArgumentException("List size mismatch");
        if (list11.size() != size) throw new IllegalArgumentException("List size mismatch");
        if (list12.size() != size) throw new IllegalArgumentException("List size mismatch");
        if (list13.size() != size) throw new IllegalArgumentException("List size mismatch");
        if (list14.size() != size) throw new IllegalArgumentException("List size mismatch");
        if (list15.size() != size) throw new IllegalArgumentException("List size mismatch");
        return new Zipper15<>(new ArrayList<>(list1), new ArrayList<>(list2), new ArrayList<>(list3), new ArrayList<>(list4), new ArrayList<>(list5), new ArrayList<>(list6), new ArrayList<>(list7), new ArrayList<>(list8), new ArrayList<>(list9), new ArrayList<>(list10), new ArrayList<>(list11), new ArrayList<>(list12), new ArrayList<>(list13), new ArrayList<>(list14), new ArrayList<>(list15));
    }

    /**
     * Creates a {@code Zipper16} by combining 16 parallel lists.
     * Each list must have the same size.
     *
     * @param list1 the list of type {@code T1}
     * @param list2 the list of type {@code T2}
     * @param list3 the list of type {@code T3}
     * @param list4 the list of type {@code T4}
     * @param list5 the list of type {@code T5}
     * @param list6 the list of type {@code T6}
     * @param list7 the list of type {@code T7}
     * @param list8 the list of type {@code T8}
     * @param list9 the list of type {@code T9}
     * @param list10 the list of type {@code T10}
     * @param list11 the list of type {@code T11}
     * @param list12 the list of type {@code T12}
     * @param list13 the list of type {@code T13}
     * @param list14 the list of type {@code T14}
     * @param list15 the list of type {@code T15}
     * @param list16 the list of type {@code T16}
     * @return a {@code Zipper16} instance with the provided lists
     * @throws IllegalArgumentException if list sizes are not equal
     */
    public static <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16> Zipper16<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16> addLists(List<? extends T1> list1, List<? extends T2> list2, List<? extends T3> list3, List<? extends T4> list4, List<? extends T5> list5, List<? extends T6> list6, List<? extends T7> list7, List<? extends T8> list8, List<? extends T9> list9, List<? extends T10> list10, List<? extends T11> list11, List<? extends T12> list12, List<? extends T13> list13, List<? extends T14> list14, List<? extends T15> list15, List<? extends T16> list16) {
        int size = list1.size();
        if (list2.size() != size) throw new IllegalArgumentException("List size mismatch");
        if (list3.size() != size) throw new IllegalArgumentException("List size mismatch");
        if (list4.size() != size) throw new IllegalArgumentException("List size mismatch");
        if (list5.size() != size) throw new IllegalArgumentException("List size mismatch");
        if (list6.size() != size) throw new IllegalArgumentException("List size mismatch");
        if (list7.size() != size) throw new IllegalArgumentException("List size mismatch");
        if (list8.size() != size) throw new IllegalArgumentException("List size mismatch");
        if (list9.size() != size) throw new IllegalArgumentException("List size mismatch");
        if (list10.size() != size) throw new IllegalArgumentException("List size mismatch");
        if (list11.size() != size) throw new IllegalArgumentException("List size mismatch");
        if (list12.size() != size) throw new IllegalArgumentException("List size mismatch");
        if (list13.size() != size) throw new IllegalArgumentException("List size mismatch");
        if (list14.size() != size) throw new IllegalArgumentException("List size mismatch");
        if (list15.size() != size) throw new IllegalArgumentException("List size mismatch");
        if (list16.size() != size) throw new IllegalArgumentException("List size mismatch");
        return new Zipper16<>(new ArrayList<>(list1), new ArrayList<>(list2), new ArrayList<>(list3), new ArrayList<>(list4), new ArrayList<>(list5), new ArrayList<>(list6), new ArrayList<>(list7), new ArrayList<>(list8), new ArrayList<>(list9), new ArrayList<>(list10), new ArrayList<>(list11), new ArrayList<>(list12), new ArrayList<>(list13), new ArrayList<>(list14), new ArrayList<>(list15), new ArrayList<>(list16));
    }

    /**
     * Creates a {@code Zipper17} by combining 17 parallel lists.
     * Each list must have the same size.
     *
     * @param list1 the list of type {@code T1}
     * @param list2 the list of type {@code T2}
     * @param list3 the list of type {@code T3}
     * @param list4 the list of type {@code T4}
     * @param list5 the list of type {@code T5}
     * @param list6 the list of type {@code T6}
     * @param list7 the list of type {@code T7}
     * @param list8 the list of type {@code T8}
     * @param list9 the list of type {@code T9}
     * @param list10 the list of type {@code T10}
     * @param list11 the list of type {@code T11}
     * @param list12 the list of type {@code T12}
     * @param list13 the list of type {@code T13}
     * @param list14 the list of type {@code T14}
     * @param list15 the list of type {@code T15}
     * @param list16 the list of type {@code T16}
     * @param list17 the list of type {@code T17}
     * @return a {@code Zipper17} instance with the provided lists
     * @throws IllegalArgumentException if list sizes are not equal
     */
    public static <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17> Zipper17<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17> addLists(List<? extends T1> list1, List<? extends T2> list2, List<? extends T3> list3, List<? extends T4> list4, List<? extends T5> list5, List<? extends T6> list6, List<? extends T7> list7, List<? extends T8> list8, List<? extends T9> list9, List<? extends T10> list10, List<? extends T11> list11, List<? extends T12> list12, List<? extends T13> list13, List<? extends T14> list14, List<? extends T15> list15, List<? extends T16> list16, List<? extends T17> list17) {
        int size = list1.size();
        if (list2.size() != size) throw new IllegalArgumentException("List size mismatch");
        if (list3.size() != size) throw new IllegalArgumentException("List size mismatch");
        if (list4.size() != size) throw new IllegalArgumentException("List size mismatch");
        if (list5.size() != size) throw new IllegalArgumentException("List size mismatch");
        if (list6.size() != size) throw new IllegalArgumentException("List size mismatch");
        if (list7.size() != size) throw new IllegalArgumentException("List size mismatch");
        if (list8.size() != size) throw new IllegalArgumentException("List size mismatch");
        if (list9.size() != size) throw new IllegalArgumentException("List size mismatch");
        if (list10.size() != size) throw new IllegalArgumentException("List size mismatch");
        if (list11.size() != size) throw new IllegalArgumentException("List size mismatch");
        if (list12.size() != size) throw new IllegalArgumentException("List size mismatch");
        if (list13.size() != size) throw new IllegalArgumentException("List size mismatch");
        if (list14.size() != size) throw new IllegalArgumentException("List size mismatch");
        if (list15.size() != size) throw new IllegalArgumentException("List size mismatch");
        if (list16.size() != size) throw new IllegalArgumentException("List size mismatch");
        if (list17.size() != size) throw new IllegalArgumentException("List size mismatch");
        return new Zipper17<>(new ArrayList<>(list1), new ArrayList<>(list2), new ArrayList<>(list3), new ArrayList<>(list4), new ArrayList<>(list5), new ArrayList<>(list6), new ArrayList<>(list7), new ArrayList<>(list8), new ArrayList<>(list9), new ArrayList<>(list10), new ArrayList<>(list11), new ArrayList<>(list12), new ArrayList<>(list13), new ArrayList<>(list14), new ArrayList<>(list15), new ArrayList<>(list16), new ArrayList<>(list17));
    }

    /**
     * Creates a {@code Zipper18} by combining 18 parallel lists.
     * Each list must have the same size.
     *
     * @param list1 the list of type {@code T1}
     * @param list2 the list of type {@code T2}
     * @param list3 the list of type {@code T3}
     * @param list4 the list of type {@code T4}
     * @param list5 the list of type {@code T5}
     * @param list6 the list of type {@code T6}
     * @param list7 the list of type {@code T7}
     * @param list8 the list of type {@code T8}
     * @param list9 the list of type {@code T9}
     * @param list10 the list of type {@code T10}
     * @param list11 the list of type {@code T11}
     * @param list12 the list of type {@code T12}
     * @param list13 the list of type {@code T13}
     * @param list14 the list of type {@code T14}
     * @param list15 the list of type {@code T15}
     * @param list16 the list of type {@code T16}
     * @param list17 the list of type {@code T17}
     * @param list18 the list of type {@code T18}
     * @return a {@code Zipper18} instance with the provided lists
     * @throws IllegalArgumentException if list sizes are not equal
     */
    public static <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18> Zipper18<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18> addLists(List<? extends T1> list1, List<? extends T2> list2, List<? extends T3> list3, List<? extends T4> list4, List<? extends T5> list5, List<? extends T6> list6, List<? extends T7> list7, List<? extends T8> list8, List<? extends T9> list9, List<? extends T10> list10, List<? extends T11> list11, List<? extends T12> list12, List<? extends T13> list13, List<? extends T14> list14, List<? extends T15> list15, List<? extends T16> list16, List<? extends T17> list17, List<? extends T18> list18) {
        int size = list1.size();
        if (list2.size() != size) throw new IllegalArgumentException("List size mismatch");
        if (list3.size() != size) throw new IllegalArgumentException("List size mismatch");
        if (list4.size() != size) throw new IllegalArgumentException("List size mismatch");
        if (list5.size() != size) throw new IllegalArgumentException("List size mismatch");
        if (list6.size() != size) throw new IllegalArgumentException("List size mismatch");
        if (list7.size() != size) throw new IllegalArgumentException("List size mismatch");
        if (list8.size() != size) throw new IllegalArgumentException("List size mismatch");
        if (list9.size() != size) throw new IllegalArgumentException("List size mismatch");
        if (list10.size() != size) throw new IllegalArgumentException("List size mismatch");
        if (list11.size() != size) throw new IllegalArgumentException("List size mismatch");
        if (list12.size() != size) throw new IllegalArgumentException("List size mismatch");
        if (list13.size() != size) throw new IllegalArgumentException("List size mismatch");
        if (list14.size() != size) throw new IllegalArgumentException("List size mismatch");
        if (list15.size() != size) throw new IllegalArgumentException("List size mismatch");
        if (list16.size() != size) throw new IllegalArgumentException("List size mismatch");
        if (list17.size() != size) throw new IllegalArgumentException("List size mismatch");
        if (list18.size() != size) throw new IllegalArgumentException("List size mismatch");
        return new Zipper18<>(new ArrayList<>(list1), new ArrayList<>(list2), new ArrayList<>(list3), new ArrayList<>(list4), new ArrayList<>(list5), new ArrayList<>(list6), new ArrayList<>(list7), new ArrayList<>(list8), new ArrayList<>(list9), new ArrayList<>(list10), new ArrayList<>(list11), new ArrayList<>(list12), new ArrayList<>(list13), new ArrayList<>(list14), new ArrayList<>(list15), new ArrayList<>(list16), new ArrayList<>(list17), new ArrayList<>(list18));
    }

    /**
     * Creates a {@code Zipper19} by combining 19 parallel lists.
     * Each list must have the same size.
     *
     * @param list1 the list of type {@code T1}
     * @param list2 the list of type {@code T2}
     * @param list3 the list of type {@code T3}
     * @param list4 the list of type {@code T4}
     * @param list5 the list of type {@code T5}
     * @param list6 the list of type {@code T6}
     * @param list7 the list of type {@code T7}
     * @param list8 the list of type {@code T8}
     * @param list9 the list of type {@code T9}
     * @param list10 the list of type {@code T10}
     * @param list11 the list of type {@code T11}
     * @param list12 the list of type {@code T12}
     * @param list13 the list of type {@code T13}
     * @param list14 the list of type {@code T14}
     * @param list15 the list of type {@code T15}
     * @param list16 the list of type {@code T16}
     * @param list17 the list of type {@code T17}
     * @param list18 the list of type {@code T18}
     * @param list19 the list of type {@code T19}
     * @return a {@code Zipper19} instance with the provided lists
     * @throws IllegalArgumentException if list sizes are not equal
     */
    public static <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19> Zipper19<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19> addLists(List<? extends T1> list1, List<? extends T2> list2, List<? extends T3> list3, List<? extends T4> list4, List<? extends T5> list5, List<? extends T6> list6, List<? extends T7> list7, List<? extends T8> list8, List<? extends T9> list9, List<? extends T10> list10, List<? extends T11> list11, List<? extends T12> list12, List<? extends T13> list13, List<? extends T14> list14, List<? extends T15> list15, List<? extends T16> list16, List<? extends T17> list17, List<? extends T18> list18, List<? extends T19> list19) {
        int size = list1.size();
        if (list2.size() != size) throw new IllegalArgumentException("List size mismatch");
        if (list3.size() != size) throw new IllegalArgumentException("List size mismatch");
        if (list4.size() != size) throw new IllegalArgumentException("List size mismatch");
        if (list5.size() != size) throw new IllegalArgumentException("List size mismatch");
        if (list6.size() != size) throw new IllegalArgumentException("List size mismatch");
        if (list7.size() != size) throw new IllegalArgumentException("List size mismatch");
        if (list8.size() != size) throw new IllegalArgumentException("List size mismatch");
        if (list9.size() != size) throw new IllegalArgumentException("List size mismatch");
        if (list10.size() != size) throw new IllegalArgumentException("List size mismatch");
        if (list11.size() != size) throw new IllegalArgumentException("List size mismatch");
        if (list12.size() != size) throw new IllegalArgumentException("List size mismatch");
        if (list13.size() != size) throw new IllegalArgumentException("List size mismatch");
        if (list14.size() != size) throw new IllegalArgumentException("List size mismatch");
        if (list15.size() != size) throw new IllegalArgumentException("List size mismatch");
        if (list16.size() != size) throw new IllegalArgumentException("List size mismatch");
        if (list17.size() != size) throw new IllegalArgumentException("List size mismatch");
        if (list18.size() != size) throw new IllegalArgumentException("List size mismatch");
        if (list19.size() != size) throw new IllegalArgumentException("List size mismatch");
        return new Zipper19<>(new ArrayList<>(list1), new ArrayList<>(list2), new ArrayList<>(list3), new ArrayList<>(list4), new ArrayList<>(list5), new ArrayList<>(list6), new ArrayList<>(list7), new ArrayList<>(list8), new ArrayList<>(list9), new ArrayList<>(list10), new ArrayList<>(list11), new ArrayList<>(list12), new ArrayList<>(list13), new ArrayList<>(list14), new ArrayList<>(list15), new ArrayList<>(list16), new ArrayList<>(list17), new ArrayList<>(list18), new ArrayList<>(list19));
    }

    /**
     * Creates a {@code Zipper20} by combining 20 parallel lists.
     * Each list must have the same size.
     *
     * @param list1 the list of type {@code T1}
     * @param list2 the list of type {@code T2}
     * @param list3 the list of type {@code T3}
     * @param list4 the list of type {@code T4}
     * @param list5 the list of type {@code T5}
     * @param list6 the list of type {@code T6}
     * @param list7 the list of type {@code T7}
     * @param list8 the list of type {@code T8}
     * @param list9 the list of type {@code T9}
     * @param list10 the list of type {@code T10}
     * @param list11 the list of type {@code T11}
     * @param list12 the list of type {@code T12}
     * @param list13 the list of type {@code T13}
     * @param list14 the list of type {@code T14}
     * @param list15 the list of type {@code T15}
     * @param list16 the list of type {@code T16}
     * @param list17 the list of type {@code T17}
     * @param list18 the list of type {@code T18}
     * @param list19 the list of type {@code T19}
     * @param list20 the list of type {@code T20}
     * @return a {@code Zipper20} instance with the provided lists
     * @throws IllegalArgumentException if list sizes are not equal
     */
    public static <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20> Zipper20<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20> addLists(List<? extends T1> list1, List<? extends T2> list2, List<? extends T3> list3, List<? extends T4> list4, List<? extends T5> list5, List<? extends T6> list6, List<? extends T7> list7, List<? extends T8> list8, List<? extends T9> list9, List<? extends T10> list10, List<? extends T11> list11, List<? extends T12> list12, List<? extends T13> list13, List<? extends T14> list14, List<? extends T15> list15, List<? extends T16> list16, List<? extends T17> list17, List<? extends T18> list18, List<? extends T19> list19, List<? extends T20> list20) {
        int size = list1.size();
        if (list2.size() != size) throw new IllegalArgumentException("List size mismatch");
        if (list3.size() != size) throw new IllegalArgumentException("List size mismatch");
        if (list4.size() != size) throw new IllegalArgumentException("List size mismatch");
        if (list5.size() != size) throw new IllegalArgumentException("List size mismatch");
        if (list6.size() != size) throw new IllegalArgumentException("List size mismatch");
        if (list7.size() != size) throw new IllegalArgumentException("List size mismatch");
        if (list8.size() != size) throw new IllegalArgumentException("List size mismatch");
        if (list9.size() != size) throw new IllegalArgumentException("List size mismatch");
        if (list10.size() != size) throw new IllegalArgumentException("List size mismatch");
        if (list11.size() != size) throw new IllegalArgumentException("List size mismatch");
        if (list12.size() != size) throw new IllegalArgumentException("List size mismatch");
        if (list13.size() != size) throw new IllegalArgumentException("List size mismatch");
        if (list14.size() != size) throw new IllegalArgumentException("List size mismatch");
        if (list15.size() != size) throw new IllegalArgumentException("List size mismatch");
        if (list16.size() != size) throw new IllegalArgumentException("List size mismatch");
        if (list17.size() != size) throw new IllegalArgumentException("List size mismatch");
        if (list18.size() != size) throw new IllegalArgumentException("List size mismatch");
        if (list19.size() != size) throw new IllegalArgumentException("List size mismatch");
        if (list20.size() != size) throw new IllegalArgumentException("List size mismatch");
        return new Zipper20<>(new ArrayList<>(list1), new ArrayList<>(list2), new ArrayList<>(list3), new ArrayList<>(list4), new ArrayList<>(list5), new ArrayList<>(list6), new ArrayList<>(list7), new ArrayList<>(list8), new ArrayList<>(list9), new ArrayList<>(list10), new ArrayList<>(list11), new ArrayList<>(list12), new ArrayList<>(list13), new ArrayList<>(list14), new ArrayList<>(list15), new ArrayList<>(list16), new ArrayList<>(list17), new ArrayList<>(list18), new ArrayList<>(list19), new ArrayList<>(list20));
    }



    /**
     * Creates a {@link Zipper1} by generating a list of elements using a supplier function
     * that receives the index of each element.
     *
     * <p>This is useful when you want to construct a list dynamically based on the element index,
     * such as generating values, coordinates, or structured data.</p>
     *
     * <pre>{@code
     * Zipper.fromIndex(5, i -> "Item " + i)
     *         .forEach((i, value) -> System.out.println(i + ": " + value));
     * }</pre>
     *
     * @param count    the number of elements to generate
     * @param supplier a function that takes the element index (0-based) and returns a value
     * @param <R>      the type of elements to generate
     * @return a {@code Zipper1<R>} stream wrapping the generated list
     * @throws IllegalArgumentException if {@code count < 0}
     */
    public static <R> Zipper1<R> generateList(int count, Supplier0<R> supplier) {
        if (count < 0) {
            throw new IllegalArgumentException("count must be non-negative");
        }

        List<R> list = new ArrayList<>(count);
        for (int i = 0; i < count; i++) {
            list.add(supplier.get(i));
        }
        return new Zipper1<>(list);
    }

}
                                                        
