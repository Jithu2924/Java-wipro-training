package questions;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.Test;


public class Q9 {
	WebDriver driver;
  @Test
  public void f() throws IOException {
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));
	  File ss=((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
	  FileUtils.copyFile(ss, new File("\\src\\test\\java\\questions\\homepage.png"));
  }
  @BeforeSuite
  public void BeforeSuite(){
	  driver= new ChromeDriver();
	  driver.get("https://www.wikipedia.org/");
  }
  @AfterSuite
  public void AfterSuite(){
	  driver.close();
  }
}