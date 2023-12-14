package moreAboutSelenium;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.github.dockerjava.api.model.Driver;

public class fileUpload2 {
	
	static ChromeDriver driver;


	public static void main(String[] args) throws InterruptedException {

		//USANDO DE FORMA MAIS DIRETA, SELECIONANDO O ARQUIVO DENTRO DO PRÓPRIO INPUT SEM INTERAÇÃO COM WINDOWS

			WebDriver driver = new ChromeDriver();

			driver.get("https://convertio.co/pt/pdf-doc/");
			
			driver.findElement(By.xpath("//input[@id='pc-upload-add']")).sendKeys("C:\\Users\\Luiz Fernando\\Documents\\Test\\Portfolio.pdf");
			
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
			driver.close();
			
			
	}
	

	}
