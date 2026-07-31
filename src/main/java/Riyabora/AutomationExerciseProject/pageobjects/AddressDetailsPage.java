package Riyabora.AutomationExerciseProject.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import AbstractComponents.AbstractComponent;

public class AddressDetailsPage extends AbstractComponent {
	WebDriver driver;
	public WebDriverWait wait;
	 
	 public AddressDetailsPage(WebDriver driver) {
	        super(driver);
	        this.driver = driver;
	        PageFactory.initElements(driver, this);
	        handleAdsAfterPageLoad();   
	 }
	 By deliveraddresstext =By.xpath("//h3[text()='Your delivery address']");
	 By reviewordertext =By.xpath("//h2[text()='Review Your Order']");
	 
	 @FindBy(xpath="//textarea[@name='message']")
	 WebElement messagebox;
	 
	 @FindBy(xpath="//a[text()='Place Order']")
	 WebElement placeorderbtn;
	 
	 public void verifydeliveryaddress() {
	    String text=driver.findElement(deliveraddresstext).getText();
	  Assert.assertEquals(text,"YOUR DELIVERY ADDRESS");
	  }
	 
	 public void verifyreviewOrder() {
		 WebElement reviewtext=driver.findElement(reviewordertext);
		 getScroll(reviewtext);
		    String text=driver.findElement(reviewordertext).getText();
		  Assert.assertEquals(text,"Review Your Order");
		  }
	 
	 
	 public PaymentPage sendmessage() {
		 messagebox.sendKeys("satisfied as a customer,nice service");
		 placeorderbtn.click();
		 return new PaymentPage(driver);
	 }
	 
	 
}
