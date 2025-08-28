package questions;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.Test;


public class Q7 {
	WebDriver driver;
  @Test
  public void f() {
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));
	  WebElement table=driver.findElement(By.id("table1"));
	  List<WebElement> row=table.findElements(By.tagName("tr"));
	  String jasonemail="";
	  for (int i=1;i<row.size();i++) {
		  List<WebElement> cell = row.get(i).findElements(By.tagName("td"));
		  
		  System.out.println(cell.get(1).getText());
		  if((cell.get(1).getText().contains("Jason"))) {
			  jasonemail=cell.get(2).getText();
		  }
	  }
	  System.out.println("Email of Jason: "+jasonemail);
  }
  @BeforeSuite
  public void BeforeSuite(){
	  driver= new ChromeDriver();
	  driver.get("https://the-internet.herokuapp.com/tables");
  }
  @AfterSuite
  public void AfterSuite(){
	  driver.close();
  }
}
