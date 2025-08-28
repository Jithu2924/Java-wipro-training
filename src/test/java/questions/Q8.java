package questions;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.Test;


public class Q8 {
	WebDriver driver;
  @Test
  public void f() {
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));
	  String parent=driver.getWindowHandle();
	  driver.findElement(By.xpath("//*[@id=\"content\"]/div/a")).click();
	  for (String w:driver.getWindowHandles()) {
		  if(!w.equals(parent)) {
			  driver.switchTo().window(w);
		  }
	  }
	  String title=driver.getTitle();
	  System.out.println("The title of the page: "+ title);
	  driver.switchTo().window(parent);
	  String title1=driver.getTitle();
	  System.out.println("The title of the page: "+ title1);
	  
	  
  }
  @BeforeSuite
  public void BeforeSuite(){
	  driver= new ChromeDriver();
	  driver.get("https://the-internet.herokuapp.com/windows");
  }
  @AfterSuite
  public void AfterSuite(){
	  driver.quit();
  }
}

