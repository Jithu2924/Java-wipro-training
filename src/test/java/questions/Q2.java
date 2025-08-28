package questions;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.DataProvider;
import org.testng.annotations.BeforeSuite;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;

public class Q2 {
	WebDriver driver;
  @Test(dataProvider = "dp")
  public void f(String username, String password) {
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

	  driver.findElement(By.name("username")).sendKeys(username);
	  driver.findElement(By.name("password")).sendKeys(password);
	  driver.findElement(By.xpath("//*[@id=\"login\"]/button")).click();
	  WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(5));
	  WebElement loginpage= wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("flash")));
	  Assert.assertTrue(loginpage.getText().contains("You logged into a secure area"),"Login was not successful");
	  if(loginpage.isDisplayed()) {
		  System.out.println("Login successful");
	  }
  }

  @DataProvider
  public Object[][] dp() {
    return new Object[][] {
      new Object[] { "tomsmith", "SuperSecretPassword!" }
    };
  }
  @BeforeSuite
  public void beforeSuite(){
	  WebDriverManager.chromedriver();
	  driver= new ChromeDriver();
	  driver.get("https://the-internet.herokuapp.com/login");
  }
  @AfterSuite
  public void afterSuite(){
	  driver.close();
  }
}
