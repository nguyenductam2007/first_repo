import java.util.ArrayList;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    ArrayList<Employee> employeeList = new ArrayList<>();

    if (scanner.hasNextInt()) {
      int n = Integer.parseInt(scanner.nextLine().trim());
      for (int i = 0; i < n; i++) {
        String[] parts = scanner.nextLine().trim().split("\\s+");
        String type = parts[0];
        String name = parts[1];
        double baseSalary = Double.parseDouble(parts[2]);

        if (type.equals("E")) {
          employeeList.add(new Employee(name, baseSalary));
        } else if (type.equals("D")) {
          int overtimeHours = Integer.parseInt(parts[3]);
          employeeList.add(new Developer(name, baseSalary, overtimeHours));
        } else if (type.equals("T")) {
          int bugsFound = Integer.parseInt(parts[3]);
          employeeList.add(new Tester(name, baseSalary, bugsFound));
        }
      }
    }

    for (int i = 0; i < employeeList.size(); i++) {
      Employee emp = employeeList.get(i);

      System.out.println(emp.getName() + " - Bonus: " + emp.calculateBonus());
      if (emp instanceof Developer) {
        System.out.println("Tặng khóa học AWS");
      } else if (emp instanceof Tester) {
        System.out.println("Tặng tool Test");
      }

      if (i < employeeList.size() - 1) {
        System.out.println();
      }
    }

    scanner.close();
  }
}