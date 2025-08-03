package streamx.predicates;

@FunctionalInterface
public interface Predicate1<I, T1> {
    boolean test(I index, T1 v1);
}
