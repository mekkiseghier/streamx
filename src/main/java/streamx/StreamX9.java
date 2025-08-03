package streamx;

import com.github.mekkiseghier.streamx.accumulators.Accumulator9;
import com.github.mekkiseghier.streamx.consumers.Consumer9;
import com.github.mekkiseghier.streamx.functions.Function9;
import com.github.mekkiseghier.streamx.predicates.Predicate9;
import com.github.mekkiseghier.streamx.tuples.Tuple9;

import java.util.ArrayList;
import java.util.List;

public class StreamX9<T1, T2, T3, T4, T5, T6, T7, T8, T9> {
    private final List<T1> list1;
    private final List<T2> list2;
    private final List<T3> list3;
    private final List<T4> list4;
    private final List<T5> list5;
    private final List<T6> list6;
    private final List<T7> list7;
    private final List<T8> list8;
    private final List<T9> list9;
    private final int size;

    public StreamX9(List<T1> list1, List<T2> list2, List<T3> list3, List<T4> list4, List<T5> list5, List<T6> list6, List<T7> list7, List<T8> list8, List<T9> list9) {
        int expectedSize = list1.size();
        if (list2.size() != expectedSize) throw new IllegalArgumentException("List sizes must match");
        if (list3.size() != expectedSize) throw new IllegalArgumentException("List sizes must match");
        if (list4.size() != expectedSize) throw new IllegalArgumentException("List sizes must match");
        if (list5.size() != expectedSize) throw new IllegalArgumentException("List sizes must match");
        if (list6.size() != expectedSize) throw new IllegalArgumentException("List sizes must match");
        if (list7.size() != expectedSize) throw new IllegalArgumentException("List sizes must match");
        if (list8.size() != expectedSize) throw new IllegalArgumentException("List sizes must match");
        if (list9.size() != expectedSize) throw new IllegalArgumentException("List sizes must match");
        this.list1 = list1;
        this.list2 = list2;
        this.list3 = list3;
        this.list4 = list4;
        this.list5 = list5;
        this.list6 = list6;
        this.list7 = list7;
        this.list8 = list8;
        this.list9 = list9;
        this.size = expectedSize;
    }

     @SafeVarargs    public final <T10> StreamX10 <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10> and( T10... values) {
        if (values.length != size) throw new IllegalArgumentException("List size mismatch");
        List<T10> safeList =new ArrayList<>(values.length);
        for (T10 item :  List.of(values) ) safeList.add(item);
        return new StreamX10 <>(list1, list2, list3, list4, list5, list6, list7, list8, list9, safeList);
    }

    public < T10> StreamX10 <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10> with(List <? extends T10 > list) {
        if (list.size() != size) throw new IllegalArgumentException("List size mismatch");
        List<T10> safeList = new ArrayList<>(list.size());
        for (T10 item : list) safeList.add(item);
        return new StreamX10 <>(list1, list2, list3, list4, list5, list6, list7, list8, list9, safeList);
    }

    public void forEach(Consumer9<Integer, T1, T2, T3, T4, T5, T6, T7, T8, T9> action) {
        for (int i = 0; i < size; i++) {
            action.accept(i, list1.get(i), list2.get(i), list3.get(i), list4.get(i), list5.get(i), list6.get(i), list7.get(i), list8.get(i), list9.get(i));
        }
    }

    public <R> List<R> map(Function9<Integer, T1, T2, T3, T4, T5, T6, T7, T8, T9, R> mapper) {
        List<R> results = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            results.add(mapper.apply(i, list1.get(i), list2.get(i), list3.get(i), list4.get(i), list5.get(i), list6.get(i), list7.get(i), list8.get(i), list9.get(i)));
        }
        return results;
    }

    public StreamX9<T1, T2, T3, T4, T5, T6, T7, T8, T9> filter(Predicate9<Integer, T1, T2, T3, T4, T5, T6, T7, T8, T9> predicate) {
        List<T1> filtered1 = new ArrayList<>();
        List<T2> filtered2 = new ArrayList<>();
        List<T3> filtered3 = new ArrayList<>();
        List<T4> filtered4 = new ArrayList<>();
        List<T5> filtered5 = new ArrayList<>();
        List<T6> filtered6 = new ArrayList<>();
        List<T7> filtered7 = new ArrayList<>();
        List<T8> filtered8 = new ArrayList<>();
        List<T9> filtered9 = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            if (predicate.test(i, list1.get(i), list2.get(i), list3.get(i), list4.get(i), list5.get(i), list6.get(i), list7.get(i), list8.get(i), list9.get(i))) {
                filtered1.add(list1.get(i));
                filtered2.add(list2.get(i));
                filtered3.add(list3.get(i));
                filtered4.add(list4.get(i));
                filtered5.add(list5.get(i));
                filtered6.add(list6.get(i));
                filtered7.add(list7.get(i));
                filtered8.add(list8.get(i));
                filtered9.add(list9.get(i));
            }
        }
        return new StreamX9<>(filtered1, filtered2, filtered3, filtered4, filtered5, filtered6, filtered7, filtered8, filtered9);
    }

    public <R> R reduce(R identity, Accumulator9<Integer, T1, T2, T3, T4, T5, T6, T7, T8, T9, R> accumulator) {
        R result = identity;
        for (int i = 0; i < size; i++) {
            result = accumulator.reduce(i, list1.get(i), list2.get(i), list3.get(i), list4.get(i), list5.get(i), list6.get(i), list7.get(i), list8.get(i), list9.get(i));
        }
        return result;
    }

    public List<Tuple9<T1, T2, T3, T4, T5, T6, T7, T8, T9>> asTupleList() {
        List<Tuple9<T1, T2, T3, T4, T5, T6, T7, T8, T9>> result = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            result.add(new Tuple9<>(i,list1.get(i), list2.get(i), list3.get(i), list4.get(i), list5.get(i), list6.get(i), list7.get(i), list8.get(i), list9.get(i)));
        }
        return result;
    }
    public boolean allMatch(Predicate9<Integer, T1, T2, T3, T4, T5, T6, T7, T8, T9> predicate) {
        for (int i = 0; i < size; i++) {
            if (!predicate.test(i, list1.get(i), list2.get(i), list3.get(i), list4.get(i), list5.get(i), list6.get(i), list7.get(i), list8.get(i), list9.get(i)) ) return false;
        }
        return true;
    }

    public boolean anyMatch(Predicate9<Integer, T1, T2, T3, T4, T5, T6, T7, T8, T9> predicate) {
        for (int i = 0; i < size; i++) {
            if (predicate.test(i, list1.get(i), list2.get(i), list3.get(i), list4.get(i), list5.get(i), list6.get(i), list7.get(i), list8.get(i), list9.get(i)) ) return true;
        }
        return false;
    }
    public int size() { return size; }

    public StreamX9<T1, T2, T3, T4, T5, T6, T7, T8, T9> peek(Consumer9<Integer, T1, T2, T3, T4, T5, T6, T7, T8, T9> action) {
        for (int i = 0; i < size; i++) {
            action.accept(i, list1.get(i), list2.get(i), list3.get(i), list4.get(i), list5.get(i), list6.get(i), list7.get(i), list8.get(i), list9.get(i));
        }
        return this;
    }
}
