import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import org.openqa.selenium.devtools.v119.fetch.model.RequestPattern;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v119.fetch.Fetch;
import org.openqa.selenium.devtools.v119.network.model.ErrorReason;

public class NetworkFailedRequest {

	static ChromeDriver driver;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		driver = new ChromeDriver();

		DevTools devTools = driver.getDevTools();

		devTools.createSession();

//		Aqui, um padr�o de requisi��o � definido usando a classe RequestPattern do
//		DevTools. Este padr�o parece indicar que qualquer requisi��o que contenha 
//		a string "GetBook" no seu URL deve ser manipulada.

		Optional<List<RequestPattern>> patterns = Optional
				.of(Arrays.asList(new RequestPattern(Optional.of("*GetBook*"), Optional.empty(), Optional.empty())));

		Optional<Boolean> optinalBoolean = Optional.empty();

		// A fun��o enable do namespace Fetch do DevTools est� sendo chamada para ativar
		// o monitoramento de requisi��es com base nos padr�es definidos anteriormente.
		
		devTools.send(Fetch.enable(patterns, optinalBoolean));

		// Aqui, um ouvinte est� sendo adicionado para o evento requestPaused. Isso
		// significa que o c�digo ser� notificado sempre que uma requisi��o for pausada.
		// Quando isso acontecer, a fun��o failRequest do namespace Fetch � chamada para
		// simular que a requisi��o falhou.
		
		devTools.addListener(Fetch.requestPaused(), request -> {
			devTools.send(Fetch.failRequest(request.getRequestId(), ErrorReason.FAILED));

		});
		driver.get("https://rahulshettyacademy.com/angularAppdemo/");
		driver.findElement(By.cssSelector("button[routerlink*='library']")).click();

	}

}
