package com.orangehrm.tests;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.devtools.v136.page.model.Screenshot;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.orangehrm.base.BaseTest;
import com.orangehrm.pages.Login_PageFactory;
import com.orangehrm.utilities.ExcelUtiles;
import com.orangehrm.utilities.ScreenShots;

import test_ng_tasks.login_credentials;

public class LoginOrangeHRM extends BaseTest{
	static String projectpath=System.getProperty("user.dir")  ;
  @Test(dataProvider="logindata")
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
}