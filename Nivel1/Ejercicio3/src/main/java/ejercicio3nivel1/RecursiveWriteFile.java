package ejercicio3nivel1;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Date;

public class RecursiveWriteFile {
    private static final SimpleDateFormat DATE_FORMAT =
            new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    private static final int INDENT_SPACES = 4;

    private final File directory;
    private final File outputFile;

    public RecursiveWriteFile(String path, String outputFilePath) {
        this.directory = new File(path);
        this.outputFile = new File(outputFilePath);
    }

    public void writeDirectoryTreeToFile() {

        if (!directory.exists()) {
            System.out.println("Error: Directory not found");
            return;
        }

        if (!directory.isDirectory()) {
            System.out.println("Error: The path is not a directory");
            return;
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))) {
            writeRecursively(directory, 0, writer);
            System.out.println("Directory tree saved to: " + outputFile.getName());
        } catch (IOException e) {
            System.out.println("Error writing file: " + e.getMessage());
        }
    }

    private void writeRecursively(File directory, int level, BufferedWriter writer)
            throws IOException {

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

            writer.write(indent + type + " " +
                    file.getName() + " - Last modification: " + lastModified);
            writer.newLine();

            if (file.isDirectory()) {
                writeRecursively(file, level + 1, writer);
            }
        }
    }
}
