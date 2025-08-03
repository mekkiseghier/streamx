package streamx.tuples;

public class Tuple3<T1, T2, T3> {
    public final int index;
    public final T1 t1;
    public final T2 t2;
    public final T3 t3;

    public Tuple3(int index, T1 t1, T2 t2, T3 t3) {
        this.index = index;
        this.t1 = t1;
        this.t2 = t2;
        this.t3 = t3;
    }

    public int index() { return index; }
    public T1 get_1st() { return t1; }
    public T2 get_2nd() { return t2; }
    public T3 get_3rd() { return t3; }
}
