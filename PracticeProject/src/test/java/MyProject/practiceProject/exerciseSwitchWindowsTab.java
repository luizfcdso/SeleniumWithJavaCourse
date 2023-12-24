package MyProject.practiceProject;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class exerciseSwitchWindowsTab {

	
	static ChromeDriver driver;

	
	public static void main(String[] args) throws InterruptedException {
		driver = new ChromeDriver();
		
		driver.get("https://the-internet.herokuapp.com/windows");
		
		driver.findElement(By.linkText("Click Here")).click();
		
		Set<String> tabs = driver.getWindowHandles();
		Iterator<String> it = tabs.iterator();
		String child = it.next();
		String parent = it.next();
		
		driver.switchTo().window(child);
		
		
		System.out.println("this is the text of the child tab: " + driver.findElement(By.xpath("//body//div//h3")).getText());

		driver.switchTo().window(parent);
		
		System.out.println("this is the text of the parent tab: " + driver.findElement(By.xpath("//body//div//h3")).getText());

		
		driver.quit();
	}

}
