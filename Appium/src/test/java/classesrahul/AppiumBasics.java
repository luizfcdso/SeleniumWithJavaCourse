package classesrahul;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;

import io.appium.java_client.android.options.UiAutomator2Options;


public class AppiumBasics {
	
	@Test
	public void AppiumTest() throws MalformedURLException, URISyntaxException {
		
		// Appium code -> Appium Server -> Mobile
		
		
		UiAutomator2Options options = new  UiAutomator2Options();
		options.setDeviceName("Pixel 4 API 30");
		options.setApp("C:\\Users\\Luiz Fernando\\eclipse-workspace\\Appium\\src\\test\\java\\resources\\ApiDemos-debug.apk");
		
		
		
		
		
		AndroidDriver driver = new AndroidDriver(new URI("http://127.0.0.1:4723").toURL(), options);
		
		
	}
}
