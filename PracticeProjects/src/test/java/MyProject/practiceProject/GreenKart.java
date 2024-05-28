package MyProject.practiceProject;

import java.lang.reflect.Array;
import java.time.Duration;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.opentelemetry.exporter.logging.SystemOutLogRecordExporter;

public class GreenKart {

	
	
	static ChromeDriver driver;
	public static void main(String[] args) throws InterruptedException {
		
		
		driver = new ChromeDriver();
		
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
		
		driver.manage().window().maximize();
		
		
		
		///Tratamento para as abas começa aqui
		String parentTab = driver.getWindowHandle();
		
		
		//AÇAO QUE VAI FAZER MUDAR DE ABA
		driver.findElement(By.xpath("//a[normalize-space()='Top Deals']")).click();	

		
		Set<String> allTabs = driver.getWindowHandles();
		
		
		
		String potatoPrice = "";
		String tomatoPrice = "";
		
		for(String handle : allTabs) {
			
			if(!handle.equals(parentTab)) {
				driver.switchTo().window(handle);
				
				//AÇOES DA NOVA ABA
				
				WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10000));
				
				
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[normalize-space()='Delivery Date']")));
				
				driver.findElement(By.xpath("//input[@id='search-field']")).sendKeys("To");
				
				//Pegando a terceira coluna para ver o preço com desconto
				
				List<WebElement> discountPrice = driver.findElements(By.xpath("//tbody//tr//td[3]"));
				
				List<String> prices = discountPrice.stream().map(WebElement::getText).collect(Collectors.toList());
				
				
				System.out.println(prices);
				
				//String price = prices.get(0);
				
				Assert.assertEquals(prices.contains("26") && prices.contains("22"), true);
				
				
				List<WebElement> products = driver.findElements(By.xpath("//tbody//tr//td[1]"));
				
				List<WebElement> discountPrices = driver.findElements(By.xpath("//tbody//tr//td[3]"));
				
				
				
				
				for (int i = 0; i < products.size(); i++) {
					
					//PEGANDO O PRIMEIRO INDEX PARA FAZER MEIO QUE UM FLUXO, O PRIMEIRO SEMPRE ATRIBUINDO AO PRIMEIRO DA LINHA
					WebElement product = products.get(i);
					WebElement discountPrice1 = discountPrices.get(i);
					
					String productName = product.getText();
					String priceDiscount = discountPrice1.getText();
					
					
					//VALIDAR O NOME DO PRODUTO DA LISTA E ATRIBUIR AO PREÇO 
					
					if (productName.equals("Tomato")) {
						
						tomatoPrice = priceDiscount;
						
						System.out.println(productName + " tem o preço com disconto: " + tomatoPrice);

					} if (productName.equals("Potato")){
						
						potatoPrice = priceDiscount;
						
						System.out.println(productName + " tem o preço com disconto: " + potatoPrice);
					}
					
				}
				
				
				
				
			}
		}
		System.out.println("********************************************" + potatoPrice + "****************************************************" + tomatoPrice + "******************************************************");
		
		
		//driver.switchTo().window(parentTab);
		
		
		Thread.sleep(10000);
		driver.quit();
		
		
		 //TRATAMENTO TERMINA AQUI 
		
		
		
		
		
		
		
		
		
		
		
	
	
	
	
	}

}
