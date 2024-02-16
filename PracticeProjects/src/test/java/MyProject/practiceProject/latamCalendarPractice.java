package MyProject.practiceProject;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class latamCalendarPractice {
		static ChromeDriver driver;
		
		public static void main(String[] args) throws InterruptedException {		
		driver = new ChromeDriver();
		
		 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		
		String mesIda = "abril";
		String mesVolta = "maio";
	
		
		driver.manage().window().maximize();
					
		driver.get("https://latamtravel-brasil.decolar.com/");
		//driver.findElement(By.id("cookies-politics-button")).click();

		
		//Usando o Keys down para selecionar uma opção. O R I G E M
		WebElement origem = driver.findElement(By.xpath("//input[@placeholder='Insira sua cidade de origem']"));
		origem.click();
		origem.clear();
		origem.sendKeys("Uberlandia");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='item-text']"))).click();
		//origem.sendKeys(Keys.ENTER);
		
		//Usando um select para selecionar uma opção: D E S T I N O
		WebElement destino = driver.findElement(By.xpath("//input[@placeholder='Insira uma cidade']"));
		destino.click();
		destino.sendKeys("Salvador, Bahia");
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='item-text']"))).click();
			
		JavascriptExecutor js = (JavascriptExecutor) driver;

		driver.findElement(By.xpath("//input[@placeholder='Ida']")).click();
		
		
		//driver.findElement(By.xpath("(//div[@class='MuiInputBase-root MuiOutlinedInput-root MuiInputBase-formControl MuiInputBase-adornedEnd MuiOutlinedInput-adornedEnd'])[1]")).click();
		
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[@class='sbox5-monthgrid-title-month'])[1]"))).click();
		
		js.executeScript("window.scrollBy(0, 300)");
		
		while (!driver.findElement(By.xpath("(//div[@class='sbox5-monthgrid-title-month'])[1]")).getText().equalsIgnoreCase("Fevereiro")){
			
			driver.findElement(By.cssSelector(".calendar-arrow-right ")).click();
			//se usar break aqui, pode ser que no primeiro clique ele já pula para o prox passo
			
		}
		
		
		List<WebElement> dayPick = driver.findElements(By.cssSelector("[class*='sbox5-monthgrid-datenumber-number']"));
		int numDay = dayPick.size();
		
		for (int i = 0; i < numDay; i++) {
			String dayElement = dayPick.get(i).getText();
			if(dayElement.equalsIgnoreCase("10")) {
				wait.until(ExpectedConditions.visibilityOf(dayPick.get(i)));
				dayPick.get(i).click();
				break;
			}
		}
		
		
		List<WebElement> dayPick2 = driver.findElements(By.cssSelector("[class*='sbox5-monthgrid-datenumber-number']"));
		int numDay2 = dayPick2.size();
		for (int i = 0; i < numDay2; i++) {
			String dayElement = dayPick2.get(i).getText();
			if(dayElement.equalsIgnoreCase("31")) {
				dayPick2.get(i).click();
				break;
			}
		}
		
		driver.findElement(By.cssSelector(".sbox5-3-btn.-primary.-md")).click();
		
		driver.findElement(By.cssSelector("[class*='sbox5-box-button-ovr--lX4PS']")).click();
	
} 
}
