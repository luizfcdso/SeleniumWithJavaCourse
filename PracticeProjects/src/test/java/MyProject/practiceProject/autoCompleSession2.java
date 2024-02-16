package MyProject.practiceProject;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class autoCompleSession2 {

	static ChromeDriver driver;

	public static void main(String[] args) throws InterruptedException {
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--headless");

		// Inicializar o driver com as opções configuradas
		driver = new ChromeDriver(options);

		//driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");

		WebElement inputKeys = driver.findElement(By.xpath("//input[@placeholder='Type to Select Countries']"));
		inputKeys.sendKeys("United States (USA)");

		inputKeys.sendKeys(Keys.DOWN);

		Actions actions = new Actions(driver);
		actions.moveToElement(driver.findElement(By.cssSelector("div[id='select-class-example'] fieldset legend")))
				.click().build().perform();

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		wait.until(ExpectedConditions.textToBePresentInElementValue(inputKeys, "United States (USA)"));

		String textoDoInput = inputKeys.getAttribute("value");

		System.out.println(textoDoInput);

		Assert.assertEquals(textoDoInput, "United States (USA)");

	}

}
