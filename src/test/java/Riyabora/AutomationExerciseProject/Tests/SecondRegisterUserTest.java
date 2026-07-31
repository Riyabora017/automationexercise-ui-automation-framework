package Riyabora.AutomationExerciseProject.Tests;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import Riyabora.AutomationExerciseProject.TestComponents.BaseTest;
import Riyabora.AutomationExerciseProject.UserFlows.User;
import Riyabora.AutomationExerciseProject.pageobjects.AccountdeletePage;
import Riyabora.AutomationExerciseProject.pageobjects.AddressDetailsPage;
import Riyabora.AutomationExerciseProject.pageobjects.CartPage;
import Riyabora.AutomationExerciseProject.pageobjects.LoginSignupPage;
import Riyabora.AutomationExerciseProject.pageobjects.OrderConfirmationPage;
import Riyabora.AutomationExerciseProject.pageobjects.PaymentPage;
import Riyabora.AutomationExerciseProject.pageobjects.SignUpInfoPage;
import Riyabora.AutomationExerciseProject.pageobjects.SignupAccountCreatedPage;

public class SecondRegisterUserTest extends BaseTest {
	String email = "shivi" + System.currentTimeMillis() + "@gmail.com";
	String password = "shivi123";
	String userName = "SHIVI";

	String firstName = "Shivi";
	String lastName = "Bora";
	String company = "xyz";
	String address1 = "D-16";
	String address2 = "ABC Society";
	String state = "UP";
	String city = "Greater Noida";
	String zipCode = "201315";
	String mobile = "7042415769";
	
	@Test
	public void registerUserTest() {

	    User user = registerUser();

	    assertTrue(homePage.isLoggedIn());

	    homePage.clickDeleteAccount();

	    assertEquals(homePage.getAccountDeletedMessage(), "ACCOUNT DELETED!");

	    homePage.clickContinue();
	}
	
	@Test
	public void alreadyRegister() {
		   	LoginSignupPage loginsignupPage = homePage.verifyhomepage().clicksignin_login();		
			loginsignupPage.verifysigninpage();
			loginsignupPage.enterSignupDetails("Riya Bora","borariya982@gmail.com" );
			loginsignupPage.clickSignup();
			loginsignupPage.emailalreadyexisttext();
					
	}
	@Test
	public void RegisterwhileCheckoutTest() {
		homePage.verifyhomepage();
		homePage.addtocart();
		CartPage cartPage = homePage.clickcartbtn();

		cartPage.verifycartPage();
		LoginSignupPage loginSignupPage = cartPage.clickloginsignBtn();
		loginSignupPage.verifysigninpage();

		loginSignupPage.enterSignupDetails(userName, email);

		SignUpInfoPage signUpInfoPage = loginSignupPage.clickSignup();

		signUpInfoPage.verifysignupInfoPage();

		SignupAccountCreatedPage accountCreatedPage =
		        signUpInfoPage.fillAccountInformation(password,
		                firstName,
		                lastName,
		                company,
		                address1,
		                address2,
		                state,
		                city,
		                zipCode,
		                mobile);

		accountCreatedPage.verifyAccountCreated();

		homePage = accountCreatedPage.clickcontinuebtn();
		assertTrue(homePage.isLoggedIn());
		 cartPage=homePage.clickheaderCartbtn();
		 AddressDetailsPage addressDetailsPage=cartPage.clickproceedbtn();
		 addressDetailsPage.verifydeliveryaddress();
		 addressDetailsPage.verifyreviewOrder();
		 PaymentPage paymentPage=addressDetailsPage.sendmessage();
		 paymentPage.enterPaymentDetails();
		 OrderConfirmationPage orderConfirmationPage= paymentPage.payconfirmbtn();
//		paymentPage.paymentconfirmsgverify();
		orderConfirmationPage.orderconfirmsg();
		homePage=orderConfirmationPage.clickbtn();
		homePage.clickDeleteAccount();
	}

	@Test
	public void  RegisterbeforeCheckout() {
   	LoginSignupPage loginsignupPage = homePage.verifyhomepage().clicksignin_login();
   	loginsignupPage.enterSignupDetails(userName, email);
   	
   			SignUpInfoPage signUpInfoPage = loginsignupPage.clickSignup();
   	
   			signUpInfoPage.verifysignupInfoPage();
   	
   			SignupAccountCreatedPage accountCreatedPage =
   			        signUpInfoPage.fillAccountInformation(password,
   			                firstName,
   			                lastName,
   			                company,
   			                address1,
   			                address2,
   			                state,
   			                city,
   			                zipCode,
   			                mobile);
   	
   			accountCreatedPage.verifyAccountCreated();
   	
   			homePage = accountCreatedPage.clickcontinuebtn();
   			assertTrue(homePage.isLoggedIn());
   			homePage.addtocart();
   			CartPage cartPage=homePage.clickheaderCartbtn(); 
   			AddressDetailsPage addressDetailsPage=cartPage.clickproceedbtn();
   			addressDetailsPage.verifydeliveryaddress();
   			addressDetailsPage.verifyreviewOrder();
   			PaymentPage paymentPage=addressDetailsPage.sendmessage();
   			paymentPage.enterPaymentDetails();
   			OrderConfirmationPage orderConfirmationPage	= paymentPage.payconfirmbtn();
   			 //paymentPage.paymentconfirmsgverify();
   			AccountdeletePage accountdeletePage=orderConfirmationPage.clickDeleteAccount();

	}
	}

