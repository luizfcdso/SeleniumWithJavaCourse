package br.com.luiz.model;

public class Estudante extends Pessoa{
	
	
	private int RA;
	private String Curso;
	
	@Override
	public String toString() {
		
		return getCurso();
	}
	
	
	public int getRA() {
		return RA;
	}
	public void setRA(int rA) {
		RA = rA;
	}
	public String getCurso() {
		return Curso;
	}
	public void setCurso(String curso) {
		Curso = curso;
	}

}
