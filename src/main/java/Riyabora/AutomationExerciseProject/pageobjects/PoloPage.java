package Riyabora.AutomationExerciseProject.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import AbstractComponents.AbstractComponent;

public class PoloPage extends AbstractComponent {
	WebDriver driver;
	public WebDriverWait wait;
	 
	 public PoloPage(WebDriver driver) {
	        super(driver);
	        this.driver = driver;
	        PageFactory.initElements(driver, this);
	        handleAdsAfterPageLoad();
	    }
// By PolocenterText = By.xpath("//h2[contains(.,'Brand - Polo Products')]");
	 By PolocenterText = By.xpath("//div[@class='features_items']/h2");
//	 public PoloPage verifytestcasePage() {
//	     waitForElementToAppear(TestcasePageText);
//		 String text=driver.findElement(TestcasePageText).getText();
//	  Assert.assertEquals(text, "TEST CASES");
//	  return new PoloPage (driver);
//	  }
	 
	 public void verifyPoloPage() {

	     waitForElementToAppear(PolocenterText);
		 String text=driver.findElement(PolocenterText).getText();
		  System.out.println("Heading: " + text);
		 Assert.assertEquals(text, "BRAND -  Polo PRODUCTS");
		 List<WebElement> products = driver.findElements(By.xpath("//div[@class='features_items']//div[@class='product-image-wrapper']"));
		 Assert.assertTrue(products.size() > 0, "No products are displayed.");
	  }
	 }
