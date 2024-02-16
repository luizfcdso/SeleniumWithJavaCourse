package MyProject.practiceProject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class exerciseFrameAssigmentNested {

	
	static ChromeDriver driver;
	
	public static void main(String[] args) {

		// PARA PEGAR UM VALOR DENTRO DE UM FRAME, PRECISA MUDAR O FRAME PARA O TOP E PARA O MEIO
		
		driver = new ChromeDriver();
		driver.get("https://the-internet.herokuapp.com/nested_frames");
		
		 // Mudar para o frame externo
		driver.switchTo().frame("frame-top");
		
		 // Mudar para o frame interno
		driver.switchTo().frame("frame-middle");
		
		WebElement value = driver.findElement(By.id("content"));
		
		//String text = value.getAttribute("text");
		
		System.out.println(value.getText());
		driver.close();
	}

}
