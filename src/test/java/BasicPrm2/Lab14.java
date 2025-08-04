package BasicPrm2;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Lab14 {
	public ZonedDateTime zonedate(String zoneid) {
		ZoneId id=ZoneId.of(zoneid);
		ZonedDateTime date=ZonedDateTime.now(id);
		return date;
	}
public static void main(String[] args) {
	Scanner scanner=new Scanner(System.in);
	System.out.println("Enter the zone Ex: America/New_York, Europe/London, Asia/Tokyo, US/Pacific, Africa/Cairo, Australia/Sydney");
	String zone=scanner.next();
	Lab14 ob=new Lab14();
	DateTimeFormatter format= DateTimeFormatter.ofPattern("dd-MM-yyyy HH-mm-ss");
	ZonedDateTime zonedate=ob.zonedate(zone);
	System.out.println("The zone date & time of "+zone+" is "+zonedate.format(format));
	
	
}
}
