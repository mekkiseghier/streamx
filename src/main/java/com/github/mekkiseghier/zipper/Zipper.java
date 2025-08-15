package com.github.mekkiseghier.zipper;

import java.util.ArrayList;
import java.util.List;

/**
 * Zipper — Main factory class for creating index-aware parallel streams of lists.
 * Entry point to construct parallel, index-aware streams using {@code Zipper1} through {@code Zipper8}.
 * <p>
 * Each static method here initializes a stream of typed lists — supporting from 1 up to 8 parallel lists —
 * enabling functional-style processing with full type safety and index awareness.
 * </p>
 * <p>
 * This class avoids reflection, casts, and external dependencies.
 * </p>
 * <p><strong>Usage Examples:</strong></p>
 * <pre>{@code
 * // From values
 * Zipper.zip("A", "B", "C")
 *        .forEach((i, v) -> System.out.println(i + ": " + v));
 *
 * // From multiple lists
 * Zipper.zipper(List.of("A", "B"), List.of(1, 2))
 *        .map((i, a, b) -> a + b);
 * }</pre>
 * Developed by Mekki Seghier as part of the Zipper utility library.
 * @author Mekki Seghier
 * @since 1.0
 */
public class Zipper {
/*    public static void main( String[] args ) {
        List < String > names = List.of( "Jessica", "Bob", "Charlie" );
        List < Integer > ages = List.of( 41, 40, 35 );
        List < Boolean > online = List.of( false, true, true );
        Zipper.zipper3( names, ages, online )
                .forEach3( (index, name, age, isOnline ) ->
                        System.out.println( (index +1 ) +": "+name +" is "+age +" years old, online: "+isOnline ));

// (2) Combining varargs and a list
        List < Double > nums = List.of( 1.2, 3.2, 4.2 );
        Zipper.zip1( "A","B","C" ).zip2( 1,2,3 ).zipList3( nums )
                .forEach3( (i, a, b, c ) ->
                        System.out.println( i +": "+a+", "+b+", "+c ) );
    }*/
    /**
     * Creates a {@link Zipper1} from given values.
     * @param values the elements to wrap in a stream
     * @param <T1>   type of elements
     * @return {@code Zipper1<T1>} representing the stream
     */
    public static < T1 > Zipper1 < T1 > zip1( T1... values ) {
        return new Zipper1 <>( List.of( values ) );
    }

    /**
     * Creates a {@link Zipper1} from a single list.
     * @param list1 source list
     * @param <T1>  type of elements
     * @return {@code Zipper1<T1>}
     */
    public static < T1 > Zipper1 < T1 > zipper1( List < ? extends T1 > list1 ) {
        return new Zipper1 <>( new ArrayList <>( list1 ) );
    }

    /**
     * Creates a {@code Zipper2} by combining 2 parallel lists.
     * Each list must have the same size.
     * @param list1 the list of type {@code T1}
     * @param list2 the list of type {@code T2}
     * @return a {@code Zipper2} instance with the provided lists
     * @throws IllegalArgumentException if list sizes are not equal
     */
    public static < T1, T2 > Zipper2 < T1, T2 > zipper2( List < ? extends T1 > list1, List < ? extends T2 > list2 ) {
        int size = list1.size();
        if ( list2.size() != size ) {throw new IllegalArgumentException( "List size mismatch" );}
        return new Zipper2 <>( new ArrayList <>( list1 ), new ArrayList <>( list2 ) );
    }

    /**
     * Creates a {@code Zipper3} by combining 3 parallel lists.
     * Each list must have the same size.
     * @param list1 the list of type {@code T1}
     * @param list2 the list of type {@code T2}
     * @param list3 the list of type {@code T3}
     * @return a {@code Zipper3} instance with the provided lists
     * @throws IllegalArgumentException if list sizes are not equal
     */
    public static < T1, T2, T3 > Zipper3 < T1, T2, T3 > zipper3( List < ? extends T1 > list1, List < ? extends T2 > list2, List < ? extends T3 > list3 ) {
        int size = list1.size();
        if ( list2.size() != size ) {throw new IllegalArgumentException( "List size mismatch" );}
        if ( list3.size() != size ) {throw new IllegalArgumentException( "List size mismatch" );}
        return new Zipper3 <>( new ArrayList <>( list1 ), new ArrayList <>( list2 ), new ArrayList <>( list3 ) );
    }

