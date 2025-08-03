package com.github.mekkiseghier.streamx;

import com.github.mekkiseghier.streamx.suppliers.Supplier0;

import java.util.ArrayList;
import java.util.List;


public class StreamX {
    public static < T1 > StreamX1 < T1 > of( T1... values ) {
        return new StreamX1 <>( List.of( values ) );
    }

    public static < T1 > StreamX1 < T1 > from( List < ? extends T1 > list1 ) {
        return new StreamX1 <>( new ArrayList <>( list1 ) );
    }

    public static < T1, T2 > StreamX2 < T1, T2 > from( List < ? extends T1 > list1, List < ? extends T2 > list2 ) {
        return new StreamX2 <>( new ArrayList <>( list1 ), new ArrayList <>( list2 ) );
    }

    public static < T1, T2, T3 > StreamX3 < T1, T2, T3 > from( List < ? extends T1 > list1, List < ? extends T2 > list2, List < ? extends T3 > list3 ) {
        return new StreamX3 <>( new ArrayList <>( list1 ), new ArrayList <>( list2 ), new ArrayList <>( list3 ) );
    }

    public static < T1, T2, T3, T4 > StreamX4 < T1, T2, T3, T4 > from( List < ? extends T1 > list1, List < ? extends T2 > list2, List < ? extends T3 > list3,
            List < ? extends T4 > list4 )
    {
        return new StreamX4 <>( new ArrayList <>( list1 ), new ArrayList <>( list2 ), new ArrayList <>( list3 ), new ArrayList <>( list4 ) );
    }

    public static < T1, T2, T3, T4, T5 > StreamX5 < T1, T2, T3, T4, T5 > from( List < ? extends T1 > list1, List < ? extends T2 > list2,
            List < ? extends T3 > list3, List < ? extends T4 > list4, List < ? extends T5 > list5 )
    {
        return new StreamX5 <>( new ArrayList <>( list1 ), new ArrayList <>( list2 ), new ArrayList <>( list3 ), new ArrayList <>( list4 ),
                new ArrayList <>( list5 ) );
    }

    public static < T1, T2, T3, T4, T5, T6 > StreamX6 < T1, T2, T3, T4, T5, T6 > from( List < ? extends T1 > list1, List < ? extends T2 > list2,
            List < ? extends T3 > list3, List < ? extends T4 > list4, List < ? extends T5 > list5, List < ? extends T6 > list6 )
    {
        return new StreamX6 <>( new ArrayList <>( list1 ), new ArrayList <>( list2 ), new ArrayList <>( list3 ), new ArrayList <>( list4 ),
                new ArrayList <>( list5 ), new ArrayList <>( list6 ) );
    }

    public static < T1, T2, T3, T4, T5, T6, T7 > StreamX7 < T1, T2, T3, T4, T5, T6, T7 > from( List < ? extends T1 > list1, List < ? extends T2 > list2,
            List < ? extends T3 > list3, List < ? extends T4 > list4, List < ? extends T5 > list5, List < ? extends T6 > list6, List < ? extends T7 > list7 )
    {
        return new StreamX7 <>( new ArrayList <>( list1 ), new ArrayList <>( list2 ), new ArrayList <>( list3 ), new ArrayList <>( list4 ),
                new ArrayList <>( list5 ), new ArrayList <>( list6 ), new ArrayList <>( list7 ) );
    }

    public static < T1, T2, T3, T4, T5, T6, T7, T8 > StreamX8 < T1, T2, T3, T4, T5, T6, T7, T8 > from( List < ? extends T1 > list1, List < ? extends T2 > list2,
            List < ? extends T3 > list3, List < ? extends T4 > list4, List < ? extends T5 > list5, List < ? extends T6 > list6, List < ? extends T7 > list7,
            List < ? extends T8 > list8 )
    {
        return new StreamX8 <>( new ArrayList <>( list1 ), new ArrayList <>( list2 ), new ArrayList <>( list3 ), new ArrayList <>( list4 ),
                new ArrayList <>( list5 ), new ArrayList <>( list6 ), new ArrayList <>( list7 ), new ArrayList <>( list8 ) );
    }

    public static < T1, T2, T3, T4, T5, T6, T7, T8, T9 > StreamX9 < T1, T2, T3, T4, T5, T6, T7, T8, T9 > from( List < ? extends T1 > list1,
            List < ? extends T2 > list2, List < ? extends T3 > list3, List < ? extends T4 > list4, List < ? extends T5 > list5, List < ? extends T6 > list6,
            List < ? extends T7 > list7, List < ? extends T8 > list8, List < ? extends T9 > list9 )
    {
        return new StreamX9 <>( new ArrayList <>( list1 ), new ArrayList <>( list2 ), new ArrayList <>( list3 ), new ArrayList <>( list4 ),
                new ArrayList <>( list5 ), new ArrayList <>( list6 ), new ArrayList <>( list7 ), new ArrayList <>( list8 ), new ArrayList <>( list9 ) );
    }

