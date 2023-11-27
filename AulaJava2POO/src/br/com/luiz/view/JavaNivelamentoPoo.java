package br.com.luiz.view;

import br.com.luiz.model.Estudante;
import br.com.luiz.model.Pessoa;
import br.com.luiz.model.Professor;

public class JavaNivelamentoPoo {
	
	public static void main (String[] args) {
		
		Pessoa objeto = new Pessoa(); 
		
		objeto.setNome(" Luiz");
		objeto.setEmail("luizxtcosta@gmail.com");
		objeto.setTelefone("34999999");
		
		System.out.println(objeto.minhaLingua());
		System.out.println("Email: "+objeto.getEmail());
		System.out.println("Telefone: "+objeto.getTelefone());
		
		Pessoa joao = new Pessoa();
		
		
		joao.setNome("\n\njoao");
		joao.setEmail("joao@gmail.com");
		joao.setTelefone("34999999");
		
		System.out.println("Nome: "+joao.getNome());
		System.out.println("Email: "+joao.getEmail());
		System.out.println("Telefone: "+joao.getTelefone());
		
		
		
		Estudante estudante = new Estudante();
		System.out.println("\n");
		estudante.setNome("Maria");
		estudante.setCurso("Matemática");
		estudante.setRA(123);
		
		Professor professor = new Professor();
		
		professor.setNome("Lucas");
		professor.setTitulo("Desenvolvedor mobile");
		
		System.out.println("Nome: "+estudante.getNome()+"\nRA: "+estudante.getRA()+"\nNome do Prof: "+professor.getNome()+"\nTitulo: "+professor.getTitulo());
		
		System.out.println("toString: "+professor.toString());
		System.out.println("toString: "+estudante.toString());
		
		
		
	}

}
