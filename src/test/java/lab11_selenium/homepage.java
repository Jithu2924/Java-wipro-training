package lab11_selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class homepage {
	WebDriver driver;
//	By desktopsMenu = By.linkText("Desktops");
//    By macOption = By.linkText("Mac (1)");
//    By sortDropdown = By.id("input-sort");
//    By sortAZOption = By.cssSelector("#input-sort > option:nth-child(2)");
//    By addToCartButton = By.cssSelector(".button-group > button:nth-child(1)");
//    By searchBox = By.name("search");
//    By searchButton = By.xpath("/html/body/header/div/div/div[2]/div/span/button");
//    By descriptionCheckbox = By.name("description");
//    By searchConfirmButton = By.id("button-search");
    @FindBy(linkText = "Desktops")
    WebElement desktopsMenu;

    @FindBy(linkText = "Mac (1)")
    WebElement macOption;

    @FindBy(id = "input-sort")
    WebElement sortDropdown;

    @FindBy(css = "#input-sort > option:nth-child(2)")
    WebElement sortAZOption;

    @FindBy(css = ".button-group > button:nth-child(1)")
    WebElement addToCartButton;

    @FindBy(name = "search")
    WebElement searchBox;

    @FindBy(xpath = "/html/body/header/div/div/div[2]/div/span/button")
    WebElement searchButton;

    @FindBy(name = "description")
    WebElement descriptionCheckbox;

    @FindBy(id = "button-search")
    WebElement searchConfirmButton;
    
    
    homepage(WebDriver driver1){
	this.driver=driver1;
	PageFactory.initElements(driver1, this);
    
}
public void clickDesktops() {
//    driver.findElement(desktopsMenu).click();
	desktopsMenu.click();
}

public void clickMac() {
//    driver.findElement(macOption).click();
	macOption.click();
}
public void selectSortAZ() {
//    driver.findElement(sortDropdown).click();
//    driver.findElement(sortAZOption).click();
	sortDropdown.click();
	sortAZOption.click();
}

public void clickAddToCart() {
//    driver.findElement(addToCartButton).click();
	addToCartButton.click();
}

public void searchProduct(String productName) {
//    driver.findElement(searchBox).clear();
//    driver.findElement(searchBox).sendKeys(productName);
//    driver.findElement(searchButton).click();
	searchBox.clear();
	searchBox.sendKeys(productName);
	searchButton.click();
}

public void enableDescriptionSearch() {
//    driver.findElement(descriptionCheckbox).click();
	descriptionCheckbox.click();
}

public void confirmSearch() {
//    driver.findElement(searchConfirmButton).click();
	searchConfirmButton.click();
}
}
