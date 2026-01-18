package ejercicio2nivel1;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Date;

public class RecursiveSortedDirectory {
    private static final SimpleDateFormat DATE_FORMAT =
            new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    private static final int INDENT_SPACES = 4;

    private final File directory;

    public RecursiveSortedDirectory(String path) {
        this.directory = new File(path);
    }

    public void listDirectoryTree() {

        if (!directory.exists()) {
            System.out.println("Error: Directory not found");
            return;
        }

        if (!directory.isDirectory()) {
            System.out.println("Error: The path is not a directory");
            return;
        }

        listRecursively(directory, 0);
    }

    private void listRecursively(File directory, int level) {

        File[] files = directory.listFiles();

        if (files == null || files.length == 0) {
            return;
        }

        Arrays.sort(files,
                Comparator.comparing(File::getName, String.CASE_INSENSITIVE_ORDER));

        for (File file : files) {

            String type = file.isDirectory() ? "(D)" : "(F)";
            String lastModified = DATE_FORMAT.format(new Date(file.lastModified()));
            String indent = " ".repeat(level * INDENT_SPACES);

            System.out.println(indent + type + " " +
                    file.getName() + " - Last modification: " + lastModified);

            if (file.isDirectory()) {
                listRecursively(file, level + 1);
            }
        }
    }

}
