package inheritance_and_polymorphism;

import java.util.Scanner;

public class Lab3and4 {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Employee ID: ");
        int id = sc.nextInt();

        sc.nextLine();
        System.out.print("Enter Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Salary: ");
        double salary = sc.nextDouble();

        sc.nextLine();
        System.out.print("Enter Designation (Programmer/Manager?System Associate): ");
        String designation = sc.nextLine();

        Employee emp = new Employee(id, name, salary, designation);

        EmployeeService service = new Employeeservice1();
        service.insurance(emp);
        service.employeedetails(emp);
        }

}
