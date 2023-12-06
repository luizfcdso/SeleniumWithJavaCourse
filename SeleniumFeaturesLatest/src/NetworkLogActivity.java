import java.util.Optional;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v119.network.Network;
import org.openqa.selenium.devtools.v119.network.model.AuthChallengeResponse.Response;
import org.openqa.selenium.devtools.v119.network.model.Request;

import io.opentelemetry.exporter.logging.SystemOutLogRecordExporter;

public class NetworkLogActivity {

	
	static ChromeDriver driver;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		driver = new ChromeDriver();
		
		DevTools devTools = driver.getDevTools();
		devTools.createSession();
		devTools.send(Network.enable(Optional.empty(), Optional.empty(), Optional.empty()));
		
		
		devTools.addListener(Network.requestWillBeSent(), request ->
				{
					Request req = request.getRequest();
					//System.out.println(req.getUrl());
					//System.out.println(req.getHeaders());
					
					
				});
		
		
		//Event will get fired 
		devTools.addListener(Network.responseReceived(), response -> 
		{
			org.openqa.selenium.devtools.v119.network.model.Response res = response.getResponse();
			if(res.getStatus().toString().startsWith("4")) {
				
				System.out.println(res.getUrl()+"is failing with status code " + res.getStatus());
				
			}
			
			
			//System.out.println(res.getUrl());
			//System.out.println(res.getStatus());
			
		});	
		
		driver.get("https://rahulshettyacademy.com/angularAppdemo/");
		driver.findElement(By.cssSelector("button[routerlink*='library']")).click();
		
		
		

	}

}
