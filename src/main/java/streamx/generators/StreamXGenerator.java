package streamx.generators;
// Code generator for StreamX3 to StreamX20
// Each class will be written to its own file
// Each class will support: and(), with(), forEach(), filter(), map(), reduce(), sortedBy(), peek(), allMatch(), anyMatch(), size()
import java.io.FileWriter;
import java.io.IOException;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class StreamXGenerator {
    public static void main( String[] args ) throws IOException {
        generateStreamXClasses_untill_n( 20 );
        //  generate_signle_StreamXClass( 30 );
    }

    static void generateStreamXClasses_untill_n( int max ) throws IOException {
        for ( int n = 2; n <= max; n++ ) {
            generateStreamXClass( n );
        }
    }

    static void generate_signle_StreamXClass( int x ) throws IOException {
        generateStreamXClass( x );
    }

    private static String generateStreamXX( int n ) {
        StringBuilder sb = new StringBuilder();
        sb.append( "    public List<Tuple" ).append( n ).append( "<" );
        for ( int i = 1; i <= n; i++ ) {
            sb.append( "T" ).append( i ).append( i < n ? ", " : ">> asTupleList() {\n" );
        }
        sb.append( "        List<Tuple" ).append( n ).append( "<" );
        for ( int i = 1; i <= n; i++ ) {
            sb.append( "T" ).append( i ).append( i < n ? ", " : ">> result = new ArrayList<>();\n" );
        }
        sb.append( "        for (int i = 0; i < size; i++) {\n" );
        sb.append( "            result.add(new Tuple" ).append( n ).append( "<" ).append( ">(i," );
        for ( int i = 1; i <= n; i++ ) {
            sb.append( "list" ).append( i ).append( ".get(i)" ).append( i < n ? ", " : "));\n" );
        }
        sb.append( "        }\n        return result;\n    }\n" );
        return sb.toString();
    }

    static void generateStreamXClass( int n ) throws IOException {
        String className = "StreamX" + n;
        String nextClassName = n < 20 ? "StreamX" + ( n + 1 ) : "StreamXRaw";
        StringBuilder sb = new StringBuilder();
        // Package and imports
        //    sb.append( "package com.github.mekkiseghier.streamxs;\n\n" );
        sb.append( "import java.util.*;\n" );
        sb.append( "import com.github.mekkiseghier.streamxs.consumers.Consumer" + n + ";\n" );
        sb.append( "import com.github.mekkiseghier.streamxs.functions.Function" + n + ";\n" );
        sb.append( "import com.github.mekkiseghier.streamxs.predicates.Predicate" + n + ";\n" );
        sb.append( "import com.github.mekkiseghier.streamxs.accumulators.Accumulator" + n + ";\n" );
        sb.append( "import com.github.mekkiseghier.streamxs.tuples.Tuple" + n + ";\n\n" );
        // Class declaration
        sb.append( "public class " + className );
        sb.append( "<" + typeParams( n ) + "> {\n" );
        // Fields
        for ( int i = 1; i <= n; i++ ) {
            sb.append( "    private final List<T" + i + "> list" + i + ";\n" );
        }
        sb.append( "    private final int size;\n\n" );
        // Constructor
        sb.append( "    public " + className + "(" + listParams( n ) + ") {\n" );
        sb.append( "        int expectedSize = list1.size();\n" );
        for ( int i = 2; i <= n; i++ ) {
            sb.append( "        if (list" + i + ".size() != expectedSize) throw new IllegalArgumentException(\"List sizes must match\");\n" );
        }
        for ( int i = 1; i <= n; i++ ) {
            sb.append( "        this.list" + i + " = list" + i + ";\n" );
        }
        sb.append( "        this.size = expectedSize;\n" );
        sb.append( "    }\n\n" );
        if ( n < 20 ) {
            sb.append(
                    "     @SafeVarargs    public final <T" + ( n + 1 ) + "> " + nextClassName + "<" + typeArgs( n ) + ", T" + ( n + 1 ) + "> and( T" + ( n + 1 ) + ".." +
                    "." + " values) " + "{\n" );
            sb.append( "        if (values.length != size) throw new IllegalArgumentException(\"List size mismatch\");\n" );
            sb.append( "        List<T" ).append( n + 1 ).append( "> safeList =new ArrayList<>(values.length);\n" );
            sb.append( "        for (T" ).append( n + 1 ).append( " item :  List.of(values) ) safeList.add(item);\n" );
            sb.append( "        return new " + nextClassName + "<>(" + IntStream.rangeClosed( 1, n ).mapToObj( i -> "list" + i ).collect( Collectors.joining( ", " ) ) +
                       ", safeList);\n" );
            sb.append( "    }\n\n" );
            // with()
            sb.append( "    public < T" + ( n + 1 ) + "> " + nextClassName + "<" + typeArgs( n ) + ", T" + ( n + 1 ) + "> with(List <? extends T" + ( n + 1 ) +
                       " > list) {\n" );
            sb.append( "        if (list.size() != size) throw new IllegalArgumentException(\"List size mismatch\");\n" );
            sb.append( "        List<T" ).append( n + 1 ).append( "> safeList = new ArrayList<>(list.size());\n" );
            sb.append( "        for (T" ).append( n + 1 ).append( " item : list) safeList.add(item);\n" );
            sb.append( "        return new " + nextClassName + "<>(" + IntStream.rangeClosed( 1, n ).mapToObj( i -> "list" + i ).collect( Collectors.joining( ", " ) ) +
                       ", safeList);\n" );
            sb.append( "    }\n\n" );
        }
        else {
            // and()
            sb.append( "    @SafeVarargs    public final  " + nextClassName + " and(Object" + "... values) {\n" );
            sb.append( "        if (values.length != size) throw new IllegalArgumentException(\"List size mismatch\");\n" );
            sb.append( "        return new " + nextClassName + "(" + IntStream.rangeClosed( 1, n ).mapToObj( i -> "list" + i ).collect( Collectors.joining( ", " ) ) +
                       ", List.of(values));\n" );
            sb.append( "    }\n\n" );
            // with()
            sb.append( "    public " + nextClassName + " with(List list) {\n" );
            sb.append( "        if (list.size() != size) throw new IllegalArgumentException(\"List size mismatch\");\n" );
            sb.append( "        return new " + nextClassName + "(" + IntStream.rangeClosed( 1, n ).mapToObj( i -> "list" + i ).collect( Collectors.joining( ", " ) ) +
                       ", list);\n" );
            sb.append( "    }\n\n" );
        }
        // forEach()
        sb.append( "    public void forEach(Consumer" + n + "<Integer, " + typeArgs( n ) + "> action) {\n" );
        sb.append( "        for (int i = 0; i < size; i++) {\n" );
        sb.append(
                "            action.accept(i, " + IntStream.rangeClosed( 1, n ).mapToObj( i -> "list" + i + ".get(i)" ).collect( Collectors.joining( ", " ) ) + ");\n" );
        sb.append( "        }\n    }\n\n" );
        // map()
        sb.append( "    public <R> List<R> map(Function" + n + "<Integer, " + typeArgs( n ) + ", R> mapper) {\n" );
        sb.append( "        List<R> results = new ArrayList<>();\n" );
        sb.append( "        for (int i = 0; i < size; i++) {\n" );
        sb.append(
                "            results.add(mapper.apply(i, " + IntStream.rangeClosed( 1, n ).mapToObj( i -> "list" + i + ".get(i)" ).collect( Collectors.joining( ", " ) ) +
                "));\n" );
        sb.append( "        }\n        return results;\n    }\n\n" );
        // filter()
        sb.append( "    public " + className + "<" + typeArgs( n ) + "> filter(Predicate" + n + "<Integer, " + typeArgs( n ) + "> predicate) {\n" );
        for ( int i = 1; i <= n; i++ ) {
            sb.append( "        List<T" + i + "> filtered" + i + " = new ArrayList<>();\n" );
        }
        sb.append( "        for (int i = 0; i < size; i++) {\n" );
        sb.append( "            if (predicate.test(i, " + IntStream.rangeClosed( 1, n ).mapToObj( i -> "list" + i + ".get(i)" ).collect( Collectors.joining( ", " ) ) +
                   ")) {\n" );
        for ( int i = 1; i <= n; i++ ) {
            sb.append( "                filtered" + i + ".add(list" + i + ".get(i));\n" );
        }
        sb.append( "            }\n        }\n" );
        sb.append( "        return new " + className + "<>(" + IntStream.rangeClosed( 1, n ).mapToObj( i -> "filtered" + i ).collect( Collectors.joining( ", " ) ) +
                   ");\n    }\n\n" );
        // reduce()
        sb.append( "    public <R> R reduce(R identity, Accumulator" + n + "<Integer, " + typeArgs( n ) + ", R> accumulator) {\n" );
        sb.append( "        R result = identity;\n" );
        sb.append( "        for (int i = 0; i < size; i++) {\n" );
        sb.append( "            result = accumulator.reduce(i, " +
                   IntStream.rangeClosed( 1, n ).mapToObj( i -> "list" + i + ".get(i)" ).collect( Collectors.joining( ", " ) ) + ");\n" );
        sb.append( "        }\n        return result;\n    }\n\n" );
        sb.append( generateStreamXX( n ) );
        // allMatch
        sb.append( "    public boolean allMatch(Predicate" + n + "<Integer" );
        for ( int i = 1; i <= n; i++ ) {
            sb.append( ", T" + i );
        }
        sb.append( "> predicate) {\n" );
        sb.append( "        for (int i = 0; i < size; i++) {\n" );
        sb.append( "            if (!predicate.test(i" );
        for ( int i = 1; i <= n; i++ ) {
            sb.append( ", list" + i + ".get(i)" );
        }
        sb.append( ") ) return false;\n        }\n        return true;\n    }\n\n" );
        // anyMatch
        sb.append( "    public boolean anyMatch(Predicate" + n + "<Integer" );
        for ( int i = 1; i <= n; i++ ) {
            sb.append( ", T" + i );
        }
        sb.append( "> predicate) {\n" );
        sb.append( "        for (int i = 0; i < size; i++) {\n" );
        sb.append( "            if (predicate.test(i" );
        for ( int i = 1; i <= n; i++ ) {
            sb.append( ", list" + i + ".get(i)" );
        }
        sb.append( ") ) return true;\n        }\n        return false;\n    }\n" );
        // size()
        sb.append( "    public int size() { return size; }\n\n" );
        // peek()
        sb.append( "    public " + className + "<" + typeArgs( n ) + "> peek(Consumer" + n + "<Integer, " + typeArgs( n ) + "> action) {\n" );
        sb.append( "        for (int i = 0; i < size; i++) {\n" );
        sb.append(
                "            action.accept(i, " + IntStream.rangeClosed( 1, n ).mapToObj( i -> "list" + i + ".get(i)" ).collect( Collectors.joining( ", " ) ) + ");\n" );
        sb.append( "        }\n        return this;\n    }\n" );
        //  sb.append( generateTuple( n ) );
        sb.append( "}\n" );
        try ( FileWriter fw = new FileWriter( className + ".java" ) ) {
            fw.write( sb.toString() );
        }
    }

    static String generateTuple( int n ) {
        StringBuilder sb = new StringBuilder();
        sb.append( "public class Tuple" ).append( n ).append( "<" );
        for ( int i = 1; i <= n; i++ ) {
            sb.append( "T" ).append( i ).append( i < n ? ", " : ">" );
        }
        sb.append( " {\n    public final int index;\n" );
        for ( int i = 1; i <= n; i++ ) {
            sb.append( "    public final T" ).append( i ).append( " t" ).append( i ).append( ";\n" );
        }
        sb.append( "\n    public Tuple" ).append( n ).append( "(int index" );
        for ( int i = 1; i <= n; i++ ) {
            sb.append( ", T" ).append( i ).append( " t" ).append( i );
        }
        sb.append( ") {\n        this.index = index;\n" );
        for ( int i = 1; i <= n; i++ ) {
            sb.append( "        this.t" ).append( i ).append( " = t" ).append( i ).append( ";\n" );
        }
        sb.append( "    }\n\n    public int index() { return index; }\n" );
        for ( int i = 1; i <= n; i++ ) {
            String suffix = switch ( i ) {
                case 1 -> "1st";
                case 2 -> "2nd";
                case 3 -> "3rd";
                default -> i + "th";
            };
            sb.append( "    public T" ).append( i ).append( " get_" ).append( suffix ).append( "() { return t" ).append( i ).append( "; }\n" );
        }
        sb.append( "}\n" );
        return sb.toString();
    }

    private static String typeParams( int n ) {
        return IntStream.rangeClosed( 1, n ).mapToObj( i -> "T" + i ).collect( Collectors.joining( ", " ) );
    }

    private static String typeArgs( int n ) {
        return IntStream.rangeClosed( 1, n ).mapToObj( i -> "T" + i ).collect( Collectors.joining( ", " ) );
    }

    static String generate_interfaces( int n ) {
        return generateInterfaces( n, "Consumer", "void", "accept" ) + generateInterfaces( n, "Function", "R", "apply", true ) +
               generateInterfaces( n, "Predicate", "boolean", "test" ) + generateInterfaces( n, "Accumulator", "R", "reduce", true );
    }

    static String generateInterfaces( int n, String baseName, String returnType, String methodName ) {
        return generateInterfaces( n, baseName, returnType, methodName, false );
    }

    static String generateInterfaces( int n, String baseName, String returnType, String methodName, boolean extraReturn ) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append( "@FunctionalInterface\n" );
        stringBuilder.append( "public interface " + baseName + n + "<I" );
        // Add generic types T1..Tn
        for ( int i = 1; i <= n; i++ ) {
            stringBuilder.append( ", T" + i );
        }
        if ( extraReturn ) {
            stringBuilder.append( ", R" );
        }
        stringBuilder.append( "> {\n" );
        // Method signature
        stringBuilder.append( "    " + returnType + " " + methodName + "(I index" );
        for ( int i = 1; i <= n; i++ ) {
            stringBuilder.append( ", T" + i + " v" + i );
        }
        stringBuilder.append( ");\n" );
        stringBuilder.append( "}\n" );
        return stringBuilder.toString();
    }

    private static String listParams( int n ) {
        return IntStream.rangeClosed( 1, n ).mapToObj( i -> "List<T" + i + "> list" + i ).collect( Collectors.joining( ", " ) );
    }
}
