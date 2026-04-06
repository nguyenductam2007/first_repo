import java.util.List;
import java.util.ArrayList;

public class ArrayListLibrary {
    private List<Book> bookList = new ArrayList<>();

    public void add(Book book){
        bookList.add(book);
    }

    public Book search(String id){
        for (Book tacpham : bookList){
            if (tacpham.getId().equals(id)){
                return tacpham;
            }
        }
        return null;
    }

    public void delete(String id){
        bookList.removeIf(tacpham -> tacpham.getId().equals(id));
    }

    public void print(){
        System.out.println("Danh sach cac tac pham hien co trong thu vien:");
        for (Book tacpham : bookList){
            System.out.println(tacpham.toString());
        }
    }
}