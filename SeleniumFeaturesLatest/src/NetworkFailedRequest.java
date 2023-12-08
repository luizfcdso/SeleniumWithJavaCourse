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

//		Aqui, um padrão de requisição é definido usando a classe RequestPattern do
//		DevTools. Este padrão parece indicar que qualquer requisição que contenha 
//		a string "GetBook" no seu URL deve ser manipulada.

		Optional<List<RequestPattern>> patterns = Optional
				.of(Arrays.asList(new RequestPattern(Optional.of("*GetBook*"), Optional.empty(), Optional.empty())));

		Optional<Boolean> optinalBoolean = Optional.empty();

		// A função enable do namespace Fetch do DevTools está sendo chamada para ativar
		// o monitoramento de requisições com base nos padrões definidos anteriormente.
		
		devTools.send(Fetch.enable(patterns, optinalBoolean));

		// Aqui, um ouvinte está sendo adicionado para o evento requestPaused. Isso
		// significa que o código será notificado sempre que uma requisição for pausada.
		// Quando isso acontecer, a função failRequest do namespace Fetch é chamada para
		// simular que a requisição falhou.
		
		devTools.addListener(Fetch.requestPaused(), request -> {
			devTools.send(Fetch.failRequest(request.getRequestId(), ErrorReason.FAILED));

		});
		driver.get("https://rahulshettyacademy.com/angularAppdemo/");
		driver.findElement(By.cssSelector("button[routerlink*='library']")).click();

	}

}
