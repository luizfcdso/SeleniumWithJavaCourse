package MyProject.practiceProject;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class UploadAndDownloadExcel {
	
	static ChromeDriver driver;

	public static void main(String[] args) {
		
		
		driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(7));
		driver.get("https://rahulshettyacademy.com/upload-download-test/index.html");
		
		
		String fruitName = "Mango";
		
		//download 
		
		driver.findElement(By.xpath("//button[@id='downloadButton']")).click();
		
		WebElement upload = driver.findElement(By.cssSelector("input[type='file']"));
		
		
		upload.sendKeys("C:\\Users\\Luiz Fernando\\Documents\\download.xlsx");
		

		
		//Wait for success message to show up and wait for disappear 
		
		By toastLocator = By.cssSelector(".Toastify__toast-body div:nth-child(2");
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(100));
		
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(toastLocator));
		
		String toastText = driver.findElement(toastLocator).getText();
		
		
		System.out.println(toastText);
		
		Assert.assertEquals("Updated Excel Data Successfully.", toastText);
				
		
		wait.until(ExpectedConditions.invisibilityOfElementLocated(toastLocator));
		
		
		String priceColumn = driver.findElement(By.xpath("//div[text()='Price']")).getAttribute("data-column-id");
		
		String actualPrice = driver.findElement(By.xpath("//div[text()='"+fruitName+"']/parent::div/parent::div/div[@id='cell-"+priceColumn+"-undefined']")).getText();
		
		System.out.println(actualPrice);
		
		Assert.assertEquals("299", actualPrice);
		
		
		//verify updated excel sata showing in the web table
		
		
		
		//div[contains(text(),'Updated Excel Data Successfully.')]
		
		
		// Edit excel 
		
		//upload
		
		// wait for the success message to show up and wait it disappear 
		
		

	}

}
