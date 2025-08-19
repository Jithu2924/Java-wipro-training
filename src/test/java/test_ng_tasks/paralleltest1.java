package test_ng_tasks;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class paralleltest1 {
  @Test
  public void f() {
	  WebDriverManager.chromedriver();
	  WebDriver driver=new ChromeDriver();
	  driver.get("https://amazon.in/");
	  System.out.println("test1 run successfully");
  }
}
