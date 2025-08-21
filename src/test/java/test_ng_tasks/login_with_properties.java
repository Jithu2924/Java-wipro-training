package test_ng_tasks;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class login_with_properties {
  @Test
  public void f() throws InterruptedException, IOException {
	  Properties prob=new Properties();
	  String path=System.getProperty("user.dir");
	  FileInputStream fis=new FileInputStream(path+"\\login.properties");
	  prob.load(fis);
	  String url=prob.getProperty("url");
	  String username=prob.getProperty("username");
	  String password=prob.getProperty("password");
	   
	   
	  		
	  		WebDriverManager.chromedriver().setup();
	  		WebDriver driver=new ChromeDriver();
	  		driver.get(url);
	  		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	  		String title=driver.getTitle();
	  		System.out.println("The Title is:"+title);
	  		Thread.sleep(3000);
	  		driver.findElement(By.name("username")).sendKeys(username);
	  		driver.findElement(By.name("password")).sendKeys(password);
	  		driver.findElement(By.xpath("//button[@type='submit']")).click();
  }
}
