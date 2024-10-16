package com.ifsc.ctds;

public class Peixe extends Animal {

	private String caracteristica;
	
	public Peixe(String valorNome, float valorComprimento, int numeroPatas, String corAnimal, String habitat,
			float rapidez, String caracteristica) {
		super(valorNome, valorComprimento, numeroPatas, corAnimal, habitat, rapidez);
		this.caracteristica = caracteristica;
	}

	public String getCaracteristica() {
		return caracteristica;
	}

	public void setCaracteristica(String caracteristica) {
		this.caracteristica = caracteristica;
	}

	public void dadosPeixe() {
		super.imprimirDados();
		System.out.println("Característica....: " + this.getCaracteristica());
	}
}
