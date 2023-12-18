package seleniumBrowserCloud;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;


public class TestDemo {
	
	
	@Test
	public void titleCheck() throws MalformedURLException {
		
	MutableCapabilities capabilities = new MutableCapabilities();
	WebDriver driver = new RemoteWebDriver(new URL("https://hub.browserstack.com/wd/hub"), capabilities);
	driver.get("https://rahulshettyacademy.com/");
	System.out.println(driver.getTitle());
	//Assert.assertTrue(driver.getTitle().matches(""));
	
	

}}
