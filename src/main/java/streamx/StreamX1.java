package streamx;

import com.github.mekkiseghier.streamx.accumulators.Accumulator1;
import com.github.mekkiseghier.streamx.consumers.Consumer1;
import com.github.mekkiseghier.streamx.functions.Function1;
import com.github.mekkiseghier.streamx.predicates.Predicate1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class StreamX1 < T1 > {
    private final List <  T1 > list1;

    StreamX1( List < T1 > list1 ) {
        this.list1 = list1;
    }

    @SafeVarargs public final < T2 > StreamX2 < T1, T2 > and( T2... values ) {
        return new StreamX2 <>( list1, List.of( values ) );
    }

    public < T2 > StreamX2 < T1, T2 > with( List < T2 > list2 ) {
        return new StreamX2 <>( list1, list2 );
    }

    public void forEach( Consumer1 < Integer, T1 > action ) {
        int size = Collections.min( List.of( list1.size() ) );
        for ( int i = 0; i < size; i++ ) {
            action.accept( i, list1.get( i ) );
        }
    }

    public StreamX1 < T1 > filter( Predicate1 < Integer, T1 > predicate ) {
        List < T1 > filtered1 = new ArrayList <>();
        for ( int i = 0; i < list1.size(); i++ ) {
            if ( predicate.test( i, list1.get( i ) ) ) {
                filtered1.add( list1.get( i ) );
            }
        }
        return new StreamX1 <>( filtered1 );
    }

    public boolean allMatch( Predicate1 < Integer, T1 > predicate ) {
        for ( int i = 0; i < list1.size(); i++ ) {
            if ( !predicate.test( i, list1.get( i ) ) ) {
                return false;
            }
        }
        return true;
    }

    public boolean anyMatch( Predicate1 < Integer, T1 > predicate ) {
        for ( int i = 0; i < list1.size(); i++ ) {
            if ( predicate.test( i, list1.get( i ) ) ) {
                return true;
            }
        }
        return false;
    }

    public List < T1 > asList() {
        return list1;
    }

    public int count() {
        return list1.size();
    }

    public < R > List < R > map( Function1 < Integer, T1, R > mapper ) {
        List < R > mapped1 = new ArrayList <>();
        for ( int i = 0; i < list1.size(); i++ ) {
            mapped1.add( mapper.apply( i, list1.get( i ) ) );
        }
        return mapped1;
    }

    public StreamX1 < T1 > sortedBy( Comparator < T1 > comparator ) {
        list1.sort( comparator );
        return new StreamX1 <>( list1 );
    }

    public < R > R reduce( R identity, Accumulator1 < Integer, T1, R > accumulator ) {
        R result = identity;
        for ( int i = 0; i < list1.size(); i++ ) {
            result = accumulator.reduce( i, list1.get( i ) );
        }
        return result;
    }

    public Stream1 < T1 > peek( Consumer1 < Integer, T1 > action ) {

        for ( int i = 0; i < list1.size(); i++ ) {
            T1 item = list1.get( i );
            action.accept( i, item );
            list1.add( item );
        }
        return new Stream1 <>( list1 );
    }

    public static class Stream1 < T > {
        public Stream1( List < T > list ) {
        }
    }
}

