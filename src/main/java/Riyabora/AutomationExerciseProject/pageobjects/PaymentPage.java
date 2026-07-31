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

public class PaymentPage extends AbstractComponent {
	WebDriver driver;
	public WebDriverWait wait;

	public PaymentPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
		 handleAdsAfterPageLoad();
	}

	By deleteAccount = By.cssSelector("a[href='/delete_account']");

	@FindBy(xpath = "//input[@data-qa='name-on-card']")
	WebElement nameoncard;

	@FindBy(xpath = "//input[@data-qa='card-number']")
	WebElement cardnumber;

	@FindBy(xpath = "//input[@data-qa='cvc']")
	WebElement cvc;

	@FindBy(xpath = "//input[@data-qa='expiry-month']")
	WebElement expirationmonth;

	@FindBy(xpath = "//input[@data-qa='expiry-year']")
	WebElement expirationyear;

	@FindBy(xpath = "//button[@data-qa='pay-button']")
	WebElement paybtn;

	@FindBy(xpath = "//div[@id='success_message']//div[contains(@class,'alert-success')]")
	WebElement msg;

	public void enterPaymentDetails() {
		nameoncard.sendKeys("Riya");
		cardnumber.sendKeys("1800456790");
		cvc.sendKeys("343");
		expirationmonth.sendKeys("07");
		expirationyear.sendKeys("2027");
	}

	public OrderConfirmationPage payconfirmbtn() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("document.querySelectorAll('.adsbygoogle,.grippy-host').forEach(e => e.remove());");
		waitForElementToBeClickable(paybtn);
		paybtn.click();
		return new OrderConfirmationPage(driver);
	}

	public void paymentconfirmsgverify() {
	    JavascriptExecutor js = (JavascriptExecutor) driver;
    	js.executeScript("document.querySelectorAll('.adsbygoogle,.grippy-host').forEach(e => e.remove());");
		waitForElementToBeClickable(paybtn);
		paybtn.click();
		String text = msg.getText();
		Assert.assertEquals(text, "Your order has been placed successfully!");
	}

	public AccountdeletePage clickDeleteAccount() {
		 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

		    WebElement deleteBtn = wait.until(
		        ExpectedConditions.elementToBeClickable(deleteAccount));

		    deleteBtn.click();


		return new AccountdeletePage(driver);
	}

}
