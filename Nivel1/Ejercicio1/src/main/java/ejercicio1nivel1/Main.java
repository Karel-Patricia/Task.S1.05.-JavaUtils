package ejercicio1nivel1;

public class Main {
    public static void main(String[] args) {

        if(args.length == 0) {
            System.out.println("Usage: java Main <directory_path>");
            return;
        }

        AlphabeticList.listAlphabetically(args[0]);

    }



}
