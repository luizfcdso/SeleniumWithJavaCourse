package MyProject.practiceProject;

import java.util.List;

import org.apache.commons.io.FileSystemUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class countNumberColumns {

	static ChromeDriver driver;

	public static void main(String[] args) {

		driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");

		// Se você está usando seletores CSS, então o seletor .table-display
		// td:nth-child(3) já faz exatamente o
		// que você precisa. Esse seletor CSS seleciona todas as células (td) que são
		// terceiros filhos (:nth-child(3))
		// de suas respectivas linhas em uma tabela com a classe table-display.

		List<WebElement> sumNumbers = driver.findElements(By.cssSelector(".table-display td:nth-child(3)"));

		int sum = 0;// vai armazenar os valores da terceira coluna

		for (int i = 0; i < sumNumbers.size(); i++) {
			// o i < size vai definir qual tamanho da lista que é 10, e cada vez que ele
			// passar por cada elemento, ele pega o elemento e passa ele para inteiro
			// dessa forma pega o get(i) que é o elemento da vez e extrai o texto, pega esse
			// texto e soma na proxima rodada.

			System.out.println(i + " **" + sumNumbers.size());

			sum = sum + Integer.parseInt(sumNumbers.get(i).getText());

			System.out.println(sum);
		}
		System.out.println(sum);

		driver.close();
	}

}
