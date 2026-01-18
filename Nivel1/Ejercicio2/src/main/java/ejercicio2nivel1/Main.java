package ejercicio2nivel1;

public class Main {
    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("Usage: java Main <directory_path>");
            return;
        }

        RecursiveSortedDirectory directoryLister =
                new RecursiveSortedDirectory(args[0]);

        directoryLister.listDirectoryTree();
    }
}
