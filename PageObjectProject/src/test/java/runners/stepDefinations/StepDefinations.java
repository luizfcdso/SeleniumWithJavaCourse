package runners.stepDefinations;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.Before;
import io.cucumber.java.en.*;
import lessonrahuludemy.LandingPage;
import practiceProject.test.TestRunner;
import studying.AbstractComponent.AbstractComponent;
import studying.PageObjectProject.Carrinho;
import studying.PageObjectProject.Pagamento;
import studying.PageObjectProject.PaginaDeLogin;
import studying.PageObjectProject.PaginaProdutos;


public class StepDefinations  {

	
	WebDriver driver = new ChromeDriver(); 
		
	@Given("^realizo o login com \"([^\"]*)\" e senha \"([^\"]*)\"$")
	public void logged_in_with_my_luizxtcosta_gmail_com_and_test(String username, String password) {
		
		PaginaDeLogin paginaDeLogin = new PaginaDeLogin(driver);
		driver.manage().window().maximize();
		paginaDeLogin.goTo();
		paginaDeLogin.loginAplicacao(username, password);
	
	}

	@When("^adiciono os produtos no carrinho (.+) and (.+)$")
	public void adiciono_os_produtos_no_carrinho_hummingbird_printed_t_shirt_and_hummingbird_printed_sweater(String produto1) throws InterruptedException {
		
		PaginaProdutos paginaProdutos = new PaginaProdutos(driver);
		paginaProdutos.addProdutos(produto1, produto1);

		
	}

	@And("^estes produtos foram add (.+) and (.+)$")
	public void estes_produtos_foram_add_hummingbird_printed_t_shirt_and_hummingbird_printed_sweater(String produto1, String produto2) {
		Carrinho carrinho = new Carrinho(driver);
		carrinho.goToCart();
		carrinho.checkCart(produto1, produto2);
	
	}

	@Then("minha compra foi feita")
	public void minha_compra_foi_feita() {
		Pagamento pagamento = new Pagamento(driver);
		pagamento.paying("envia minha compra rápido");
	    
	}
	
}
