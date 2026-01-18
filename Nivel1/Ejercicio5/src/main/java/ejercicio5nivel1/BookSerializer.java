package ejercicio5nivel1;

import java.io.*;

public class BookSerializer {

    public static void serializeBook(Book book, String filename) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            oos.writeObject(book);
            System.out.println("Book serialized successfully to " + filename);
        } catch (IOException e) {
            System.err.println("Error serializing book: " + e.getMessage());
        }
    }

    public static Book deserializeBook(String filename) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
            return (Book) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Error deserializing book: " + e.getMessage());
            return null;
        }
    }
}
