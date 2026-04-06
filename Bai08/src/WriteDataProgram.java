import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class WriteDataProgram {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);


        System.out.print("Nhap ten tep de ghi du lieu (vd: numbers.bin): ");
        String filename = sc.nextLine();

        System.out.print("Ban muon nhap bao nhieu so nguyen? n = ");
        int n = sc.nextInt();

        try (DataOutputStream dos = new DataOutputStream(new FileOutputStream(filename))) {

            for (int i = 0; i < n; i++) {
                System.out.print("Nhap so thu " + (i + 1) + ": ");
                int num = sc.nextInt();
                dos.writeInt(num); // Ghi dưới dạng nhị phân 4 bytes
            }

            System.out.println(">> Da ghi thanh cong " + n + " so vao tep: " + filename);

        } catch (IOException e) {
            System.out.println("Loi I/O: Khong the ghi tep.");
            e.printStackTrace();
        } finally {
            sc.close();
        }
    }
}