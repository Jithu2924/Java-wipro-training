package inheritance_and_polymorphism;


public class Employeeservice1 implements EmployeeService{
	@Override
	public void insurance(Employee emp) {
	if (emp.salary >= 50000 && emp.designation.equalsIgnoreCase("Manager")) {
        emp.insuranceScheme = "Platinum";
    } else if (emp.salary >= 30000 && emp.designation.equalsIgnoreCase("Programmer")) {
        emp.insuranceScheme = "Gold";
    } else if (emp.salary >= 20000 && emp.designation.equalsIgnoreCase("System Associate")) {
        emp.insuranceScheme = "Silver";
    } else {
        emp.insuranceScheme = "No Scheme";
    }}
	@Override
	public void employeedetails(Employee emp) {
        System.out.println("\nEmployee Details:");
        System.out.println("ID: " + emp.id);
        System.out.println("Name: " + emp.name);
        System.out.println("Salary: " + emp.salary);
        System.out.println("Designation: " + emp.designation);
        System.out.println("Insurance Scheme: " + emp.insuranceScheme);
	}
	
}
	




