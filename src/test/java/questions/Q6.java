package questions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeSuite;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.Test;


public class Q6 {
	WebDriver driver;
  @Test
  public void f() {
	  WebElement ch1= driver.findElement(By.xpath("//*[@id='checkboxes']/input[1]"));
	  WebElement ch2= driver.findElement(By.xpath("//*[@id='checkboxes']/input[2]"));
	  if(!ch1.isSelected()) {
		  ch1.click();
	  }
	  if(!ch2.isSelected()) {
		  ch2.click();
	  }
	  Assert.assertTrue(ch1.isSelected());
	  Assert.assertTrue(ch2.isSelected());
  }
  @BeforeSuite
  public void BeforeSuite(){
	  driver= new ChromeDriver();
	  driver.get("https://the-internet.herokuapp.com/checkboxes");
  }
  @AfterSuite
  public void AfterSuite(){
//	  driver.close();
  }
}
