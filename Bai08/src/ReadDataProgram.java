import java.io.DataInputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class ReadDataProgram {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 1. Nhập tên tệp từ bàn phím
        System.out.print("Nhap ten tep can doc (vd: numbers.bin): ");
        String filename = sc.nextLine();

        // 2. Khởi tạo DataInputStream trong try-with-resources
        try (DataInputStream dis = new DataInputStream(new FileInputStream(filename))) {

            System.out.println(">> Cac so doc duoc tu tep " + filename + ":");

            // 3. Dùng vòng lặp vô hạn, vòng lặp sẽ tự phá vỡ khi gặp EOFException
            while (true) {
                int num = dis.readInt();
                System.out.print(num + "  ");
            }

        } catch (EOFException e) {
            // 4. Xử lý khi hết dữ liệu (ĐÂY KHÔNG PHẢI LÀ LỖI HỆ THỐNG)
            // Khi nhảy vào khối catch này tức là đã đọc xong toàn bộ file
            System.out.println("\n\n(Da doc den cuoi tep - Hoan thanh!)");

        } catch (IOException e) {
            // 5. Xử lý các lỗi I/O thực sự (vd: không tìm thấy file, file bị hỏng)
            System.out.println("\nLoi I/O: Khong the doc tep hoac tep khong ton tai.");
            e.printStackTrace();

        } finally {
            sc.close();
        }
    }
}