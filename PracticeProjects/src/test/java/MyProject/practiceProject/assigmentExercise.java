package MyProject.practiceProject;

import java.util.List;
import java.util.Random;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class assigmentExercise {

	
	static ChromeDriver driver;
	
	public static void main(String[] args) {

		//PEGANDO UM CHECKBOX ALEATORIO E SELECIONANDO, PEGANDO O VALOR DESSE CHECKBOX COMO TEXTO E SELECIONANDO NA LISTA SUSPENSA
		
		driver = new ChromeDriver();
		
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		List<WebElement> checkboxes = driver.findElements(By.xpath("(//div//label//input)[@type='checkbox']"));
		
			String textCheckbox = null;
	
		if (!checkboxes.isEmpty()) {
			Random random = new Random();
			WebElement checkrandom = checkboxes.get(random.nextInt(checkboxes.size()));
			checkrandom.click();
			
			textCheckbox = checkrandom.getAttribute("value");
		} else {
			System.out.println("nenhum checkbox encontrado");
		}
		
		
		System.out.println("Checkbox value: " + textCheckbox);
		
		WebElement selectedCB = driver.findElement(By.xpath("//option[@value='"+textCheckbox+"']"));
		selectedCB.click();
		//ESCREVENDO O NOME QUE FOI SELECIONANDO RANDOMLY NO INPUT EMAIL
		driver.findElement(By.xpath("//input[@id='name']")).sendKeys(textCheckbox);
		driver.findElement(By.xpath("//input[@class='btn-style'][1]")).click();
		
		Alert alert = driver.switchTo().alert();
		
		String textPopup = alert.getText();
		
		if(textPopup.contains(textCheckbox)){
			System.out.println(textPopup + " ************ "  + "it has, that's okay");
		} else {
			System.out.println("do not have a part of the message");
		}
		
		alert.accept();
		
		driver.close();
		}
		}
		
		
//		
//		
//		WebElement inputKeys = driver.findElement(By.xpath("//input[@placeholder='Type to Select Countries']"));
//		inputKeys.sendKeys("United");
//		driver.findElement(By.xpath("//div[@id='ui-id-4']")).click();
			
		
		
	

