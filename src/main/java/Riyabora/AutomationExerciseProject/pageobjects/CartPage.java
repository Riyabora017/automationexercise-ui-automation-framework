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

public class CartPage extends AbstractComponent {
	WebDriver driver;
	
	 
	 public CartPage(WebDriver driver) {
	        super(driver);
	        this.driver = driver;
	        PageFactory.initElements(driver, this);
	        handleAdsAfterPageLoad();
	 }
	 By subscriptiontext=By.xpath("//h2[text()='Subscription']");
     By subscriptionEmail=By.id("susbscribe_email");
     By subsriptionsuccesstext = By.cssSelector("div[class='alert-success alert']");
     
     By cartProducts = By.xpath("//table[@id='cart_info_table']/tbody/tr");

     By firstPrice = By.xpath("(//td[@class='cart_price']/p)[1]");
     By secondPrice = By.xpath("(//td[@class='cart_price']/p)[2]");

     By firstQuantity = By.xpath("(//button[@class='disabled'])[1]");
     By secondQuantity = By.xpath("(//button[@class='disabled'])[2]");

     By firstTotal = By.xpath("(//td[@class='cart_total']/p)[1]");
     By secondTotal = By.xpath("(//td[@class='cart_total']/p)[2]");
	   
     By productQuantity = By.xpath("//tr[@id='product-1']/td[4]/button");
     By verifydeletequantity= By.xpath("//b[text()='Cart is empty!']");
     
     By cartProduct = By.xpath("//tr[contains(@id,'product-')]");
     By checkoutModal = By.id("checkoutModal");
     @FindBy(xpath="//div[@class='breadcrumbs']//li[2]")
	   WebElement shoppingcart;
     
     @FindBy(css="div[class='single-widget']")
	   WebElement footer;
	  
	   @FindBy(id="subscribe")
	      WebElement subscriptionbtn;
	  
	   @FindBy(xpath="//a[contains(text(),'Proceed To Checkout')]")
	   WebElement proceedbtn;
	   
	   @FindBy(xpath = "//div[@class='modal-content']//a[@href='/login']")
	   WebElement register_login;
	   
//	   @FindBy(xpath="//a[@href='/login']")
//	   WebElement register_login;
//	   
	   @FindBy(xpath="//a[@class='cart_quantity_delete']")
	   WebElement deletequantity;
	   
	 public void scrollandverifySubscription() {
		 getScroll(footer);
		String text=driver.findElement(subscriptiontext).getText();
		 Assert.assertEquals(text, "SUBSCRIPTION");
	 }
	 public void filldetailsforsubscription(String email) {
		 driver.findElement(subscriptionEmail).sendKeys(email);
		 subscriptionbtn.click();
	 }
	 public void verifysubscriptionsuccesstext() {
		String text= driver.findElement(subsriptionsuccesstext).getText();
	    Assert.assertEquals(text,"You have been successfully subscribed!");
	 }

     public boolean verifyBothProductsAdded() {
         return driver.findElements(cartProducts).size() == 2;
     }
     
     public void verifyPriceQuantityTotal() {

    	    Assert.assertEquals(driver.findElement(firstPrice).getText(), "Rs. 500");
    	    Assert.assertEquals(driver.findElement(secondPrice).getText(), "Rs. 400");

    	    Assert.assertEquals(driver.findElement(firstQuantity).getText(), "1");
    	    Assert.assertEquals(driver.findElement(secondQuantity).getText(), "1");

    	    Assert.assertEquals(driver.findElement(firstTotal).getText(), "Rs. 500");
    	    Assert.assertEquals(driver.findElement(secondTotal).getText(), "Rs. 400");
    	}
     public void verifyexactquantity(String expectedQuantity) {
    	  String actualQuantity = driver.findElement(productQuantity).getText();

    	    Assert.assertEquals(actualQuantity, expectedQuantity);
     }
     public AddressDetailsPage  verifycartPage() {

    	String verifycart= shoppingcart.getText();
    	Assert.assertEquals(verifycart, "Shopping Cart");
    	waitForElementToAppear(proceedbtn);
    	proceedbtn.click();
   	 return new  AddressDetailsPage(driver);
     }
     public void  verifyonlycartPage() {
    	 System.out.println(driver.getCurrentUrl());
    	String verifycart= shoppingcart.getText();
    	Assert.assertEquals(verifycart, "Shopping Cart");
    	     	    	}
     public AddressDetailsPage clickproceedbtn() {
    	 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

    	    WebElement btn = wait.until(
    	            ExpectedConditions.elementToBeClickable(proceedbtn));

    	    ((JavascriptExecutor) driver)
    	            .executeScript("arguments[0].scrollIntoView(true);", btn);
    	 proceedbtn.click();
    	 return new  AddressDetailsPage(driver);
     }
//     public LoginSignupPage clickloginsignBtn() {
//
//    	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//
//    	    wait.until(ExpectedConditions.invisibilityOfElementLocated(checkoutModal));
//
//    	    wait.until(ExpectedConditions.elementToBeClickable(register_login));
//
//    	    register_login.click();
//
//    	    return new LoginSignupPage(driver);
//    	}
     public LoginSignupPage clickloginsignBtn() {
    	 waitForElementToBeClickable(register_login);
    	 register_login.click();
    	 return new LoginSignupPage(driver);
     }   //click proceed btn ke baad register login popup se on krna h try manuall first
     public void deletecartquantity() {
    	 deletequantity.click();
     }
     public void verifydeletecartquantity() {
    	 String text=driver.findElement(verifydeletequantity).getText();     
     Assert.assertEquals(text, "Cart is empty!");
}
     public boolean verifyProductsAdded() {
         return driver.findElements(cartProducts).size() !=0;
     }
    
}

