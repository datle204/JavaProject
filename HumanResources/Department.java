import java.util.*;

public class Department{
    private String departmentId;
    private String departmentName;
    private  int departmentTotalEmployee;
    private static int departmentTechnicalTotalEmployee = 3;
    private  static int departmentBusinessTotalEmployee = 3;
    private static int departmentProjectTotalEmployee = 3;
    

    public Department(String departmentId, String departmentName, int departmentTotalEmployee) {
       
        this.departmentId = departmentId;
        this.departmentName = departmentName;
        this.departmentTotalEmployee = departmentTotalEmployee;
    }

    // Get department id
    public String getDepartmentId() {
        return departmentId;
    }

    // Set department id
    public void setDepartmentId(String departmentId) {
        this.departmentId = departmentId;
    }

    // Get department name
    public String getDepartmentName() {
        return departmentName;
    }

    // Set department name
    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    // Get total employees
    public int getDepartmentTotalEmployee() {
        return departmentTotalEmployee;
    }

    // Set total employees
    public void setDepartmentTotalEmployee(int departmentTotalEmployee) {
        this.departmentTotalEmployee = departmentTotalEmployee;
    }


    public static String getHeader() {
        return String.format("%-20s%-20s%-20s\n%s", "ID", "Tên", "Số lượng nhân viên",
                "-----------------------------------------------------------------");

    }

    public String toString() {
        return String.format("%-20s%-20s%-20s", getDepartmentId(), getDepartmentName(), getDepartmentTotalEmployee());
    }

    
    // Raw data
    private static List<Department> departments = new ArrayList<>(
            Arrays.asList(new Department("D01", "Technical", departmentTechnicalTotalEmployee),
                    new Department("D02", "Business", departmentBusinessTotalEmployee),
                    new Department("D03", "Project", departmentProjectTotalEmployee)));

    // Get all data
    public static List<Department> getAll() {
        return departments;
    }

    // Change total of employees in department
    public static void changeTotalEmployee(String department){

        if(department.equalsIgnoreCase("Technical")){
            departmentTechnicalTotalEmployee += 1;
            departments.get(0).setDepartmentTotalEmployee(departmentTechnicalTotalEmployee);
        }else if(department.equalsIgnoreCase("Business")){
            departmentBusinessTotalEmployee += 1;
            departments.get(1).setDepartmentTotalEmployee(departmentBusinessTotalEmployee);
        }else{
            departmentProjectTotalEmployee += 1;
            departments.get(2).setDepartmentTotalEmployee(departmentProjectTotalEmployee);
        }
        
    }

    // Display department
    public static void display() {
        System.out.println(getHeader());
        for (Department depart : departments) {
            System.out.println(depart);
        }
    }

}
