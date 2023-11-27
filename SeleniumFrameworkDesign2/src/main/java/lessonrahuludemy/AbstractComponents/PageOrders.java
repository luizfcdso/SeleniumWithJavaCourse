package lessonrahuludemy.AbstractComponents;

import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PageOrders extends AbstractComponent{
	
	

	WebDriver driver;
	
	
	
	public PageOrders(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
		

	}
	
	@FindBy(xpath = "//table//tbody//tr//td[2]")
	List<WebElement> listOrders;
	
	public Boolean listOrders(String nameProduct) {
				
		Boolean match = listOrders.stream().anyMatch(list->list.getText().equalsIgnoreCase(nameProduct));
		System.out.println(nameProduct);
		return match;
		
	}

}
