package streamx.suppliers;

@FunctionalInterface
public interface Supplier3<A1, A2, A3, R> {

    R get(int index, A1 a1, A2 a2, A3 a3);
}
