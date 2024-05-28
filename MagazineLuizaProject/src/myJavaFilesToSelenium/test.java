
		package myJavaFilesToSelenium;
		import java.util.Iterator;
		import java.util.Set;

		import org.openqa.selenium.By;
		import org.openqa.selenium.WebDriver;
		import org.openqa.selenium.chrome.ChromeDriver;


public class test {

	static ChromeDriver driver;
	
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		
			


			
				// TODO Auto-generated method stub
				driver = new ChromeDriver();
				driver.manage().window().maximize();
				driver.get("https://www.rahulshettyacademy.com/loginpagePractise/");
				driver.findElement(By.cssSelector(".blinkingText")).click();
				Set<String> windows = driver.getWindowHandles(); //[parentid, childid]
				Iterator<String>it = windows.iterator();
				String parentID = it.next();
				String childId = it.next();
				driver.switchTo().window(childId);
				Thread.sleep(1000);
				String email = driver.findElement(By.cssSelector(".im-para.red")).getText().split("at")[1].trim().split(" ")[0];
				System.out.println(email);
				driver.switchTo().window(parentID);
				driver.findElement(By.id("username")).sendKeys(email);
				Thread.sleep(8000);
				driver.quit();
				
				
				

			}




	}

