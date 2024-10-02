package com.ifsc.ctds.funcionario;

public class TesteFuncionario {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Funcionario eu = new Funcionario();

		eu.informarNome("Fulano", "Ciclano");
		eu.incrementarHoras(10);
		eu.setValorPorHora(25.50);
		
		eu.nomeCompleto();
		eu.calcularSalario();
		
		eu.setHorasTrabalhadas(8);
		eu.calcularSalario();
	}

}
	
