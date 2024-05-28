import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.JavascriptExecutor;

import org.testng.Assert;

public class MagazineProject {
	
	static ChromeDriver driver;

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		driver = new ChromeDriver();
		
		JavascriptExecutor  js = (JavascriptExecutor)driver;

		
		driver.get("https://www.magazineluiza.com.br/");
		driver.manage().window().maximize();
		
		driver.findElement(By.cssSelector("#input-search")).sendKeys("Samsung S23");
		driver.findElement(By.xpath("(//*[name()='svg'][@aria-label='Buscar produto'])[1]")).click();
		
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("span[title='Resultados para ']")));
		
		//procurando pelo CONTAINS XPath
		driver.findElement(By.xpath("(//h2[@class='sc-fvwjDU fbccdO'][contains(text(),'Samsung Galaxy S23 ')])[2]")).click();
		
		WebElement cartButton = driver.findElement(By.xpath("(//button[@class='sc-kOPcWz fZuCAx sc-hwFkLi kVmJYX'])[1]"));
		
	
		wait.until(ExpectedConditions.visibilityOf(cartButton));
		
		cartButton.click();
		
		js.executeScript("window.scrollBy(0,1000)");
		
		//WebElement resumoWait = driver.findElement(By.xpath("//p[normalize-space()='Resumo']"));
		
		//wait.until(ExpectedConditions.visibilityOf(resumoWait));
		
		driver.findElement(By.xpath("(//button[@class='sc-kOPcWz diwoJl sc-idPYgo dCQwqq'])[1]")).click();
		
		
		WebElement cartProduct = driver.findElement(By.cssSelector("div[class='BasketTable'] p:nth-child(1)"));
		
		
		String Text = cartProduct.getText();
		
		Assert.assertEquals(true, Text.contains("Samsung Galaxy S23"));
		
		System.out.println(Text);
		
		
		
		
		

		
		
		
		

		
		
		
		

	}

}
