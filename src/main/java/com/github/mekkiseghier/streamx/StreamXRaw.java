package com.github.mekkiseghier.streamx;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

/**
 * A raw, non-type-safe container for managing multiple lists of arbitrary types in parallel.
 * <p>
 * This class is useful for scenarios where the number or types of lists are not known at compile time,
 * or where generic type safety is not required. It wraps multiple {@code List<?>} instances into
 * a single structure to facilitate unified operations such as indexing or transformation.
 * </p>
 *
 * <p><b>Note:</b> Unlike {@code StreamX1} to {@code StreamX20}, this class does not enforce type safety.
 * All elements are treated as {@code Object}, and type casting may be required when accessing elements.</p>
 *
 * <p>
 * Example:
 * </p>
 *
 * <pre>{@code
 * List<String> names = List.of("Alice", "Bob");
 * List<Integer> scores = List.of(85, 92);
 * StreamXRaw raw = new StreamXRaw(names, scores);
 * }</pre>
 */
public class StreamXRaw {

    private final List<List<?>> lists = new ArrayList<>();

    /**
     * Constructs a {@code StreamXRaw} instance by accepting a variable number of lists.
     * Each list may contain elements of a different type.
     *
     * @param list one or more {@code List<?>} instances to be grouped and stored internally
     */
    public StreamXRaw(List<?>... list) {
        lists.addAll(List.of(list));
    }
    /**
     * Adds a new array of elements to this {@link StreamXRaw}
     * that enables parallel index-aware iteration .
     *
     * <p>The number of provided elements must match the size of the existing lists to
     * maintain index alignment.</p>
     *
     * <pre>{@code
     * streamXRaw.addElements(v1, v2, v3)
     *        .forEach((i, ...) -> { ... });
     * }</pre>
     *
     * @param values the array of new elements to include
     * @return a {@code StreamXRaw} representing the parallel lists
     * @throws IllegalArgumentException if the number of elements does not match the existing size
     */
    public StreamXRaw addElements( Object... values ) {
        if (values.length != lists.get( 0 ).size()) throw new IllegalArgumentException("List size mismatch");
        lists.add( List.of( values ) );
        return this;
    }
    /**
     * Adds a new list to this {@link StreamXRaw}, producing a {@link StreamXRaw} that enables
     * parallel index-aware iteration via index.
     *
     * <p>All lists must have the same size to maintain index alignment.</p>
     *
     * <pre>{@code
     * StreamXRaw.addList(list)
     *        .forEach((i, ...) -> { ... });
     * }</pre>
     *
     * @param list the new list to include in the stream
     * @return a {@code StreamXRaw} representing the parallel lists as raw type which needs explicit casting before usage
     * @throws IllegalArgumentException if the provided list size does not match existing lists
     */
    public StreamXRaw addList( List < ? > list ) {
        if (list.size() != lists.get( 0 ).size()) throw new IllegalArgumentException("List size mismatch");
        lists.add( list );
        return this;
    }

    public List < Entry > asTupleList() {
        List < Entry > result = new ArrayList <>();
        for ( int i = 0; i < lists.size(); i++ ) {
            List result_entry = new ArrayList <>();
            for ( int j = 0; j < lists.get( 0 ).size(); j++ ) {
                result_entry.add( lists.get( i ).get( j ) );
            }
            Entry entry = new Entry( i, result_entry );
            result.add( entry );
        }
        return result;
    }
    /**
     * Converts the internal structure of parallel lists into a stream of {@link Entry} objects.
     * <p>
     * Each {@code Entry} represents a logical column, where:
     * - The entry index corresponds to the column index in the original multi-list structure.
     * - The entry elements contain values from that column across all rows.
     * </p>
     *
     * @return a {@code Stream<Entry>} where each entry holds elements of one column.
     */
    public Stream < Entry > stream() {
        List < Entry > result = new ArrayList <>();
        for ( int i = 0; i < lists.size(); i++ ) {
            List < Object > entry_element = new ArrayList <>();
            for ( int j = 0; j < lists.get( 0 ).size(); j++ ) {
                entry_element.add( lists.get( i ).get( j ) );
            }
            Entry entry = new Entry( i, entry_element );
            result.add( entry );
        }
        return result.stream();
    }

    /**
     * Represents a single row entry containing multiple values from parallel lists.
     * <p>
     * This class is typically used in multi-list streaming operations where each
     * row (or entry) corresponds to the ith elements of all involved lists.
     * </p>
     */
    class Entry {

        /** The index of this entry within the original lists. */
        private final int index;

        /** The list of values for this entry, each corresponding to a value from a parallel list. */
        private final List<Object> values;

        /**
         * Constructs an {@code Entry} with the specified index and values.
         *
         * @param index  the index of the entry in the parallel lists
         * @param values the values corresponding to this index, from each list
         */
        public Entry(int index, List<Object> values) {
            this.index = index;
            this.values = values;
        }

        /**
         * Returns the index of this entry within the source lists.
         *
         * @return the 0-based index of the entry
         */
        public int index() {
            return index;
        }

        /**
         * Retrieves the value at the specified position within this entry.
         *
         * @param i the index of the value to retrieve (0-based)
         * @return the value at position {@code i}
         * @throws IndexOutOfBoundsException if {@code i} is out of bounds
         */
        public Object get(int i) {
            return values.get(i);
        }

        /**
         * Replaces the value at the specified position in this entry.
         *
         * @param i     the index of the value to replace (0-based)
         * @param value the new value to set
         * @throws IndexOutOfBoundsException if {@code i} is out of bounds
         */
        public void set(int i, Object value) {
            values.set(i, value);
        }
    }

}
