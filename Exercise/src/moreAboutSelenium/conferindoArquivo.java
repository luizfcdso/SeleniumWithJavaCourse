package moreAboutSelenium;

import java.io.File;

public class conferindoArquivo {

	public static void main(String[] args) {


		File file = new File("C:\\Users\\Luiz Fernando\\Downloads\\Portfolio.doc");
		
		
		
		
		if(file.exists()) {
			System.out.println("Arquivo encontrado");
			
		} else {
			
			System.out.println("Arquivo NÃO encontrado");
			
		}   		
		
	}

}
