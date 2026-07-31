package Riyabora.AutomationExerciseProject.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import AbstractComponents.AbstractComponent;

public class OrderConfirmationPage extends AbstractComponent {
	WebDriver driver;
	public WebDriverWait wait;
	 
	 public OrderConfirmationPage(WebDriver driver) {
	        super(driver);
	        this.driver = driver;
	        PageFactory.initElements(driver, this);
	        handleAdsAfterPageLoad();   
	 }
	 
	By deleteAccount = By.cssSelector("a[href='/delete_account']");
	 
	 @FindBy(xpath = "//p[contains(text(),'Congratulations! Your order has been confirmed!')]")
	 WebElement msg;

	 
	 @FindBy(xpath="//a[@data-qa='continue-button']")
	 WebElement continuebtn;


	
	 
	//h2[@class='title text-center']/b
	 public void orderconfirmsg() {

		    String actualText = msg.getText().trim();

		    Assert.assertEquals(
		        actualText,
		        "Congratulations! Your order has been confirmed!"
		    );
		}
	 public HomePage clickbtn() {
		 continuebtn.click();
		 return new HomePage(driver);
	 }
	 public AccountdeletePage clickDeleteAccount() {
		    driver.findElement(deleteAccount).click();
	return new AccountdeletePage(driver);	
	 }
	 
	 
}




