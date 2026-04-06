import java.util.HashMap;
import java.util.Map;

public class HashMapLibrary {
    // Key là String (id), Value là Book
    private Map<String, Book> books = new HashMap<>();

    public void addBook(Book book) {
        books.put(book.getId(), book);
    }

    public Book findBookById(String id) {
        return books.get(id);
    }

    public boolean deleteBookById(String id) {
        return books.remove(id) != null;
    }

    public void printAllBooks() {
        for (Book book : books.values()) {
            System.out.println(book);
        }
    }
}