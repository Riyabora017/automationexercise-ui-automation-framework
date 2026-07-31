package Riyabora.AutomationExerciseProject.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import AbstractComponents.AbstractComponent;

public class MenCategoryProductsPage extends AbstractComponent {
	WebDriver driver;
	public WebDriverWait wait;
	 
	 public MenCategoryProductsPage(WebDriver driver) {
	        super(driver);
	        this.driver = driver;
	        PageFactory.initElements(driver, this);
	        handleAdsAfterPageLoad();   
	 }
	 By element=By.xpath("//h2[@class='title text-center']");
	public void verifytexttitle() {
		WebElement heading =driver.findElement(element);
		 waitForElementToAppear(heading);
		    Assert.assertEquals(heading.getText().trim().toUpperCase(), "MEN - TSHIRTS PRODUCTS");
	
	}
	 
	 
	
		
	 
	 

}