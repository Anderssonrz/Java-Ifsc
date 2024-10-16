package com.ifsc.ctds;

public class Oviparo extends Animal {
	
	private boolean sangueQuente;

	public Oviparo(String valorNome, float valorComprimento, int numeroPatas, String corAnimal, String habitat,
			float rapidez, boolean sangueQuente) {
		super(valorNome, valorComprimento, numeroPatas, corAnimal, habitat, rapidez);
		
		this.sangueQuente = sangueQuente;
	}

	public boolean isSangueQuente() {
		return sangueQuente;
	}

	public void setSangueQuente(boolean sangueQuente) {
		this.sangueQuente = sangueQuente;
	}
	
	public void imprimirDados() {
		super.imprimirDados();		
		System.out.println("Tem sangue quente?: " + (this.isSangueQuente() ? "Sim" : "Nao"));

	}	

}
