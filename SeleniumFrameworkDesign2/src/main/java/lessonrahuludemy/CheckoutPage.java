package lessonrahuludemy;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import lessonrahuludemy.AbstractComponents.AbstractComponent;

public class CheckoutPage extends AbstractComponent {
	
	WebDriver driver;
	
	public CheckoutPage(WebDriver driver) {
		
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}

	@FindBy( css = ".totalRow button")
	WebElement checkoutPage;
	
	@FindBy (css = "[placeholder='Select Country']")
	WebElement country;
	
	@FindBy (css = ".action__submit")
	WebElement submit;
	
	@FindBy (xpath = "//button[contains(@class, 'ta-item')]")
	WebElement selectCountry;
	
	
	
	By results = By.cssSelector(".ta-results");
	
	public void selectCountry(String countryName) {
		
		Actions a = new Actions(driver);
		a.sendKeys(country, countryName).build().perform();
		
		waitForElementToAppear(results);
		selectCountry.click();
	}
	
	public ConfirmationPage submitOrder() {
//		JavascriptExecutor jse = (JavascriptExecutor)driver;
//
//		WebElement ele = driver.findElement(By.cssSelector(".action__submit"));
//
//		jse.executeScript("arguments[0].click()", ele);
		submit.click();
		return new ConfirmationPage(driver);
		
		
	}
}
