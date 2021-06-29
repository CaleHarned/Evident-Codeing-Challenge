package dev.harned;

public class ContractEmp extends Employee{
    public ContractEmp(String name, double rate, double hours, EmployeeType type){
        super(name, rate, hours, type);
    }
    @Override
    public double salary(){
        //Salary for Contract employee is $10,000 + (Hours*Rate). There is no cap. 
        double salaryComp = 0.0;
        salaryComp = 10000+(this.getEmployeeHours()*this.getEmployeeRate());
        return salaryComp;
    }
}
