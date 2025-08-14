package webdriver;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class lab5_selenium {
public static void main(String[] args) {
	WebDriverManager.chromedriver();
	WebDriver driver=new ChromeDriver();
	driver.get("http://www.automationpractice.pl/index.php");
	String title=driver.getTitle();
	System.out.println(title);
	if(title.contentEquals("My Shop")){
		System.out.println("Title name verified");
	}
	driver.findElement(By.xpath("//*[@id=\"header\"]/div[2]/div/div/nav/div[1]/a")).click();
	driver.findElement(By.name("email_create")).sendKeys("njom2@gmail.com");
	driver.findElement(By.xpath("//*[@id=\"SubmitCreate\"]")).click();
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	WebElement genderMr = wait.until(ExpectedConditions.elementToBeClickable(By.id("id_gender1")));
	genderMr.click();
	driver.findElement(By.name("customer_firstname")).sendKeys("Admin");
	driver.findElement(By.name("customer_lastname")).sendKeys("Boy");
	
	driver.findElement(By.xpath("//*[@id=\"email\"]")).click();
	driver.findElement(By.name("passwd")).sendKeys("password");
	Select day=new Select(driver.findElement(By.id("days")));
	day.selectByVisibleText("1 ");
	Select month=new Select(driver.findElement(By.id("months")));
	month.selectByVisibleText("January ");
	Select year=new Select(driver.findElement(By.id("years")));
	year.selectByVisibleText("2000 ");
	driver.findElement(By.xpath("//*[@id=\"newsletter\"]")).click();
	driver.findElement(By.id("submitAccount")).click();
	WebElement successMessage = driver.findElement(By.cssSelector("p.alert.alert-success"));
	String message = successMessage.getText().trim();

	if (message.equals("Your account has been created.")) {
	    System.out.println("Account created successfully.");
	} else {
	    System.out.println("Account creation failed.");
	}

}
}