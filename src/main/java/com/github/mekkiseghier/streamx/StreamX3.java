package com.github.mekkiseghier.streamx;

import com.github.mekkiseghier.streamx.accumulators.Accumulator3;
import com.github.mekkiseghier.streamx.consumers.Consumer3;
import com.github.mekkiseghier.streamx.functions.Function3;
import com.github.mekkiseghier.streamx.predicates.Predicate3;
import com.github.mekkiseghier.streamx.tuples.Tuple3;

import java.util.ArrayList;
import java.util.List;

public class StreamX3<T1, T2, T3> {
    private final List<T1> list1;
    private final List<T2> list2;
    private final List<T3> list3;
    private final int size;

    public StreamX3(List<T1> list1, List<T2> list2, List<T3> list3) {
        int expectedSize = list1.size();
        if (list2.size() != expectedSize) throw new IllegalArgumentException("List sizes must match");
        if (list3.size() != expectedSize) throw new IllegalArgumentException("List sizes must match");
        this.list1 = list1;
        this.list2 = list2;
        this.list3 = list3;
        this.size = expectedSize;
    }

     @SafeVarargs    public final <T4> StreamX4 <T1, T2, T3, T4> and( T4... values) {
        if (values.length != size) throw new IllegalArgumentException("List size mismatch");
        List<T4> safeList =new ArrayList<>(values.length);
        for (T4 item :  List.of(values) ) safeList.add(item);
        return new StreamX4 <>(list1, list2, list3, safeList);
    }

    public < T4> StreamX4 <T1, T2, T3, T4> with(List <? extends T4 > list) {
        if (list.size() != size) throw new IllegalArgumentException("List size mismatch");
        List<T4> safeList = new ArrayList<>(list.size());
        for (T4 item : list) safeList.add(item);
        return new StreamX4 <>(list1, list2, list3, safeList);
    }

    public void forEach(Consumer3<Integer, T1, T2, T3> action) {
        for (int i = 0; i < size; i++) {
            action.accept(i, list1.get(i), list2.get(i), list3.get(i));
        }
    }

    public <R> List<R> map(Function3<Integer, T1, T2, T3, R> mapper) {
        List<R> results = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            results.add(mapper.apply(i, list1.get(i), list2.get(i), list3.get(i)));
        }
        return results;
    }

    public StreamX3<T1, T2, T3> filter(Predicate3<Integer, T1, T2, T3> predicate) {
        List<T1> filtered1 = new ArrayList<>();
        List<T2> filtered2 = new ArrayList<>();
        List<T3> filtered3 = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            if (predicate.test(i, list1.get(i), list2.get(i), list3.get(i))) {
                filtered1.add(list1.get(i));
                filtered2.add(list2.get(i));
                filtered3.add(list3.get(i));
            }
        }
        return new StreamX3<>(filtered1, filtered2, filtered3);
    }

    public <R> R reduce(R identity, Accumulator3<Integer, T1, T2, T3, R> accumulator) {
        R result = identity;
        for (int i = 0; i < size; i++) {
            result = accumulator.reduce(i, list1.get(i), list2.get(i), list3.get(i));
        }
        return result;
    }

    public List<Tuple3<T1, T2, T3>> asTupleList() {
        List<Tuple3<T1, T2, T3>> result = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            result.add(new Tuple3<>(i,list1.get(i), list2.get(i), list3.get(i)));
        }
        return result;
    }
    public boolean allMatch(Predicate3<Integer, T1, T2, T3> predicate) {
        for (int i = 0; i < size; i++) {
            if (!predicate.test(i, list1.get(i), list2.get(i), list3.get(i)) ) return false;
        }
        return true;
    }

    public boolean anyMatch(Predicate3<Integer, T1, T2, T3> predicate) {
        for (int i = 0; i < size; i++) {
            if (predicate.test(i, list1.get(i), list2.get(i), list3.get(i)) ) return true;
        }
        return false;
    }
    public int size() { return size; }

    public StreamX3<T1, T2, T3> peek(Consumer3<Integer, T1, T2, T3> action) {
        for (int i = 0; i < size; i++) {
            action.accept(i, list1.get(i), list2.get(i), list3.get(i));
        }
        return this;
    }
}
