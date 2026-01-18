package ejercicio5nivel1;

public class Main {
    public static void main(String[] args) {
        String filename = "book.ser";

        Book book = new Book("Effective Java", "Joshua Bloch");

        BookSerializer.serializeBook(book, filename);

        Book deserializedBook = BookSerializer.deserializeBook(filename);

        if (deserializedBook != null) {
            System.out.println("Deserialized Book: " + deserializedBook);
        } else {
            System.out.println("Failed to deserialize book.");
        }
    }
    
}
