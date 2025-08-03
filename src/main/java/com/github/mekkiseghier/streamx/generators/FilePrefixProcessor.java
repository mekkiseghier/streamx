package com.github.mekkiseghier.streamx.generators;

import java.io.*;
import java.util.*;

public class FilePrefixProcessor {
    public static List < File > findAndProcessFiles( String folderPath, String prefix ) throws IOException {
        File dir = new File( folderPath );
        if ( !dir.exists() || !dir.isDirectory() ) {
            throw new IllegalArgumentException( "Invalid directory: " + folderPath );
        }
        // Step 1: Collect files matching the prefix
        File[] matchingFiles = dir.listFiles( ( file, name ) -> name.startsWith( prefix ) );
        if ( matchingFiles == null ) {
            return Collections.emptyList();
        }
        // Step 2: Sort files by name
        List < File > sortedFiles = new ArrayList <>( Arrays.asList( matchingFiles ) );
        sortedFiles.sort( Comparator.comparing( File::getName ) );
        // Step 3: Write index-based text at the top of each file
        for ( int i = 0; i < sortedFiles.size(); i++ ) {
            File file = sortedFiles.get( i );
            List < String > originalLines = new ArrayList <>();
            try ( BufferedReader reader = new BufferedReader( new FileReader( file ) ) ) {
                String line;
                while ( ( line = reader.readLine() ) != null ) {
                    originalLines.add( line );
                }
            }
            // Add header
            //////String header = "// File index: " + i;
            String header =
                    "import com.mekkiseghier.ParallelStreams.consumers.Consumer" + i + ";\n" + "import com.mekkiseghier.ParallelStreams.functions.Function" + i + ";\n" +
                    "import com.mekkiseghier.ParallelStreams.predicates.Predicate" + i + ";\n" + "import com.mekkiseghier.ParallelStreams.reducers.Reducer" + i + ";";
            try ( PrintWriter writer = new PrintWriter( new FileWriter( file ) ) ) {
                writer.println( header );
                for ( String line : originalLines ) {
                    writer.println( line );
                }
            }
        } return sortedFiles;
    }

    // Example usage
    public static void main( String[] args ) throws IOException {
        String path = "C:\\Users\\Mekki\\IdeaProjects\\zipper\\table\\src\\main\\java";        // your folder
        String prefix = "ParallelStream";       // your prefix
        List < File > processed = findAndProcessFiles( path, prefix );
        for ( File file : processed ) {
            System.out.println( "Updated: " + file.getName() );
        }
    }
}
