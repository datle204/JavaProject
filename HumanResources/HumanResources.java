import java.util.*;

public class HumanResources{

    
    public static void main(String[] args) {

        System.out.println("Chào mừng bạn tới trang chủ quản lý nhân lực");

        while (true) {
            System.out.println("----------------------------------");
            System.out.println("1. Hiển thị danh sách nhân viên trong công ty");
            System.out.println("2. Hiển thị các bộ phận trong công ty ");
            System.out.println("3. Hiển thị danh sách nhân viên theo bộ phận ");
            System.out.println("4. Thêm mới nhân viên ");
            System.out.println("5. Tìm kiếm nhân viên theo tên hoặc id ");
            System.out.println("6. Hiển thị bảng lương của toàn nhân viên ");
            System.out.println("7. Hiển thị bảng lương của toàn nhân viên theo thứ tự tăng dần ");
            System.out.println("8. Tắt chương trình ");
            System.out.print("Lựa chọn của bạn: ");

            Scanner console = new Scanner(System.in);
            int choice = console.nextInt();
            console.nextLine();
            

            switch (choice) {
                case 1:
                    displayEmployee();
                    break;
                case 2:
                    displayDepartment();
                    break;
                case 3:
                    displayEmployeeListInDepartment();
                    break;
                case 4:
                    addEmployee(console);
                    break;
                case 5:
                    searchEmployee(console);
                    break;
                case 6:
                    displaySalary(false);
                    break;
                case 7:
                    displaySalary(true);
                    break;
                case 8:
                    exit();
                    break;
            }
        }

    }

    // Display employees (1)

    public static void displayEmployee() {
        System.out.println();
        Employee.display();
        System.out.println();
        Manager.display();
    }

    // Display departments (2)
    private static void displayDepartment() {
        System.out.println();
        Department.display();
    }

    // Display employees list sort / department (3)
    private static void displayEmployeeListInDepartment() {
        for (final Department department : Department.getAll()) {
            System.out.println();
            Employee.displayByDepartment(department.getDepartmentName());
            System.out.println();
            Manager.displayByDepartment(department.getDepartmentName());
        }
    }

    // Add new employee (4)

    private static void addEmployee(Scanner console) {
        System.out.print("Nhân viên hoặc Quản lý (1 = Nhân viên, 2 = Quản lý): ");

        // Get choice
        int choice = console.nextInt();
        console.nextLine();
        // Get id
        System.out.print("Nhập ID: ");
        String id = console.nextLine();

        // Get name
        System.out.print("Nhập Tên: ");
        String name = console.nextLine();

        // Get age
        System.out.print("Nhập Tuổi: ");
        int age = console.nextInt();
        console.nextLine();

        // Get coefficient salary
        System.out.print("Nhập Hệ số lương: ");
        double coefficientSalary = console.nextDouble();
        console.nextLine();

        // Get date join
        System.out.print("Nhập ngày bắt đầu làm (dd/mm/yyyy): ");
        String dateJoin = console.nextLine();
       

        // Get department
        System.out.print("Nhập bộ phận làm việc: ");
        String department = console.nextLine();

        // Change total employees in department 
        Department.changeTotalEmployee(department);

        // Get annualLeave
        System.out.print("Nhập ngày nghỉ phép: ");
        int annualLeave = console.nextInt();
        console.nextLine();

        if (choice == 1) {
            // Get Overtime
            System.out.print("Nhập số giờ làm thêm: ");
            int overTime = console.nextInt();
            Employee.add(new Employee(id, name, age, coefficientSalary, dateJoin, annualLeave, department, overTime));
        } else {
            // Get title
            System.out.print("Nhập chức vụ: ");
            String title = console.nextLine();
            Manager.add(new Manager(id, name, age, coefficientSalary, dateJoin, annualLeave, department, title));
        }

       
        
        System.out.println("Thêm mới thành công");
    }

    // Search employess by id or name 

    private static void searchEmployee(final Scanner console) {
        System.out.println();

        System.out.print("Enter keyword: ");
        String searchKey = console.nextLine();

        System.out.println();
        // Find employee
        Employee.search(searchKey); 

        System.out.println();
        // Find managers
        Manager.search(searchKey); 
    }

    // sort salary list
    private static void displaySalary(Boolean isSort) {
        System.out.println();
        System.out.println(String.format("%-10s%-20s%-20s\n%s", "ID", "Name", "Salary",
                "----------------------------------------------------------------------"));

        // List calculate (non sort)
        List<ICalculate> calculate = new ArrayList<>();
        calculate.addAll(Employee.getAll());
        calculate.addAll(Manager.getAll());

        // Sort data by ascending (sorted)
        if (isSort) {
            calculate.sort((e1, e2) -> (int) (e1.calculateSalary() - e2.calculateSalary()));
        }

        for (ICalculate e : calculate) {
            System.out.println(String.format("%-10s%-20s%-20.2f", e.getId(), e.getName(), e.calculateSalary()));
        }
    }

    // Exit program
    public static void exit() {
        System.exit(0);
    }
}
