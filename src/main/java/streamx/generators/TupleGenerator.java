package streamx.generators;

public class TupleGenerator {
    public static void main(String[] args) {
        for (int n = 2; n <= 20; n++) {
            System.out.println(generateTuple(n));
        }
    }

    static String generateTuple(int n) {
        StringBuilder sb = new StringBuilder();
        sb.append("public class Tuple").append(n).append("<");
        for (int i = 1; i <= n; i++) sb.append("T").append(i).append(i < n ? ", " : ">");
        sb.append(" {\n    public final int index;\n");
        for (int i = 1; i <= n; i++) sb.append("    public final T").append(i).append(" t").append(i).append(";\n");
        sb.append("\n    public Tuple").append(n).append("(int index");
        for (int i = 1; i <= n; i++) sb.append(", T").append(i).append(" t").append(i);
        sb.append(") {\n        this.index = index;\n");
        for (int i = 1; i <= n; i++) sb.append("        this.t").append(i).append(" = t").append(i).append(";\n");
        sb.append("    }\n\n    public int index() { return index; }\n");
        for (int i = 1; i <= n; i++) {
            String suffix = switch (i) {
                case 1 -> "1st";
                case 2 -> "2nd";
                case 3 -> "3rd";
                default -> i + "th";
            };
            sb.append("    public T").append(i).append(" get_").append(suffix).append("() { return t").append(i).append("; }\n");
        }
        sb.append("}\n");
        return sb.toString();
    }
}
