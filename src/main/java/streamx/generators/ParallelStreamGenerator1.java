package streamx.generators;// FINAL Code Generator for ParallelStream framework

/// FINAL Code Generator for ParallelStream framework
// - `ParallelStream1` to `ParallelStream5`: typed with expanded lambda args
// - `ParallelStreamX6` to `ParallelStreamX20`: use Tuple6 to Tuple20 (typed)
// - `ParallelStreamRaw`: fallback untyped using Entry
// - `add(...)`, `addList(...)`, and `of(...)` for constructing streams
// - Includes forEach, map, filter, reduce
public class ParallelStreamGenerator1 {
    public static void main( String[] args ) {
        generateFunctionalInterfaces();
        generateParallelStream1to5();
        generateParallelStreamX6to20();
        generateParallelStreamRaw();
    }

    static void generateFunctionalInterfaces() {
        for (int n = 1; n <= 5; n++) {
            StringBuilder consumer = new StringBuilder("@FunctionalInterface\npublic interface Consumer" + n + "<I");
            for (int i = 1; i <= n; i++) consumer.append(", T" + i);
            consumer.append("> { void accept(I index");
            for (int i = 1; i <= n; i++) consumer.append(", T" + i + " v" + i);
            consumer.append("); }\n");

            StringBuilder function = new StringBuilder("@FunctionalInterface\npublic interface Function" + n + "<I");
            for (int i = 1; i <= n; i++) function.append(", T" + i);
            function.append(", R> { R apply(I index");
            for (int i = 1; i <= n; i++) function.append(", T" + i + " v" + i);
            function.append("); }\n");

            StringBuilder predicate = new StringBuilder("@FunctionalInterface\npublic interface Predicate" + n + "<I");
            for (int i = 1; i <= n; i++) predicate.append(", T" + i);
            predicate.append("> { boolean test(I index");
            for (int i = 1; i <= n; i++) predicate.append(", T" + i + " v" + i);
            predicate.append("); }\n");

            System.out.println(consumer);
            System.out.println(function);
            System.out.println(predicate);
        }

        // For X6 to X20: use BiConsumer<Integer, TupleN>, BiFunction<Integer, TupleN, R>, BiPredicate<Integer, TupleN>
        // For Raw: use BiConsumer<Integer, Entry>, BiFunction<Integer, Entry, R>, BiPredicate<Integer, Entry>
        // No need to generate additional interfaces
    }

