package test_ng_tasks;



import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.sun.jna.platform.FileUtils;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.BeforeClass;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.Duration;
import java.util.logging.FileHandler;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class Extend_report {
	WebDriver driver;
	 String projectpath=System.getProperty("user.dir")  ;
  @Test(dataProvider = "dp")
  public void f(String username, String password) throws InterruptedException, IOException {
	  	String title=driver.getTitle();
		System.out.println("The Title is:"+title);
		new WebDriverWait(driver, Duration.ofSeconds(10))
        .until(ExpectedConditions.visibilityOfElementLocated(By.name("username")));
		//Assert.assertEquals(title, "Amazon");
		ExtentReports extent=new ExtentReports();
		String reportpath=projectpath+"\\Augreport.html";
		ExtentSparkReporter spark=new ExtentSparkReporter(reportpath);
		extent.attachReporter(spark);
		ExtentTest test=extent.createTest("Verify the title of the page");
		if(title.equals("OrangeHR"))
		{
			test.pass("title is matched");
		}
		else
		{
			test.fail("title is not mathed");
			File scr = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		    String dest = projectpath + "\\screenshot1.png";
		    Files.copy(scr.toPath(), Path.of(dest));
		    test.addScreenCaptureFromPath(dest);
			
		
		}
		
		Thread.sleep(3000);
		//WebElement username=driver.findElement(By.name("username"));
		//username.sendKeys("Admin");
		login_credentials obj=new login_credentials(driver);
		obj.enterusername(username);
		obj.enterpassword(password);
		obj.clickonlogin();
		extent.flush();
	//	driver.findElement(By.name("username")).sendKeys(username);
		//driver.findElement(By.name("password")).sendKeys(password);
	//	driver.findElement(By.xpath("//button[@type='submit']")).click();
	  }
  @BeforeMethod
  public void beforeMethod() {
	  System.out.println("Before method");
	  WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
  }
  @AfterMethod
  public void afterMethod() {
	  System.out.println("After method");
	  driver.quit();
  }


  @DataProvider
  public Object[][] dp() throws IOException {
  return new Object[][] { new Object[]  {"Admin","admin123"} };
    
    }
  
 
 

}
