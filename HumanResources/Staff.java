public abstract class Staff {

    private String employeeId;
    private String employeeName;
    private Integer employeeAge;
    private Double coefficientSalary;
    private String dateJoin;
    private Integer annualLeave;
    private String department;

    public Staff(String employeeId, String employeeName, int employeeAge, double coefficientSalary, String dateJoin,
            int annualLeave, String department) {

        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.employeeAge = employeeAge;
        this.coefficientSalary = coefficientSalary;
        this.dateJoin = dateJoin;
        this.annualLeave = annualLeave;
        this.department = department;
    }

    // Get id
    public String getId() {
        return employeeId;
    }

    // Set id
    public void setId(String employeeId) {
        this.employeeId = employeeId;
    }

    // Get name
    public String getName() {
        return employeeName;
    }

    // Set name
    public void setName(String employeeName) {
        this.employeeName = employeeName;
    }

    // Get age

    public int getAge() {
        return employeeAge;
    }
    // Set age

    public void setAge(int employeeAge) {
        this.employeeAge = employeeAge;
    }

    // Get coefficientSalary

    public double getCoefficientSalary() {
        return coefficientSalary;
    }

    // Set coefficientSalary

    public void setCoefficientSalary(double coefficientSalary) {
        this.coefficientSalary = coefficientSalary;
    }

    // Get date join

    public String getDateJoin() {
        return dateJoin;
    }
    // Set date join

    public void setDateJoin(String dateJoin) {
        this.dateJoin = dateJoin;
    }

    // Get annualLeave

    public int getAnnualLeave() {
        return annualLeave;
    }

    // Set annualLeave

    public void setAnnualLeave(int annualLeave) {
        this.annualLeave = annualLeave;
    }

    // Get department

    public String getDepartment() {
        return department;
    }

    // Set department

    public void setDepartment(String department) {
        this.department = department;
    }

    // Display information
    public abstract String toString();

}