    public static < T1, T2, T3, T4, T5, T6, T7, T8, T9, T10 > StreamX10 < T1, T2, T3, T4, T5, T6, T7, T8, T9, T10 > from( List < ? extends T1 > list1,
            List < ? extends T2 > list2, List < ? extends T3 > list3, List < ? extends T4 > list4, List < ? extends T5 > list5, List < ? extends T6 > list6,
            List < ? extends T7 > list7, List < ? extends T8 > list8, List < ? extends T9 > list9, List < ? extends T10 > list10 )
    {
        return new StreamX10 <>( new ArrayList <>( list1 ), new ArrayList <>( list2 ), new ArrayList <>( list3 ), new ArrayList <>( list4 ),
                new ArrayList <>( list5 ), new ArrayList <>( list6 ), new ArrayList <>( list7 ), new ArrayList <>( list8 ), new ArrayList <>( list9 ),
                new ArrayList <>( list10 ) );
    }

    public static < T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11 > StreamX11 < T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11 > from( List < ? extends T1 > list1,
            List < ? extends T2 > list2, List < ? extends T3 > list3, List < ? extends T4 > list4, List < ? extends T5 > list5, List < ? extends T6 > list6,
            List < ? extends T7 > list7, List < ? extends T8 > list8, List < ? extends T9 > list9, List < ? extends T10 > list10, List < ? extends T11 > list11 )
    {
        return new StreamX11 <>( new ArrayList <>( list1 ), new ArrayList <>( list2 ), new ArrayList <>( list3 ), new ArrayList <>( list4 ),
                new ArrayList <>( list5 ), new ArrayList <>( list6 ), new ArrayList <>( list7 ), new ArrayList <>( list8 ), new ArrayList <>( list9 ),
                new ArrayList <>( list10 ), new ArrayList <>( list11 ) );
    }

    public static < T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12 > StreamX12 < T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12 > from(
            List < ? extends T1 > list1, List < ? extends T2 > list2, List < ? extends T3 > list3, List < ? extends T4 > list4, List < ? extends T5 > list5,
            List < ? extends T6 > list6, List < ? extends T7 > list7, List < ? extends T8 > list8, List < ? extends T9 > list9, List < ? extends T10 > list10,
            List < ? extends T11 > list11, List < ? extends T12 > list12 )
    {
        return new StreamX12 <>( new ArrayList <>( list1 ), new ArrayList <>( list2 ), new ArrayList <>( list3 ), new ArrayList <>( list4 ),
                new ArrayList <>( list5 ), new ArrayList <>( list6 ), new ArrayList <>( list7 ), new ArrayList <>( list8 ), new ArrayList <>( list9 ),
                new ArrayList <>( list10 ), new ArrayList <>( list11 ), new ArrayList <>( list12 ) );
    }

    public static < T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13 > StreamX13 < T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13 > from(
            List < ? extends T1 > list1, List < ? extends T2 > list2, List < ? extends T3 > list3, List < ? extends T4 > list4, List < ? extends T5 > list5,
            List < ? extends T6 > list6, List < ? extends T7 > list7, List < ? extends T8 > list8, List < ? extends T9 > list9, List < ? extends T10 > list10,
            List < ? extends T11 > list11, List < ? extends T12 > list12, List < ? extends T13 > list13 )
    {
        return new StreamX13 <>( new ArrayList <>( list1 ), new ArrayList <>( list2 ), new ArrayList <>( list3 ), new ArrayList <>( list4 ),
                new ArrayList <>( list5 ), new ArrayList <>( list6 ), new ArrayList <>( list7 ), new ArrayList <>( list8 ), new ArrayList <>( list9 ),
                new ArrayList <>( list10 ), new ArrayList <>( list11 ), new ArrayList <>( list12 ), new ArrayList <>( list13 ) );
    }

