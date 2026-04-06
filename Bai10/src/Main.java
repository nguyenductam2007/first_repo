import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

// Ngoại lệ tự định nghĩa
class InvalidConfigException extends Exception {
    public InvalidConfigException(String message) {
        super(message);
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập đường dẫn file config: ");
        String filePath = scanner.nextLine();

        BufferedReader reader = null;
        try {
            // Mở file bằng FileReader + BufferedReader
            reader = new BufferedReader(new FileReader(filePath));
            Map<String, String> configMap = new HashMap<>();
            String line;

            // Đọc file theo từng dòng
            while ((line = reader.readLine()) != null) {
                line = line.trim();
                // Bỏ qua các dòng trống
                if (line.isEmpty()) continue;

                // Tách key và value theo dấu '=' đầu tiên
                String[] parts = line.split("=", 2);
                if (parts.length == 2) {
                    String key = parts[0].trim();
                    String value = parts[1].trim();
                    configMap.put(key, value);
                }
            }

            // Kiểm tra tham số bắt buộc
            if (!configMap.containsKey("username")) {
                throw new InvalidConfigException("Missing required parameter 'username'");
            }
            if (!configMap.containsKey("timeout")) {
                throw new InvalidConfigException("Missing required parameter 'timeout'");
            }

            // Kiểm tra tính hợp lệ của timeout
            int timeout = Integer.parseInt(configMap.get("timeout")); // Có thể ném ra NumberFormatException
            if (timeout <= 0) {
                throw new InvalidConfigException("timeout must be > 0");
            }

            // Kiểm tra tính hợp lệ của maxConnections (nếu có)
            if (configMap.containsKey("maxConnections")) {
                int maxConnections = Integer.parseInt(configMap.get("maxConnections")); // Có thể ném ra NumberFormatException
                if (maxConnections < 1) {
                    throw new InvalidConfigException("maxConnections must be >= 1");
                }
            }

            // In toàn bộ cấu hình nếu tất cả đều hợp lệ
            System.out.println("\n--- Cấu hình đã đọc ---");
            for (Map.Entry<String, String> entry : configMap.entrySet()) {
                System.out.println(entry.getKey() + " = " + entry.getValue());
            }
            System.out.println("Config loaded successfully.");

        } catch (FileNotFoundException e) {
            System.out.println("Config file not found.");
        } catch (IOException e) {
            System.out.println("I/O error.");
            e.printStackTrace();
        } catch (NumberFormatException e) {
            System.out.println("Invalid number format.");
        } catch (InvalidConfigException e) {
            System.out.println("Invalid config: " + e.getMessage());
        } finally {
            // Đảm bảo đóng file trong finally
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    System.out.println("Error while closing the file.");
                }
            }
            scanner.close();
            // Dù lỗi hay không cũng luôn in câu này
            System.out.println("Program finished.");
        }
    }
}