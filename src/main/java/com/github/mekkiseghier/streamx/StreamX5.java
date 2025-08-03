package com.github.mekkiseghier.streamx;

import com.github.mekkiseghier.streamx.accumulators.Accumulator5;
import com.github.mekkiseghier.streamx.consumers.Consumer5;
import com.github.mekkiseghier.streamx.functions.Function5;
import com.github.mekkiseghier.streamx.predicates.Predicate5;
import com.github.mekkiseghier.streamx.tuples.Tuple5;

import java.util.ArrayList;
import java.util.List;

public class StreamX5<T1, T2, T3, T4, T5> {
    private final List<T1> list1;
    private final List<T2> list2;
    private final List<T3> list3;
    private final List<T4> list4;
    private final List<T5> list5;
    private final int size;

    public StreamX5(List<T1> list1, List<T2> list2, List<T3> list3, List<T4> list4, List<T5> list5) {
        int expectedSize = list1.size();
        if (list2.size() != expectedSize) throw new IllegalArgumentException("List sizes must match");
        if (list3.size() != expectedSize) throw new IllegalArgumentException("List sizes must match");
        if (list4.size() != expectedSize) throw new IllegalArgumentException("List sizes must match");
        if (list5.size() != expectedSize) throw new IllegalArgumentException("List sizes must match");
        this.list1 = list1;
        this.list2 = list2;
        this.list3 = list3;
        this.list4 = list4;
        this.list5 = list5;
        this.size = expectedSize;
    }

     @SafeVarargs    public final <T6> StreamX6 <T1, T2, T3, T4, T5, T6> and( T6... values) {
        if (values.length != size) throw new IllegalArgumentException("List size mismatch");
        List<T6> safeList =new ArrayList<>(values.length);
        for (T6 item :  List.of(values) ) safeList.add(item);
        return new StreamX6 <>(list1, list2, list3, list4, list5, safeList);
    }

    public < T6> StreamX6 <T1, T2, T3, T4, T5, T6> with(List <? extends T6 > list) {
        if (list.size() != size) throw new IllegalArgumentException("List size mismatch");
        List<T6> safeList = new ArrayList<>(list.size());
        for (T6 item : list) safeList.add(item);
        return new StreamX6 <>(list1, list2, list3, list4, list5, safeList);
    }

    public void forEach(Consumer5<Integer, T1, T2, T3, T4, T5> action) {
        for (int i = 0; i < size; i++) {
            action.accept(i, list1.get(i), list2.get(i), list3.get(i), list4.get(i), list5.get(i));
        }
    }

    public <R> List<R> map(Function5<Integer, T1, T2, T3, T4, T5, R> mapper) {
        List<R> results = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            results.add(mapper.apply(i, list1.get(i), list2.get(i), list3.get(i), list4.get(i), list5.get(i)));
        }
        return results;
    }

    public StreamX5<T1, T2, T3, T4, T5> filter(Predicate5<Integer, T1, T2, T3, T4, T5> predicate) {
        List<T1> filtered1 = new ArrayList<>();
        List<T2> filtered2 = new ArrayList<>();
        List<T3> filtered3 = new ArrayList<>();
        List<T4> filtered4 = new ArrayList<>();
        List<T5> filtered5 = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            if (predicate.test(i, list1.get(i), list2.get(i), list3.get(i), list4.get(i), list5.get(i))) {
                filtered1.add(list1.get(i));
                filtered2.add(list2.get(i));
                filtered3.add(list3.get(i));
                filtered4.add(list4.get(i));
                filtered5.add(list5.get(i));
            }
        }
        return new StreamX5<>(filtered1, filtered2, filtered3, filtered4, filtered5);
    }

    public <R> R reduce(R identity, Accumulator5<Integer, T1, T2, T3, T4, T5, R> accumulator) {
        R result = identity;
        for (int i = 0; i < size; i++) {
            result = accumulator.reduce(i, list1.get(i), list2.get(i), list3.get(i), list4.get(i), list5.get(i));
        }
        return result;
    }

    public List<Tuple5<T1, T2, T3, T4, T5>> asTupleList() {
        List<Tuple5<T1, T2, T3, T4, T5>> result = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            result.add(new Tuple5<>(i,list1.get(i), list2.get(i), list3.get(i), list4.get(i), list5.get(i)));
        }
        return result;
    }
    public boolean allMatch(Predicate5<Integer, T1, T2, T3, T4, T5> predicate) {
        for (int i = 0; i < size; i++) {
            if (!predicate.test(i, list1.get(i), list2.get(i), list3.get(i), list4.get(i), list5.get(i)) ) return false;
        }
        return true;
    }

    public boolean anyMatch(Predicate5<Integer, T1, T2, T3, T4, T5> predicate) {
        for (int i = 0; i < size; i++) {
            if (predicate.test(i, list1.get(i), list2.get(i), list3.get(i), list4.get(i), list5.get(i)) ) return true;
        }
        return false;
    }
    public int size() { return size; }

    public StreamX5<T1, T2, T3, T4, T5> peek(Consumer5<Integer, T1, T2, T3, T4, T5> action) {
        for (int i = 0; i < size; i++) {
            action.accept(i, list1.get(i), list2.get(i), list3.get(i), list4.get(i), list5.get(i));
        }
        return this;
    }
}
