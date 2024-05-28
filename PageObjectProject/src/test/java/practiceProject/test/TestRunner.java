package practiceProject.test;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.cucumber.testng.CucumberOptions;
import studying.PageObjectProject.Carrinho;
import studying.PageObjectProject.Pagamento;
import studying.PageObjectProject.PaginaDeLogin;
import studying.PageObjectProject.PaginaProdutos;

public class TestRunner {

	static ChromeDriver driver;
@Test
	public static void main(String[] args) throws InterruptedException {

		driver = new ChromeDriver();
		
		
		String email = "luizxtcosta@gmail.com";
		String pass = "Test@123";
		String productName = "Hummingbird printed t-shirt";
		String productName1 = "Hummingbird printed sweater";
		String message = "Please, do not take much time to delivery it. I need it urgently!";

		driver.manage().window().maximize();
		try {

			
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			JavascriptExecutor js = (JavascriptExecutor) driver;
			PaginaDeLogin paginaDeLogin = new PaginaDeLogin(driver);
			paginaDeLogin.goTo();
			paginaDeLogin.loginAplicacao(email, pass);
			PaginaProdutos paginaProdutos = new PaginaProdutos(driver);
			paginaProdutos.addProdutos(productName, productName1);
			Carrinho carrinho = new Carrinho(driver);
			carrinho.goToCart();
			carrinho.checkCart(productName, productName1);
			Pagamento pagamento = new Pagamento(driver);
			pagamento.paying(message);
			
			
			// driver.findElement(By.cssSelector(".btn.btn-success.close-modal.btn-block")).click();
			// href="/view_cart"
			// Thread.sleep(2000);
			// wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("a[href='/view_cart']"))).click();
			// href="/product_details/1"
			// List<WebElement> product =
			// driver.findElements(By.cssSelector("a[href*='/product_details']"));

			// List<String> textProducts =
			// product.stream().map(WebElement::getText).collect(Collectors.toList());

			// System.out.println(textProducts);

			// Assert.assertTrue(textProducts.contains("Men Tshirt") &&
			// textProducts.contains("Blue Top"));

			// driver.findElement(By.cssSelector("a[class*='check_out']")).click();

//			//js.executeScript("window.scrollBy(0,300)");
//
//			//String deliveryAdress = driver.findElement(By.cssSelector("li[class='address_firstname address_lastname']"))
//					.getText();
//
//			//System.out.println(deliveryAdress);
//
//			Assert.assertTrue(deliveryAdress.equalsIgnoreCase("Mr. Luiz Fernando Costa de Souza"));
//
//			Assert.assertTrue(textProducts.contains("Men Tshirt") && textProducts.contains("Blue Top"));
//
//			js.executeScript("window.scrollBy(0,300)");
//
//			driver.findElement(By.cssSelector("a[href='/payment']")).click();
//
//			Thread.sleep(3000);
//
//			js.executeScript("var elementosAnuncios = document.querySelectorAll('.jar'); "
//					+ "elementosAnuncios.forEach(function(elemento) { elemento.style.display = 'none'; });");
//			driver.findElement(By.cssSelector("path[d*='M38 12.83L35.17 10 24 21.17 12.83 10 10 12.83 "
//					+ "21.17 24 10 35.17 12.83 38 24 26.83 35.17 38 38 35.17 26.83 24z']")).click();
//			WebElement nameCard = driver.findElement(By.cssSelector("input[name='name_on_card']"));
//
//			wait.until(ExpectedConditions.visibilityOfElementLocated((By) nameCard));
//
//			nameCard.sendKeys("Luiz Fernando C de Souza");
//
//			driver.findElement(By.cssSelector("input[name='card_number']")).sendKeys("123456789101112131415");
//			driver.findElement(By.cssSelector("input[name='cvc']")).sendKeys("123");
//			driver.findElement(By.cssSelector("input[name='expiry_month']")).sendKeys("08");
//			driver.findElement(By.cssSelector("input[name='expiry_year']")).sendKeys("2026");
//			driver.findElement(By.cssSelector("#submit")).click();
//
//			WebElement confirmation = driver.findElement(By.cssSelector("div[class='col-sm-9 col-sm-offset-1']  p"));
//
//			wait.until(ExpectedConditions.visibilityOfElementLocated((By) confirmation));
//
//			confirmation.getText();
//
//			Assert.assertEquals(confirmation, "Congratulations! Your order has been confirmed!");

		} catch (Exception e) {
			Thread.sleep(20000);
			e.printStackTrace();
		} finally {
			if (driver != null) {
				Thread.sleep(20000);
				/// driver.quit();
			}
		}

	}

}