    public static < T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14 > StreamX14 < T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14 > from(
            List < ? extends T1 > list1, List < ? extends T2 > list2, List < ? extends T3 > list3, List < ? extends T4 > list4, List < ? extends T5 > list5,
            List < ? extends T6 > list6, List < ? extends T7 > list7, List < ? extends T8 > list8, List < ? extends T9 > list9, List < ? extends T10 > list10,
            List < ? extends T11 > list11, List < ? extends T12 > list12, List < ? extends T13 > list13, List < ? extends T14 > list14 )
    {
        return new StreamX14 <>( new ArrayList <>( list1 ), new ArrayList <>( list2 ), new ArrayList <>( list3 ), new ArrayList <>( list4 ),
                new ArrayList <>( list5 ), new ArrayList <>( list6 ), new ArrayList <>( list7 ), new ArrayList <>( list8 ), new ArrayList <>( list9 ),
                new ArrayList <>( list10 ), new ArrayList <>( list11 ), new ArrayList <>( list12 ), new ArrayList <>( list13 ), new ArrayList <>( list14 ) );
    }

    public static < T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15 > StreamX15 < T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15 > from(
            List < ? extends T1 > list1, List < ? extends T2 > list2, List < ? extends T3 > list3, List < ? extends T4 > list4, List < ? extends T5 > list5,
            List < ? extends T6 > list6, List < ? extends T7 > list7, List < ? extends T8 > list8, List < ? extends T9 > list9, List < ? extends T10 > list10,
            List < ? extends T11 > list11, List < ? extends T12 > list12, List < ? extends T13 > list13, List < ? extends T14 > list14, List < ? extends T15 > list15 )
    {
        return new StreamX15 <>( new ArrayList <>( list1 ), new ArrayList <>( list2 ), new ArrayList <>( list3 ), new ArrayList <>( list4 ),
                new ArrayList <>( list5 ), new ArrayList <>( list6 ), new ArrayList <>( list7 ), new ArrayList <>( list8 ), new ArrayList <>( list9 ),
                new ArrayList <>( list10 ), new ArrayList <>( list11 ), new ArrayList <>( list12 ), new ArrayList <>( list13 ), new ArrayList <>( list14 ),
                new ArrayList <>( list15 ) );
    }

    public static < T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16 > StreamX16 < T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16 > from(
            List < ? extends T1 > list1, List < ? extends T2 > list2, List < ? extends T3 > list3, List < ? extends T4 > list4, List < ? extends T5 > list5,
            List < ? extends T6 > list6, List < ? extends T7 > list7, List < ? extends T8 > list8, List < ? extends T9 > list9, List < ? extends T10 > list10,
            List < ? extends T11 > list11, List < ? extends T12 > list12, List < ? extends T13 > list13, List < ? extends T14 > list14, List < ? extends T15 > list15,
            List < ? extends T16 > list16 )
    {
        return new StreamX16 <>( new ArrayList <>( list1 ), new ArrayList <>( list2 ), new ArrayList <>( list3 ), new ArrayList <>( list4 ),
                new ArrayList <>( list5 ), new ArrayList <>( list6 ), new ArrayList <>( list7 ), new ArrayList <>( list8 ), new ArrayList <>( list9 ),
                new ArrayList <>( list10 ), new ArrayList <>( list11 ), new ArrayList <>( list12 ), new ArrayList <>( list13 ), new ArrayList <>( list14 ),
                new ArrayList <>( list15 ), new ArrayList <>( list16 ) );
    }

    public static < T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17 > StreamX17 < T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17 > from(
            List < ? extends T1 > list1, List < ? extends T2 > list2, List < ? extends T3 > list3, List < ? extends T4 > list4, List < ? extends T5 > list5,
            List < ? extends T6 > list6, List < ? extends T7 > list7, List < ? extends T8 > list8, List < ? extends T9 > list9, List < ? extends T10 > list10,
            List < ? extends T11 > list11, List < ? extends T12 > list12, List < ? extends T13 > list13, List < ? extends T14 > list14, List < ? extends T15 > list15,
            List < ? extends T16 > list16, List < ? extends T17 > list17 )
    {
        return new StreamX17 <>( new ArrayList <>( list1 ), new ArrayList <>( list2 ), new ArrayList <>( list3 ), new ArrayList <>( list4 ),
                new ArrayList <>( list5 ), new ArrayList <>( list6 ), new ArrayList <>( list7 ), new ArrayList <>( list8 ), new ArrayList <>( list9 ),
                new ArrayList <>( list10 ), new ArrayList <>( list11 ), new ArrayList <>( list12 ), new ArrayList <>( list13 ), new ArrayList <>( list14 ),
                new ArrayList <>( list15 ), new ArrayList <>( list16 ), new ArrayList <>( list17 ) );
    }

