package Riyabora.AutomationExerciseProject.pageobjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import AbstractComponents.AbstractComponent;

public class HomePage extends AbstractComponent {
	WebDriver driver;
	 
	public HomePage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		  PageFactory.initElements(driver, this);
		  handleAdsAfterPageLoad();
	}
	  By homePageHeading=By.xpath("//h2[text()='Full-Fledged practice website for Automation Engineers']");
	  By signupLogin = By.cssSelector("a[href='/login']");
	  By loggedInUser = By.xpath("//a[contains(text(),'Logged in as')]");
	  By deleteAccount = By.cssSelector("a[href='/delete_account']");
	  By accountDeleted = By.xpath("//b[text()='Account Deleted!']");
	  
	  By continueButton = By.cssSelector("a[data-qa='continue-button']");
      By logoutBtn = By.cssSelector("a[href='/logout']");
	  By contactUsBtn = By.cssSelector("a[href='/contact_us']");
	   By testcaseBtn= By.cssSelector("a[href='/test_cases']");
      By productBtn=By.cssSelector("a[href='/products']");
	   
      By subscriptiontext=By.xpath("//h2[text()='Subscription']");
      By subscriptionEmail=By.id("susbscribe_email");
      By subsriptionsuccesstext = By.cssSelector("div[class='alert-success alert']");
  	  By clickviewProduct1 = By.cssSelector("a[href='/product_details/1']");
      
  	By addToCartbtn = By.cssSelector(".product-overlay a.add-to-cart");
  	By popupViewCart = By.xpath("//div[@id='cartModal']//a[contains(@href,'view_cart')]");
  	
  	By element=By.xpath("//h2[text()='Category']");
  	
  	
  	@FindBy(xpath = "(//div[@class='product-image-wrapper'])[1]")
  	WebElement Product;
  	
  
      @FindBy(css = "div[class='single-widget']")
      WebElement footer;
      
      @FindBy(id="subscribe")
      WebElement subscriptionbtn;
      
      @FindBy(css="a[href='/view_cart']")
      WebElement cartheaderbtn;
      
      @FindBy(css="a[href='#Women']")
      WebElement women;
     
      @FindBy(css="a[href='/category_products/1']")
      WebElement dress;

      @FindBy(xpath = "//h2[contains(.,'recommended items')]")
      WebElement recommendedproduct;
      
      @FindBy(xpath="(//div[@class='recommended_items']//a[contains(@class,'add-to-cart')])[1]")
      WebElement addtocartrecommendedproduct;
      
      @FindBy(xpath = "//a[@id='scrollUp']")
      WebElement arrowScrollUp;
      
	   public HomePage verifyhomepage() {
	String heading= driver.findElement(homePageHeading).getText();
	 Assert.assertEquals(heading, "Full-Fledged practice website for Automation Engineers");
     return this;
 }

 public LoginSignupPage clicksignin_login() {
	    driver.findElement(signupLogin).click();
	    return new LoginSignupPage(driver);
	}
 
 public boolean isLoggedIn() {
	    waitForElementToAppear(loggedInUser);
	    return driver.findElement(loggedInUser).isDisplayed();
	}
 public String getAccountDeletedMessage() {
 
	 waitForElementToAppear(accountDeleted);
	    return driver.findElement(accountDeleted).getText();
	}
 public void clickDeleteAccount() {
	 waitForElementToBeClickable(deleteAccount);
	    driver.findElement(deleteAccount).click();

	    if (driver.getCurrentUrl().contains("google_vignette")) {

	        driver.navigate().back();

	        waitForElementToBeClickable(deleteAccount);
	        driver.findElement(deleteAccount).click();
	    }
	}

 public void clickContinue() {    waitForElementToBeClickable(continueButton);

 driver.findElement(continueButton).click();

 if (driver.getCurrentUrl().contains("google_vignette")) {
     handleGoogleVignette();
 }}
 public LoginSignupPage clickLogout() {
	    if (!isLoggedIn()) {
	        throw new IllegalStateException("User is not logged in. Logout button is not available.");
	    }

	    waitForElementToAppear(logoutBtn);
	    driver.findElement(logoutBtn).click();
	    return new LoginSignupPage(driver);
	}

 

 public ContactUsPage clickContactUs() {
     driver.findElement(contactUsBtn).click();
     return new ContactUsPage(driver);
 }
 public TestCasesPage clickTestcases() {
	 driver.findElement(testcaseBtn).click();
	 if (driver.getCurrentUrl().contains("google_vignette")) {
	        driver.navigate().back();
	        waitForElementToBeClickable(testcaseBtn);
	        driver.findElement(testcaseBtn).click();}
	 return new TestCasesPage(driver); 
	 
 }
 public ProductPage clickProductsbtn() {

	    driver.findElement(productBtn).click();

	    if (driver.getCurrentUrl().contains("google_vignette")) {
	        driver.navigate().back();

	        waitForElementToBeClickable(productBtn);
	        driver.findElement(productBtn).click();
	    }

	    return new ProductPage(driver);
	}
 public void scrollandverifySubscription() {
	 getScroll(footer);
	String text=driver.findElement(subscriptiontext).getText();
	 Assert.assertEquals(text, "SUBSCRIPTION");
 }
 public void filldetailsforsubscription(String email) {
	 driver.findElement(subscriptionEmail).sendKeys(email);
	 subscriptionbtn.click();
 }
 public void verifysubscriptionsuccesstext() {
	String text= driver.findElement(subsriptionsuccesstext).getText();
    Assert.assertEquals(text,"You have been successfully subscribed!");
 }
 public CartPage clickcartbtn() {
	 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	 WebElement viewCartBtn = wait.until(
	         ExpectedConditions.elementToBeClickable(popupViewCart));
	 driver.findElement(popupViewCart).click();
	 return new CartPage(driver);
 }
 public ProductDetailsPage clickviewProduct() {
	     
		driver.findElement(clickviewProduct1).click();
		handleGoogleVignette();
		driver.findElement(clickviewProduct1).click();
		return new ProductDetailsPage(driver);
	}
