package moreAboutSelenium;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class fileUpload {

	static ChromeDriver driver;

	public static void main(String[] args) throws IOException, InterruptedException {

		WebDriver driver = new ChromeDriver();

		driver.get("https://convertio.co/pt/pdf-doc/");
		
		driver.findElement(By.className("action-label")).click();
		//PRECISA AGUARDAR ALGUNS MILISEGUNDOS PARA GARANTIR QUE O ARQUIVO FOI SELECIONADO
		Thread.sleep(800);
		uploadFile("C:\\Users\\Luiz Fernando\\Documents\\Test\\Portfolio.pdf");
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions
				.visibilityOfAllElementsLocatedBy(By.cssSelector("button[class='btn btn-xl btn-primary']")));
		driver.findElement(By.cssSelector("button[class='btn btn-xl btn-primary']")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".btn.btn-sm.btn-blue")));
		driver.findElement(By.cssSelector(".btn.btn-sm.btn-blue")).click();
		Thread.sleep(3000);
		File file = new File("C:\\Users\\Luiz Fernando\\Downloads\\Portfolio.doc");

		if (file.exists()) {
			
			System.out.println("Arquivo encontrado");
		} else {
			
			System.out.println("Arquivo NÃO encontrado");
		}
	}

	
		//	USANDO ROBOT PARA SELECIONAR O ARQUIVO. INTERAÇÃO COM WINDOWS
	public static void setClipboardData(String string) {
		// StringSelection is a class that can be used for copy and paste operations.
		StringSelection stringSelection = new StringSelection(string);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);
	}

	public static void uploadFile(String fileLocation) {
		try {
			// Setting clipboard with file location
			setClipboardData(fileLocation);
			// native key strokes for CTRL, V and ENTER keys
			Robot robot = new Robot();

			robot.keyPress(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_V);
			robot.keyRelease(KeyEvent.VK_V);
			robot.keyRelease(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);
		} catch (Exception exp) {
			exp.printStackTrace();
		}

	}

}
