package lessonrahuludemy.tests;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import lessonrahuludemy.CartPage;
import lessonrahuludemy.CheckoutPage;
import lessonrahuludemy.ConfirmationPage;
import lessonrahuludemy.LandingPage;
import lessonrahuludemy.ProductCatalogue;
import lessonrahuludemy.AbstractComponents.AbstractComponent;
import lessonrahuludemy.AbstractComponents.PageOrders;
import lessonrahuludemy.TestComponents.BaseTest;

public class SubmitOrderTest extends BaseTest {
	String productName = "ADIDAS ORIGINAL";

	@Test(dataProvider = "getData", groups = { "Purchase" }) // está pegando os dados do getData e rodando aqui com dois
																// produtos diferentes
	// precisa passar os dados dentro do method para que ele reconheça
	public void submitOrder(HashMap<String, String> input) throws IOException, InterruptedException {

		String country = "brazil";
		ProductCatalogue productCatalogue = landingPage.loginApplication(input.get("email"), input.get("password"));
		List<WebElement> products = productCatalogue.getProductsList();
		productCatalogue.addProductToCart(input.get("product"));
		CartPage cartPage = productCatalogue.goToCartPage();
		Boolean match = cartPage.VerifyProductDisplay(input.get("product"));
		System.out.println(match);
		CheckoutPage checkoutPage = cartPage.goToCheckout();
		checkoutPage.selectCountry(country);
		checkoutPage.submitOrder();
		ConfirmationPage confirmationPage = checkoutPage.submitOrder();
		confirmationPage.getConfirmMessage();
		Assert.assertEquals("THANKYOU FOR THE ORDER.", confirmationPage.getConfirmMessage());
	}

	// To verify ADIDAS ORIGINAL is displaying in orders page
	@Test(dependsOnMethods = { "submitOrder" })
	public void OrderHistoryTest() {
		ProductCatalogue productCatalogue = landingPage.loginApplication("luizxtcosta@gmail.com", "Test@123");
		PageOrders pageOrders = productCatalogue.goToOrderPage();
		Assert.assertTrue(pageOrders.listOrders(productName));

	}
	
	

	
	//extend reports 
	
	@DataProvider 
	public Object[][] getData() throws IOException {

		List<HashMap<String, String>> data = getJsonDataToMap(
				System.getProperty("user-dir") + "//src//test//java//lessonrahuludemy//data//PurcheseOrder.json");
		return new Object[][] { { data.get(0) }, { data.get(1) } };

	}
	// vai fornecer os dados que irão substituir o 1st metodo, nesse caso, o Object
	// está criando dois casos de testes,
// para dois produtos diferentes, sendo assim, podendo usar separadamente os
// produtos.
//	//para usar produtos ou emails diferentes, precisa criar outro hashmap, como o hash map1
//	HashMap<String, String> map = new  HashMap<String, String>();
//	map.put("email", "luizxtcosta@gmail.com");
//	map.put("password", "Test@123");
//	map.put("product", "ADIDAS ORIGINAL");
//	
//	HashMap<String, String> map1 = new  HashMap<String, String>();
//	map1.put("email", "luizxtcosta@gmail.com");
//	map1.put("password", "Test@123");
//	map1.put("product", "ZARA COAT 3");

}
