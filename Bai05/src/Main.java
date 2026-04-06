
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        if (!scanner.hasNextLine()) return;
        int n = Integer.parseInt(scanner.nextLine().trim());

        Employee[] employees = new Employee[n];

        for (int i = 0; i < n; i++) {
            String line = scanner.nextLine().trim();


            String[] parts = line.split("\"");
            String typeStr = parts[0].trim();
            String name = parts[1];
            String[] numbers = parts[2].trim().split("\\s+");

            if (typeStr.equals("F")) {
                double baseSalary = Double.parseDouble(numbers[0]);
                double bonus = Double.parseDouble(numbers[1]);
                double penalty = Double.parseDouble(numbers[2]);

                employees[i] = new FullTimeEmployee(name, baseSalary, bonus, penalty);

            } else if (typeStr.equals("P")) {
                double workingHours = Double.parseDouble(numbers[0]);
                double hourlyRate = Double.parseDouble(numbers[1]);

                employees[i] = new PartTimeEmployee(name, workingHours, hourlyRate);
            }
        }


        for (Employee emp : employees) {
            System.out.println(emp.getName() + " - " + emp.getEmployeeType() + " - " + emp.calculateSalary());
        }

        scanner.close();
    }
}
