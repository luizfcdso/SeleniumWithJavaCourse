package lessonrahuludemy.tests;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.IRetryAnalyzer;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;


import lessonrahuludemy.CartPage;
import lessonrahuludemy.CheckoutPage;
import lessonrahuludemy.ConfirmationPage;
import lessonrahuludemy.ProductCatalogue;
import lessonrahuludemy.TestComponents.BaseTest;
import lessonrahuludemy.TestComponents.Retry;

public class ErrorsValidationsTest extends BaseTest{

	@Test(groups = {"ErrorHandling"}, retryAnalyzer=Retry.class)
	public void LoginErrorValidation() throws IOException, InterruptedException {

		String productName = "ADIDAS ORIGINAL";
		String country = "brazil";
		landingPage.loginApplication
				("luizxtcosta@gmail.com", "Tes123");
		AssertJUnit.assertEquals("Incorrect email or password.", landingPage.getErrorMessage());

	}
	
	@Test
	public void ProductErrorValidation() throws IOException, InterruptedException {

		String productName = "ADIDAS ORIGINAL";
		String country = "brazil";
		ProductCatalogue productCatalogue = landingPage.loginApplication
				("luizxtcosta@gmail.com", "Test@123");
		List<WebElement> products = productCatalogue.getProductsList();
		productCatalogue.addProductToCart(productName);
		CartPage cartPage = productCatalogue.goToCartPage();
		Boolean match = cartPage.VerifyProductDisplay("ADIDAS ORIGINA");
		System.out.println(match);
		Assert.assertFalse(match);
		
	

	}

}


