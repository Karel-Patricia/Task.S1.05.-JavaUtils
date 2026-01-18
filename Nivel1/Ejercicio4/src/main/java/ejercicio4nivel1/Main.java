package ejercicio4nivel1;

public class Main {
    public static void main(String[] args) {

        if (args.length < 1) {
            System.out.println("Usage: java ejercicio4nivel1.Main <file_to_read>");
            return;
        }

        FileReaderUtil.printFileContent(args[0]);
    }
}
