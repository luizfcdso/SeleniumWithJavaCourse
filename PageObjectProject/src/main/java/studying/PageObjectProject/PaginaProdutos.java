package studying.PageObjectProject;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import studying.AbstractComponent.AbstractComponent;

public class PaginaProdutos extends AbstractComponent {

	WebDriver driver;
	public PaginaProdutos(WebDriver driver) {
		super();
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css = "a[class='dropdown-item']")
	WebElement goToProducts;

	@FindBy(xpath = "(//h2[@class='h3 product-title'])")
	List<WebElement> listProducts;

	@FindBy(css = ".btn.btn-primary.add-to-cart")
	WebElement addCartClick;

	@FindBy(css = ".btn.btn-secondary")
	WebElement backClick;

	public void addProdutos(String productName, String productName1) throws InterruptedException {
		goToProducts.click();

		for (WebElement product : listProducts) {
			String value = product.getText();
			if (value.equalsIgnoreCase(productName)) {
				product.click();
				WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

				wait.until(ExpectedConditions.elementToBeClickable(addCartClick)).click();
				wait.until(ExpectedConditions.elementToBeClickable(backClick)).click();
				driver.navigate().back();
			}
			if (value.equalsIgnoreCase(productName1)) {
				product.click();
				WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
				wait.until(ExpectedConditions.elementToBeClickable(addCartClick)).click();
				wait.until(ExpectedConditions.elementToBeClickable(backClick)).click();
				driver.navigate().back();
				break;
			}
		}

		driver.navigate().refresh();
	}

}
