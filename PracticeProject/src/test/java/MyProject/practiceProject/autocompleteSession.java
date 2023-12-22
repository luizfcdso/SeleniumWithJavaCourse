package MyProject.practiceProject;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import io.opentelemetry.exporter.logging.SystemOutLogRecordExporter;

public class autocompleteSession {

	static ChromeDriver driver;

	public static void main(String[] args) throws InterruptedException {
				
		driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.findElement(By.xpath("//input[@placeholder='Type to Select Countries']")).sendKeys("unit");
		WebElement inputKeys = driver.findElement(By.xpath("//input[@placeholder='Type to Select Countries']"));

		for (int i = 0; i < 4; i++) {
			inputKeys.sendKeys(Keys.DOWN);
			
		}
		Thread.sleep(500);
				
		Actions actions = new Actions(driver);
		
		// Actions para mover o cursor para fora do elemento e clicar
		
		actions.moveToElement(driver.findElement(By.cssSelector("div[id='select-class-example'] fieldset legend")))
				.click().build().perform();
		
		
		if (inputKeys.isSelected()) 
		{
			Thread.sleep(3000);
			System.out.println(inputKeys.getText());
			Assert.assertEquals(inputKeys, "United States (USA)");

		} 
		
		
	}

}
