package com.orangehrm.utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtendManager {
	 static String projectpath=System.getProperty("user.dir")  ;
	 private static ExtentReports extent;
	
	public static ExtentReports getinstance() {
		if(extent==null) {
			String reportpath= projectpath +"\\src\\test\\resources\\Reports\\ReportsAugreport.html";
		ExtentSparkReporter spark=new ExtentSparkReporter(reportpath);
		extent = new ExtentReports(); 
		extent.attachReporter(spark);

		}
		return extent;
	}
	
}
