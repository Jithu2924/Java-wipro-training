package questions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeSuite;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.Test;


public class Q4 {
	WebDriver driver;
  @Test
  public void f() {
	  Select drop=new Select(driver.findElement(By.name("my-select")));
	  drop.selectByVisibleText("Two");
	  String selected=drop.getFirstSelectedOption().getText();
	  Assert.assertEquals(selected,"Two");
	  

  }
  @BeforeSuite
  public void BeforeSuite(){
	  driver= new ChromeDriver();
	  driver.get("https://www.selenium.dev/selenium/web/web-form.html");
  }
  @AfterSuite
  public void AfterSuite(){
//	  driver.close();
  }
}
