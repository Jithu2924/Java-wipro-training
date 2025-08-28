package com.orangehrm.tests;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.v136.page.model.Screenshot;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.orangehrm.base.BaseTest;
import com.orangehrm.pages.Login_PageFactory;
import com.orangehrm.utilities.ExcelUtiles;
import com.orangehrm.utilities.ScreenShots;


public class LoginOrangeHRM extends BaseTest{
	static String projectpath=System.getProperty("user.dir")  ;
  @Test(dataProvider="logindata", enabled=false)
  public void verifylogin(String username, String password) throws IOException {
	  
	  test=extent.createTest("Login with the user:"+username);
	  Login_PageFactory obj=PageFactory.initElements(driver, Login_PageFactory.class);
	  WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	  wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("username")));
	  obj.enterusername(username);
	  obj.enterpassword(password);
	  obj.clickonlogin();
	  
	  String actualtitle=driver.getTitle();
			  if(actualtitle.equalsIgnoreCase("OrangeHRM"))
			  {
				  test.pass("Login Successfull and title is matched:"+actualtitle);
			  }
			  else
			  {
				  String screenpath=ScreenShots.Capture(driver, "Login_Failed:"+username);
				  test.fail("Login unSuccessfull and title is not matched:"+actualtitle)
				  .addScreenCaptureFromPath(screenpath);
				  
			  }
  }
  @DataProvider 
  public Object[][] logindata() throws IOException {
	  
		  String excelpath=projectpath+"\\src\\test\\resources\\TestData\\data.xlsx";
	 
		return ExcelUtiles.getdata(excelpath,"Sheet1");
}
  @Test(enabled=false)
  public void question1_google() throws IOException
  {
	  navigateurl("https://www.google.com/");
	  test=extent.createTest("Verify the title of the google page");
	  String actualtitle=driver.getTitle();
	  if(actualtitle.equalsIgnoreCase("Google"))
	  {
		  test.pass("Google title is matched");
	  }
	  else
	  {
		  String screenpath=ScreenShots.Capture(driver, "Title mismatched");
		  test.fail("Google title is not matched:"+actualtitle)
		  .addScreenCaptureFromPath(screenpath);
		  
	  }
	  
  }
  
  @Test(dataProvider = "loginhero",enabled=false)
  public void q2(String username, String password) throws IOException {
//	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	  if(username!=null) {
	  navigateurl("https://the-internet.herokuapp.com/login");
	  
	  driver.findElement(By.name("username")).sendKeys(username);
	  driver.findElement(By.name("password")).sendKeys(password);
	  driver.findElement(By.xpath("//*[@id=\"login\"]/button")).click();
	  test=extent.createTest("Verify logged into the page");
	  WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(5));
	  WebElement loginpage= wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("flash")));
	  if(loginpage.getText().contains("You logged into a secure area"))
	  {
		  test.pass("Login successful");
	  }
	  else
	  {
		  String screenpath=ScreenShots.Capture(driver, "Login was not successful");
		  test.fail("Login was not successful")
		  .addScreenCaptureFromPath(screenpath);
		  
	  }}
  }
  @DataProvider 
  public Object[][] loginhero() throws IOException {
	  
		  String excelpath=projectpath+"\\src\\test\\resources\\TestData\\loginhero.xlsx";
	 
		return ExcelUtiles.getdata(excelpath,"Sheet1");
}
  
	@Test(enabled=false)
	  public void q3() throws IOException {
		navigateurl("https://www.amazon.in/");
			try {
			driver.findElement(By.xpath("//button[@type='submit']")).click();
			
			}catch (Exception e){
				System.out.println(e.getMessage());
			}
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
			driver.findElement(By.id("twotabsearchtextbox")).sendKeys("laptop");
			driver.findElement(By.id("nav-search-submit-button")).click();
			List<WebElement> item=  driver.findElements(By.xpath("//h2[@class='a-size-medium a-spacing-none a-color-base a-text-normal']"));
			for (int i=0;i<5;i++) {
				
				System.out.println(item.get(i).getText());
			}
			
			
		  
	  }
	@Test(enabled=false)
	  public void q4() throws IOException {
		navigateurl("https://www.selenium.dev/selenium/web/web-form.html");
		  Select drop=new Select(driver.findElement(By.name("my-select")));
		  drop.selectByVisibleText("Two");
		  test=extent.createTest("Verify the dropdown selection");
		  String selected=drop.getFirstSelectedOption().getText();
		  if(selected.equalsIgnoreCase("Two"))
		  {
			  test.pass("Dropdown matched");
		  }
		  else
		  {
			  String screenpath=ScreenShots.Capture(driver, "Dropdown matched");
			  test.fail("Dropdown matched:"+selected)
			  .addScreenCaptureFromPath(screenpath);
			  
		  }

	  }
	
	@Test(enabled=false)
	  public void q5() throws IOException {
		navigateurl("https://the-internet.herokuapp.com/javascript_alerts");
		  driver.findElement(By.xpath("//*[@id=\"content\"]/div/ul/li[1]/button")).click();
		  Alert al=driver.switchTo().alert();
		  al.accept();
		  System.out.println("You successfully clicked an alert");
		  test=extent.createTest("Verify the dropdown selection");
		  String result=driver.findElement(By.id("result")).getText();
		  if(result.equalsIgnoreCase("You successfully clicked an alert"))
		  {
			  test.pass("You successfully clicked an alert");
		  }
		  else
		  {
			  String screenpath=ScreenShots.Capture(driver, "alert mismatch");
			  test.fail("You not clicked on alert:"+result)
			  .addScreenCaptureFromPath(screenpath);
			  
		  }

	  }
	
	
	@Test(enabled=false)
	  public void q6() throws IOException {
		navigateurl("https://the-internet.herokuapp.com/checkboxes");
		  WebElement ch1= driver.findElement(By.xpath("//*[@id='checkboxes']/input[1]"));
		  WebElement ch2= driver.findElement(By.xpath("//*[@id='checkboxes']/input[2]"));
		  if(!ch1.isSelected()) {
			  ch1.click();
		  }
		  if(!ch2.isSelected()) {
			  ch2.click();
		  }
		  test=extent.createTest("Verify the dropdown selection");
		  if(ch1.isSelected()&& ch2.isSelected())
		  {
			  test.pass("You successfully checked");
		  }
		  else
		  {
			  String screenpath=ScreenShots.Capture(driver, "checkbox mismatch");
			  test.fail("You not clicked on both checkboxes")
			  .addScreenCaptureFromPath(screenpath);
			  
		  }
	  }
	@Test(enabled=false)
	public void q7() {
		navigateurl("https://the-internet.herokuapp.com/tables");
		  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));
		  WebElement table=driver.findElement(By.id("table1"));
		  List<WebElement> row=table.findElements(By.tagName("tr"));
		  String jasonemail="";
		  for (int i=1;i<row.size();i++) {
			  List<WebElement> cell = row.get(i).findElements(By.tagName("td"));
			  
			  System.out.println(cell.get(1).getText());
			  if((cell.get(1).getText().contains("Jason"))) {
				  jasonemail=cell.get(2).getText();
			  }
		  }
		  System.out.println("Email of Jason: "+jasonemail);
	}
	@Test(enabled=false)
	  public void q8() throws IOException {
		navigateurl("https://the-internet.herokuapp.com/windows");
		  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));
		  String parent=driver.getWindowHandle();
		  driver.findElement(By.xpath("//*[@id=\"content\"]/div/a")).click();
		  for (String w:driver.getWindowHandles()) {
			  if(!w.equals(parent)) {
				  driver.switchTo().window(w);
			  }
		  }
		  String title=driver.getTitle();
		  System.out.println("The title of the page: "+ title);
		  driver.switchTo().window(parent);
		  String title1=driver.getTitle();
		  System.out.println("The title of the page: "+ title1);
		  test=extent.createTest("Verify the dropdown selection");
		  if(!title.isEmpty() && !title1.isEmpty())
		  {
			  test.pass("You successfully got titles");
		  }
		  else
		  {
			  String screenpath=ScreenShots.Capture(driver, "title empty");
			  test.fail("not get the titles")
			  .addScreenCaptureFromPath(screenpath);
			  
		  }
		  
	}
	
	@Test
	  public void q9() throws IOException {
		navigateurl("https://www.wikipedia.org/");
		  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));
		  File ss=((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		  FileUtils.copyFile(ss, new File("\\src\\test\\java\\questions\\homepage.png"));
	  }
}