package dev.harned;

public class FullTimeEmp extends Employee{
    public FullTimeEmp(String name, double rate, double hours, EmployeeType type){
        super(name, rate, hours, type);
    }
    @Override
    public double salary(){
        //Salary for a full time employee is Hours*Rate but capped at $50,000.
        double salaryComp = 0.0;
        salaryComp = this.getEmployeeHours()*this.getEmployeeRate();
        if (salaryComp>50000){
            salaryComp=50000;
        }
        return salaryComp;
    }
}
