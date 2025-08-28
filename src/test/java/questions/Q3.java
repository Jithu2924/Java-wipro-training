package questions;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import java.util.List;
public class Q3 {
	WebDriver driver;
	@Test
  public void f() {
		try {
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
		}catch (Exception e){
			System.out.println(e.getMessage());
		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("laptop");
		driver.findElement(By.id("nav-search-submit-button")).click();
		List<WebElement> item=  driver.findElements(By.xpath("//h2[@class='a-size-medium a-spacing-none a-color-base a-text-normal']"));
		for (int i=0;i<5;i++) {
			
			System.out.println(item.get(i).getText());
		}
		
	  
  }


  @BeforeSuite
  public void beforeSuite(){
	  WebDriverManager.chromedriver();
	  driver= new ChromeDriver();
	  driver.get("https://www.amazon.in/");
  }
  @AfterSuite
  public void afterSuite(){
	  driver.close();
  }
}
