// File: Main.java
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextLine()) return;

        int n = Integer.parseInt(scanner.nextLine().trim());

        List<Product> order = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String line = scanner.nextLine().trim();

            String[] parts = line.split("\"");
            String typeCode = parts[0].trim();
            String name = parts[1];
            String[] details = parts[2].trim().split("\\s+");

            if (typeCode.equals("E")) {
                double basePrice = Double.parseDouble(details[0]);
                double warrantyFee = Double.parseDouble(details[1]);
                order.add(new Electronics(name, basePrice, warrantyFee));

            } else if (typeCode.equals("F")) {
                double basePrice = Double.parseDouble(details[0]);
                LocalDate expDate = LocalDate.parse(details[1]);
                order.add(new Food(name, basePrice, expDate));
            }
        }

        // Tính tổng tiền in ra Output
        double totalAmount = 0;
        for (Product p : order) {
            double finalPrice = p.getFinalPrice();
            totalAmount += finalPrice;
            System.out.println(p.getName() + " - " + p.getType() + " - " + finalPrice);
        }

        System.out.println("Total = " + totalAmount);

        scanner.close();
    }
}