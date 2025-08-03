package streamx.generators;
public class GenerateSortedByMethods {
    public static void main(String[] args) {
        for (int n = 1; n <= 20; n++) {
            StringBuilder sb = new StringBuilder();

            String className = "ParallelStream" + n;
            String tupleType = "Tuple" + n + "<" + typeParams(n) + ">";
            sb.append("public " + className + "<" + typeParams(n) + "> sortedBy(int listIndex, Comparator<?> comparator) {\n");

            sb.append("    List<" + tupleType + "> tuples = new ArrayList<>();\n");
            sb.append("    for (int i = 0; i < list1.size(); i++) {\n");
            sb.append("        tuples.add(new Tuple" + n + "<>(");
            for (int i = 1; i <= n; i++) {
                sb.append("list" + i + ".get(i)");
                if (i < n) sb.append(", ");
            }
            sb.append("));\n    }\n\n");

            sb.append("    Comparator<Tuple" + n + "<" + typeParams(n) + ">> tupleComparator;\n");
            sb.append("    switch (listIndex) {\n");
            for (int i = 1; i <= n; i++) {
                sb.append("        case " + i + ":\n");
                sb.append("            tupleComparator = Comparator.comparing(t -> (Comparable) t._" + i + ", (Comparator<Object>) comparator);\n");
                sb.append("            break;\n");
            }
            sb.append("        default:\n");
            sb.append("            throw new IllegalArgumentException(\"listIndex must be between 1 and " + n + "\");\n");
            sb.append("    }\n\n");

            sb.append("    tuples.sort(tupleComparator);\n\n");

            for (int i = 1; i <= n; i++) {
                sb.append("    List<T" + i + "> newList" + i + " = new ArrayList<>();\n");
            }
            sb.append("\n");

            sb.append("    for (Tuple" + n + "<" + typeParams(n) + "> t : tuples) {\n");
            for (int i = 1; i <= n; i++) {
                sb.append("        newList" + i + ".add(t._" + i + ");\n");
            }
            sb.append("    }\n\n");

            sb.append("    return new " + className + "<>(");
            for (int i = 1; i <= n; i++) {
                sb.append("newList" + i);
                if (i < n) sb.append(", ");
            }
            sb.append(");\n}\n");

            System.out.println("// ====== " + className + " ======");
            System.out.println(sb.toString());
            System.out.println();
        }
    }

    static String typeParams(int n) {
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            sb.append("T" + i);
            if (i < n) sb.append(", ");
        }
        return sb.toString();
    }
}
