package com.ifsc.ctds.pessoa;

public class Pessoa {
	private String nome;
	private int idade;

	public Pessoa(String valorNome, int valorIdade) { // metodo construtor
		this.nome = valorNome;
		this.idade = valorIdade;
	}
	/**
	 * Retorna o saldo da conta.
	 * 
	 * @return int, String;
	 * */
	public void dizerNome() {
		System.out.println("Olá meu nome é " + this.nome);

	}

	public void valorIdade() {
		System.out.println("Olá, eu tenho " + this.idade + "anos");

	}

	public void fazerAniversario() {
		this.idade = this.idade + 1;

	}
}

