package Riyabora.AutomationExerciseProject.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import AbstractComponents.AbstractComponent;

public class ProductPage extends AbstractComponent {
	WebDriver driver;

	public ProductPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
		 handleAdsAfterPageLoad();
	}

	By ProductPageText = By.xpath("//h2[text()='All Products']");
	By productsList = By.cssSelector(".features_items");
	By clickviewProduct = By.cssSelector("a[href='/product_details/1']");
	By searchBox = By.id("search_product");
	By searchBtn = By.id("submit_search");

	By viewCart = By.xpath("//u[text()='View Cart']");
   // By brandtext=By.xpath("//h2[text()='Brands']");
    By brandtext = By.xpath("//div[@class='brands_products']//h2");
    By searchbox=By.xpath("//inpu[@id='search_product']");
    
    @FindBy(xpath = "(//div[@class='product-image-wrapper'])[1]")
	WebElement firstProduct;

	@FindBy(xpath = "//button[text()='Continue Shopping']")
	WebElement continueShopping;

	@FindBy(xpath = "(//div[@class='product-image-wrapper'])[2]")
	WebElement secondProduct;

	@FindBy(xpath = "//a[@href='/brand_products/H&M']")
	WebElement H_Mbtn;
	
	public void verifyProductPage() {
		System.out.println(driver.getCurrentUrl());
		 waitForElementToAppear(ProductPageText);
		String text = driver.findElement(ProductPageText).getText();
		System.out.println(text);

		Assert.assertEquals(text.trim(), "ALL PRODUCTS");

	}

	public boolean verifyproductListVisible() {
		return driver.findElement(productsList).isDisplayed();
	}

	public ProductDetailsPage clickviewProduct() {
		driver.findElement(clickviewProduct).click();
		return new ProductDetailsPage(driver);
	}

	public SearchPage searchProduct(String productName) {
		driver.findElement(searchBox).sendKeys(productName);
		driver.findElement(searchBtn).click();
		return new SearchPage(driver);

	}

	public void addFirstProduct() throws InterruptedException {
		Thread.sleep(2000);
		hover(firstProduct);
		driver.findElement(By.xpath("(//div[@class='product-overlay']//a[contains(text(),'Add to cart')])[1]")).click();
		waitForElementToAppear(continueShopping);
		continueShopping.click();
	}

	public CartPage addSecondProduct() {
		hover(secondProduct);
		driver.findElement(By.xpath("(//div[@class='product-overlay']//a[contains(text(),'Add to cart')])[2]")).click();
		waitForElementToAppear(viewCart);
		driver.findElement(viewCart).click();
		return new CartPage(driver);
	}
	
	public HNMPage verifyandclickbrand(){
		waitForElementToAppear(brandtext);
	String text=driver.findElement(brandtext).getText();
	
	Assert.assertEquals(text.trim(), "BRANDS");
	waitForElementToAppear(H_Mbtn);
	H_Mbtn.click();
	return new HNMPage(driver);
	}
	
	public SearchPage enterproductinsearchbox(String item) {
		driver.findElement(searchBox).sendKeys(item);
		driver.findElement(searchBtn).click();
        return new SearchPage(driver);
	}
}
