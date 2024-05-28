package studying.AbstractComponent;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AbstractComponent  {
	
	WebDriver driver;

	//Fazendo uma tratativa do wait pelo elemento, se for By ou se for Webelement.
		public void waitForElementAppear(Object elementOrBy) {
		    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		        wait.until(ExpectedConditions.visibilityOf((WebElement) elementOrBy));
		   
		}
	
}
