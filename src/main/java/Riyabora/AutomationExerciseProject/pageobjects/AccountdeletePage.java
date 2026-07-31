package Riyabora.AutomationExerciseProject.pageobjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import AbstractComponents.AbstractComponent;

public class AccountdeletePage extends AbstractComponent {
	WebDriver driver;
	public WebDriverWait wait;
	 
	 public AccountdeletePage(WebDriver driver) {
	        super(driver);
	        this.driver = driver;
	        PageFactory.initElements(driver, this);
	        handleAdsAfterPageLoad();
	 }
	 By deletemsg= By.xpath("//b[text()='Account Deleted!']");
	
	 
	 @FindBy(xpath="//a[@data-qa='continue-button']")
	 WebElement continuebtn;
	 

	
		
			  
	 public HomePage clickcontinue() {
		 
		  WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		    WebElement msg = wait.until(
		        ExpectedConditions.visibilityOfElementLocated(
		            By.xpath("//b[contains(text(),'Account Deleted')]")
		        )
		    );

		    Assert.assertTrue(msg.isDisplayed());
		    continuebtn.click();

		 return new HomePage(driver);
	 }
	 
	 
	 }
