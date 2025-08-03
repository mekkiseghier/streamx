package streamx;

import com.github.mekkiseghier.streamx.accumulators.Accumulator2;
import com.github.mekkiseghier.streamx.consumers.Consumer2;
import com.github.mekkiseghier.streamx.functions.Function2;
import com.github.mekkiseghier.streamx.predicates.Predicate2;
import com.github.mekkiseghier.streamx.tuples.Tuple2;

import java.util.ArrayList;
import java.util.List;

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

    public < T3 > StreamX3 < T1, T2, T3 > and( T3... values ) {
        if ( values.length != size ) {
            throw new IllegalArgumentException( "List size mismatch" );
        }
        return new StreamX3( list1, list2, List.of( values ) );
    }

    public < T3 > StreamX3 < T1, T2, T3 > with( List < T3 > list ) {
        if ( list.size() != size ) {
            throw new IllegalArgumentException( "List size mismatch" );
        }
        return new StreamX3( list1, list2, list );
    }

    public void forEach( Consumer2 < Integer, T1, T2 > action ) {
        for ( int i = 0; i < size; i++ ) {
            action.accept( i, list1.get( i ), list2.get( i ) );
        }
    }

    public < R > List < R > map( Function2 < Integer, T1, T2, R > mapper ) {
        List < R > results = new ArrayList <>();
        for ( int i = 0; i < size; i++ ) {
            results.add( mapper.apply( i, list1.get( i ), list2.get( i ) ) );
        }
        return results;
    }

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

    public < R > R reduce( R identity, Accumulator2 < Integer, T1, T2, R > accumulator ) {
        R result = identity;
        for ( int i = 0; i < size; i++ ) {
            result = accumulator.reduce( i, list1.get( i ), list2.get( i ) );
        }
        return result;
    }

    public List < Tuple2 < T1, T2 > > asTupleList() {
        List < Tuple2 < T1, T2 > > result = new ArrayList <>();
        for ( int i = 0; i < size; i++ ) {
            result.add( new Tuple2 <>( i, list1.get( i ), list2.get( i ) ) );
        }
        return result;
    }

    public boolean allMatch( Predicate2 < Integer, T1, T2 > predicate ) {
        for ( int i = 0; i < size; i++ ) {
            if ( !predicate.test( i, list1.get( i ), list2.get( i ) ) ) {
                return false;
            }
        }
        return true;
    }

    public boolean anyMatch( Predicate2 < Integer, T1, T2 > predicate ) {
        for ( int i = 0; i < size; i++ ) {
            if ( predicate.test( i, list1.get( i ), list2.get( i ) ) ) {
                return true;
            }
        }
        return false;
    }

    public int size() {
        return size;
    }

    public StreamX2 < T1, T2 > peek( Consumer2 < Integer, T1, T2 > action ) {
        for ( int i = 0; i < size; i++ ) {
            action.accept( i, list1.get( i ), list2.get( i ) );
        }
        return this;
    }
}