    static void generateParallelStream1to5() {
        for ( int n = 1; n <= 5; n++ ) {
            StringBuilder sb = new StringBuilder();
            sb.append( "public class ParallelStream" + n + "<" );
            for ( int i = 1; i <= n; i++ ) {
                sb.append( "T" + i + ( i < n ? ", " : "> {\n" ) );
            }
            for ( int i = 1; i <= n; i++ ) {
                sb.append( "    private final List<T" + i + "> list" + i + ";\n" );
            }
            sb.append( "\n    public ParallelStream" + n + "<" );
            for ( int i = 1; i <= n; i++ ) {
                sb.append( "T" + i + ( i < n ? ", " : "> (" ) );
            }
            for ( int i = 1; i <= n; i++ ) {
                sb.append( "List<T" + i + "> list" + i + ( i < n ? ", " : ") {\n" ) );
            }
            for ( int i = 1; i <= n; i++ ) {
                sb.append( "        this.list" + i + " = list" + i + ";\n" );
            }
            sb.append( "    }\n\n" );
            if ( n == 1 ) {
                sb.append( "    public static <T1> ParallelStream1<T1> of(T1... values) {\n" );
                sb.append( "        return new ParallelStream1<>(List.of(values));\n    }\n\n" );
            }
            if ( n < 5 ) {
                sb.append( "    public <T" + ( n + 1 ) + "> ParallelStream" + ( n + 1 ) + "<" );
                for ( int i = 1; i <= n; i++ ) {
                    sb.append( "T" + i + ", " );
                }
                sb.append( "T" + ( n + 1 ) + "> and(T" + ( n + 1 ) + "... values) {\n" );
                sb.append( "        return new ParallelStream" + ( n + 1 ) + "<>(" );
                for ( int i = 1; i <= n; i++ ) {
                    sb.append( "list" + i + ", " );
                }
                sb.append( "List.of(values));\n    }\n\n" );
            }
            else {
                sb.append( "    public <T6> ParallelStreamX6<" );
                for ( int i = 1; i <= 5; i++ ) {
                    sb.append( "T" + i + ", " );
                }
                sb.append( "T6> and(T6... values) {\n" );
                sb.append( "        return new ParallelStreamX6<>(" );
                for ( int i = 1; i <= 5; i++ ) {
                    sb.append( "list" + i + ", " );
                }
                sb.append( "List.of(values));\n    }\n\n" );
            }
            if ( n < 5 ) {
                sb.append( "    public <T" + ( n + 1 ) + "> ParallelStream" + ( n + 1 ) + "<" );
                for ( int i = 1; i <= n; i++ ) {
                    sb.append( "T" + i + ", " );
                }
                sb.append( "T" + ( n + 1 ) + "> addList(List< T"+ ( n + 1 ) + ">list"+(n+1)+") {\n" );
                sb.append( "        return new ParallelStream" + ( n + 1 ) + "<>(" );
                for ( int i = 1; i <= n; i++ ) {
                    sb.append( "list" + i + ", " );
                }
                sb.append( "list"+(n+1)+");\n    }\n\n" );
            }
            else {
                sb.append( "    public <T6> ParallelStreamX6<" );
                for ( int i = 1; i <= 5; i++ ) {
                    sb.append( "T" + i + ", " );
                }
                sb.append( "T6> and(T6... values) {\n" );
                sb.append( "        return new ParallelStreamX6<>(" );
                for ( int i = 1; i <= 5; i++ ) {
                    sb.append( "list" + i + ", " );
                }
                sb.append( "List.of(values));\n    }\n\n" );
            }
            sb.append( "    public void forEach(Consumer" + n + "<Integer, " );
            for ( int i = 1; i <= n; i++ ) {
                sb.append( "T" + i + ( i < n ? ", " : "> action) {\n" ) );
            }
            sb.append( "        int size = Collections.min(List.of(" );
            for ( int i = 1; i <= n; i++ ) {
                sb.append( "list" + i + ".size()" + ( i < n ? ", " : "));\n" ) );
            }
            sb.append( "        for (int i = 0; i < size; i++) {\n            action.accept(i, " );
            for ( int i = 1; i <= n; i++ ) {
                sb.append( "list" + i + ".get(i)" + ( i < n ? ", " : ");\n        }\n    }\n\n" ) );
            }            sb.append( "    public boolean filter(Predicate" + n + "<Integer, " );
            for ( int i = 1; i <= n; i++ ) {
                sb.append( "T" + i + ( i < n ? ", " : "> tester) {\n" ) );
            }
            sb.append( "        int size = Collections.min(List.of(" );
            for ( int i = 1; i <= n; i++ ) {
                sb.append( "list" + i + ".size()" + ( i < n ? ", " : "));\n" ) );
            }
            sb.append( "        List<R> result = new ArrayList<>();\n" );
            sb.append( "        for (int i = 0; i < size; i++) {\n          if(  tester.test(i, " );
            for ( int i = 1; i <= n; i++ ) {
                sb.append( "list" + i + ".get(i)" + ( i < n ? ", " : ");\n  ) result.add()      }\n    }\n\n" ) );
            }

            sb.append( "    public <R> List<R> map(Function" + n + "<Integer, " );
            for ( int i = 1; i <= n; i++ ) {
                sb.append( "T" + i + ( i < n ? ", " : ", R> mapper) {\n" ) );
            }
            sb.append( "        List<R> result = new ArrayList<>();\n" );
            sb.append( "        ... // Mapping logic\n" );
            sb.append( "        return result;\n    }\n\n" );
            sb.append( "    public <R> R reduce(R identity, BiFunction<R, Tuple" + n + "<" );
            for ( int i = 1; i <= n; i++ ) {
                sb.append( "T" + i + ( i < n ? ", " : ">, R> reducer) {\n" ) );
            }

            sb.append( "        R result = identity;\n        ... // Reduction logic\n        return result;\n    }\n" );
            sb.append( "}\n\n" );
            System.out.println( sb );
        }
    }

