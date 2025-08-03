package com.github.mekkiseghier.streamx.generators;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Generates thread-safe EntriesList classes (ConcurrentEntriesList1, ConcurrentEntriesList2, ...) using generic types T1, T2, ..., TN.
 */
public class ConcurrentListNGenerator {

    public static void main(String[] args) {
        int n = 30; // You can increase this number to generate more classes

            try {
                generate(n);
            } catch (IOException e) {
                System.err.println("Error generating class for " + n + " fields: " + e.getMessage());
                e.printStackTrace();
            }

    }

    static void generate(int n) throws IOException {
        String packageName = "com.mekkiseghier.entriesList.lists";
        String className = "ConcurrentEntriesList" + n;

        StringBuilder sb = new StringBuilder();
        sb.append("package ").append(packageName).append(";\n\n");
        sb.append("import java.util.*;\nimport java.util.function.*;\nimport java.util.stream.*;\n\n");

        sb.append("/**\n * Thread-safe list of entries with ").append(n).append(" fields.\n */\n");
        sb.append("public class ").append(className).append("<");
        for (int i = 1; i <= n; i++) sb.append("T").append(i).append(i < n ? ", " : ">\n");

        sb.append(" {\n");
        sb.append("    private final List<Entry<");
        for (int i = 1; i <= n; i++) sb.append("T").append(i).append(i < n ? ", " : ">> list = Collections.synchronizedList(new ArrayList<>());\n");

        sb.append("    private final List<Consumer<List<Entry<");
        for (int i = 1; i <= n; i++) sb.append("T").append(i).append(i < n ? ", " : ">>>> changeListeners = Collections.synchronizedList(new ArrayList<>());\n\n");

        // Default constructor
        sb.append("    /** Default constructor. */\n    public ").append(className).append("() {}\n\n");

        // Constructor from varargs Entry<...>
        sb.append("    /** Constructor from variable number of entries. */\n");
        sb.append("    @SafeVarargs\n");
        sb.append("    public  ").append(className).append("(Entry<");
        for (int i = 1; i <= n; i++) sb.append("T").append(i).append(i < n ? ", " : ">... entries) {\n");
        sb.append("        Collections.addAll(list, entries);\n");
        sb.append("        reindex();\n        notifyChangeListeners();\n    }\n\n");

        // Constructor from multiple column lists
        sb.append("    /** Constructor from ").append(n).append(" lists (columns). */\n");
        sb.append("    public ").append(className).append("(");
        for (int i = 1; i <= n; i++) {
            sb.append("List<T").append(i).append("> col").append(i);
            if (i < n) sb.append(", ");
        }
        sb.append(") {\n");
        sb.append("        int size = Collections.min(Arrays.asList(");
        for (int i = 1; i <= n; i++) {
            sb.append("col").append(i).append(".size()");
            if (i < n) sb.append(", ");
        }
        sb.append("));\n");
        sb.append("        for (int i = 0; i < size; i++) {\n");
        sb.append("            list.add(new Entry<>(");
        for (int i = 1; i <= n; i++) {
            sb.append("col").append(i).append(".get(i)");
            if (i < n) sb.append(", ");
        }
        sb.append("));\n        }\n        reindex();\n        notifyChangeListeners();\n    }\n\n");

        sb.append("    /** Entry class representing a single row. */\n    public static class Entry<");
        for (int i = 1; i <= n; i++) sb.append("T").append(i).append(i < n ? ", " : "> {\n");
        for (int i = 1; i <= n; i++) sb.append("        private T").append(i).append(" f_").append(i).append(";\n");
        sb.append("        private int index;\n\n");

        sb.append("        public Entry(");
        for (int i = 1; i <= n; i++) sb.append("T").append(i).append(" f_").append(i).append(i < n ? ", " : ") {\n");
        for (int i = 1; i <= n; i++) sb.append("            this.f_").append(i).append(" = f_").append(i).append(";\n");
        sb.append("        }\n\n");

        for (int i = 1; i <= n; i++) {
            sb.append("        public synchronized T").append(i).append(" get_").append(i).append("() { return f_").append(i).append("; }\n");
            sb.append("        public synchronized void set_").append(i).append("(T").append(i).append(" v) { this.f_").append(i).append(" = v; }\n\n");
        }

        sb.append("        public synchronized int getIndex() { return index; }\n");
        sb.append("        public synchronized void setIndex(int index) { this.index = index; }\n\n");

        sb.append("        @Override public synchronized String toString() {\n");
        sb.append("            return \"( \" + ");
        for (int i = 1; i <= n; i++) {
            sb.append("f_").append(i);
            if (i < n) sb.append(" + \", \" + ");
        }
        sb.append(" + \" ) index: \" + index;\n        }\n    }\n\n");

        // Add, get, set, remove, insert, swap, sortBy, clear, size, stream, asList
        sb.append("    /** Add an entry to the list. */\n");
        sb.append("    public synchronized void add(");
        for (int i = 1; i <= n; i++) sb.append("T").append(i).append(" t").append(i).append(i < n ? ", " : ") {\n");
        sb.append("        list.add(new Entry<>(");
        for (int i = 1; i <= n; i++) sb.append("t").append(i).append(i < n ? ", " : "));\n");
        sb.append("        reindex();\n        notifyChangeListeners();\n    }\n\n");

        sb.append("    /** Get entry at index i. */\n");
        sb.append("    public synchronized Entry<");
        for (int i = 1; i <= n; i++) sb.append("T").append(i).append(i < n ? ", " : "> get(int i) { return list.get(i); }\n\n");

        sb.append("    /** Remove entry at index i. */\n");
        sb.append("    public synchronized void remove(int i) { list.remove(i); reindex(); notifyChangeListeners(); }\n\n");

        sb.append("    /** Insert entry at index i. */\n");
        sb.append("    public synchronized void insert(int i, ");
        for (int i = 1; i <= n; i++) sb.append("T").append(i).append(" t").append(i).append(i < n ? ", " : ") {\n");
        sb.append("        list.add(i, new Entry<>(");
        for (int i = 1; i <= n; i++) sb.append("t").append(i).append(i < n ? ", " : "));\n");
        sb.append("        reindex();\n        notifyChangeListeners();\n    }\n\n");

        sb.append("    /** Swap two entries by index. */\n");
        sb.append("    public synchronized void swap(int i, int j) { Collections.swap(list, i, j); reindex(); notifyChangeListeners(); }\n\n");

        sb.append("    /** Sort entries by comparator. */\n");
        sb.append("    public synchronized void sortBy(Comparator<Entry<");
        for (int i = 1; i <= n; i++) sb.append("T").append(i).append(i < n ? ", " : ">> c) {\n");
        sb.append("        list.sort(c); reindex(); notifyChangeListeners();\n    }\n\n");

        sb.append("    /** Clear all entries. */\n");
        sb.append("    public synchronized void clear() { list.clear(); notifyChangeListeners(); }\n\n");

        sb.append("    /** Get the number of entries. */\n");
        sb.append("    public synchronized int size() { return list.size(); }\n\n");

        sb.append("    /** Return unmodifiable view of the entry list. */\n");
        sb.append("    public synchronized List<Entry<");
        for (int i = 1; i <= n; i++) sb.append("T").append(i).append(i < n ? ", " : ">> asList() { return Collections.unmodifiableList(new ArrayList<>(list)); }\n\n");

        sb.append("    /** Return a stream of entries. */\n");
        sb.append("    public synchronized Stream<Entry<");
        for (int i = 1; i <= n; i++) sb.append("T").append(i).append(i < n ? ", " : ">> stream() { return new ArrayList<>(list).stream(); }\n\n");

        sb.append("    /** Register a change listener. */\n");
        sb.append("    public void addChangeListener(Consumer<List<Entry<");
        for (int i = 1; i <= n; i++) sb.append("T").append(i).append(i < n ? ", " : ">>> l) { changeListeners.add(l); }\n\n");

        sb.append("    /** Notify all registered change listeners. */\n");
        sb.append("    private void notifyChangeListeners() {\n");
        sb.append("        List<Entry<");
        for (int i = 1; i <= n; i++) sb.append("T").append(i).append(i < n ? ", " : ">> snapshot;\n");
        sb.append("        synchronized (this) { snapshot = new ArrayList<>(list); }\n");
        sb.append("        for (Consumer<List<Entry<");
        for (int i = 1; i <= n; i++) sb.append("T").append(i).append(i < n ? ", " : ">>> listener : changeListeners) {\n");
        sb.append("            listener.accept(Collections.unmodifiableList(snapshot));\n        }\n    }\n\n");

        sb.append("    /** Update the index of all entries. */\n    private void reindex() { for (int i = 0; i < list.size(); i++) list.get(i).setIndex(i); }\n\n");
        sb.append("}\n");

        File dir = new File("src/com/mekkiseghier/entriesList/lists");
        dir.mkdirs();
        try (FileWriter writer = new FileWriter(new File(dir, className + ".java"))) {
            writer.write(sb.toString());
        }
    }
}
