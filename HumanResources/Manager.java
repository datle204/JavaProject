import java.util.*;

public class Manager extends Staff implements ICalculate {

    private String title;

    public Manager(String employeeId, String employeeName, int employeeAge, double coefficientSalary, String dateJoin,
            int annualLeave, String department, String title) {
        super(employeeId, employeeName, employeeAge, coefficientSalary, dateJoin, annualLeave, department);
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double calculateSalary() {
        if (getTitle() == "Business Leader") {
            return (getCoefficientSalary() * 5000000) + 8000000;
        } else if (getTitle() == "Project Leader") {
            return (getCoefficientSalary() * 5000000) + 5000000;
        } else {
            return (getCoefficientSalary() * 5000000) + 6000000;
        }
    }

    public static String getHeader() {
        return String.format("%-10s%-20s%-10s%-20s%-20s%-20s%-20s%-10s\n%s", "ID", "Tên", "Tuổi", "Hệ số lương",
                "Ngày bắt đầu",  "Nghỉ phép", "Bộ phận", "Chức vụ",
                "--------------------------------------------------------------------------------------------------------------------------------------");

    }

    public String toString() {
        return String.format("%-10s%-20s%-10s%-20s%-20s%-20s%-20s%-10s", getId(), getName(), getAge(),
                getCoefficientSalary(), getDateJoin(), getAnnualLeave(), getDepartment(), getTitle());

    }


    // Raw data
    private static List<Manager> managers = new ArrayList<>(Arrays.asList(
            new Manager("TM01", "Tung", 35, 2.5, "12/02/2018", 5, "Technical", "Technical Leader"),
            new Manager("BM01", "Thanh", 36, 2.4, "20/08/2018", 10, "Business", "Business Leader"),
            new Manager("PM01", "Hoa", 40, 2.7, "15/06/2018", 10, "Project", "Project Leader")
    ));

    // Display managers
    static void display() {
        System.out.println("Danh sách quản lý:");
        System.out.println(getHeader());
        for (Manager m : managers) {
            System.out.println(m);
        }
    }

    // Display by department
    static void displayByDepartment(String department) {
        
        // List found manager
        List<Manager> foundManagers = new ArrayList<>();

        // Find department name
        for (Manager m : managers) {
            if (m.getDepartment().equalsIgnoreCase(department)) {

                // Add to list found
                foundManagers.add(m);
            }
        }
        if (!foundManagers.isEmpty()) {
            System.out.println("Quản lý " + department);
            System.out.println();
            System.out.println(getHeader());
            for (Manager m : foundManagers) {
                System.out.println(m);
            }
        }
    }

    static void search(String searchKey) {

        // List found manager
        List<Manager> foundManagers = new ArrayList<>();

        for (Manager m : managers) {
            if (m.getId().contains(searchKey) || m.getName().contains(searchKey)) {
                // Add to list found manager by search key
                foundManagers.add(m);
            }
        }

        if (!foundManagers.isEmpty()) {
            System.out.println("Managers:");
            System.out.println();
            System.out.println(getHeader());
            for (Manager m : foundManagers) {
                System.out.println(m);
            }
        } else {
            System.out.println("Không tìm thấy quản lý.");
        }
    }

    // Add manager
    public static void add(Manager m) {
        managers.add(m);
    }

    // Get all managers
    public static List<Manager> getAll() {
        return managers;
    }


}