package br.com.AulaJava.view;

import java.io.IOException;

/*controle de Fluxo e Execução
 * Criar um game para receber letras digitadas via teclado
 * tratamento de erros 
 * swith case
 * char -- ASCII tabela universal de caracteres 
 * A = 65
 * Enter = 13
 * 
 */
public class JavaControledDeFluxo {

	public static void main(String[] args) throws IOException {
		
		System.out.print("Digite uma das letras da palavra Aplicativo: ---> ");
		
		int codigoASCII = System.in.read();
		
		
		
		switch ((char) codigoASCII){
		
		case 'A':
		case 'p':
		case 'l':
		case 'i':
		case 'c':
		case 'a':
		case 't':
		case 'v':
		case 'o':
		case 's':
			System.out.println("\nCódigo da tecla: "+codigoASCII);
			System.out.println("\nLetra digitada: "+(char)codigoASCII);
			break;
			default:
				System.out.println("\nLetra digitada não pertence a palavra Aplicativos");
			
		
		
		}

	}

}
