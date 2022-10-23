import java.util.*;

public class Employee extends Staff implements ICalculate {

    private Integer overTime;

    public Employee(final String employeeId, final String employeeName, final int employeeAge,
            final double coefficientSalary, String dateJoin, final int annualLeave, final String department,
            final int overTime) {

        super(employeeId, employeeName, employeeAge, coefficientSalary, dateJoin, annualLeave, department);
        this.overTime = overTime;
    }

    public int getOverTime() {
        return overTime;
    }

    public void setOverTime(int overTime) {
        this.overTime = overTime;
    }

    public double calculateSalary() {
        return (getCoefficientSalary() * 3000000) + (getOverTime() * 200000);
    }

    public static String getHeader() {
        return String.format("%-10s%-20s%-10s%-20s%-20s%-20s%-20s%-10s\n%s", "ID", "Tên", "Tuổi", "Hệ số lương",
                "Ngày bắt đầu", "Nghỉ phép", "Bộ phận", "Overtime",
                "-----------------------------------------------------------------------------------------------------------------------------------");

    }

    public String toString() {
        return String.format("%-10s%-20s%-10s%-20s%-20s%-20s%-20s%-10s", getId(), getName(), getAge(),
                getCoefficientSalary(), getDateJoin(), getAnnualLeave(), getDepartment(), getOverTime());

    }

    // Raw data
    private static List<Employee> employees = new ArrayList<>(
            Arrays.asList(new Employee("TE01", "Linh", 20, 1.0, "02/08/2020", 8, "Technical", 9),
                    new Employee("BE01", "Hung", 22, 1.0, "02/01/2021", 3, "Business", 0),
                    new Employee("PE01", "Khanh", 23, 1.1, "20/04/2020", 9, "Project", 0),
                    new Employee("TE02", "My", 25, 1.3, "16/05/2020", 6, "Technical", 5),
                    new Employee("PE02", "Thien", 24, 1.5, "10/03/2020", 9, "Project", 0),
                    new Employee("BE02", "Nam", 26, 1.0, "06/02/2021", 9, "Business", 0)));

    // Display employees
    public static void display() {
        System.out.println("Danh sách nhân viên:");
        System.out.println(getHeader());
        for (Employee e : employees) {
            System.out.println(e);
        }
    }

    // Display by department
    public static void displayByDepartment(String department) {
        final List<Employee> foundEmployees = new ArrayList<>();

        // Find department name
        for (Employee e : employees) {
            if (e.getDepartment().equalsIgnoreCase(department)) {
                foundEmployees.add(e);
            }
        }

        // print data
        if (!foundEmployees.isEmpty()) {
            System.out.println("Nhân viên " + department);
            System.out.println(getHeader());
            for (Employee e : foundEmployees) {
                System.out.println(e);
            }
        }
    }

    public static void search(final String searchKey) {

        // List found employees

        final List<Employee> foundEmployees = new ArrayList<>();

        for (final Employee e : employees) {
            if (e.getId().contains(searchKey) || e.getName().contains(searchKey)) {

                // Add to list found
                foundEmployees.add(e);
            }
        }

        if (!foundEmployees.isEmpty()) {
            System.out.println("Nhân viên:");
            System.out.println();
            System.out.println(getHeader());
            for (final Employee e : foundEmployees) {
                System.out.println(e);
            }
        } else {
            System.out.println("Không tìm thấy nhân viên.");
        }
    }

    // Add employee
    public static void add(Employee e) {
        employees.add(e);
    }

    // Get all employees
    static List<Employee> getAll() {
        return employees;
    }

}