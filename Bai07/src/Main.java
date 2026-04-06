import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nhap duong dan tep nguon: ");
        String sourcePath = scanner.nextLine();

        System.out.print("Nhap duong dan tep dich: ");
        String destPath = scanner.nextLine();

        // Khai báo các luồng I/O bên ngoài try để có thể truy cập trong finally
        BufferedReader reader = null;
        PrintWriter writer = null;
        int lineCount = 0;

        try {

            reader = new BufferedReader(new FileReader(sourcePath));
            writer = new PrintWriter(new FileWriter(destPath));

            String line;
            while ((line = reader.readLine()) != null) {
                writer.println(line);
                lineCount++;
            }
            System.out.println("Sao chep thanh cong!");
            System.out.println("So dong da sao chep: " + lineCount);

        } catch (FileNotFoundException e) {

            File srcFile = new File(sourcePath);
            if (!srcFile.exists()) {
                System.out.println("Source file not found.");
            } else {
                System.out.println("Cannot create destination file.");
            }

        } catch (IOException e) {
            // 3. Xử lý các lỗi I/O khác (ví dụ: lỗi đọc/ghi đĩa)
            System.out.println("I/O error.");
            e.printStackTrace();

        } finally {

            try {
                if (reader != null) {
                    reader.close();
                }
            } catch (IOException e) {
                System.out.println("Loi khi dong tep nguon.");
                e.printStackTrace();
            }

            if (writer != null) {
                writer.close();
            }
            scanner.close();
        }
    }
}