package streamx.tuples;

public class Tuple2<T1, T2> {
    public final int index;
    public final T1 t1;
    public final T2 t2;

    public Tuple2(int index, T1 t1, T2 t2) {
        this.index = index;
        this.t1 = t1;
        this.t2 = t2;
    }

    public int index() { return index; }
    public T1 get_1st() { return t1; }
    public T2 get_2nd() { return t2; }
}
