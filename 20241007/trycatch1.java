package com.ifsc.ctds;

public class Principal {

	public static void main(String[] args) {
		int resultado = Principal.divisao(2, 0 );
		System.out.println(resultado);

	}
	public static int divisao(int a, int b) {
		return a / b;
	}
	

}
