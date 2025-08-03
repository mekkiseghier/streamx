package com.github.mekkiseghier.streamx.generators;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Generates a single EntriesListN class for any given N using generic types T1, T2, ..., TN.
 */
public class ListNGenerator {

    public static void main(String[] args) throws IOException {
        int n = 30; // Change to generate any EntriesListN you want
        generate(n);
    }

    static void generate(int n) throws IOException {
        String packageName = "com.mekkiseghier.entriesList.lists";
        String className = "EntriesList" + n;

        StringBuilder sb = new StringBuilder();
        sb.append("package ").append(packageName).append(";\n\n");
        sb.append("import java.util.*;\nimport java.util.function.*;\nimport java.util.stream.*;\n\n");

        sb.append("/**\n * Non-thread-safe list of entries with ").append(n).append(" fields.\n */\n");
        sb.append("public class ").append(className).append("<");
        for (int i = 1; i <= n; i++) sb.append("T").append(i).append(i < n ? ", " : ">\n");

        sb.append(" {\n");
        sb.append("    private final List<Entry<");
        for (int i = 1; i <= n; i++) sb.append("T").append(i).append(i < n ? ", " : ">> list = new ArrayList<>();\n");

        sb.append("    private final List<Consumer<List<Entry<");
        for (int i = 1; i <= n; i++) sb.append("T").append(i).append(i < n ? ", " : ">>>> changeListeners = new ArrayList<>();\n\n");

        // Default constructor
        sb.append("    /**\n     * Creates an empty list.\n     */\n");
        sb.append("    public ").append(className).append("() {}\n\n");

        // Constructor from varargs of entries
        sb.append("    /**\n");
        sb.append("     * Creates a list initialized with a variable number of entries.\n");
        sb.append("     * @param entries entries to add\n");
        sb.append("     * @throws NullPointerException if entries is null or contains null elements\n");
        sb.append("     */\n");
        sb.append("    @SafeVarargs\n");
        sb.append("    public  ").append(className).append("(Entry<");
        for (int i = 1; i <= n; i++) sb.append("T").append(i).append(i < n ? ", " : ">... entries) {\n");
        sb.append("        if (entries == null) throw new NullPointerException(\"Entries cannot be null\");\n");
        sb.append("        for (Entry<");
        for (int i = 1; i <= n; i++) sb.append("T").append(i).append(i < n ? ", " : "> e : entries) {\n");
        sb.append("            if (e == null) throw new NullPointerException(\"Entry cannot be null\");\n");
        sb.append("            list.add(e);\n        }\n");
        sb.append("        reindex();\n        notifyChangeListeners();\n    }\n\n");

        // Constructor from parallel column lists
        sb.append("    /**\n");
        sb.append("     * Creates a list from ").append(n).append(" parallel lists (columns).\n");
        sb.append("     * @throws IllegalArgumentException if list sizes differ\n");
        sb.append("     */\n");
        sb.append("    public ").append(className).append("(");
        for (int i = 1; i <= n; i++) {
            sb.append("List<T").append(i).append("> col").append(i);
            if (i < n) sb.append(", ");
        }
        sb.append(") {\n");
        sb.append("        int size = col1.size();\n");
        for (int i = 2; i <= n; i++) {
            sb.append("        if (col").append(i).append(".size() != size) throw new IllegalArgumentException(\"All column lists must be of the same size\");\n");
        }
        sb.append("        for (int i = 0; i < size; i++) {\n");
        sb.append("            list.add(new Entry<>(");
        for (int i = 1; i <= n; i++) sb.append("col").append(i).append(".get(i)").append(i < n ? ", " : "));\n");
        sb.append("        }\n        reindex();\n        notifyChangeListeners();\n    }\n\n");

        // Entry class
        sb.append("    /**\n     * Represents a single row with ").append(n).append(" fields.\n     */\n");
        sb.append("    public static class Entry<");
        for (int i = 1; i <= n; i++) sb.append("T").append(i).append(i < n ? ", " : "> {\n");
        for (int i = 1; i <= n; i++) sb.append("        private T").append(i).append(" f_").append(i).append(";\n");
        sb.append("        private int index;\n\n");

        sb.append("        public Entry(");
        for (int i = 1; i <= n; i++) sb.append("T").append(i).append(" f_").append(i).append(i < n ? ", " : ") {\n");
        for (int i = 1; i <= n; i++) sb.append("            this.f_").append(i).append(" = f_").append(i).append(";\n");
        sb.append("        }\n\n");

        for (int i = 1; i <= n; i++) {
            sb.append("        public T").append(i).append(" get_").append(i).append("() { return f_").append(i).append("; }\n");
            sb.append("        public void set_").append(i).append("(T").append(i).append(" v) { this.f_").append(i).append(" = v; }\n\n");
        }

        sb.append("        public int getIndex() { return index; }\n");
        sb.append("        public void setIndex(int index) { this.index = index; }\n\n");

        sb.append("        @Override public String toString() {\n");
        sb.append("            return \"( \" + ");
        for (int i = 1; i <= n; i++) {
            sb.append("f_").append(i);
            if (i < n) sb.append(" + \", \" + ");
        }
        sb.append(" + \" ) index: \" + index;\n        }\n    }\n\n");

        // Rest of logic
        sb.append("    public void add(");
        for (int i = 1; i <= n; i++) sb.append("T").append(i).append(" t").append(i).append(i < n ? ", " : ") {\n");
        sb.append("        list.add(new Entry<>(");
        for (int i = 1; i <= n; i++) sb.append("t").append(i).append(i < n ? ", " : "));\n");
        sb.append("        reindex();\n        notifyChangeListeners();\n    }\n\n");

        sb.append("    public Entry<");
        for (int i = 1; i <= n; i++) sb.append("T").append(i).append(i < n ? ", " : "> get(int i) { return list.get(i); }\n\n");

        sb.append("    public void remove(int i) { list.remove(i); reindex(); notifyChangeListeners(); }\n\n");

        sb.append("    public void insert(int i, ");
        for (int i = 1; i <= n; i++) sb.append("T").append(i).append(" t").append(i).append(i < n ? ", " : ") {\n");
        sb.append("        list.add(i, new Entry<>(");
        for (int i = 1; i <= n; i++) sb.append("t").append(i).append(i < n ? ", " : "));\n");
        sb.append("        reindex();\n        notifyChangeListeners();\n    }\n\n");

        sb.append("    public void swap(int i, int j) { Collections.swap(list, i, j); reindex(); notifyChangeListeners(); }\n\n");

        sb.append("    public void sortBy(Comparator<Entry<");
        for (int i = 1; i <= n; i++) sb.append("T").append(i).append(i < n ? ", " : ">> c) {\n");
        sb.append("        list.sort(c); reindex(); notifyChangeListeners();\n    }\n\n");

        sb.append("    public void clear() { list.clear(); notifyChangeListeners(); }\n\n");

        sb.append("    public int size() { return list.size(); }\n\n");

        sb.append("    public List<Entry<");
        for (int i = 1; i <= n; i++) sb.append("T").append(i).append(i < n ? ", " : ">> asList() { return Collections.unmodifiableList(new ArrayList<>(list)); }\n\n");

        sb.append("    public Stream<Entry<");
        for (int i = 1; i <= n; i++) sb.append("T").append(i).append(i < n ? ", " : ">> stream() { return new ArrayList<>(list).stream(); }\n\n");

        sb.append("    public void addChangeListener(Consumer<List<Entry<");
        for (int i = 1; i <= n; i++) sb.append("T").append(i).append(i < n ? ", " : ">>> l) { changeListeners.add(l); }\n\n");

        sb.append("    private void notifyChangeListeners() {\n");
        sb.append("        List<Entry<");
        for (int i = 1; i <= n; i++) sb.append("T").append(i).append(i < n ? ", " : ">> snapshot = new ArrayList<>(list);\n");
        sb.append("        for (Consumer<List<Entry<");
        for (int i = 1; i <= n; i++) sb.append("T").append(i).append(i < n ? ", " : ">>> listener : changeListeners) {\n");
        sb.append("            listener.accept(Collections.unmodifiableList(snapshot));\n        }\n    }\n\n");

        sb.append("    private void reindex() {\n");
        sb.append("        for (int i = 0; i < list.size(); i++) list.get(i).setIndex(i);\n    }\n");

        sb.append("}\n");

        File dir = new File("src/com/mekkiseghier/entriesList/lists");
        dir.mkdirs();
        try (FileWriter writer = new FileWriter(new File(dir, className + ".java"))) {
            writer.write(sb.toString());
        }
    }

}
