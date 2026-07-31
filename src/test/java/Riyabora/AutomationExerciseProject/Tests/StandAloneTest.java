package Riyabora.AutomationExerciseProject.Tests;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class StandAloneTest {

	@Test
	public void  firstscriptTest() {
		// TODO Auto-generated method stub
         String email="riya"+ System.currentTimeMillis() +"@gmail.com";
         String Password="riya123";
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://automationexercise.com");
		//HomePage homePage=new HomePage(driver);
		//homePage.verifyhomePage();
		
		//homePage.clicksignin();
			//SignupPage signupPage= new SignupPage(driver);
		     //signupPage.verifysigninpage();
		//signupPage.enterSignupDetails();
		//signupPage.clickSignup();
		
	    String homePageHeading=driver.findElement(By.xpath("//h2[text()='Full-Fledged practice website for Automation Engineers']")).getText();
		Assert.assertEquals(homePageHeading, "Full-Fledged practice website for Automation Engineers");
		driver.findElement(By.cssSelector("a[href='/login']")).click();
		//verify signin
		
		String signin=driver.findElement(By.xpath("//h2[contains(text(),'New User Signup')]")).getText();
		Assert.assertEquals(homePageHeading, "New User Signup");
		driver.findElement(By.cssSelector("input[data-qa='signup-name']")).sendKeys("Riya");
		driver.findElement(By.cssSelector("input[data-qa='signup-email']")).sendKeys(email);
		
		//driver.findElement(By.cssSelector("button[type='submit']")).click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		WebElement signupBtn = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button[data-qa='signup-button']")));
		signupBtn.click();
		//done
		String signupPageHeading = driver.findElement(By.xpath("//b[text()='Enter Account Information']")).getText();
		Assert.assertEquals(signupPageHeading, "ENTER ACCOUNT INFORMATION" );
		driver.findElement(By.id("id_gender2")).click();
		driver.findElement(By.id("password")).sendKeys(Password);
		
		Select dateDropdown = new Select(driver.findElement(By.id("days")));
		dateDropdown.selectByVisibleText("17");

		Select monthDropdown = new Select(driver.findElement(By.id("months")));
		monthDropdown.selectByVisibleText("July");

		Select yearDropdown = new Select(driver.findElement(By.id("years")));
		yearDropdown.selectByVisibleText("2003");
		
		driver.findElement(By.id("newsletter")).click();
		driver.findElement(By.id("optin")).click();
		
		driver.findElement(By.id("first_name")).sendKeys("Riya");
		driver.findElement(By.id("last_name")).sendKeys("Bora");
		
		driver.findElement(By.id("company")).sendKeys("redhu tech");
		driver.findElement(By.cssSelector("#address1")).sendKeys("A-301");
		driver.findElement(By.cssSelector("#address2")).sendKeys("Omicron society");
		
		Select countryDropdown = new Select(driver.findElement(By.id("country")));
		 countryDropdown.selectByVisibleText("India");
		driver.findElement(By.cssSelector("#state")).sendKeys("UP");
		driver.findElement(By.cssSelector("#city")).sendKeys("G.noida");
		driver.findElement(By.cssSelector("#zipcode")).sendKeys("201310");
		driver.findElement(By.cssSelector("#mobile_number")).sendKeys("9837567192");
		//driver.findElement(By.cssSelector("button[type='submit']")).click();
		driver.findElement(By.cssSelector("button[data-qa='create-account']")).click();
		//verify account created
		String accountcreated=driver.findElement(By.xpath("//b[text()='Account Created!']")).getText();
		Assert.assertEquals(accountcreated, "ACCOUNT CREATED!");
		driver.findElement(By.cssSelector("a[data-qa='continue-button']")).click();
		//. Verify that 'Logged in as username' is visible
		wait.until(ExpectedConditions.visibilityOfElementLocated(
		        By.xpath("//a[contains(text(),'Logged in as')]")));

		Assert.assertTrue(driver.findElement(
		        By.xpath("//a[contains(text(),'Logged in as')]"))
		        .isDisplayed());
		
		//delete account 
		driver.findElement(By.cssSelector("a[href='/delete_account']")).click();
		String deleteAccount=driver.findElement(By.xpath("//b[text()='Account Deleted!']")).getText();
		Assert.assertEquals(deleteAccount, "ACCOUNT DELETED!");
		driver.findElement(By.cssSelector("a[data-qa='continue-button']")).click();

		driver.quit();
				
	}

}
