package Riyabora.AutomationExerciseProject.Tests;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import Riyabora.AutomationExerciseProject.TestComponents.BaseTest;
import Riyabora.AutomationExerciseProject.pageobjects.HomePage;
import Riyabora.AutomationExerciseProject.pageobjects.SignUpInfoPage;
import Riyabora.AutomationExerciseProject.pageobjects.SignupAccountCreatedPage;
import Riyabora.AutomationExerciseProject.pageobjects.LoginSignupPage;

public class RegisterUsertest extends BaseTest {
	
	@Test
	public void registerUserTest()  {
		 String email = "riya" + System.currentTimeMillis() + "@gmail.com";
		    String password = "riya123";
		    String userName = "RIYA";

		    String firstName = "Riya";
		    String lastName = "Bora";
		    String company = "Redhu Tech";
		    String address1 = "A-301";
		    String address2 = "Omicron Society";
		    String state = "UP";
		    String city = "Greater Noida";
		    String zipCode = "201310";
		    String mobile = "9837567192";
		    
		LoginSignupPage loginsignupPage = homePage.verifyhomepage().clicksignin_login();	
		loginsignupPage.verifysigninpage();
		loginsignupPage.enterSignupDetails(userName, email);
		SignUpInfoPage signUpInfoPage=loginsignupPage.clickSignup();
		signUpInfoPage.verifysignupInfoPage();
		SignupAccountCreatedPage signupAccountCreatedPage=	signUpInfoPage.fillAccountInformation(password, firstName, lastName, company, address1, address2, state, city, zipCode, mobile);

		signupAccountCreatedPage.verifyAccountCreated();
		homePage=signupAccountCreatedPage.clickcontinuebtn();
		assertTrue(homePage.isLoggedIn());
		homePage.clickDeleteAccount();
		assertEquals(homePage.getAccountDeletedMessage(), "ACCOUNT DELETED!");
		homePage.clickContinue();
		
	}
}
