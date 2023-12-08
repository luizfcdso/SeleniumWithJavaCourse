import java.util.Optional;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v119.network.Network;

import com.google.common.collect.ImmutableList;

public class BlockNetworkRequests {

	static ChromeDriver driver;
	
	public static void main(String[] args) {

		
		driver = new ChromeDriver();

		DevTools devTools = driver.getDevTools();

		devTools.createSession();
		
		devTools.send(Network.enable(Optional.empty(), Optional.empty(), Optional.empty()));
		devTools.send(Network.setBlockedURLs(ImmutableList.of("*.jpg", "*.css")));
		driver.get("http://teststore.automationtesting.co.uk/");
		
		
	}

}
