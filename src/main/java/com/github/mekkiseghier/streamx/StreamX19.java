package com.github.mekkiseghier.streamx;

import com.github.mekkiseghier.streamx.accumulators.Accumulator19;
import com.github.mekkiseghier.streamx.consumers.Consumer19;
import com.github.mekkiseghier.streamx.functions.Function19;
import com.github.mekkiseghier.streamx.predicates.Predicate19;
import com.github.mekkiseghier.streamx.tuples.Tuple19;

import java.util.ArrayList;
import java.util.List;

public class StreamX19<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19> {
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

    public StreamX19(List<T1> list1, List<T2> list2, List<T3> list3, List<T4> list4, List<T5> list5, List<T6> list6, List<T7> list7, List<T8> list8, List<T9> list9, List<T10> list10, List<T11> list11, List<T12> list12, List<T13> list13, List<T14> list14, List<T15> list15, List<T16> list16, List<T17> list17, List<T18> list18, List<T19> list19) {
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

     @SafeVarargs    public final <T20> StreamX20 <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20> and( T20... values) {
        if (values.length != size) throw new IllegalArgumentException("List size mismatch");
        List<T20> safeList =new ArrayList<>(values.length);
        for (T20 item :  List.of(values) ) safeList.add(item);
        return new StreamX20 <>(list1, list2, list3, list4, list5, list6, list7, list8, list9, list10, list11, list12, list13, list14, list15, list16, list17, list18, list19, safeList);
    }

    public < T20> StreamX20 <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20> with(List <? extends T20 > list) {
        if (list.size() != size) throw new IllegalArgumentException("List size mismatch");
        List<T20> safeList = new ArrayList<>(list.size());
        for (T20 item : list) safeList.add(item);
        return new StreamX20 <>(list1, list2, list3, list4, list5, list6, list7, list8, list9, list10, list11, list12, list13, list14, list15, list16, list17, list18, list19, safeList);
    }

    public void forEach(Consumer19<Integer, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19> action) {
        for (int i = 0; i < size; i++) {
            action.accept(i, list1.get(i), list2.get(i), list3.get(i), list4.get(i), list5.get(i), list6.get(i), list7.get(i), list8.get(i), list9.get(i), list10.get(i), list11.get(i), list12.get(i), list13.get(i), list14.get(i), list15.get(i), list16.get(i), list17.get(i), list18.get(i), list19.get(i));
        }
    }

    public <R> List<R> map(Function19<Integer, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, R> mapper) {
        List<R> results = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            results.add(mapper.apply(i, list1.get(i), list2.get(i), list3.get(i), list4.get(i), list5.get(i), list6.get(i), list7.get(i), list8.get(i), list9.get(i), list10.get(i), list11.get(i), list12.get(i), list13.get(i), list14.get(i), list15.get(i), list16.get(i), list17.get(i), list18.get(i), list19.get(i)));
        }
        return results;
    }

    public StreamX19<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19> filter(Predicate19<Integer, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19> predicate) {
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
        return new StreamX19<>(filtered1, filtered2, filtered3, filtered4, filtered5, filtered6, filtered7, filtered8, filtered9, filtered10, filtered11, filtered12, filtered13, filtered14, filtered15, filtered16, filtered17, filtered18, filtered19);
    }

    public <R> R reduce(R identity, Accumulator19<Integer, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, R> accumulator) {
        R result = identity;
        for (int i = 0; i < size; i++) {
            result = accumulator.reduce(i, list1.get(i), list2.get(i), list3.get(i), list4.get(i), list5.get(i), list6.get(i), list7.get(i), list8.get(i), list9.get(i), list10.get(i), list11.get(i), list12.get(i), list13.get(i), list14.get(i), list15.get(i), list16.get(i), list17.get(i), list18.get(i), list19.get(i));
        }
        return result;
    }

    public List<Tuple19<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19>> asTupleList() {
        List<Tuple19<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19>> result = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            result.add(new Tuple19<>(i,list1.get(i), list2.get(i), list3.get(i), list4.get(i), list5.get(i), list6.get(i), list7.get(i), list8.get(i), list9.get(i), list10.get(i), list11.get(i), list12.get(i), list13.get(i), list14.get(i), list15.get(i), list16.get(i), list17.get(i), list18.get(i), list19.get(i)));
        }
        return result;
    }
    public boolean allMatch(Predicate19<Integer, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19> predicate) {
        for (int i = 0; i < size; i++) {
            if (!predicate.test(i, list1.get(i), list2.get(i), list3.get(i), list4.get(i), list5.get(i), list6.get(i), list7.get(i), list8.get(i), list9.get(i), list10.get(i), list11.get(i), list12.get(i), list13.get(i), list14.get(i), list15.get(i), list16.get(i), list17.get(i), list18.get(i), list19.get(i)) ) return false;
        }
        return true;
    }

    public boolean anyMatch(Predicate19<Integer, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19> predicate) {
        for (int i = 0; i < size; i++) {
            if (predicate.test(i, list1.get(i), list2.get(i), list3.get(i), list4.get(i), list5.get(i), list6.get(i), list7.get(i), list8.get(i), list9.get(i), list10.get(i), list11.get(i), list12.get(i), list13.get(i), list14.get(i), list15.get(i), list16.get(i), list17.get(i), list18.get(i), list19.get(i)) ) return true;
        }
        return false;
    }
    public int size() { return size; }

    public StreamX19<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19> peek(Consumer19<Integer, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19> action) {
        for (int i = 0; i < size; i++) {
            action.accept(i, list1.get(i), list2.get(i), list3.get(i), list4.get(i), list5.get(i), list6.get(i), list7.get(i), list8.get(i), list9.get(i), list10.get(i), list11.get(i), list12.get(i), list13.get(i), list14.get(i), list15.get(i), list16.get(i), list17.get(i), list18.get(i), list19.get(i));
        }
        return this;
    }
}
