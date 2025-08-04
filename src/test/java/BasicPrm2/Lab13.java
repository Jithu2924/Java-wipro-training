package BasicPrm2;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Lab13 {
	public LocalDate product(LocalDate productdate,int year,int month) {
		LocalDate warrantydate= productdate.plusYears(year).plusMonths(month);
		
		return warrantydate;
		
	}
public static void main(String[] args) {
	Scanner sc=new Scanner(System.in);
	System.out.println("Enter the date in the pattern dd-MM-yyyy");
	String productdate=sc.next();
	System.out.println("Enter the warranty in years");
	int warrantyyears=sc.nextInt();
	System.out.println("Enter the warranty in months");
	int warrantymonths=sc.nextInt();
	DateTimeFormatter format=DateTimeFormatter.ofPattern("dd-MM-yyyy");
	LocalDate date1=LocalDate.parse(productdate,format);
	Lab13 obj=new Lab13();
	String expiredate= obj.product(date1,warrantyyears,warrantymonths).format(format);
	System.out.println("Warranty expires in "+expiredate);
	
	
}
}
