package Riyabora.AutomationExerciseProject.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import AbstractComponents.AbstractComponent;

public class HNMPage extends AbstractComponent {
	WebDriver driver;
	
	 
	 public HNMPage(WebDriver driver) {
	        super(driver);
	        this.driver = driver;
	        PageFactory.initElements(driver, this);
	        handleAdsAfterPageLoad();   
	 }
	By HNMcenterText = By.xpath("//h2[contains(text(),'Brand - H&M Products')]");
	

	@FindBy(xpath = "//a[@href='/brand_products/Polo']")
	WebElement polobtn;
	

	 public void verifyHnmPage() {
	     waitForElementToAppear(HNMcenterText);
		 String text=driver.findElement(HNMcenterText).getText();
		 Assert.assertEquals(text, "BRAND - H&M PRODUCTS");
		 List<WebElement> products = driver.findElements(By.xpath("//div[@class='features_items']//div[@class='product-image-wrapper']"));
		 Assert.assertTrue(products.size() > 0, "No products are displayed.");
	  }
public PoloPage clickPolo() {
	waitForElementToAppear(polobtn);
	polobtn.click();
	return new PoloPage(driver);
}	 
}
