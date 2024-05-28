package studying.PageObjectProject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import net.bytebuddy.agent.builder.AgentBuilder.RedefinitionStrategy.Listener.Pausing;
import studying.AbstractComponent.AbstractComponent;

public class Pagamento extends AbstractComponent{

	WebDriver driver;

	
	public Pagamento(WebDriver driver) {
		super();
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(xpath = "//a[normalize-space()='Proceed to checkout']")
	WebElement checkout;
	
	
	@FindBy(css = "button[name='confirm-addresses']")
	WebElement confirmAdress;
	
	@FindBy(css = "textarea[id='delivery_message']")
	WebElement deliveryMessage;
	
	@FindBy(css = "button[name='confirmDeliveryOption']")
	WebElement confirmDelivery;
	
	@FindBy(css = "input[id='payment-option-1']")
	WebElement payOption;
	
	@FindBy(css = "input[type='checkbox']")
	WebElement checkbox;
	
	@FindBy(css = "button[class='btn btn-primary center-block']")
	WebElement confirm;
	

	public void paying(String message) {
		checkout.click();
		confirmAdress.click();
		deliveryMessage.sendKeys(message);
		confirmDelivery.click();
		//Thread.sleep(1000);
		payOption.click();
		checkbox.click();
		confirm.click();
		
		
		
	}
		
	
	
	

}
