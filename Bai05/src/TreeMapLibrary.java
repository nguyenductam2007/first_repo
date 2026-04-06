import java.util.TreeMap;
import java.util.Map;

public class TreeMapLibrary {
    // Key là String (id), Value là Book
    private Map<String, Book> books = new TreeMap<>();

    public void addBook(Book book) {
        books.put(book.getId(), book);
    }

    public Book findBookById(String id) {
        return books.get(id);
    }

    public boolean deleteBookById(String id) {
        return books.remove(id) != null;
    }

    // In danh sách (sẽ tự động in ra theo thứ tự bảng chữ cái của ID)
    public void printAllBooks() {
        for (Book book : books.values()) {
            System.out.println(book);
        }
    }
}