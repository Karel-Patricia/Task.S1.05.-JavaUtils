package ejercicio3nivel1;

public class Main {
    public static void main(String[] args) {

        if (args.length < 2) {
            System.out.println("Usage: java Main <directory_path> <output_file>");
            return;
        }

        RecursiveWriteFile directoryWriter =
                new RecursiveWriteFile(args[0], args[1]);

        directoryWriter.writeDirectoryTreeToFile();
    }
}
