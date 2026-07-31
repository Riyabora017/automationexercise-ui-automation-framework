package Riyabora.AutomationExerciseProject.pageobjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import AbstractComponents.AbstractComponent;

public class SignupAccountCreatedPage extends AbstractComponent {
	WebDriver driver;
	public WebDriverWait wait;
	 
	public SignupAccountCreatedPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		  PageFactory.initElements(driver, this);
		  handleAdsAfterPageLoad();
	}
	By AccountCreated = By.xpath("//b[text()='Account Created!']");
    By clickaccountcontinue= By.cssSelector("a[data-qa='continue-button']");

	
 public void verifyAccountCreated() {
	 handleGoogleVignette();
	String accountcreatedverify= driver.findElement(AccountCreated).getText();
		Assert.assertEquals(accountcreatedverify, "ACCOUNT CREATED!");
		// System.out.println(driver.getCurrentUrl());
 }
 public HomePage clickcontinuebtn() {
	System.out.println(driver.getCurrentUrl());
	waitForElementToBeClickable(clickaccountcontinue);
	// driver.findElement(clickaccountcontinue).click();
	 handleGoogleVignette();
	 driver.findElement(clickaccountcontinue).click();
		 return new HomePage(driver);
 }
 




}
