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

public class SignUpInfoPage extends AbstractComponent {
	WebDriver driver;
	public WebDriverWait wait;
	 
	 public SignUpInfoPage(WebDriver driver) {
	        super(driver);
	        this.driver = driver;
	        PageFactory.initElements(driver, this);
	        handleAdsAfterPageLoad(); 
	 }

	By signupIfoPage = By.xpath("//b[text()='Enter Account Information']");
	By gender= By.id("id_gender2");
	By pass=By.id("password");
	By newsletter= By.id("newsletter");
	By Option=By.id("optin");
	By firstname=By.id("first_name");
	By lastname=By.id("last_name");
	By Company=By.id("company");
	By Address1=By.cssSelector("#address1");
	By Address2=By.cssSelector("#address2");
	By State=By.cssSelector("#state");
	By City= By.cssSelector("#city");
	By Code=By.cssSelector("#zipcode");
	By Phoneno=By.cssSelector("#mobile_number");
	
	@FindBy(id="days")
	WebElement day;
	
	@FindBy(id="months")
	WebElement months ;
	
	@FindBy(id="years")
	WebElement years;
	
	@FindBy(id="country")
	WebElement countryDropdown;
	
	@FindBy(css = "button[data-qa='create-account']")
	WebElement createaccount;
	
 public void verifysignupInfoPage() {
	String signinfoverify= driver.findElement(signupIfoPage).getText();
	 Assert.assertEquals(signinfoverify, "ENTER ACCOUNT INFORMATION");
 }

 public SignupAccountCreatedPage fillAccountInformation(String password,String firstName,String lastName,String company,String address1,String address2,String state,String city,String zipCode,String mobile) {
	driver.findElement(gender).click();
	driver.findElement(pass).sendKeys(password);	
	getselectByVisibleText(day, "17");
	getselectByVisibleText(months, "July");
	getselectByVisibleText(years, "2003");
	driver.findElement(newsletter).click();
	driver.findElement(Option).click();
	driver.findElement(firstname).sendKeys(firstName);
	driver.findElement(lastname).sendKeys(lastName);
	driver.findElement(Company).sendKeys(company);
	driver.findElement(Address1).sendKeys(address1);
	getselectByVisibleText(countryDropdown, "India");
	driver.findElement(State).sendKeys(state);
	driver.findElement(City).sendKeys(city);
	driver.findElement(Code).sendKeys(zipCode);
	driver.findElement(Phoneno).sendKeys(mobile);
	
	createaccount.click();
	return new SignupAccountCreatedPage(driver);
 }




}
