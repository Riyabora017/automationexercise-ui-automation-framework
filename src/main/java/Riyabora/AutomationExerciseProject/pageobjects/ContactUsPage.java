package Riyabora.AutomationExerciseProject.pageobjects;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import AbstractComponents.AbstractComponent;

public class ContactUsPage extends AbstractComponent {
	WebDriver driver;
	public WebDriverWait wait;
	 
	 public ContactUsPage(WebDriver driver) {
	        super(driver);
	        this.driver = driver;
	        PageFactory.initElements(driver, this);
	        handleAdsAfterPageLoad();   
	 }

	By contactusText = By.xpath("//h2[text()='Get In Touch']");
	By ContactName=By.cssSelector("input[data-qa='name']");
	By  ContactEmail= By.cssSelector("input[data-qa='email']");
	By ContactSubject =By.cssSelector("input[data-qa='subject']");
	By ContactMessage =By.cssSelector("textarea[data-qa='message']");
    By uploadbtn= By.cssSelector("input[class='form-control']");
	By submitbtn=By.cssSelector("input[data-qa='submit-button']");
    By textsuccessfullsubmit=By.xpath("//div[text()='Success! Your details have been submitted successfully.']");
	
    @FindBy(xpath = "//a[@href='/']")
    WebElement homebtn;
	
	
	
 public void verifyContactPage() {
	String ContactPageVerify= driver.findElement(contactusText).getText();
	 Assert.assertEquals(ContactPageVerify, "GET IN TOUCH");
 }
 
public HomePage enterContactInfo(String name,String email,String subject,String message,String filePath) {
		driver.findElement(ContactName).sendKeys(name);
 driver.findElement(ContactEmail).sendKeys(email);
 driver.findElement(ContactSubject).sendKeys(subject);
 driver.findElement(ContactMessage).sendKeys(message);
 driver.findElement(uploadbtn).sendKeys(filePath);
 driver.findElement(submitbtn).click();
 Alert a = driver.switchTo().alert();
 a.accept();
 String successtext= driver.findElement(textsuccessfullsubmit).getText();
 Assert.assertEquals(successtext, "Success! Your details have been submitted successfully.");
 homebtn.click();
 
 return  new HomePage(driver);
}}
