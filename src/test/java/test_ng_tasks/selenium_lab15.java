package test_ng_tasks;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.BeforeClass;

import java.util.List;
import java.util.ArrayList;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class selenium_lab15 {
	WebDriver driver;
	String projectpath=System.getProperty("user.dir") ;
  @Test(dataProvider = "dp")
  public void f(String firstName, String lastName, String email, String phone, String pwd, String confirmPwd) throws IOException {
	  driver.get("https://tutorialsninja.com/demo/index.php?");
      WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(5));
      wait.until(driver->!driver.getTitle().isEmpty());
      String title=driver.getTitle();
      ExtentReports extent=new ExtentReports();
		String reportpath=projectpath+"\\lab11_title_report.html";
		ExtentSparkReporter spark=new ExtentSparkReporter(reportpath);
		extent.attachReporter(spark);
		ExtentTest test=extent.createTest("Verify the title of the page");
		if(title.equals("Your Store"))
		{
			test.pass("title is matched");
		}
		else
		{
			test.fail("title is not mathed");
			File scr = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
			String dest = projectpath + "\\lab11_title_" + timestamp + ".png";
		    Files.copy(scr.toPath(), Path.of(dest));
		    test.addScreenCaptureFromPath(dest);
		}
		driver.findElement(By.linkText("My Account")).click();
		driver.findElement(By.linkText("Register")).click();
		
		WebElement heading = driver.findElement(By.xpath("//h1[contains(text(),'Register Account')]"));
		 ExtentTest test2 = extent.createTest("Verify Register Account text");
		    String actualText = heading.getText();

		    if (actualText.equals("Register Account")) {
		        test2.pass("Verified heading: " + actualText);
		    } else {
		        test2.fail("Heading not matched. Found: " + actualText);
		        File scr2 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		        String timestamp2 = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
		        String dest2 = projectpath + "\\lab11_register_" + timestamp2 + ".png";
		        Files.copy(scr2.toPath(), Path.of(dest2));
		        test2.addScreenCaptureFromPath(dest2);
		    }
		    driver.findElement(By.name("firstname")).sendKeys(firstName);
		    driver.findElement(By.name("lastname")).sendKeys(lastName);
		    driver.findElement(By.id("input-email")).sendKeys(email);
		    driver.findElement(By.name("telephone")).sendKeys(phone);
		    driver.findElement(By.name("password")).sendKeys(pwd);
		    driver.findElement(By.name("confirm")).sendKeys(confirmPwd);
		    driver.findElement(By.name("agree")).click();
		    driver.findElement(By.xpath("//*[@id=\"content\"]/form/div/div/input[2]")).click();
		  
		    String actualText1 = driver.findElement(By.xpath("/html/body/div[2]/div/div/h1")).getText();
			 ExtentTest test3 = extent.createTest("Verify Account Created Confirmation text");
			    

			    if (actualText1.equals("Your Account Has Been Created!")) {
			        test3.pass("Verified heading: " + actualText1);
			    } else {
			        test3.fail("Heading not matched. Found: " + actualText1);
			        File scr2 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			        String timestamp2 = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
			        String dest2 = projectpath + "\\lab11_register_" + timestamp2 + ".png";
			        Files.copy(scr2.toPath(), Path.of(dest2));
			        test3.addScreenCaptureFromPath(dest2);
			    }
		
		extent.flush();
  }
  @BeforeMethod
  public void beforeMethod() {
  }

  @AfterMethod
  public void afterMethod() {
  }


  @DataProvider
  public Object[][] dp() throws IOException, CsvException {
	  String projectPath = System.getProperty("user.dir");
	    String csvFile = projectPath + "\\UserDetails.csv";

	    CSVReader reader = new CSVReader(new FileReader(csvFile));
	        List<String[]> allRows = reader.readAll();

	        int rowCount = allRows.size();
	        int colCount = allRows.get(0).length;

	        System.out.println("Rows: " + rowCount + " | Cols: " + colCount);

	        String[][] data = new String[rowCount - 2][colCount];

	        for (int i = 1; i < rowCount-1; i++) {
	            String[] row = allRows.get(i);
	            for (int j = 0; j < colCount; j++) {
	                data[i - 1][j] = row[j];
	            }
	        }
	        return data;
  }
  @BeforeClass
  public void beforeClass() {
	  WebDriverManager.chromedriver().setup();
      driver = new ChromeDriver();
  }

  @AfterClass
  public void afterClass() {
  }

  @BeforeTest
  public void beforeTest() {
  }

  @AfterTest
  public void afterTest() {
  }

  @BeforeSuite
  public void beforeSuite() {
  }

  @AfterSuite
  public void afterSuite() {
  }

}
