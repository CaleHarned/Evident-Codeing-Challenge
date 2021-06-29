package dev.harned;

public class Employee {
    //the Different Employee vars
    private String EmployeeName;
    private double EmployeeRate;
    private double EmployeeHours;
    private EmployeeType EmployeeEmploymentType;


    //getters and setters for each Employee var
    public String getEmployeeName() {
        return EmployeeName;
    }

    public void setEmployeeName(String employeeName) {
        EmployeeName = employeeName;
    }

    public double getEmployeeRate() {
        return EmployeeRate;
    }

    public void setEmployeeRate(double employeeRate) {
        EmployeeRate = employeeRate;
    }

    public double getEmployeeHours() {
        return EmployeeHours;
    }

    public void setEmployeeHours(double employeeHours) {
        EmployeeHours = employeeHours;
    }

    public EmployeeType getEmployeeEmploymentType() {
        return EmployeeEmploymentType;
    }

    public void setEmployeeEmploymentType(EmployeeType employeeEmploymentType) {
        EmployeeEmploymentType = employeeEmploymentType;
    }

    //Constructors
    public Employee(){}

    public Employee(String name, double rate, double hours, EmployeeType type){
        this.EmployeeName=name;
        this.EmployeeRate=rate;
        this.EmployeeHours=hours;
        this.EmployeeEmploymentType=type;
    }

    //iniitial salary method to be overriden
    public double salary(){
        return 0.0;
    }
}
