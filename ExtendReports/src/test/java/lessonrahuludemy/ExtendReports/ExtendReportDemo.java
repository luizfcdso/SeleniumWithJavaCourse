package lessonrahuludemy.ExtendReports;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ExtendReportDemo {
	ExtentReports  extent;
	
	
	
	
	@BeforeTest
	public void confing() {
		// ExtentReports = main class reponsável por dirigir todos a execução , ExtentSparkReporter é a helper, que ajuda na configuração
		String path = System.getProperty("user=dir") + "\\reports\\index.html";
		ExtentSparkReporter reporter = new ExtentSparkReporter(path);
		reporter.config().setResourceCDN("Web Automation Results"); // config o nome do relaórioo 
		reporter.config().setDocumentTitle("Test Results");
		
		extent = new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Tester", "Luiz Fernando");
		
		
	}
	
	@Test
	public void initialDemo() {
		ExtentTest test = extent.createTest("Initial Demo");
		WebDriverManager.chromedriver().setup();

		//System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com");
		System.out.println(driver.getTitle());
		
		driver.close();
		test.fail("Results do not match");
		
		extent.flush();//notificação que foi feito o teste
		
		
		
		
	}

}
