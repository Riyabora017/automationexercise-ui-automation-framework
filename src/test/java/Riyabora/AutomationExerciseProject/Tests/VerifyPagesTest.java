package Riyabora.AutomationExerciseProject.Tests;

import org.testng.annotations.Test;

import Riyabora.AutomationExerciseProject.TestComponents.BaseTest;
import Riyabora.AutomationExerciseProject.pageobjects.ContactUsPage;
import Riyabora.AutomationExerciseProject.pageobjects.HomePage;
import Riyabora.AutomationExerciseProject.pageobjects.TestCasesPage;

public class VerifyPagesTest extends BaseTest {
     
	@Test
	public void verifyContactUsTest() {
		ContactUsPage contactUsPage=homePage.verifyhomepage().clickContactUs();
		contactUsPage.verifyContactPage();
		HomePage homePage=contactUsPage.enterContactInfo("Riya","riya@gmail.com","Contact Subject","This is a test message","C:\\Users\\LENOVO\\Desktop\\important document\\email.png");
		  homePage.verifyhomepage();
	}		

@Test
public void verifytestcasePageTest() {
	TestCasesPage testCasePage=homePage.verifyhomepage().clickTestcases();
	testCasePage.verifytestcasePage();
}
}