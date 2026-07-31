package Riyabora.AutomationExerciseProject.Tests;

import org.testng.annotations.Test;

import Riyabora.AutomationExerciseProject.TestComponents.BaseTest;

public class HomePageValidationTest extends BaseTest {

	@Test
	public void verifyScrollUpUsingArrowButton() {
	homePage.verifyhomepage();
	homePage.scrollandverifySubscription();
	homePage.clickScrollupArrow();
	homePage.verifyhomepage();
	}
	@Test
	public void verifyScrollUpWithoutArrowButton() {
		homePage.verifyhomepage();
		homePage.scrollandverifySubscription();		
		homePage.scrollToTop();
		homePage.verifyhomepage();
	}
	}
