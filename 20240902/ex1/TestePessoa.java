package com.ifsc.ctds.pessoa;

public class TestePessoa {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Pessoa eu = new Pessoa("Fulano", 20);
		Pessoa outra = new Pessoa("Ciclano", 30);
		Pessoa maisuma = new Pessoa("Beltrsno", 40);

		eu.dizerNome();
		eu.valorIdade();
		eu.fazerAniversario();
		eu.valorIdade();

		outra.dizerNome();
		outra.valorIdade();
		outra.fazerAniversario();
		outra.valorIdade();

		maisuma.dizerNome();
		maisuma.valorIdade();
		maisuma.fazerAniversario();
		maisuma.valorIdade();
	}

}
