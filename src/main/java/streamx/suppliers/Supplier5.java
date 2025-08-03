package streamx.suppliers;

@FunctionalInterface
public interface Supplier5<A1, A2, A3, A4, A5, R> {

    R get(int index, A1 a1, A2 a2, A3 a3, A4 a4, A5 a5);
}
