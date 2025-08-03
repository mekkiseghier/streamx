package streamx;

import com.github.mekkiseghier.streamx.accumulators.Accumulator7;
import com.github.mekkiseghier.streamx.consumers.Consumer7;
import com.github.mekkiseghier.streamx.functions.Function7;
import com.github.mekkiseghier.streamx.predicates.Predicate7;
import com.github.mekkiseghier.streamx.tuples.Tuple7;

import java.util.ArrayList;
import java.util.List;

public class StreamX7<T1, T2, T3, T4, T5, T6, T7> {
    private final List<T1> list1;
    private final List<T2> list2;
    private final List<T3> list3;
    private final List<T4> list4;
    private final List<T5> list5;
    private final List<T6> list6;
    private final List<T7> list7;
    private final int size;

    public StreamX7(List<T1> list1, List<T2> list2, List<T3> list3, List<T4> list4, List<T5> list5, List<T6> list6, List<T7> list7) {
        int expectedSize = list1.size();
        if (list2.size() != expectedSize) throw new IllegalArgumentException("List sizes must match");
        if (list3.size() != expectedSize) throw new IllegalArgumentException("List sizes must match");
        if (list4.size() != expectedSize) throw new IllegalArgumentException("List sizes must match");
        if (list5.size() != expectedSize) throw new IllegalArgumentException("List sizes must match");
        if (list6.size() != expectedSize) throw new IllegalArgumentException("List sizes must match");
        if (list7.size() != expectedSize) throw new IllegalArgumentException("List sizes must match");
        this.list1 = list1;
        this.list2 = list2;
        this.list3 = list3;
        this.list4 = list4;
        this.list5 = list5;
        this.list6 = list6;
        this.list7 = list7;
        this.size = expectedSize;
    }

     @SafeVarargs    public final <T8> StreamX8 <T1, T2, T3, T4, T5, T6, T7, T8> and( T8... values) {
        if (values.length != size) throw new IllegalArgumentException("List size mismatch");
        List<T8> safeList =new ArrayList<>(values.length);
        for (T8 item :  List.of(values) ) safeList.add(item);
        return new StreamX8 <>(list1, list2, list3, list4, list5, list6, list7, safeList);
    }

    public < T8> StreamX8 <T1, T2, T3, T4, T5, T6, T7, T8> with(List <? extends T8 > list) {
        if (list.size() != size) throw new IllegalArgumentException("List size mismatch");
        List<T8> safeList = new ArrayList<>(list.size());
        for (T8 item : list) safeList.add(item);
        return new StreamX8 <>(list1, list2, list3, list4, list5, list6, list7, safeList);
    }

    public void forEach(Consumer7<Integer, T1, T2, T3, T4, T5, T6, T7> action) {
        for (int i = 0; i < size; i++) {
            action.accept(i, list1.get(i), list2.get(i), list3.get(i), list4.get(i), list5.get(i), list6.get(i), list7.get(i));
        }
    }

    public <R> List<R> map(Function7<Integer, T1, T2, T3, T4, T5, T6, T7, R> mapper) {
        List<R> results = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            results.add(mapper.apply(i, list1.get(i), list2.get(i), list3.get(i), list4.get(i), list5.get(i), list6.get(i), list7.get(i)));
        }
        return results;
    }

    public StreamX7<T1, T2, T3, T4, T5, T6, T7> filter(Predicate7<Integer, T1, T2, T3, T4, T5, T6, T7> predicate) {
        List<T1> filtered1 = new ArrayList<>();
        List<T2> filtered2 = new ArrayList<>();
        List<T3> filtered3 = new ArrayList<>();
        List<T4> filtered4 = new ArrayList<>();
        List<T5> filtered5 = new ArrayList<>();
        List<T6> filtered6 = new ArrayList<>();
        List<T7> filtered7 = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            if (predicate.test(i, list1.get(i), list2.get(i), list3.get(i), list4.get(i), list5.get(i), list6.get(i), list7.get(i))) {
                filtered1.add(list1.get(i));
                filtered2.add(list2.get(i));
                filtered3.add(list3.get(i));
                filtered4.add(list4.get(i));
                filtered5.add(list5.get(i));
                filtered6.add(list6.get(i));
                filtered7.add(list7.get(i));
            }
        }
        return new StreamX7<>(filtered1, filtered2, filtered3, filtered4, filtered5, filtered6, filtered7);
    }

    public <R> R reduce(R identity, Accumulator7<Integer, T1, T2, T3, T4, T5, T6, T7, R> accumulator) {
        R result = identity;
        for (int i = 0; i < size; i++) {
            result = accumulator.reduce(i, list1.get(i), list2.get(i), list3.get(i), list4.get(i), list5.get(i), list6.get(i), list7.get(i));
        }
        return result;
    }

    public List<Tuple7<T1, T2, T3, T4, T5, T6, T7>> asTupleList() {
        List<Tuple7<T1, T2, T3, T4, T5, T6, T7>> result = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            result.add(new Tuple7<>(i,list1.get(i), list2.get(i), list3.get(i), list4.get(i), list5.get(i), list6.get(i), list7.get(i)));
        }
        return result;
    }
    public boolean allMatch(Predicate7<Integer, T1, T2, T3, T4, T5, T6, T7> predicate) {
        for (int i = 0; i < size; i++) {
            if (!predicate.test(i, list1.get(i), list2.get(i), list3.get(i), list4.get(i), list5.get(i), list6.get(i), list7.get(i)) ) return false;
        }
        return true;
    }

    public boolean anyMatch(Predicate7<Integer, T1, T2, T3, T4, T5, T6, T7> predicate) {
        for (int i = 0; i < size; i++) {
            if (predicate.test(i, list1.get(i), list2.get(i), list3.get(i), list4.get(i), list5.get(i), list6.get(i), list7.get(i)) ) return true;
        }
        return false;
    }
    public int size() { return size; }

    public StreamX7<T1, T2, T3, T4, T5, T6, T7> peek(Consumer7<Integer, T1, T2, T3, T4, T5, T6, T7> action) {
        for (int i = 0; i < size; i++) {
            action.accept(i, list1.get(i), list2.get(i), list3.get(i), list4.get(i), list5.get(i), list6.get(i), list7.get(i));
        }
        return this;
    }
}