    static void generateParallelStreamX6to20() {
        for ( int n = 6; n <= 20; n++ ) {
            StringBuilder sb = new StringBuilder();
            sb.append( "public class ParallelStreamX" + n + "<" );
            for ( int i = 1; i <= n; i++ ) {
                sb.append( "T" + i + ( i < n ? ", " : "> {\n" ) );
            }
            for ( int i = 1; i <= n; i++ ) {
                sb.append( "    private final List<T" + i + "> list" + i + ";\n" );
            }
            sb.append( "\n    public ParallelStreamX" + n + "(" );
            for ( int i = 1; i <= n; i++ ) {
                sb.append( "List<T" + i + "> list" + i + ( i < n ? ", " : ") {\n" ) );
            }
            for ( int i = 1; i <= n; i++ ) {
                sb.append( "        this.list" + i + " = list" + i + ";\n" );
            }
            sb.append( "    }\n\n" );
            sb.append( "    public <T" + ( n + 1 ) + "> ParallelStreamX" + ( n + 1 ) + "<" );
            for ( int i = 1; i <= n; i++ ) {
                sb.append( "T" + i + ", " );
            }
            sb.append( "T" + ( n + 1 ) + "> and(T" + ( n + 1 ) + "... values) {\n" );
            sb.append( "        return new ParallelStreamX" + ( n + 1 ) + "<>(" );
            for ( int i = 1; i <= n; i++ ) {
                sb.append( "list" + i + ", " );
            }
            sb.append( "List.of(values));\n    }\n\n" );
            sb.append( "    public <T" + ( n + 1 ) + "> ParallelStreamX" + ( n + 1 ) + "<" );
            for ( int i = 1; i <= n; i++ ) {
                sb.append( "T" + i + ", " );
            }
            sb.append( "T" + ( n + 1 ) + "> addList(List< T"+ ( n + 1 ) + ">list"+(n+1)+") {\n" );
            sb.append( "        return new ParallelStreamX" + ( n + 1 ) + "<>(" );
            for ( int i = 1; i <= n; i++ ) {
                sb.append( "list" + i + ", " );
            }
            sb.append( "list"+(n+1)+");\n    }\n\n" );
            sb.append("    public Stream<Tuple").append(n).append("<");
            for (int i = 1; i <= n; i++) {
                sb.append("T").append(i);
                if (i < n) sb.append(", ");
            }
            sb.append(">> stream() {\n");
            sb.append("        List<Tuple").append(n).append("<");
            for (int i = 1; i <= n; i++) {
                sb.append("T").append(i);
                if (i < n) sb.append(", ");
            }
            sb.append(">> result = new ArrayList<>();\n");
            sb.append("        for (int i = 0; i < list1.size(); i++) {\n");
            sb.append("            result.add(new Tuple").append(n).append("<>(").append("i");
            for (int i = 1; i <= n; i++) {
                sb.append(", list").append(i).append(".get(i)");
            }
            sb.append("));\n");
            sb.append("        }\n");
            sb.append("        return result.stream();\n");
            sb.append("    }\n");
    /*        sb.append( "    public void forEach(Consumer<Tuple" + n + "<" );
            for ( int i = 1; i <= n; i++ ) {
                sb.append( "T" + i + ( i < n ? ", " : ">> action) {\n" ) );
            }
            sb.append( "        int size = Collections.min(List.of(" );
            for ( int i = 1; i <= n; i++ ) {
                sb.append( "list" + i + ".size()" + ( i < n ? ", " : "));\n" ) );
            }
            sb.append( "        for (int i = 0; i < size; i++) {\n            action.accept(new Tuple" + n + "<>(" );
            for ( int i = 1; i <= n; i++ ) {
                sb.append( "list" + i + ".get(i)" + ( i < n ? ", " : ", i));\n        }\n    }\n\n" ) );
            }
            sb.append( "    public <R> List<R> map(Function<Tuple" + n + "<" );
            for ( int i = 1; i <= n; i++ ) {
                sb.append( "T" + i + ( i < n ? ", " : ">, R> mapper) {\n" ) );
            }
            sb.append( "        List<R> result = new ArrayList<>();\n        ... // Mapping logic\n        return result;\n    }\n\n" );
            sb.append( "    public ParallelStreamX" + n + "<...> filter(Predicate<Tuple" + n + "<" );
            for ( int i = 1; i <= n; i++ ) {
                sb.append( "T" + i + ( i < n ? ", " : ">> predicate) {\n" ) );
            }
            sb.append( "        ... // Filtering logic\n        return this;\n    }\n\n" );
            sb.append( "    public <R> R reduce(R identity, BiFunction<R, Tuple" + n + "<" );
            for ( int i = 1; i <= n; i++ ) {
                sb.append( "T" + i + ( i < n ? ", " : ">, R> reducer) {\n" ) );
            }
            sb.append( "        R result = identity;\n        ... // Reduction logic\n        return result;\n    }\n} " );*/
            System.out.println( sb );
        }
    }

