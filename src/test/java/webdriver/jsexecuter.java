package webdriver;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class jsexecuter {
public static void main(String[] args) {
	WebDriverManager.chromedriver();
	WebDriver driver=new ChromeDriver();
	driver.get("https://amazon.in/");
	JavascriptExecutor js=(JavascriptExecutor)driver;
//	js.executeScript("alert('Hello')");
//	js.executeScript("window.scrollBy(0,200)");
//	js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
}
}
