package Riyabora.AutomationExerciseProject.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import AbstractComponents.AbstractComponent;

public class TestCasesPage extends AbstractComponent {
	WebDriver driver;
	public WebDriverWait wait;
	 
	 public TestCasesPage(WebDriver driver) {
	        super(driver);
	        this.driver = driver;
	        PageFactory.initElements(driver, this);
	        handleAdsAfterPageLoad();   
	 }
	 By TestcasePageText = By.xpath("//b[text()='Test Cases']");
	//h2[@class='title text-center']/b
	 public TestCasesPage verifytestcasePage() {
		 System.out.println(driver.getCurrentUrl());	  
		 waitForElementToAppear(TestcasePageText);
		 String text=driver.findElement(TestcasePageText).getText();
	  Assert.assertEquals(text, "TEST CASES");
	  return new TestCasesPage (driver);
	  }}
