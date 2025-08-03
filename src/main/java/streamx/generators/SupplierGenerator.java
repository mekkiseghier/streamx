package streamx.generators;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class SupplierGenerator {

    public static void main(String[] args) throws IOException {
        int max = 20;
        String baseDir = "suppliers";
        File folder = new File(baseDir);
        if (!folder.exists()) folder.mkdirs();

        for (int i = 0; i <= max; i++) {
            String className = "Supplier" + i;
            StringBuilder sb = new StringBuilder();

            // Package declaration
            sb.append("package suppliers;\n\n");

            // Functional interface annotation
            sb.append("@FunctionalInterface\n");

            // Interface header
            sb.append("public interface ").append(className).append("<");

            // Add type parameters
            for (int j = 1; j <= i; j++) {
                sb.append("A").append(j).append(", ");
            }
            sb.append("R> {\n\n");

            // Method declaration
            sb.append("    R get(int index");
            for (int j = 1; j <= i; j++) {
                sb.append(", A").append(j).append(" a").append(j);
            }
            sb.append(");\n");

            sb.append("}\n");

            // Write to file
            FileWriter writer = new FileWriter(baseDir + "/" + className + ".java");
            writer.write(sb.toString());
            writer.close();
        }

        System.out.println("Generated suppliers: Supplier0 to Supplier" + max + " in folder '" + baseDir + "'");
    }
}
