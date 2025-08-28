package questions;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeSuite;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.Test;


public class Q5 {
	WebDriver driver;
  @Test
  public void f() {
	  driver.findElement(By.xpath("//*[@id=\"content\"]/div/ul/li[1]/button")).click();
	  Alert al=driver.switchTo().alert();
	  al.accept();
	  String result=driver.findElement(By.id("result")).getText();
	  Assert.assertEquals(result,"You successfully clicked an alert");
	  System.out.println("You successfully clicked an alert");
  }
  @BeforeSuite
  public void BeforeSuite(){
	  driver= new ChromeDriver();
	  driver.get("https://the-internet.herokuapp.com/javascript_alerts");
  }
  @AfterSuite
  public void AfterSuite(){
	  driver.close();
  }
}
