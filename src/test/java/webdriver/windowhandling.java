package webdriver;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class windowhandling {
public static void main(String[] args) {
	
		WebDriverManager.chromedriver();
	WebDriver driver=new ChromeDriver();
	driver.get("https://letcode.in/window");
	driver.findElement(By.id("home")).click();
	System.out.println(driver.getCurrentUrl());
	Set<String> w=driver.getWindowHandles();
	for(String c:w) {
		driver.switchTo().window(c);
		System.out.println(driver.getCurrentUrl());
	}
	driver.close();
	driver.quit();
}
}
