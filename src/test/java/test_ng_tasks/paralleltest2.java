package test_ng_tasks;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class paralleltest2 {
  @Test
  public void f() {
	  WebDriverManager.chromedriver();
	  WebDriver driver=new ChromeDriver();
	  driver.get("https://flipkart.com/");
	  System.out.println("test2 run successfully");
  }
}
