package lessonrahuludemy.stepDefination;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.AssertJUnit;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lessonrahuludemy.CartPage;
import lessonrahuludemy.CheckoutPage;
import lessonrahuludemy.ConfirmationPage;
import lessonrahuludemy.LandingPage;
import lessonrahuludemy.ProductCatalogue;
import lessonrahuludemy.TestComponents.BaseTest;



public class StepDefinationImplamantation extends BaseTest {

	
	public LandingPage landingPage;
	public ProductCatalogue productCatalogue;
	public ConfirmationPage confirmationPage; 
	@Given("I landed on Ecommerce Page")
	public void I_landed_on_Ecommerce_Page() throws IOException {
		
		landingPage = launchApplication();
		
	}
	@Given("^Logged in with user (.+) and password (.+)$")
	public void logged_in_username_and_password(String username, String password) {
		
		productCatalogue = landingPage.loginApplication(username, password);
		
	}
	@When("^I add the product (.+) to Cart$")
	public void add_product_to_cart(String productName) throws InterruptedException {
		List<WebElement> products = productCatalogue.getProductsList();
		productCatalogue.addProductToCart(productName);
		
	}
	
	@When("^This product (.+) has been added and submit the Order$")
	public void  verify_submit_order(String productName) throws InterruptedException{
		CartPage cartPage = productCatalogue.goToCartPage();
		Boolean match = cartPage.VerifyProductDisplay(productName);
		CheckoutPage checkoutPage = cartPage.goToCheckout();
		checkoutPage.selectCountry("brazil");
		checkoutPage.submitOrder();
		confirmationPage = checkoutPage.submitOrder();
		
		
	}
	
	@Then("{string} message is displayed on ConfirmationPage")
	public void get_the_message_to_confirmation(String confirmationMessage) {
		String confirmMessage = confirmationPage.getConfirmMessage();
		//2 jeitos de fazer o assert:
		Assert.assertEquals(confirmationMessage, confirmMessage);
		Assert.assertTrue(confirmMessage.equalsIgnoreCase(confirmMessage));
		driver.close();
	}
	
	@Then("^\"([^\"]*)\" message is displayed$")
	public void something_message_is_displayed(String message)
	{
		AssertJUnit.assertEquals(message, landingPage.getErrorMessage());
		driver.close();
	}
	
	
	
}
