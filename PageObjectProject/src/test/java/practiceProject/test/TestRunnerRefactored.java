package practiceProject.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import studying.PageObjectProject.Carrinho;
import studying.PageObjectProject.Pagamento;
import studying.PageObjectProject.PaginaDeLogin;
import studying.PageObjectProject.PaginaProdutos;

public class TestRunnerRefactored {

	private static WebDriver driver;
	

	public static void main(String[] args) throws InterruptedException {

 
		
		setWebDriver();
		loginAndAddProducts();
		checkCartAndPay();

	}

	private static void setWebDriver() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		
	}


	private static void loginAndAddProducts() throws InterruptedException {
		
		String email = "luizxtcosta@gmail.com";
		String pass = "Test@123";
		String productName = "Hummingbird printed t-shirt";
		String productName1 = "Hummingbird printed sweater";
		
		 PaginaDeLogin paginaDeLogin = new PaginaDeLogin(driver);
	     paginaDeLogin.goTo();
	     paginaDeLogin.loginAplicacao(email, pass);
		
		PaginaProdutos paginaProdutos = new PaginaProdutos(driver);
        paginaProdutos.addProdutos(productName, productName1);

	}
	
	private static void checkCartAndPay() throws InterruptedException {
		
		 String productName = "Hummingbird printed t-shirt";
	        String productName1 = "Hummingbird printed sweater";
	        String message = "Please, do not take much time to delivery it. I need it urgently!";

	        Carrinho carrinho = new Carrinho(driver);
	        carrinho.goToCart();
	        carrinho.checkCart(productName, productName1);

	        Pagamento pagamento = new Pagamento(driver);
	        pagamento.paying(message);
	}

}
