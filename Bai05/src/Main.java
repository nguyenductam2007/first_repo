public class Main {
    public static void main(String[] args) {

        Book b1 = new Book("B005", "Lap trinh Java", "Tac gia A", 2020);
        Book b2 = new Book("B001", "Cau truc du lieu", "Tac gia B", 2018);
        Book b3 = new Book("B003", "Thiet ke Web", "Tac gia C", 2022);
        Book b4 = new Book("B002", "Co so du lieu", "Tac gia D", 2021);
        Book b5 = new Book("B004", "Tri tue nhan tao", "Tac gia E", 2023);

        String searchId = "B003";
        String deleteId = "B001";


        System.out.println("======= TEST VỚI ARRAYLIST =======");
        ArrayListLibrary listLib = new ArrayListLibrary();
        runTest(listLib, b1, b2, b3, b4, b5, searchId, deleteId);

        System.out.println("\n======= TEST VỚI HASHMAP =======");
        HashMapLibrary hashLib = new HashMapLibrary();
        runTestHash(hashLib, b1, b2, b3, b4, b5, searchId, deleteId);


        System.out.println("\n======= TEST VỚI TREEMAP =======");
        TreeMapLibrary treeLib = new TreeMapLibrary();
        runTestTree(treeLib, b1, b2, b3, b4, b5, searchId, deleteId);
    }


    public static void runTest(ArrayListLibrary lib, Book b1, Book b2, Book b3, Book b4, Book b5, String sId, String dId) {
        lib.add(b1); lib.add(b2); lib.add(b3); lib.add(b4); lib.add(b5);
        System.out.println("Danh sách ban đầu (Theo thứ tự thêm vào):");
        lib.print();

        System.out.println("Tìm kiếm sách " + sId + ": " + lib.search(sId));

        System.out.println("Xóa sách " + dId + "...");
        lib.delete(dId);

        System.out.println("Danh sách sau khi xóa:");
        lib.print();
    }


    public static void runTestHash(HashMapLibrary lib, Book b1, Book b2, Book b3, Book b4, Book b5, String sId, String dId) {
        lib.addBook(b1); lib.addBook(b2); lib.addBook(b3); lib.addBook(b4); lib.addBook(b5);
        System.out.println("Danh sách ban đầu (Thứ tự ngẫu nhiên):");
        lib.printAllBooks();

        System.out.println("Tìm kiếm sách " + sId + ": " + lib.findBookById(sId));
        lib.deleteBookById(dId);
        System.out.println("Danh sách sau khi xóa " + dId + ":");
        lib.printAllBooks();
    }

    // Hàm bổ trợ cho TreeMap
    public static void runTestTree(TreeMapLibrary lib, Book b1, Book b2, Book b3, Book b4, Book b5, String sId, String dId) {
        lib.addBook(b1); lib.addBook(b2); lib.addBook(b3); lib.addBook(b4); lib.addBook(b5);
        System.out.println("Danh sách ban đầu (Tự động sắp xếp theo ID):");
        lib.printAllBooks();

        System.out.println("Tìm kiếm sách " + sId + ": " + lib.findBookById(sId));
        lib.deleteBookById(dId);
        System.out.println("Danh sách sau khi xóa " + dId + ":");
        lib.printAllBooks();
    }
}