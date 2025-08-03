package com.github.mekkiseghier.streamx.generators;

public class g {
    public static String generateTimesMethods(int max) {
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= max; i++) {
            sb.append("public static <");
            for (int j = 1; j <= i; j++) sb.append("A").append(j).append(", ");
            sb.append("R> ParallelStream1<R> times(int count");
            for (int j = 1; j <= i; j++) sb.append(", A").append(j).append(" a").append(j);
            sb.append(", Supplier").append(i).append("<");
            for (int j = 1; j <= i; j++) sb.append("A").append(j).append(", ");
            sb.append("R> supplier) {\n");

            sb.append("    List<R> list = new ArrayList<>(count);\n");
            sb.append("    for (int i = 0; i < count; i++) {\n        list.add(supplier.get(i");
            for (int j = 1; j <= i; j++) sb.append(", a").append(j);
            sb.append("));\n    }\n");

            sb.append("    return new ParallelStream1<>(list);\n}\n\n");
        }
        return sb.toString();
    }


    public static void main( String[] args ) {
        System.out.println(generateTimesMethods( 20 ) );
    }
}
