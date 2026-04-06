import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Student> students = new ArrayList<>();
        String fileName = "students.dat";

        System.out.println("--- NHẬP DANH SÁCH SINH VIÊN ---");
        System.out.println("(Nhập 'END' ở phần ID để kết thúc việc nhập)");

        while (true) {
            System.out.print("Nhập ID: ");
            String id = scanner.nextLine();

            // Điều kiện dừng
            if (id.equalsIgnoreCase("END")) {
                break;
            }

            System.out.print("Nhập Tên: ");
            String name = scanner.nextLine();

            System.out.print("Nhập GPA: ");
            double gpa = 0;
            try {
                gpa = Double.parseDouble(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Lỗi: GPA phải là một số. Đã gán GPA = 0.0");
            }

            // Tạo đối tượng Student và thêm vào danh sách
            students.add(new Student(id, name, gpa));
            System.out.println("-----------------");
        }

        //Ghi danh sách ra tệp bằng ObjectOutputStream
        System.out.println("\n--- ĐANG GHI RA TỆP ---");
        try (FileOutputStream fos = new FileOutputStream(fileName);
             ObjectOutputStream oos = new ObjectOutputStream(fos)) {

            for (Student student : students) {
                oos.writeObject(student); // Ghi từng đối tượng vào tệp
            }
            System.out.println("Đã ghi dữ liệu thành công vào tệp " + fileName);

        } catch (FileNotFoundException e) {
            System.err.println("Lỗi: Không tìm thấy tệp để ghi - " + e.getMessage());
        } catch (IOException e) {
            System.err.println("Lỗi I/O khi ghi tệp - " + e.getMessage());
        }

        //Đọc lại từ tệp bằng ObjectInputStream và in ra
        System.out.println("\n--- ĐỌC TỪ TỆP VÀ HIỂN THỊ ---");
        try (FileInputStream fis = new FileInputStream(fileName);
             ObjectInputStream ois = new ObjectInputStream(fis)) {

            int count = 1;
            while (true) {
                // Đọc từng đối tượng. Khi hết file sẽ ném ra EOFException
                Student student = (Student) ois.readObject();
                System.out.println(count++ + ". " + student);
            }

        } catch (EOFException e) {
            // Đây là điều kiện thoát vòng lặp bình thường khi đọc hết file
            System.out.println("-> Đã đọc đến cuối tệp (Đã bắt EOFException thành công).");
        } catch (FileNotFoundException e) {
            System.err.println("Lỗi: Không tìm thấy tệp để đọc - " + e.getMessage());
        } catch (ClassNotFoundException e) {
            System.err.println("Lỗi: Không tìm thấy class Student (Sai phiên bản hoặc class bị xóa) - " + e.getMessage());
        } catch (IOException e) {
            System.err.println("Lỗi I/O khi đọc tệp - " + e.getMessage());
        }
    }
}
