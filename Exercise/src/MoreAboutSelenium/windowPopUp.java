package MoreAboutSelenium;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class windowPopUp {

	static ChromeDriver driver;
	
	
	public static void main(String[] args) {

		driver = new ChromeDriver();
		driver.get("http://admin:admin@the-internet.herokuapp.com/");
		driver.findElement(By.linkText("Basic Auth")).click();
		
		
		
		
	}

}
