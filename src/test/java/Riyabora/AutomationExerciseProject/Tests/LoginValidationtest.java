package Riyabora.AutomationExerciseProject.Tests;

import static org.testng.Assert.assertTrue;

import java.util.HashMap;

import org.testng.annotations.Test;

import Riyabora.AutomationExerciseProject.TestComponents.BaseTest;
import Riyabora.AutomationExerciseProject.TestComponents.LoginDataProvider;
import Riyabora.AutomationExerciseProject.UserFlows.User;
import Riyabora.AutomationExerciseProject.pageobjects.AccountdeletePage;
import Riyabora.AutomationExerciseProject.pageobjects.AddressDetailsPage;
import Riyabora.AutomationExerciseProject.pageobjects.CartPage;
import Riyabora.AutomationExerciseProject.pageobjects.LoginSignupPage;
import Riyabora.AutomationExerciseProject.pageobjects.PaymentPage;

public class LoginValidationtest extends BaseTest {

    @Test
	  public void loginWithCorrectEmailAndPassword() {
    	User user = registerUser();
        assertTrue(homePage.isLoggedIn());
        LoginSignupPage loginSignupPage = homePage.clickLogout();
        loginSignupPage.verifyLoginPage();
        loginSignupPage.enterLoginDetails(user.getEmail(), user.getPassword());
        loginSignupPage.clicklogin();
    	assertTrue(homePage.isLoggedIn());
		homePage.clickDeleteAccount();
		assertTrue(homePage.getAccountDeletedMessage().equalsIgnoreCase("ACCOUNT DELETED!"));

	}	
	
    @Test(dataProvider = "invalidLoginData", dataProviderClass = LoginDataProvider.class)
	    public void loginWithIncorrectEmailAndPassword(HashMap<String, String> input) {
	    	LoginSignupPage loginsignupPage = homePage.verifyhomepage().clicksignin_login();		
	    	loginsignupPage.verifyLoginPage();
	    	loginsignupPage.enterLoginDetails(input.get("email"),input.get("password"));
	    	loginsignupPage.clicklogin();
	    	loginsignupPage.verifywrongcredential();
	    	    	
	    }

       @Test(dataProvider = "validLoginData", dataProviderClass = LoginDataProvider.class)
       public void logoutUser(HashMap<String, String> input) {
	        // Test Case 4
	    	        
	        LoginSignupPage loginsignupPage = homePage.verifyhomepage().clicksignin_login();		
	    	loginsignupPage.verifyLoginPage();
	    	loginsignupPage.enterLoginDetails(input.get("email"),input.get("password"));
	    	loginsignupPage.clicklogin();
	    	assertTrue(homePage.isLoggedIn());
	    	loginsignupPage=homePage.clickLogout();
	    	loginsignupPage.verifyLoginPage();
	    }
	    
	    @Test
	    public void LoginbeforeCheckout() {
	    	User user = registerUser();
	        assertTrue(homePage.isLoggedIn());
	        LoginSignupPage loginSignupPage = homePage.clickLogout();
	        loginSignupPage.verifyLoginPage();
	        loginSignupPage.enterLoginDetails(user.getEmail(), user.getPassword());
	        loginSignupPage.clicklogin();
	        homePage.isLoggedIn();
	        homePage.addtocart();
	        CartPage cartPage=homePage.clickcartbtn();
	         //cartPage.verifycartPage();
	        AddressDetailsPage addressDetailsPage= cartPage.clickproceedbtn();
	        addressDetailsPage.verifydeliveryaddress();
	        addressDetailsPage.verifyreviewOrder();
	        PaymentPage paymentPage= addressDetailsPage.sendmessage();
	        paymentPage.enterPaymentDetails();
	        paymentPage.payconfirmbtn();
	        AccountdeletePage accountdeletePage=paymentPage.clickDeleteAccount();
	        accountdeletePage.clickcontinue();
  }

	
}
