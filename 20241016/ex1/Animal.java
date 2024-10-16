package com.ifsc.ctds;

public class Animal {

	private String nome;
	private double comprimento;
	private int numeroDePatas;
	private String cor;
	private String ambiente;
	private double velocidadeMedia;

	public Animal(String valorNome, float valorComprimento, int numeroPatas, String corAnimal, String habitat,
			float rapidez) {
		this.nome = valorNome;
		this.comprimento = valorComprimento;
		this.numeroDePatas = numeroPatas;
		this.cor = corAnimal;
		this.ambiente = habitat;
		this.velocidadeMedia = rapidez;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public double getComprimento() {
		return comprimento;
	}

	public void setComprimento(double comprimento) {
		this.comprimento = comprimento;
	}

	public int getNumeroDePatas() {
		return numeroDePatas;
	}

	public void setNumeroDePatas(int numeroDePatas) {
		this.numeroDePatas = numeroDePatas;
	}

	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}

	public String getAmbiente() {
		return ambiente;
	}

	public void setAmbiente(String ambiente) {
		this.ambiente = ambiente;
	}

	public double getVelocdadeMedia() {
		return velocidadeMedia;
	}

	public void setVelocdadeMedia(double velocdadeMedia) {
		this.velocidadeMedia = velocdadeMedia;
	}

	public void imprimirDados() {
		System.out.println("");
		System.out.println("===Ficha do Animal===");
		System.out.println("Nome..............: " + this.getNome());
		System.out.println("Comprimento.......: " + this.getComprimento());
		System.out.println("Número de patas...: " + this.getNumeroDePatas());
		System.out.println("Cor...............: " + this.getCor());
		System.out.println("Ambiente..........: " + this.getAmbiente());
		System.out.println("Velocidade Média..: " + String.format("%.2f", this.getVelocdadeMedia()));
	}
}
