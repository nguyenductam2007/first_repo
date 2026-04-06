
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        if (scanner.hasNextLine()) {
            String input = scanner.nextLine().trim();
            String[] parts = input.split("\\s+");

            if (parts.length == 2) {
                String roomType = parts[0].toUpperCase();
                int nights = Integer.parseInt(parts[1]);

                Room room = null;

                if (roomType.equals("S")) {
                    room = new Standard(nights);
                } else if (roomType.equals("V")) {
                    room = new Vip(nights);
                }


                if (room != null) {

                    System.out.println((long) room.calculateTotal());
                } else {
                    System.out.println("Loại phòng không hợp lệ!");
                }
            }
        }
        scanner.close();
    }
}