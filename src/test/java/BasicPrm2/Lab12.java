package BasicPrm2;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Lab12 {
public static void main(String[] args) {
	Scanner sc=new Scanner(System.in);
	System.out.println("Enter the date in the pattern dd-MM-yyyy");
	String userdate1=sc.next();
	System.out.println("Enter the second date in the pattern dd-MM-yyyy");
	String userdate2=sc.next();
	DateTimeFormatter format=DateTimeFormatter.ofPattern("dd-MM-yyyy");
	LocalDate date1=LocalDate.parse(userdate1,format);
	LocalDate date2=LocalDate.parse(userdate2,format);
	Period difference= Period.between(date1, date2);
	System.out.println(difference);
}
}
