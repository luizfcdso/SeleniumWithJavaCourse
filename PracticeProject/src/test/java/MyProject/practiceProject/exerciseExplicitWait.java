package MyProject.practiceProject;

import java.time.Duration;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class exerciseExplicitWait {
	
	
	static ChromeDriver driver;

	public static void main(String[] args) throws InterruptedException {
		
		driver = new ChromeDriver();
		
		driver.get("https://rahulshettyacademy.com/loginpagePractise/");
		
		driver.manage().window().maximize();
		
		driver.findElement(By.id("username")).sendKeys("rahulshettyacademy");
		driver.findElement(By.id("password")).sendKeys("learning");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//label[2]//span[2]")).click();
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".btn.btn-success"))).click();
				
		
		driver.findElement(By.xpath("//div//select")).click();
		
				
		WebElement optionEle = driver.findElement(By.xpath("//option[@value='consult']"));
		
		optionEle.click();
	
		
//		control.click();
//		
//		for (int i=0; i<3; i++) {
//			control.sendKeys(Keys.DOWN);
//			}
				
		driver.findElement(By.cssSelector("#terms")).click();
		driver.findElement(By.id("signInBtn")).click();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//button)[2]"))).click();
		driver.findElement(By.xpath("(//button)[3]")).click();
		driver.findElement(By.xpath("(//button)[4]")).click();
		driver.findElement(By.xpath("(//button)[5]")).click();
		driver.findElement(By.xpath("(//a)[5]")).click();
	}

}
