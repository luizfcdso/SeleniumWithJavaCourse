import java.time.Duration;
import java.util.Optional;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v119.fetch.Fetch;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class NetworkMocking {
	
	
	static ChromeDriver driver;

	public static void main(String[] args) throws InterruptedException {
		
		//WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		
		
		
		driver = new ChromeDriver();
		
		DevTools devTools = driver.getDevTools();
		devTools.createSession();
		
		devTools.send(Fetch.enable(Optional.empty(), Optional.empty()));
		devTools.addListener(Fetch.requestPaused(), request-> {
			if(request.getRequest().getUrl().contains("shetty")) {
				String newUrl = request.getRequest().getUrl().replace("=shetty", "=BadGuy");
				System.out.println(newUrl);
				devTools.send(Fetch.continueRequest(request.getRequestId(), Optional.of(newUrl), Optional.of(request.getRequest().getMethod()), 
						Optional.empty(), Optional.empty(), Optional.empty()));		
				}else {
					devTools.send(Fetch.continueRequest(request.getRequestId(), Optional.of(request.getRequest().getUrl()), Optional.of(request.getRequest().getMethod()), 
							Optional.empty(), Optional.empty(), Optional.empty()));
				}
			
		});
		driver.get("https://rahulshettyacademy.com/angularAppdemo/");
		driver.findElement(By.cssSelector("button[routerlink*='library']")).click();
		Thread.sleep(3000);
		System.out.println(driver.findElement(By.cssSelector("p")).getText());
		
		//WebElement button = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("p")));
		//System.out.println(button.getText());
		
		
	}

}
