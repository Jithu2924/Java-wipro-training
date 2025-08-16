package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC_002_dropdown {
public static void main(String[] args) throws InterruptedException {
	WebDriverManager.chromedriver();
	WebDriver driver= new ChromeDriver();
	driver.get("https://tutorialsninja.com/demo/index.php?");
	System.out.println(driver.getTitle());
	Thread.sleep(3000);
	driver.findElement(By.linkText("Desktops")).click();
	driver.findElement(By.linkText("Mac (1)")).click();
	Select sortby=new Select(driver.findElement(By.id("input-sort")));
//	sortby.selectByVisibleText("Name (A - Z)");
	System.out.println(sortby.getOptions().size());
	System.out.println(sortby.getOptions().get(2).getText());
	}
}
