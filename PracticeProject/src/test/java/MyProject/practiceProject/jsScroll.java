package MyProject.practiceProject;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.chrome.ChromeDriver;

public class jsScroll {
	
	static ChromeDriver driver;
	
	public static void main(String[] args) {
		
		driver = new ChromeDriver();
		driver.get("http://teststore.automationtesting.co.uk/");
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		
		
		driver.findElement(By.xpath("//input[@placeholder='Your email address']")).sendKeys("luizxtcosta@gmail.com");
		
		js.executeScript("window.scrollBy(0,1000)");
		
		
		
	}

}
