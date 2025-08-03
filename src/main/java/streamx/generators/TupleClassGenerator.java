package streamx.generators;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class TupleClassGenerator {
    public static void main(String[] args) throws IOException {
        File dir = new File("tuples");
        if (!dir.exists()) dir.mkdir();

        for (int n = 1; n <= 20; n++) {
            String className = "Tuple" + n;
            File file = new File(dir, className + ".java");

            try (FileWriter fw = new FileWriter(file)) {
         fw.write( StreamXGenerator.generateTuple( n ) );
            }

            System.out.println("Generated: tuples/" + className + ".java");
        }
    }
}
