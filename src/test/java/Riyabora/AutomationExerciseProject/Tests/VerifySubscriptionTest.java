package Riyabora.AutomationExerciseProject.Tests;

import org.testng.annotations.Test;

import Riyabora.AutomationExerciseProject.TestComponents.BaseTest;
import Riyabora.AutomationExerciseProject.pageobjects.CartPage;

public class VerifySubscriptionTest extends BaseTest {

	@Test
	public void verifyhomePageSubscriptionTest() {
		homePage.verifyhomepage();
		homePage.scrollandverifySubscription();
		homePage.filldetailsforsubscription("borariya982@gmail.com");
		homePage.verifysubscriptionsuccesstext();
	}
	
	@Test
	public void verifycartPageSubscriptionTest() {
	CartPage cartPage=	homePage.verifyhomepage().clickheaderCartbtn();
	cartPage.scrollandverifySubscription();
	cartPage.filldetailsforsubscription("borariya982@gmail.com");
	cartPage.verifysubscriptionsuccesstext();
	}
	
}
