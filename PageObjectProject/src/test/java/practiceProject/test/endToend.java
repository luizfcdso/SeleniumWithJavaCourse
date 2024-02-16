package practiceProject.test;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class endToend {

	static ChromeDriver driver;

	public static void main(String[] args) throws InterruptedException {

		driver = new ChromeDriver();
		driver.manage().window().maximize();
		try {
			
			
			String productName =  "Hummingbird printed t-shirt";
			
			String productName1 = "Hummingbird printed sweater";
			
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			JavascriptExecutor js = (JavascriptExecutor) driver;


			driver.get("http://teststore.automationtesting.co.uk/");

			driver.findElement(By.cssSelector("span[class='hidden-sm-down']")).click();
			

			driver.findElement(By.cssSelector("input[class='form-control']")).sendKeys("luizxtcosta@gmail.com");

			driver.findElement(By.cssSelector("input[name='password']")).sendKeys("Test@123");

			driver.findElement(By.cssSelector("#submit-login")).click();

			WebElement backPage = driver.findElement(By.cssSelector("img[class='logo img-responsive']"));
			
			backPage.click();

			List<WebElement> listProducts = driver.findElements(By.xpath("(//h3[@class='h3 product-title'])"));
			
			
			
			for (WebElement product : listProducts) {
				String value = product.getText();
				
				if (value.equalsIgnoreCase(productName)) {
					product.click();
					wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".btn.btn-primary.add-to-cart"))).click();
					wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("button[class='btn btn-secondary']"))).click();
					driver.navigate().back();
				}
				if(value.equalsIgnoreCase(productName1)) {
					product.click();
					wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".btn.btn-primary.add-to-cart"))).click();
					wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("button[class='btn btn-secondary']"))).click();
					driver.navigate().back();
					break;
					}
				}
		
		
			driver.navigate().refresh();

			
			WebElement cart = driver.findElement(By.cssSelector("div[class='header']"));
			
			cart.click();
						
			
			
			List<WebElement> productCart = driver.findElements(By.cssSelector("div[class='product-line-info']"));
			
			List<String> listP = productCart.stream().map(WebElement::getText).collect(Collectors.toList());
						
			
			
			System.out.println("************************" + listP +"**************************");
			
			Assert.assertEquals(listP.contains("Arroz"), listP.contains(productName1));
			
			
			
			//driver.findElement(By.cssSelector(".btn.btn-success.close-modal.btn-block")).click();
			// href="/view_cart"
			//Thread.sleep(2000);
			//wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("a[href='/view_cart']"))).click();
			// href="/product_details/1"
			//List<WebElement> product = driver.findElements(By.cssSelector("a[href*='/product_details']"));

			//List<String> textProducts = product.stream().map(WebElement::getText).collect(Collectors.toList());

			//System.out.println(textProducts);

			//Assert.assertTrue(textProducts.contains("Men Tshirt") && textProducts.contains("Blue Top"));

			//driver.findElement(By.cssSelector("a[class*='check_out']")).click();

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
			///e.printStackTrace();
		} finally {
			if (driver != null) {
				Thread.sleep(20000);
				///driver.quit();
			}
		}

	}

}