    /**
     * Creates a {@code Zipper4} by combining 4 parallel lists.
     * Each list must have the same size.
     * @param list1 the list of type {@code T1}
     * @param list2 the list of type {@code T2}
     * @param list3 the list of type {@code T3}
     * @param list4 the list of type {@code T4}
     * @return a {@code Zipper4} instance with the provided lists
     * @throws IllegalArgumentException if list sizes are not equal
     */
    public static < T1, T2, T3, T4 > Zipper4 < T1, T2, T3, T4 > zipper4( List < ? extends T1 > list1, List < ? extends T2 > list2, List < ? extends T3 > list3,
            List < ? extends T4 > list4 )
    {
        int size = list1.size();
        if ( list2.size() != size ) {throw new IllegalArgumentException( "List size mismatch" );}
        if ( list3.size() != size ) {throw new IllegalArgumentException( "List size mismatch" );}
        if ( list4.size() != size ) {throw new IllegalArgumentException( "List size mismatch" );}
        return new Zipper4 <>( new ArrayList <>( list1 ), new ArrayList <>( list2 ), new ArrayList <>( list3 ), new ArrayList <>( list4 ) );
    }

    /**
     * Creates a {@code Zipper5} by combining 5 parallel lists.
     * Each list must have the same size.
     * @param list1 the list of type {@code T1}
     * @param list2 the list of type {@code T2}
     * @param list3 the list of type {@code T3}
     * @param list4 the list of type {@code T4}
     * @param list5 the list of type {@code T5}
     * @return a {@code Zipper5} instance with the provided lists
     * @throws IllegalArgumentException if list sizes are not equal
     */
    public static < T1, T2, T3, T4, T5 > Zipper5 < T1, T2, T3, T4, T5 > zipper5( List < ? extends T1 > list1, List < ? extends T2 > list2, List < ? extends T3 > list3,
            List < ? extends T4 > list4, List < ? extends T5 > list5 )
    {
        int size = list1.size();
        if ( list2.size() != size ) {throw new IllegalArgumentException( "List size mismatch" );}
        if ( list3.size() != size ) {throw new IllegalArgumentException( "List size mismatch" );}
        if ( list4.size() != size ) {throw new IllegalArgumentException( "List size mismatch" );}
        if ( list5.size() != size ) {throw new IllegalArgumentException( "List size mismatch" );}
        return new Zipper5 <>( new ArrayList <>( list1 ), new ArrayList <>( list2 ), new ArrayList <>( list3 ), new ArrayList <>( list4 ), new ArrayList <>( list5 ) );
    }

    /**
     * Creates a {@code Zipper6} by combining 6 parallel lists.
     * Each list must have the same size.
     * @param list1 the list of type {@code T1}
     * @param list2 the list of type {@code T2}
     * @param list3 the list of type {@code T3}
     * @param list4 the list of type {@code T4}
     * @param list5 the list of type {@code T5}
     * @param list6 the list of type {@code T6}
     * @return a {@code Zipper6} instance with the provided lists
     * @throws IllegalArgumentException if list sizes are not equal
     */
    public static < T1, T2, T3, T4, T5, T6 > Zipper6 < T1, T2, T3, T4, T5, T6 > zipper6( List < ? extends T1 > list1, List < ? extends T2 > list2,
            List < ? extends T3 > list3, List < ? extends T4 > list4, List < ? extends T5 > list5, List < ? extends T6 > list6 )
    {
        int size = list1.size();
        if ( list2.size() != size ) {throw new IllegalArgumentException( "List size mismatch" );}
        if ( list3.size() != size ) {throw new IllegalArgumentException( "List size mismatch" );}
        if ( list4.size() != size ) {throw new IllegalArgumentException( "List size mismatch" );}
        if ( list5.size() != size ) {throw new IllegalArgumentException( "List size mismatch" );}
        if ( list6.size() != size ) {throw new IllegalArgumentException( "List size mismatch" );}
        return new Zipper6 <>( new ArrayList <>( list1 ), new ArrayList <>( list2 ), new ArrayList <>( list3 ), new ArrayList <>( list4 ), new ArrayList <>( list5 ),
                new ArrayList <>( list6 ) );
    }

