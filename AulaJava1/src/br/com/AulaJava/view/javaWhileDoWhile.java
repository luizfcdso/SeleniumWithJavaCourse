package br.com.AulaJava.view;

public class javaWhileDoWhile {

	public static void main(String[] args) {
		int valor = -20;
		int valorMax = 10;
		
		System.out.println("Condição: " +(valor >= valorMax));
		while (valor <= valorMax) {
			System.out.println("Valor: " + valor++);
			
		}
	}

}
