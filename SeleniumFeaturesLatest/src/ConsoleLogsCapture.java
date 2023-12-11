import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;

public class ConsoleLogsCapture {

	
	static ChromeDriver driver;
	public static void main(String[] args) throws InterruptedException {

		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/angularAppdemo/");
		driver.findElement(By.cssSelector("[class*='btn btn-lg btn-success']")).click();
		driver.findElement(By.linkText("Selenium")).click();
		driver.findElement(By.cssSelector("[class*='add-to']")).click();
		driver.findElement(By.linkText("Cart")).click();
		Thread.sleep(1000);
		WebElement campo = driver.findElement(By.xpath("//input[@id='exampleInputEmail1']"));
		campo.clear();
		campo.sendKeys("2"); 
		
		LogEntries entry = driver.manage().logs().get(LogType.BROWSER);
		List<LogEntry> logs = entry.getAll();
		System.out.println(logs);
		
		
		
		
	}

}
