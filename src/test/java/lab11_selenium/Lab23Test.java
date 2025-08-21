package lab11_selenium;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.core.IsNot.not;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Alert;
import org.openqa.selenium.Keys;
import java.util.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
public class Lab23Test {
  private WebDriver driver;
  private Map<String, Object> vars;
  JavascriptExecutor js;

@BeforeMethod
//@Parameters("browser")
public void setUp() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		js = (JavascriptExecutor) driver;
		vars = new HashMap<String, Object>();
  }

@AfterMethod
public void tearDown() {
    driver.quit();
  }
  @Test
  public void lab23() {
    driver.get("https://tutorialsninja.com/demo/index.php");

    homepage obj=new homepage(driver);
    obj.clickDesktops();
    obj.clickMac();

    Select sortby=new Select(driver.findElement(By.id("input-sort")));
	sortby.selectByVisibleText("Name (A - Z)");
	driver.findElement(By.cssSelector(".button-group > button:nth-child(1)")).click();

  }
}