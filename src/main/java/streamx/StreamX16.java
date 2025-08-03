package streamx;

import com.github.mekkiseghier.streamx.accumulators.Accumulator16;
import com.github.mekkiseghier.streamx.consumers.Consumer16;
import com.github.mekkiseghier.streamx.functions.Function16;
import com.github.mekkiseghier.streamx.predicates.Predicate16;
import com.github.mekkiseghier.streamx.tuples.Tuple16;

import java.util.ArrayList;
import java.util.List;

public class StreamX16<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16> {
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
    private final int size;

    public StreamX16(List<T1> list1, List<T2> list2, List<T3> list3, List<T4> list4, List<T5> list5, List<T6> list6, List<T7> list7, List<T8> list8, List<T9> list9, List<T10> list10, List<T11> list11, List<T12> list12, List<T13> list13, List<T14> list14, List<T15> list15, List<T16> list16) {
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
        this.size = expectedSize;
    }

     @SafeVarargs    public final <T17> StreamX17 <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17> and( T17... values) {
        if (values.length != size) throw new IllegalArgumentException("List size mismatch");
        List<T17> safeList =new ArrayList<>(values.length);
        for (T17 item :  List.of(values) ) safeList.add(item);
        return new StreamX17 <>(list1, list2, list3, list4, list5, list6, list7, list8, list9, list10, list11, list12, list13, list14, list15, list16, safeList);
    }

    public < T17> StreamX17 <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17> with(List <? extends T17 > list) {
        if (list.size() != size) throw new IllegalArgumentException("List size mismatch");
        List<T17> safeList = new ArrayList<>(list.size());
        for (T17 item : list) safeList.add(item);
        return new StreamX17 <>(list1, list2, list3, list4, list5, list6, list7, list8, list9, list10, list11, list12, list13, list14, list15, list16, safeList);
    }

    public void forEach(Consumer16<Integer, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16> action) {
        for (int i = 0; i < size; i++) {
            action.accept(i, list1.get(i), list2.get(i), list3.get(i), list4.get(i), list5.get(i), list6.get(i), list7.get(i), list8.get(i), list9.get(i), list10.get(i), list11.get(i), list12.get(i), list13.get(i), list14.get(i), list15.get(i), list16.get(i));
        }
    }

    public <R> List<R> map(Function16<Integer, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, R> mapper) {
        List<R> results = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            results.add(mapper.apply(i, list1.get(i), list2.get(i), list3.get(i), list4.get(i), list5.get(i), list6.get(i), list7.get(i), list8.get(i), list9.get(i), list10.get(i), list11.get(i), list12.get(i), list13.get(i), list14.get(i), list15.get(i), list16.get(i)));
        }
        return results;
    }

    public StreamX16<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16> filter(Predicate16<Integer, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16> predicate) {
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
        for (int i = 0; i < size; i++) {
            if (predicate.test(i, list1.get(i), list2.get(i), list3.get(i), list4.get(i), list5.get(i), list6.get(i), list7.get(i), list8.get(i), list9.get(i), list10.get(i), list11.get(i), list12.get(i), list13.get(i), list14.get(i), list15.get(i), list16.get(i))) {
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
            }
        }
        return new StreamX16<>(filtered1, filtered2, filtered3, filtered4, filtered5, filtered6, filtered7, filtered8, filtered9, filtered10, filtered11, filtered12, filtered13, filtered14, filtered15, filtered16);
    }

    public <R> R reduce(R identity, Accumulator16<Integer, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, R> accumulator) {
        R result = identity;
        for (int i = 0; i < size; i++) {
            result = accumulator.reduce(i, list1.get(i), list2.get(i), list3.get(i), list4.get(i), list5.get(i), list6.get(i), list7.get(i), list8.get(i), list9.get(i), list10.get(i), list11.get(i), list12.get(i), list13.get(i), list14.get(i), list15.get(i), list16.get(i));
        }
        return result;
    }

    public List<Tuple16<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16>> asTupleList() {
        List<Tuple16<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16>> result = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            result.add(new Tuple16<>(i,list1.get(i), list2.get(i), list3.get(i), list4.get(i), list5.get(i), list6.get(i), list7.get(i), list8.get(i), list9.get(i), list10.get(i), list11.get(i), list12.get(i), list13.get(i), list14.get(i), list15.get(i), list16.get(i)));
        }
        return result;
    }
    public boolean allMatch(Predicate16<Integer, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16> predicate) {
        for (int i = 0; i < size; i++) {
            if (!predicate.test(i, list1.get(i), list2.get(i), list3.get(i), list4.get(i), list5.get(i), list6.get(i), list7.get(i), list8.get(i), list9.get(i), list10.get(i), list11.get(i), list12.get(i), list13.get(i), list14.get(i), list15.get(i), list16.get(i)) ) return false;
        }
        return true;
    }

    public boolean anyMatch(Predicate16<Integer, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16> predicate) {
        for (int i = 0; i < size; i++) {
            if (predicate.test(i, list1.get(i), list2.get(i), list3.get(i), list4.get(i), list5.get(i), list6.get(i), list7.get(i), list8.get(i), list9.get(i), list10.get(i), list11.get(i), list12.get(i), list13.get(i), list14.get(i), list15.get(i), list16.get(i)) ) return true;
        }
        return false;
    }
    public int size() { return size; }

    public StreamX16<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16> peek(Consumer16<Integer, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16> action) {
        for (int i = 0; i < size; i++) {
            action.accept(i, list1.get(i), list2.get(i), list3.get(i), list4.get(i), list5.get(i), list6.get(i), list7.get(i), list8.get(i), list9.get(i), list10.get(i), list11.get(i), list12.get(i), list13.get(i), list14.get(i), list15.get(i), list16.get(i));
        }
        return this;
    }
}
