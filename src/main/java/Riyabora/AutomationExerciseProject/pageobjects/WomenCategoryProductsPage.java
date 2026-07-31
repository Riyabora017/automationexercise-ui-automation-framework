package Riyabora.AutomationExerciseProject.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import AbstractComponents.AbstractComponent;

public class WomenCategoryProductsPage extends AbstractComponent {
	WebDriver driver;
	public WebDriverWait wait;
	 
	 public WomenCategoryProductsPage(WebDriver driver) {
	        super(driver);
	        this.driver = driver;
	        PageFactory.initElements(driver, this);
	        handleAdsAfterPageLoad();  
	 }
	 By element=By.xpath("//h2[@class='title text-center']");
	 
	 @FindBy(css="a[href='#Men']")
     WebElement men;
	
	 @FindBy(css="a[href='/category_products/3']")
     WebElement Tshirts;
	

	 public void verifycategoryproductPage() {
	  Assert.assertTrue(driver.getCurrentUrl().contains("/category_products/"));
	}
	 public void confirmCategoryHeading()  {
		 WebElement heading =driver.findElement(element);
		 waitForElementToAppear(heading);
		    Assert.assertEquals(heading.getText().trim().toUpperCase(), "WOMEN -  DRESS PRODUCTS");
		 }
	 public MenCategoryProductsPage  clickmensubcategories() {
		 System.out.println(driver.getCurrentUrl());
		 men.click();
		 waitForElementToAppear(Tshirts);      // pehle visible hone do
		
		 waitForElementToBeClickable(Tshirts);
		 Tshirts.click();
		return new MenCategoryProductsPage(driver);
	 }
	 

}