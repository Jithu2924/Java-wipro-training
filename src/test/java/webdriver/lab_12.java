package webdriver;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class lab_12 {
  @Test
  public void f() throws IOException {
	  Properties prob=new Properties();
	  String path=System.getProperty("user.dir");
	  FileInputStream fis=new FileInputStream(path+"\\config.properties");
	  prob.load(fis);
	  WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
	  driver.get(prob.getProperty("url"));

	    driver.findElement(By.linkText(prob.getProperty("desktopOption"))).click();
	    driver.findElement(By.linkText(prob.getProperty("mac"))).click();

	    driver.findElement(By.id(prob.getProperty("sortBy"))).click();

	    driver.findElement(By.cssSelector(prob.getProperty("NameAZ"))).click();
	    driver.findElement(By.cssSelector(prob.getProperty("addToCart"))).click();

	    
	    driver.findElement(By.name(prob.getProperty("search"))).click();
	    driver.findElement(By.name(prob.getProperty("search"))).sendKeys("Mobile");
	    driver.findElement(By.xpath(prob.getProperty("searchButton"))).click();
	    
	    
	    driver.findElement(By.name(prob.getProperty("description"))).click();
	    driver.findElement(By.id(prob.getProperty("buttonSearch"))).click();
	    driver.findElement(By.name(prob.getProperty("search"))).clear();
	    driver.findElement(By.name(prob.getProperty("search"))).click();
	    driver.findElement(By.name(prob.getProperty("search"))).sendKeys("Monitors");
	    driver.findElement(By.xpath(prob.getProperty("searchButton"))).click();
	    driver.close();
  }
}
