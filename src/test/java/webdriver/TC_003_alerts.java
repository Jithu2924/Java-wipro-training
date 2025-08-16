package webdriver;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC_003_alerts {
public static void main(String[] args) throws InterruptedException {
	WebDriverManager.chromedriver();
	WebDriver d=new ChromeDriver();
	d.get("https://letcode.in/alert");
	d.findElement(By.id("confirm")).click();
//	d.findElement(null)
	Alert al= d.switchTo().alert();
	al.dismiss();
	d.findElement(By.id("prompt")).click();
	Alert pt= d.switchTo().alert();
	System.out.println(pt.getText());
	pt.sendKeys("Njom");
	pt.accept();
}
}
