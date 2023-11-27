package newintroduction;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;



public class newclassjava {

	public static void main(String[] args) {
		
				

		System.setProperty("Webdriver.chrome.driver", "C:\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("");
        driver.quit();
    }
		
	
		
	}


