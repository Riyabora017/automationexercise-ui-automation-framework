package Riyabora.AutomationExerciseProject.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import AbstractComponents.AbstractComponent;

public class ProductDetailsPage extends AbstractComponent {
	WebDriver driver;
	public WebDriverWait wait;
	 
	 public ProductDetailsPage(WebDriver driver) {
	        super(driver);
	        this.driver = driver;
	        PageFactory.initElements(driver, this);
	        handleAdsAfterPageLoad();   
	 }
	 By productName = By.xpath("//div[@class='product-information']/h2");
	 By category = By.xpath("//div[@class='product-information']/p[contains(text(),'Category')]");
	 By price = By.xpath("//div[@class='product-information']//span/span");
	 By availability = By.xpath("//b[text()='Availability:']");
	 By condition = By.xpath("//b[text()='Condition:']");
	 By brand = By.xpath("//b[text()='Brand:']");
	
	 By quantity = By.id("quantity");
	
	 By review=By.xpath("//a[@data-toggle='tab']");
	
	 By reviewformname=By.cssSelector("#name");
	 By reviewformemail=By.cssSelector("#email");
	 By reviewformreviewtext=By.cssSelector("textarea[name='review']");
	 
	 By msg = By.xpath("//span[contains(text(),'Thank you for your review.')]");
	
	 @FindBy(css = "#button-review")
	 WebElement Submitbtn;
	 
	 @FindBy(css = "button.btn.btn-default.cart")
	 WebElement addToCartBtn;
	 
	 @FindBy(xpath="//u[text()='View Cart']")
	 WebElement viewcartbtn;
	 
	 
	 
	 
	 public void verifyProductDetails() throws InterruptedException {
            Thread.sleep(3000);
		    Assert.assertTrue(driver.findElement(productName).isDisplayed());
		    Assert.assertTrue(driver.findElement(category).isDisplayed());
		    Assert.assertTrue(driver.findElement(price).isDisplayed());
		    Assert.assertTrue(driver.findElement(availability).isDisplayed());
		    Assert.assertTrue(driver.findElement(condition).isDisplayed());
		    Assert.assertTrue(driver.findElement(brand).isDisplayed());
		}
	 public void verifyProductDetailsPage() throws InterruptedException {
	
		  //System.out.println(driver.getCurrentUrl());
		  Assert.assertTrue(driver.getCurrentUrl().contains("/product_details/"));
		}
	 public void increaseQuantity(String qty) {
		    WebElement quantityBox = driver.findElement(quantity);
		    quantityBox.clear();
		    quantityBox.sendKeys(qty);
		}
	 public  void clickaddtocart() {
		 addToCartBtn.click();
		
	 }
	 public CartPage viewCart() {
		 waitForElementToAppear(viewcartbtn);
		viewcartbtn.click();
		 return new CartPage(driver);
	 }
	public void verifywriteyourreview() {
		String text=driver.findElement(review).getText();
		Assert.assertEquals(text, "WRITE YOUR REVIEW");
	}
	 public void enterReview(String name,String email,String reviewtext) {
		 driver.findElement(reviewformname).sendKeys(name);
		 driver.findElement(reviewformemail).sendKeys(email);
		 driver.findElement(reviewformreviewtext).sendKeys(reviewtext);
		 Submitbtn.click();
	 }
	 public void verifysuccessreviewmsg() {
			String text=driver.findElement(review).getText();
			Assert.assertEquals(text, "WRITE YOUR REVIEW");
		}
	 public void verifysuccessfullyreviewaddmsg() {
		 String text=driver.findElement(msg).getText();
		 Assert.assertEquals(text, "Thank you for your review.");
	 }
	}