    /**
     * Creates a {@code Zipper7} by combining 7 parallel lists.
     * Each list must have the same size.
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
    public static < T1, T2, T3, T4, T5, T6, T7 > Zipper7 < T1, T2, T3, T4, T5, T6, T7 > zipper7( List < ? extends T1 > list1, List < ? extends T2 > list2,
            List < ? extends T3 > list3, List < ? extends T4 > list4, List < ? extends T5 > list5, List < ? extends T6 > list6, List < ? extends T7 > list7 )
    {
        int size = list1.size();
        if ( list2.size() != size ) {throw new IllegalArgumentException( "List size mismatch" );}
        if ( list3.size() != size ) {throw new IllegalArgumentException( "List size mismatch" );}
        if ( list4.size() != size ) {throw new IllegalArgumentException( "List size mismatch" );}
        if ( list5.size() != size ) {throw new IllegalArgumentException( "List size mismatch" );}
        if ( list6.size() != size ) {throw new IllegalArgumentException( "List size mismatch" );}
        if ( list7.size() != size ) {throw new IllegalArgumentException( "List size mismatch" );}
        return new Zipper7 <>( new ArrayList <>( list1 ), new ArrayList <>( list2 ), new ArrayList <>( list3 ), new ArrayList <>( list4 ), new ArrayList <>( list5 ),
                new ArrayList <>( list6 ), new ArrayList <>( list7 ) );
    }

    /**
     * Creates a {@code Zipper8} by combining 8 parallel lists.
     * Each list must have the same size.
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
    public static < T1, T2, T3, T4, T5, T6, T7, T8 > Zipper8 < T1, T2, T3, T4, T5, T6, T7, T8 > zipper8( List < ? extends T1 > list1, List < ? extends T2 > list2,
            List < ? extends T3 > list3, List < ? extends T4 > list4, List < ? extends T5 > list5, List < ? extends T6 > list6, List < ? extends T7 > list7,
            List < ? extends T8 > list8 )
    {
        int size = list1.size();
        if ( list2.size() != size ) {throw new IllegalArgumentException( "List size mismatch" );}
        if ( list3.size() != size ) {throw new IllegalArgumentException( "List size mismatch" );}
        if ( list4.size() != size ) {throw new IllegalArgumentException( "List size mismatch" );}
        if ( list5.size() != size ) {throw new IllegalArgumentException( "List size mismatch" );}
        if ( list6.size() != size ) {throw new IllegalArgumentException( "List size mismatch" );}
        if ( list7.size() != size ) {throw new IllegalArgumentException( "List size mismatch" );}
        if ( list8.size() != size ) {throw new IllegalArgumentException( "List size mismatch" );}
        return new Zipper8 <>( new ArrayList <>( list1 ), new ArrayList <>( list2 ), new ArrayList <>( list3 ), new ArrayList <>( list4 ), new ArrayList <>( list5 ),
                new ArrayList <>( list6 ), new ArrayList <>( list7 ), new ArrayList <>( list8 ) );
    }

    /**
     * Creates a {@code ZipperRaw} by combining passed lists, without type safety.
     * Each list must have the same size.
     * @param lists the lists to pass
     * @return a {@code ZipperRaw} instance with the provided lists
     * @throws IllegalArgumentException if list sizes are not equal
     */
    public static ZipperRaw zipperRaw( List < ? >... lists ) {
        int size = lists[ 0 ].size();
        for ( int i = 0; i < lists.length; i++ ) {
            if ( lists[ 0 ].size() != size ) {throw new IllegalArgumentException( "List size mismatch" );}
        }
        return new ZipperRaw( lists );
    }
}
                                                        