    public static < T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18 > StreamX18 < T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18 > from(
            List < ? extends T1 > list1, List < ? extends T2 > list2, List < ? extends T3 > list3, List < ? extends T4 > list4, List < ? extends T5 > list5,
            List < ? extends T6 > list6, List < ? extends T7 > list7, List < ? extends T8 > list8, List < ? extends T9 > list9, List < ? extends T10 > list10,
            List < ? extends T11 > list11, List < ? extends T12 > list12, List < ? extends T13 > list13, List < ? extends T14 > list14, List < ? extends T15 > list15,
            List < ? extends T16 > list16, List < ? extends T17 > list17, List < ? extends T18 > list18 )
    {
        return new StreamX18 <>( new ArrayList <>( list1 ), new ArrayList <>( list2 ), new ArrayList <>( list3 ), new ArrayList <>( list4 ),
                new ArrayList <>( list5 ), new ArrayList <>( list6 ), new ArrayList <>( list7 ), new ArrayList <>( list8 ), new ArrayList <>( list9 ),
                new ArrayList <>( list10 ), new ArrayList <>( list11 ), new ArrayList <>( list12 ), new ArrayList <>( list13 ), new ArrayList <>( list14 ),
                new ArrayList <>( list15 ), new ArrayList <>( list16 ), new ArrayList <>( list17 ), new ArrayList <>( list18 ) );
    }

    public static < T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19 > StreamX19 < T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19 > from(
            List < ? extends T1 > list1, List < ? extends T2 > list2, List < ? extends T3 > list3, List < ? extends T4 > list4, List < ? extends T5 > list5,
            List < ? extends T6 > list6, List < ? extends T7 > list7, List < ? extends T8 > list8, List < ? extends T9 > list9, List < ? extends T10 > list10,
            List < ? extends T11 > list11, List < ? extends T12 > list12, List < ? extends T13 > list13, List < ? extends T14 > list14, List < ? extends T15 > list15,
            List < ? extends T16 > list16, List < ? extends T17 > list17, List < ? extends T18 > list18, List < ? extends T19 > list19 )
    {
        return new StreamX19 <>( new ArrayList <>( list1 ), new ArrayList <>( list2 ), new ArrayList <>( list3 ), new ArrayList <>( list4 ),
                new ArrayList <>( list5 ), new ArrayList <>( list6 ), new ArrayList <>( list7 ), new ArrayList <>( list8 ), new ArrayList <>( list9 ),
                new ArrayList <>( list10 ), new ArrayList <>( list11 ), new ArrayList <>( list12 ), new ArrayList <>( list13 ), new ArrayList <>( list14 ),
                new ArrayList <>( list15 ), new ArrayList <>( list16 ), new ArrayList <>( list17 ), new ArrayList <>( list18 ), new ArrayList <>( list19 ) );
    }

    public static < T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20 > StreamX20 < T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20 > from(
            List < ? extends T1 > list1, List < ? extends T2 > list2, List < ? extends T3 > list3, List < ? extends T4 > list4, List < ? extends T5 > list5,
            List < ? extends T6 > list6, List < ? extends T7 > list7, List < ? extends T8 > list8, List < ? extends T9 > list9, List < ? extends T10 > list10,
            List < ? extends T11 > list11, List < ? extends T12 > list12, List < ? extends T13 > list13, List < ? extends T14 > list14, List < ? extends T15 > list15,
            List < ? extends T16 > list16, List < ? extends T17 > list17, List < ? extends T18 > list18, List < ? extends T19 > list19, List < ? extends T20 > list20 )
    {
        return new StreamX20 <>( new ArrayList <>( list1 ), new ArrayList <>( list2 ), new ArrayList <>( list3 ), new ArrayList <>( list4 ),
                new ArrayList <>( list5 ), new ArrayList <>( list6 ), new ArrayList <>( list7 ), new ArrayList <>( list8 ), new ArrayList <>( list9 ),
                new ArrayList <>( list10 ), new ArrayList <>( list11 ), new ArrayList <>( list12 ), new ArrayList <>( list13 ), new ArrayList <>( list14 ),
                new ArrayList <>( list15 ), new ArrayList <>( list16 ), new ArrayList <>( list17 ), new ArrayList <>( list18 ), new ArrayList <>( list19 ),
                new ArrayList <>( list20 ) );
    }



    public static < R > StreamX1 < R > generateStartingListBasedOnIndex( int count, Supplier0 < R > supplier ) {
        List < R > list = new ArrayList <>( count );
        for ( int i = 0; i < count; i++ ) {
            list.add( supplier.get( i ) );
        }
        return new StreamX1 <>( list );
    }
}
                                                        
