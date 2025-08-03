package streamx.generators;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FunctionalInterfaceGenerator {
    public static void main(String[] args) throws IOException {
        generateInterfaces("consumers", "Consumer", "void", "accept");
        generateInterfaces("functions", "Function", "R", "apply", true);
        generateInterfaces("predicates", "Predicate", "boolean", "test");
        generateInterfaces("reducers", "Reducer", "R", "reduce", true);
    }

    static void generateInterfaces(String dirName, String baseName, String returnType, String methodName) throws IOException {
        generateInterfaces(dirName, baseName, returnType, methodName, false);
    }

    static void generateInterfaces(String dirName, String baseName, String returnType, String methodName, boolean extraReturn) throws IOException {
        File dir = new File(dirName);
        if (!dir.exists()) dir.mkdir();

        for (int n = 1; n <= 20; n++) {
            File file = new File(dir, baseName + n + ".java");
            try (FileWriter fw = new FileWriter(file)) {
                fw.write("package " + dirName + ";\n\n");
                fw.write("@FunctionalInterface\n");
                fw.write("public interface " + baseName + n + "<I");

                // Add generic types T1..Tn
                for (int i = 1; i <= n; i++) fw.write(", T" + i);
                if (extraReturn) fw.write(", R");
                fw.write("> {\n");

                // Method signature
                fw.write("    " + returnType + " " + methodName + "(I index");
                for (int i = 1; i <= n; i++) fw.write(", T" + i + " v" + i);
                fw.write(");\n");

                fw.write("}\n");
            }

            System.out.println("Generated: " + dirName + "/" + baseName + n + ".java");
        }
    }
}