// public void addtocart() {
//	 hover(Product);
//	 driver.findElement(By.xpath("(//div[@class='product-overlay']//a[contains(text(),'Add to cart')])[1]")).click();
//	 
// }
 public void addtocart() {
	 hover(Product);

	 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

	 WebElement addBtn = wait.until(ExpectedConditions.elementToBeClickable(
	         Product.findElement(By.cssSelector(".product-overlay a.add-to-cart"))
	 ));

	 ((JavascriptExecutor)driver).executeScript("arguments[0].click();", addBtn);
	}
public CartPage clickheaderCartbtn() {
	waitForElementToBeClickable(cartheaderbtn);
	cartheaderbtn.click();
	return new CartPage(driver);
}
 
public void verifyacategories() {
	WebElement categoryElement = driver.findElement(element);
	getScroll(categoryElement);
	//waitForElementToAppear(categoryElement);
	   	    Assert.assertEquals(categoryElement.getText(), "CATEGORY");
	}
public WomenCategoryProductsPage clickwomen() {
	
	women.click();
	handleGoogleVignette();
	women.click();
	waitForElementToAppear(dress);      // pehle visible hone do
    waitForElementToBeClickable(dress); 
	//waitForElementToBeClickable(dress);
	dress.click();
	return new WomenCategoryProductsPage(driver);
}
public void  scrolltorecommendedproductAndVerify() throws InterruptedException {
    
	getScroll(recommendedproduct);
	String text=recommendedproduct.getText().trim();
	 System.out.println(text);
	Assert.assertEquals(text,"RECOMMENDED ITEMS");
}
public void addRecommendedProductToCart() throws InterruptedException {
	 JavascriptExecutor js = (JavascriptExecutor)driver;

	 js.executeScript(
	     "arguments[0].scrollIntoView({block:'center'});",
	     recommendedproduct
	 );

	 Thread.sleep(2000);

	 Assert.assertTrue(recommendedproduct.isDisplayed());

	 js.executeScript(
	     "arguments[0].click();",
	     addtocartrecommendedproduct
	 );
	 
}
public void clickScrollupArrow(){

	 ((JavascriptExecutor) driver).executeScript(
		        "arguments[0].scrollIntoView({block:'center'});",
		        arrowScrollUp);

		    ((JavascriptExecutor) driver).executeScript(
		        "arguments[0].click();",
		        arrowScrollUp);

}

	public void scrollToTop() {
	    JavascriptExecutor js = (JavascriptExecutor) driver;
	    js.executeScript("window.scrollTo(0,0);");
	
}

} 


 
