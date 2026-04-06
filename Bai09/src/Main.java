import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<IPayable> payableList = new ArrayList<>();

        if (scanner.hasNextInt()) {
            int n = Integer.parseInt(scanner.nextLine().trim());

            for (int i = 0; i < n; i++) {
                String line = scanner.nextLine().trim();
                String[] parts = line.split("\\s+");
                String type = parts[0];

                if (type.equals("S")) {
                    String id = parts[1];
                    String name = parts[2];
                    int hours = Integer.parseInt(parts[3]);
                    double rate = Double.parseDouble(parts[4]);

                    payableList.add(new PartTimeStaff(id, name, hours, rate));

                } else if (type.equals("I")) {
                    String itemName = parts[1];
                    int quantity = Integer.parseInt(parts[2]);
                    double price = Double.parseDouble(parts[3]);

                    payableList.add(new Invoice(itemName, quantity, price));
                }
            }
        }

        double totalPayment = 0.0;


        for (IPayable item : payableList) {
            double payment = item.getPaymentAmount();
            totalPayment += payment; // Cộng dồn vào tổng tiền

            if (item instanceof PartTimeStaff) {
                PartTimeStaff staff = (PartTimeStaff) item;
                System.out.println("PartTimeStaff " + staff.getName() + " - Payment: " + payment);
            }
            else if (item instanceof Invoice) {
                Invoice invoice = (Invoice) item;
                System.out.println("Invoice " + invoice.getItemName() + " - Payment: " + payment);
            }
        }

        System.out.println("Total Payment = " + totalPayment);

        scanner.close();
    }
}