package webdriver;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC_004_sync {
public static void main(String[] args) {
	WebDriverManager.chromedriver();
	WebDriver driver=new ChromeDriver();
	
	//implicit wait : applies globally to driver instance.
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	
	//explicit wait: applies to  specific webelement.
	WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(5));
	WebElement ele=driver.findElement(By.name("username"));
	wait.until(ExpectedConditions.elementToBeClickable(ele));
	ele.sendKeys("Admin");
}
}
