package BasicPrm2;

import java.time.LocalDate;
import java.time.Period;
import java.time.chrono.ChronoLocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Lab11 {
public static void main(String[] args) {
	
	Scanner sc=new Scanner(System.in);
	System.out.println("Enter the date in the pattern dd-MM-yyyy");
	String userdate=sc.next();
	DateTimeFormatter format=DateTimeFormatter.ofPattern("dd-MM-yyyy");
	LocalDate date=LocalDate.parse(userdate,format);
	LocalDate currentdate=LocalDate.now();
	
	Period difference =Period.between(date, currentdate);
	System.out.println("Years"+difference.getYears());
	System.out.println("Months"+difference.getMonths());
	System.out.println("Days"+difference.getDays());
}
}
