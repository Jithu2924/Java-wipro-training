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

public class lab6 {
    public static void main(String[] args) {
        WebDriverManager.chromedriver();
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.get("https://tutorialsninja.com/demo/index.php?");
        driver.findElement(By.xpath("//*[@id=\"top-links\"]/ul/li[2]/a")).click();
        driver.findElement(By.linkText("Login")).click();
        driver.findElement(By.id("input-email")).sendKeys("Njom1@gmail.com");
        driver.findElement(By.id("input-password")).sendKeys("password");
        driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[2]/div/form/input")).click();

        driver.findElement(By.linkText("Components")).click();
        driver.findElement(By.linkText("Monitors (2)")).click();
        new Select(driver.findElement(By.id("input-limit"))).selectByVisibleText("25");
        driver.findElement(By.xpath("//*[@id=\'content\']/div[3]/div[1]/div/div[2]/div[2]/button[1]")).click();

        WebElement myLink = wait.until(
            ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='content']/div[1]/div[1]/ul[2]/li[2]/a"))
        );
        myLink.click();

        driver.findElement(By.xpath("//*[@id=\"content\"]/div[1]/div[2]/div[1]/button[1]")).click();
        WebElement alert = wait.until(
            ExpectedConditions.visibilityOfElementLocated(
                By.cssSelector("#product-product > div.alert.alert-success.alert-dismissible")
            )
        );
        String message = alert.getText().trim();
        if (message.contains("Success: You have added Apple Cinema 30")) {
            System.out.println("Message: (Success: You have added Apple Cinema 30) is verified");
        } else {
            System.out.println("Message verification failed. Actual: " + message);
        }

        driver.findElement(By.name("search")).sendKeys("Mobile");
        driver.findElement(By.xpath("//*[@id=\"search\"]/span/button")).click();
        driver.findElement(By.id("description")).click();
        driver.findElement(By.id("button-search")).click();
        driver.findElement(By.linkText("HTC Touch HD")).click();
        driver.findElement(By.id("input-quantity")).clear();
        driver.findElement(By.id("input-quantity")).sendKeys("3");
        driver.findElement(By.id("button-cart")).click();

        WebElement cartadd = wait.until(
            ExpectedConditions.visibilityOfElementLocated(
                By.cssSelector("#product-product > div.alert.alert-success.alert-dismissible")
            )
        );
        String cartmsg = cartadd.getText().trim();
        if (cartmsg.contains("Success: You have added HTC Touch HD to your shopping cart!")) {
            System.out.println("Message: (Success: You have added HTC Touch HD to your shopping cart!) is verified");
        } else {
            System.out.println("Message verification failed. Actual: " + cartmsg);
        }

        driver.findElement(By.xpath("//*[@id=\"cart\"]/button")).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.linkText("View Cart"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Checkout"))).click();

        driver.findElement(By.xpath("//*[@id=\"top-links\"]/ul/li[2]/a")).click();
        driver.findElement(By.linkText("Logout")).click();

        // wait for logout page
        wait.until(ExpectedConditions.urlContains("logout"));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#content h1")));

        if (driver.getCurrentUrl().contains("logout")) {
            System.out.println("Logout successful – URL verified");
        } else {
            System.out.println("Logout failed – URL not as expected");
        }

        // continue button after logout
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"content\"]/div/div/a"))).click();

        driver.quit();
    }
}

