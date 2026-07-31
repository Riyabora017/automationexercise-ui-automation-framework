package Riyabora.AutomationExerciseProject.Tests;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import Riyabora.AutomationExerciseProject.TestComponents.BaseTest;
import Riyabora.AutomationExerciseProject.pageobjects.CartPage;
import Riyabora.AutomationExerciseProject.pageobjects.ProductDetailsPage;
import Riyabora.AutomationExerciseProject.pageobjects.ProductPage;

public class cartValidationTest extends BaseTest {

	@Test
	public void addTocartTest() throws InterruptedException {

		ProductPage productPage=homePage.verifyhomepage().clickProductsbtn();
		productPage.addFirstProduct();
		CartPage cartPage=productPage.addSecondProduct();
		assertTrue(cartPage.verifyBothProductsAdded());
		cartPage.verifyPriceQuantityTotal();
		}

	
	@Test
	public void verifyProductquantityincartTest() throws InterruptedException {
		ProductDetailsPage productDetailsPage=	homePage.verifyhomepage().clickviewProduct();
		productDetailsPage.verifyProductDetailsPage();
		productDetailsPage.increaseQuantity("4");
	    productDetailsPage.clickaddtocart();
	    CartPage cartPage=productDetailsPage.viewCart();
	    cartPage.verifyexactquantity("4");

	}
	
	@Test
	public void RemoveProductsFromCart() {
		homePage.verifyhomepage();
		homePage.addtocart();
		CartPage cartPage=homePage.clickcartbtn();
		cartPage.verifyonlycartPage();
		cartPage.deletecartquantity();
		
	}
	
}







