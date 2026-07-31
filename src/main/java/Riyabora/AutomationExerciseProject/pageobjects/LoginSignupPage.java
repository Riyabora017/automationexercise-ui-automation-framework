package Riyabora.AutomationExerciseProject.pageobjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import AbstractComponents.AbstractComponent;

public class LoginSignupPage extends AbstractComponent {
	WebDriver driver;
	public WebDriverWait wait;
	 
	public LoginSignupPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		  PageFactory.initElements(driver, this);
		  handleAdsAfterPageLoad();
	}
	 By signintext=By.xpath("//h2[contains(text(),'New User Signup')]");
	  By name = By.cssSelector("input[data-qa='signup-name']");
	  By email = By.cssSelector("input[data-qa='signup-email']");
	   By signupButton = By.cssSelector("button[data-qa='signup-button']");
	   
       By logintext=By.xpath("//h2[text()='Login to your account']");
	   By loginEmail=By.cssSelector("input[data-qa='login-email']");
	   By loginPass=By.cssSelector("input[data-qa='login-password']");
       By loginButton=By.cssSelector("button[data-qa='login-button']");
	 
       By wrongcredentialMessage=By.xpath("//p[text()='Your email or password is incorrect!']");
       By alreadyExist= By.xpath("//p[text()='Email Address already exist!']");
       public void verifysigninpage() {
	String signin= driver.findElement(signintext).getText();
	 Assert.assertEquals(signin, "New User Signup!");
 }

 public void enterSignupDetails(String userName, String userEmail) {
     driver.findElement(name).sendKeys(userName);
     driver.findElement(email).sendKeys(userEmail);
 }
 public SignUpInfoPage clickSignup() {
	    wait.until(ExpectedConditions.elementToBeClickable(signupButton)).click();
	    return new SignUpInfoPage(driver);
	}
 public LoginPage verifyLoginPage() {
	 String login=driver.findElement(logintext).getText();
	 Assert.assertEquals(login, "Login to your account");
	return new LoginPage(driver);
	 
 }
  public void enterLoginDetails(String email, String password) {
	  driver.findElement(loginEmail).sendKeys(email);
	  driver.findElement(loginPass).sendKeys(password);
	  
  }
  public HomePage clicklogin(){

	  wait.until(ExpectedConditions.elementToBeClickable(loginButton)).click();
	  handleGoogleVignette();
	    return new HomePage(driver);
	}
 public void verifywrongcredential() {
	 String errormessage=driver.findElement(wrongcredentialMessage).getText();
      Assert.assertEquals(errormessage, "Your email or password is incorrect!");
 }
  
 public void emailalreadyexisttext() {
	 String errormessage=driver.findElement(alreadyExist).getText();
     Assert.assertEquals(errormessage, "Email Address already exist!");
 }
 

}
