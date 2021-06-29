package dev.harned;

public class PartTimeEmp extends Employee{
    public PartTimeEmp(String name, double rate, double hours, EmployeeType type){
        super(name, rate, hours, type);
    }
    @Override
    public double salary(){
        //Salary for a part time employee is Hours*Rate. Let’s not worry about OT.
        double salaryComp = 0.0;
        salaryComp = this.getEmployeeHours()*this.getEmployeeRate();
        return salaryComp;
    }


}
