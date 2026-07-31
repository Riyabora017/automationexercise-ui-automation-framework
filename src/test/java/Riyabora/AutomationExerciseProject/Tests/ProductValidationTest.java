package Riyabora.AutomationExerciseProject.Tests;

import static org.testng.Assert.assertTrue;

import org.testng.Assert;
import org.testng.annotations.Test;

import Riyabora.AutomationExerciseProject.TestComponents.BaseTest;
import Riyabora.AutomationExerciseProject.pageobjects.CartPage;
import Riyabora.AutomationExerciseProject.pageobjects.HNMPage;
import Riyabora.AutomationExerciseProject.pageobjects.HomePage;
import Riyabora.AutomationExerciseProject.pageobjects.LoginSignupPage;
import Riyabora.AutomationExerciseProject.pageobjects.MenCategoryProductsPage;
import Riyabora.AutomationExerciseProject.pageobjects.PoloPage;
import Riyabora.AutomationExerciseProject.pageobjects.ProductDetailsPage;
import Riyabora.AutomationExerciseProject.pageobjects.ProductPage;
import Riyabora.AutomationExerciseProject.pageobjects.SearchPage;
import Riyabora.AutomationExerciseProject.pageobjects.WomenCategoryProductsPage;

public class ProductValidationTest extends BaseTest {

	@Test
public void ProductdetailsviewTest() throws InterruptedException {
	homePage.verifyhomepage();
	ProductPage productPage=homePage.clickProductsbtn();
	productPage.verifyProductPage();
	assertTrue(productPage.verifyproductListVisible());
	ProductDetailsPage productDetailsPage=productPage.clickviewProduct();
	productDetailsPage.verifyProductDetails();
}
	@Test
	public void searchProductTest() throws InterruptedException {
		ProductPage productPage=homePage.verifyhomepage().clickProductsbtn();
		productPage.verifyProductPage();
		SearchPage searchPage=productPage.searchProduct("Winter Top");
		searchPage.verifysearchPage();
		assertTrue(searchPage.verifySearchedProductsVisible());
	}
	

	@Test
	public void ViewCategoryProductsTest() {
     homePage.verifyacategories();
     WomenCategoryProductsPage categoryProductsPage= homePage.clickwomen();
     categoryProductsPage.verifycategoryproductPage();
     categoryProductsPage.confirmCategoryHeading();
     MenCategoryProductsPage menCategoryProductsPage=  categoryProductsPage.clickmensubcategories();
     menCategoryProductsPage.verifytexttitle();
	}

	@Test
	public void  BrandProductsTest(){
		ProductPage productPage=homePage.clickProductsbtn();
		HNMPage hNMPage=productPage.verifyandclickbrand();
		hNMPage.verifyHnmPage();
		PoloPage poloPage=hNMPage.clickPolo();
		poloPage.verifyPoloPage();
   }
	
	@Test
	public void searchProductAndVerifyCartAfterLogin() {
		 ProductPage productPage=homePage.clickProductsbtn();
		 productPage.verifyProductPage();
		 SearchPage searchPage= productPage.enterproductinsearchbox("Winter Top");
		 searchPage.verifysearchPage();
		 searchPage.verifySearchedProductsVisible();
		 searchPage.addtocartproduct();
		  
		 CartPage cartPage=searchPage.clickcartbtn();
		 cartPage.verifyProductsAdded();
		 Assert.assertTrue(cartPage.verifyProductsAdded(),
		            "Products are not visible in the cart");
		 cartPage.clickproceedbtn(); 
		 LoginSignupPage loginSignupPage=cartPage.clickloginsignBtn();
		 loginSignupPage.enterLoginDetails("borariya982@gmail.com", "Riya123");
		 HomePage homePage=loginSignupPage.clicklogin();
		 cartPage=homePage.clickheaderCartbtn();
		 cartPage.verifyProductsAdded();
	}
	@Test
	public void addReviewonProduct() {
    	 ProductPage productPage=homePage.clickProductsbtn();
		 productPage.verifyProductPage();
		 ProductDetailsPage productDetailsPage =productPage.clickviewProduct();
		 productDetailsPage.verifywriteyourreview();
		 productDetailsPage.enterReview("Riya Bora","borariya982@gmail.com","nice product");
		 productDetailsPage.verifysuccessreviewmsg();
		 productDetailsPage.verifysuccessfullyreviewaddmsg();
	}
	@Test
	public void	AddtocartfromRecommendeditems() throws InterruptedException {
    homePage.scrolltorecommendedproductAndVerify();
     homePage.addRecommendedProductToCart();
    CartPage cartPage= homePage.clickcartbtn();
    cartPage.verifyProductsAdded();
     }
}