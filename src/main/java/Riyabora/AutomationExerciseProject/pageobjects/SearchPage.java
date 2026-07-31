package Riyabora.AutomationExerciseProject.pageobjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import AbstractComponents.AbstractComponent;

public class SearchPage extends AbstractComponent {
	WebDriver driver;

	 
	 public SearchPage(WebDriver driver) {
	        super(driver);
	        this.driver = driver;
	        PageFactory.initElements(driver, this);
	        handleAdsAfterPageLoad();  
	 }
	 By verifysearchPage = By.xpath("//h2[text()='Searched Products']");
	 By searchedProducts = By.cssSelector(".features_items .product-image-wrapper");

	 By popupViewCart = By.xpath("//div[@id='cartModal']//a[contains(@href,'view_cart')]");
	  	
	 
	 
	 @FindBy(xpath = "(//a[contains(@class,'add-to-cart')])[1]")
		WebElement addtocartbtn;
	 
	 @FindBy(xpath = "//a[@href='/view_cart']")
		WebElement headercartbtn;
	
		@FindBy(xpath = "(//div[@class='product-image-wrapper'])[1]")
	  	WebElement Product;
	  	
	 
	 public SearchPage verifysearchPage() {
	     waitForElementToAppear(verifysearchPage );
		 String text=driver.findElement(verifysearchPage).getText();
	  Assert.assertEquals(text, "SEARCHED PRODUCTS");
	  return new SearchPage (driver);
	  }
	 
	 public boolean verifySearchedProductsVisible() {
	     return driver.findElements(searchedProducts).size() > 0;
	 }	
	 
	 public void addtocartproduct() {
		 //waitForElementToAppear(addtocartbtn);
		 hover(Product);

		 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		 WebElement addBtn = wait.until(ExpectedConditions.elementToBeClickable(
		         Product.findElement(By.cssSelector(".product-overlay a.add-to-cart"))
		 ));

		 ((JavascriptExecutor)driver).executeScript("arguments[0].click();", addBtn);
		
	 }
	 
//	 public CartPage clickcartbtn() {
//			waitForElementToBeClickable(headercartbtn);
//
//		 headercartbtn.click();
//		return new CartPage(driver);
//	 }
	 public CartPage clickcartbtn() {
		 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		 WebElement viewCartBtn = wait.until(
		         ExpectedConditions.elementToBeClickable(popupViewCart));
		 driver.findElement(popupViewCart).click();
		 return new CartPage(driver);
	 }
}
