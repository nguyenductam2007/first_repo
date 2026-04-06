
public abstract class Employee {
    protected String employeeId;
    protected String name;
    protected String dob;

    public Employee(String name) {
        this.name = name;
        this.employeeId = "Unknown";
        this.dob = "Unknown";
    }

    public String getName() {
        return name;
    }


    public abstract double calculateSalary();
    public abstract String getEmployeeType();
}