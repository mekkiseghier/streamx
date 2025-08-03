package com.github.mekkiseghier.streamx;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class StreamXRaw {
    private final List < List < ? > > lists = new ArrayList <>();

    public StreamXRaw( List < ? >... list ) {
        lists.addAll( List.of( list ) );
    }

    public StreamXRaw add( Object... values ) {
        lists.add( List.of( values ) );
        return this;
    }

    public StreamXRaw with( List < ? > list ) {
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

    class Entry {
        private final int index;
        private final List < Object > values;

        public Entry( int index, List < Object > values ) {
            this.index = index;
            this.values = values;
        }

        public int index() {
            return index;
        }

        public Object get( int i ) {
            return values.get( i );
        }

        public void set( int i, Object value ) {
            values.set( i, value );
        }
    }
}
