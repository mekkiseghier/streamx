package streamx.generators;

import java.io.FileWriter;
import java.io.IOException;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ParallelStreamGenerator_old {

    static final int MAX_ARITY = 20; // adjust up to 30 if needed

    public static void main(String[] args) throws IOException {
        try (FileWriter writer = new FileWriter("ParallelStream.java")) {
            writer.write("import java.util.*;\n");
            writer.write("import java.util.function.*;\n");
            writer.write("import java.util.stream.IntStream;\n\n");
            writer.write("public class ParallelStream {\n\n");
            writer.write("    private ParallelStream() {}\n\n");

            for (int i = 1; i <= MAX_ARITY; i++) {
                writer.write(makeStaticOf(i));
                writer.write(makeClass(i));
            }

            // Functional interfaces
            for (int i = 1; i <= MAX_ARITY; i++) {
                writer.write(makeFunctionalInterfaces(i));
            }

            writer.write("}\n");
        }

        System.out.println("ParallelStream.java generated.");
    }

    static String makeStaticOf(int arity) {
        String typeParams = IntStream.rangeClosed(1, arity)
                .mapToObj(i -> "T" + i)
                .collect(Collectors.joining(", "));
        String listParams = IntStream.rangeClosed(1, arity)
                .mapToObj(i -> "List<T" + i + "> l" + i)
                .collect(Collectors.joining(", "));
        String returnType = "ParallelStream" + arity + "<" + typeParams + ">";
        String argsCheck = (arity == 1) ? "" : String.format("""
                if (%s) throw new IllegalArgumentException("All lists must be same size");
                """, IntStream.rangeClosed(2, arity)
                .mapToObj(i -> "l1.size() != l" + i + ".size()")
                .collect(Collectors.joining(" || ")));

        return String.format("""
                public static <%s> %s of(%s) {
                    %s
                    return new %s(%s);
                }
                
                """, typeParams, returnType, listParams, argsCheck, returnType,
                IntStream.rangeClosed(1, arity).mapToObj(i -> "l" + i).collect(Collectors.joining(", ")));
    }

    static String makeClass(int arity) {
        String typeParams = IntStream.rangeClosed(1, arity)
                .mapToObj(i -> "T" + i)
                .collect(Collectors.joining(", "));

        String fields = IntStream.rangeClosed(1, arity)
                .mapToObj(i -> "private final List<T" + i + "> l" + i + ";")
                .collect(Collectors.joining("\n        "));

        String constructorArgs = IntStream.rangeClosed(1, arity)
                .mapToObj(i -> "List<T" + i + "> l" + i)
                .collect(Collectors.joining(", "));

        String constructorAssign = IntStream.rangeClosed(1, arity)
                .mapToObj(i -> "this.l" + i + " = l" + i + ";")
                .collect(Collectors.joining("\n            "));

        String forEach = String.format("""
            public void forEach(Consumer%d<%s> consumer) {
                IntStream.range(0, size()).parallel().forEach(i -> consumer.accept(i, %s));
            }
            """, arity,  typeParams,
                IntStream.rangeClosed(1, arity).mapToObj(i -> "l" + i + ".get(i)").collect(Collectors.joining(", ")));

        String filter = String.format("""
            public ParallelStream%d<%s> filter(Predicate%d<%s> predicate) {
                List<Integer> indices = IntStream.range(0, size()).parallel()
                        .filter(i -> predicate.test(i, %s))
                        .boxed().toList();
                        
                %s

                return new ParallelStream%d<>(%s);
            }
            """, arity, typeParams, arity,  typeParams,
                IntStream.rangeClosed(1, arity).mapToObj(i -> "l" + i + ".get(i)").collect(Collectors.joining(", ")),
                IntStream.rangeClosed(1, arity)
                        .mapToObj(i -> String.format("List<T%d> newL%d = indices.parallelStream().map(l%d::get).toList();", i, i, i))
                        .collect(Collectors.joining("\n                ")),
                arity,
                IntStream.rangeClosed(1, arity).mapToObj(i -> "newL" + i).collect(Collectors.joining(", ")));

        String map = String.format("""
            public <R> List<R> map(Function%d<%s, R> mapper) {
                return IntStream.range(0, size()).parallel()
                        .mapToObj(i -> mapper.apply(i, %s))
                        .toList();
            }
            """, arity,  typeParams,
                IntStream.rangeClosed(1, arity).mapToObj(i -> "l" + i + ".get(i)").collect(Collectors.joining(", ")));

        String reduce = String.format("""
            public <R> R reduce(R identity, Function%d<%s, R> mapper, BinaryOperator<R> reducer) {
                return IntStream.range(0, size()).parallel()
                        .mapToObj(i -> mapper.apply(i, %s))
                        .reduce(identity, reducer);
            }
            """, arity,  typeParams,
                IntStream.rangeClosed(1, arity).mapToObj(i -> "l" + i + ".get(i)").collect(Collectors.joining(", ")));

        return String.format("""
            public static class ParallelStream%d<%s> {
                %s

                private ParallelStream%d(%s) {
                    %s
                }

                public int size() {
                    return l1.size();
                }

                %s
                %s
                %s
                %s
            }
            
            """, arity, typeParams,
                fields, arity, constructorArgs, constructorAssign,
                forEach, filter, map, reduce);
    }

    static String makeFunctionalInterfaces(int arity) {
        String typeParams = IntStream.rangeClosed(1, arity)
                .mapToObj(i -> "T" + i)
                .collect(Collectors.joining(", "));

        String args = IntStream.rangeClosed(1, arity)
                .mapToObj(i -> "T" + i + " v" + i)
                .collect(Collectors.joining(", "));

        return String.format("""
            @FunctionalInterface public interface Consumer%d<%s> {
                void accept(Integer i, %s);
            }
            
            @FunctionalInterface public interface Predicate%d<%s> {
                boolean test(Integer i, %s);
            }
            
            @FunctionalInterface public interface Function%d<%s, R> {
                R apply(Integer i, %s);
            }
            
            """, arity, typeParams, args,
                arity, typeParams, args,
                arity, typeParams, args);
    }
}
