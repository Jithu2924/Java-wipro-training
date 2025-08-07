package lab3;

import java.util.Scanner;

import lab2.Employee;
import lab2.Employeeservice1;
import lab2.EmployeeService;

public class Lab3 {


	    public static void main(String[] args) {
	        Scanner sc = new Scanner(System.in);

	        try {
	            System.out.print("Enter Employee ID: ");
	            int id = sc.nextInt();
	            sc.nextLine();

	            System.out.print("Enter Name: ");
	            String name = sc.nextLine();

	            System.out.print("Enter Salary: ");
	            double salary = sc.nextDouble();
	            sc.nextLine();

	            if (salary < 3000) {
	                throw new EmployeeException("Salary should not be below 3000.");
	            }

	            System.out.print("Enter Designation (Programmer/Manager/System Associate): ");
	            String designation = sc.nextLine();

	            Employee emp = new Employee(id, name, salary, designation);
	            EmployeeService service = new Employeeservice1();
	            service.insurance(emp);
	            service.employeedetails(emp);

	        } catch (EmployeeException e) {
	            System.out.println("Exception: " + e.getMessage());
	        } catch (Exception e) {
	            System.out.println("Something went wrong: " + e.getMessage());
	        } finally {
	            sc.close();
	        
	    }
	}

}
