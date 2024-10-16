package com.ifsc.ctds;

public class Mamifero extends Animal {
	
	private String alimento;

	public Mamifero(String valorNome, float valorComprimento, int numeroPatas, String corAnimal, String habitat,
			float rapidez, String alimento) {
		super(valorNome, valorComprimento, numeroPatas, corAnimal, habitat, rapidez);
		
		this.alimento = alimento;
	}

	public String getAlimento() {
		return alimento;
	}

	public void setAlimento(String alimento) {
		this.alimento = alimento;
	}


	
	public void dadosMamifero() {
		super.imprimirDados();
		System.out.println("Alimento..........: " + this.getAlimento());
	
	}	

}
