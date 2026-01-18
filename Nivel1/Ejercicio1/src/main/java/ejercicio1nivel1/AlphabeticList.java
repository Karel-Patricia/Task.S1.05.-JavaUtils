package ejercicio1nivel1;

import java.io.File;
import java.util.Arrays;

public class AlphabeticList {

    public static void listAlphabetically(String path) {

        File file = new File(path);

        if (file.exists()) {
            String[] items = file.list();
            if (items != null && items.length > 0) {
                Arrays.sort(items);
                for (String item : items) {
                    System.out.println(item);
                }
            }
        } else {
            System.out.println("File not found");
        }

    }
}
