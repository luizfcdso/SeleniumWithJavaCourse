package studying.PageObjectProject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import lessonrahuludemy.LandingPage;
import lessonrahuludemy.ProductCatalogue;
import studying.AbstractComponent.AbstractComponent;


public class PaginaDeLogin extends AbstractComponent{
	

		WebDriver driver;

		public PaginaDeLogin(WebDriver driver) {
		super();
		this.driver = driver;
		PageFactory.initElements(driver, this);
		}
	
		

		@FindBy(css = "span[class='hidden-sm-down']")
		WebElement clickLogin;
		
		@FindBy(css = "input[class='form-control']")
		WebElement userEmail;
		
		@FindBy(css = "input[name='password']")
		WebElement passwordEle;
		
		@FindBy(css = "#submit-login")
		WebElement submeter;
		
		public void loginAplicacao(String email, String password) {
			clickLogin.click();
			userEmail.sendKeys(email);
			passwordEle.sendKeys(password);
			submeter.click();
		};
			
		
		
		public void goTo() {
			 if (driver == null) {
		            System.out.println("DEBUG: Objeto driver é nulo!");
		        }
			driver.get("http://teststore.automationtesting.co.uk/");
	
		}
			

}