    static void generateParallelStreamRaw() {
        StringBuilder sb = new StringBuilder();
        sb.append( "public class ParallelStreamRaw {\n" );
        sb.append( "    private final List<List<?>> lists = new ArrayList<>();\n\n" );
        sb.append( "    public ParallelStreamRaw add(Object... values) {\n        lists.add(List.of(values));\n        return this;\n    }\n\n" );
        sb.append( "    public ParallelStreamRaw addList(List<?> list) {\n        lists.add(list);\n        return this;\n    }\n\n" );
        sb.append(
                "    public void forEach(Consumer<Entry> action) {\n        int size = lists.stream().mapToInt(List::size).min().orElse(0);\n        for (int i = 0; i < size; i++) {\n            List<Object> values = new ArrayList<>();\n            for (List<?> list : lists) values.add(list.get(i));\n            action.accept(new Entry(i, values));\n        }\n    }\n\n" );
        sb.append(
                "    public <R> List<R> map(Function<Entry, R> mapper) {\n        List<R> result = new ArrayList<>();\n        int size = lists.stream().mapToInt(List::size).min().orElse(0);\n        for (int i = 0; i < size; i++) {\n            List<Object> values = new ArrayList<>();\n            for (List<?> list : lists) values.add(list.get(i));\n            result.add(mapper.apply(new Entry(i, values)));\n        }\n        return result;\n    }\n\n" );
        sb.append( "    public ParallelStreamRaw filter(Predicate<Entry> predicate) {\n        ... // Filtering logic\n        return this;\n    }\n\n" );
        sb.append(
                "    public <R> R reduce(R identity, BiFunction<R, Entry, R> reducer) {\n        R result = identity;\n        int size = lists.stream().mapToInt(List::size).min().orElse(0);\n        for (int i = 0; i < size; i++) {\n            List<Object> values = new ArrayList<>();\n            for (List<?> list : lists) values.add(list.get(i));\n            result = reducer.apply(result, new Entry(i, values));\n        }\n        return result;\n    }\n}" );
        sb.append(
                "\n\nclass Entry {\n    private final int index;\n    private final List<Object> values;\n    public Entry(int index, List<Object> values) { this.index = index; this.values = values; }\n\n" );
        sb.append( "    public int index() { return index; }\n" );
        sb.append( "    public Object get(int i) { return values.get(i); }\n" );
        sb.append( "    public void set(int i, Object value) { values.set(i, value); }\n}" );
        System.out.println( sb );
    }
}
