package studying.PageObjectProject;

import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import studying.AbstractComponent.AbstractComponent;

public class Carrinho extends AbstractComponent {

	WebDriver driver;

	public Carrinho(WebDriver driver) {
		super();
		this.driver= driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css = "div[class='header']")
	WebElement cartButton;
	
	@FindBy(css = "div[class='product-line-info']")
	List<WebElement> listP;
	
	
	
	public void goToCart() {
		cartButton.click();
	}
	
	
	public void checkCart(String productName, String productName1) {
		List<WebElement> productCart = listP;
		List<String> listP = productCart.stream().map(WebElement::getText).collect(Collectors.toList());
		System.out.println("************************" + listP + "**************************");
		Assert.assertEquals(listP.contains(productName), listP.contains(productName1));
	}
	


	

	

}
