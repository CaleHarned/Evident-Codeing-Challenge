package dev.harned;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {
    public static void main(String[] args){
        //Create an empty list for Employees
        List<Employee> employeeRecords = new ArrayList<>();

        //Ask the User for the CSV file to use for the program
        //using a scanner and our ReadFromCSV meathod located below
        System.out.println("Please enter the file path of the file you would like to use");
        Scanner sc1 = new Scanner(System.in);
        String file = sc1.next();
        employeeRecords=ReadFromCSV(file);

        //This Flag tells us when the user is done with the program
        boolean quitFlag= false;
        while(quitFlag==false) {
            //Now that we have our list of employee objects, Use another scanner
            //to ask what the user would like to do with the information
            Scanner sc2 = new Scanner(System.in);
            System.out.println("What would you like to see:\n1.Total salary for all employees\n" +
                    "2.Total salary for a specific group of employees\n3.Quit");
            int choice = sc2.nextInt();


            if (choice == 1){//If they choose the the first option
                double totalSalary = 0.0;
                //itterate through the Employee list and calculate the salary from each one and
                //add all the values togeather. Then output the value, and prompt the user to
                //choose another choice
                for (int i=0;i< employeeRecords.size();i++){
                    totalSalary=totalSalary+employeeRecords.get(i).salary();
                }
                System.out.println("The total salary of all employees is : $"+totalSalary+"\n");

            }
            if (choice == 2){//If they choose the the first option
                //This flag tells us when the get total salray from employee group is done
                boolean innerQuitFlag = false;
                while(innerQuitFlag==false) {

                    //Using another scanner, Ask the user which group they would
                    //like to see the total salary for
                    Scanner sc3 = new Scanner(System.in);
                    System.out.println("Which group would you like to see the total salary for?" +
                            "\n1.Part Time Employees\n2.Full Time Employees\n3.Contract employees\n4.Back");
                    int innerChoice = sc3.nextInt();


                    if (innerChoice == 1) {
                //itterate through the Employee list and calculate the salary from each employee
                //of a specific type and add all the values togeather. Then output the value, 
                //and bring the user to the orginal menu
                        double groupTotalSalary = 0.0;
                        for (int i =0;i< employeeRecords.size();i++){
                            if(employeeRecords.get(i).getEmployeeEmploymentType()==EmployeeType.PARTTIME){
                               groupTotalSalary= groupTotalSalary + employeeRecords.get(i).salary();
                            }
                        }
                        System.out.println("The total salary for the Part Time Employees : $"+groupTotalSalary+"\n");
                        innerQuitFlag = true;
                    }


                    if (innerChoice == 2) {
                //itterate through the Employee list and calculate the salary from each employee
                //of a specific type and add all the values togeather. Then output the value, 
                //and bring the user to the orginal menu
                        double groupTotalSalary = 0.0;
                        for (int i =0;i< employeeRecords.size();i++){
                            if(employeeRecords.get(i).getEmployeeEmploymentType()==EmployeeType.FULLTIME){
                                groupTotalSalary= groupTotalSalary + employeeRecords.get(i).salary();
                            }
                        }System.out.println("The total salary for the Full Time Employees : $"+groupTotalSalary+"\n");

                        innerQuitFlag = true;
                    }


                    if (innerChoice == 3) {
                //itterate through the Employee list and calculate the salary from each employee
                //of a specific type and add all the values togeather. Then output the value, 
                //and bring the user to the orginal menu
                        double groupTotalSalary = 0.0;
                        for (int i =0;i< employeeRecords.size();i++){
                            if(employeeRecords.get(i).getEmployeeEmploymentType()==EmployeeType.CONTRACT){
                                groupTotalSalary= groupTotalSalary + employeeRecords.get(i).salary();
                            }
                        }
                        System.out.println("The total salary for the Contract Employees : $"+groupTotalSalary+"\n");
                        innerQuitFlag = true;
                    }

                    //Take the user Back to the orignal Menu
                    if (innerChoice == 4) {
                        innerQuitFlag = true;
                    }
                    //If the input is invalid, tell the user and then prompt them with the group menu again
                    if (!(innerChoice == 1 || innerChoice == 2 || innerChoice == 3 || innerChoice == 4)) {
                        System.out.println("Invalid input please try again\n");
                    }
                }


            }


            //If the user wants to quit, quit the program
            if (choice == 3){
                System.out.println("Thank you for using my program");
                quitFlag = true;
            }

            //If the input is invalid, tell the user and then prompt them with the original
            if (!(choice == 1 || choice == 2 || choice == 3)){
                System.out.println("Invalid input please try again");
            }
        }



    }


    
    public static List<Employee> ReadFromCSV(String a){
        //Takes a file path string and parses through said file to add employee elements
        //to a list, Then return said list


        //Initialize empty list
        List<Employee> employeeRecords = new ArrayList<>();
        

        //try to find the file, if it cant, output an exception
        try (BufferedReader br = Files.newBufferedReader(Path.of(a))) {
            //initialize black holder vars
            String newName = "";
            double newRate = 0.0;
            double newHours = 0.0;
            EmployeeType newType;

            //get the first line of the file
            String line = br.readLine();

            //While there are more lines
            while (line != null) {
                //Take the line as an array of String elements
                String[] employeeIn = line.split(",");

                //assign the gathered elements to their respective holders
                newName = employeeIn[0];
                newRate = Double.parseDouble(employeeIn[1]);
                newHours = Double.parseDouble(employeeIn[2]);
                newType = EmployeeType.valueOf(employeeIn[3]);

                //Determine the type of employee, and create an employee object of that type and 
                //add it to the List
                if (newType == EmployeeType.PARTTIME) {
                    PartTimeEmp emp = new PartTimeEmp(newName, newRate, newHours, newType);
                    employeeRecords.add(emp);
                }
                if (newType == EmployeeType.FULLTIME) {
                    FullTimeEmp emp = new FullTimeEmp(newName, newRate, newHours, newType);
                    employeeRecords.add(emp);
                }
                if (newType == EmployeeType.CONTRACT) {
                    ContractEmp emp = new ContractEmp(newName, newRate, newHours, newType);
                    employeeRecords.add(emp);
                }

                //get the next line
                line = br.readLine();
            }
        }

        //Exceptions for file not found
        catch (NoSuchFileException e){
            System.out.println("Invalid file declaration! Please try again");

        } catch (IOException e) {
            e.printStackTrace();
        }
        //return the list
        return employeeRecords;
    }

}
