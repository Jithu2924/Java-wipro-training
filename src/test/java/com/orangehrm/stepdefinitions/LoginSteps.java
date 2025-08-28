package com.orangehrm.stepdefinitions;



import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.util.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

 
public class LoginSteps {
	WebDriver driver;
	
	@Given("Launch the Browser")
	public void launch_the_browser() {
	    // Write code here that turns the phrase above into concrete actions
	   	    
	    WebDriverManager.chromedriver().setup();
		 driver=new ChromeDriver();
		    
	}
 
	@Given("Navigate to the URL")
	public void navigate_to_the_url() {
	    // Write code here that turns the phrase above into concrete actions
		
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("username")));
	   
	}
 
	@When("Enter the username and password")
	public void enter_the_username_and_password() {
		driver.findElement(By.name("username")).sendKeys("Admin");
				driver.findElement(By.name("password")).sendKeys("admin123");
	}
	
	@When("Enter the invalid username and password")
	public void enter_the_invalid_username_and_password() {
		driver.findElement(By.name("username")).sendKeys("fgdfgdfg");
				driver.findElement(By.name("password")).sendKeys("admin123fgdf");
	}

	@Then("Close the browser")
	public void close_the_browser()
	
	{
		driver.quit();
	}

 
	@When("Click on Login Button")
	public void click_on_login_button() {
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
	}
 
	@Then("Login should be successful")
	public void login_should_be_successful() {
		String title=driver.getTitle();
		System.out.println("The Title is:"+title);
		if(title.equalsIgnoreCase("OrangeHRM"))
		{
			System.out.println("Login Successfull");
		}
		else
		{
			System.out.println("Login unSuucessfull");
		}
	}
	
	@Then("Login should be unsuccessful")
	public void login_should_be_unsuccessful() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement errorMsg = wait.until(
		    ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/div/div[1]/div[1]/p"))
		);

		if(errorMsg.isDisplayed())
		{
			System.out.println("login unsuccessfull");
		}
				
		
	}
	
	@Then("verify dashboard")
	public void verify_dashboard() {
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='app']/div[1]/div[1]/header/div[1]/div[1]/span/h6")));
		
	}

 
}
 
 
