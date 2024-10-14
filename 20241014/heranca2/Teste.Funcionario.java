package com.ifsc.ctds;

public class TesteFuncionario {

	public static void main(String[] args) {
		Funcinario fulano = new Funcinario();
		Funcinario ciclano = new Funcinario();


		fulano.setNome("fulano");
		System.out.println("Nome: " + fulano.getNome());
		
		ciclano.setNome("ciclano");
		System.out.println("Nome: " + fulano.getNome());
	}

}
