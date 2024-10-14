package com.ifsc.ctds;

public class TesteFuncionario {

	public static void main(String[] args) {
		Funcionario fulano = new Funcionario();
		Funcionario ciclano = new Funcionario();


		fulano.setNome("fulano");
		System.out.println("Nome: " + fulano.getNome());
		
		ciclano.setNome("ciclano");
		System.out.println("Nome: " + fulano.getNome());
	}

}
