package MyProject.practiceProject;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class stream {
	
	static ChromeDriver driver;


	public static void main(String[] args) {

		
		
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		
			
			
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
	
		}
}
