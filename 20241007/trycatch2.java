package com.ifsc.ctds;

public class Principal {

	public static void main(String[] args) {
		try {
			int resultado = Principal.divisao(2, 4);
			System.out.println(resultado);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static int divisao(int a, int b) throws ArithmeticException {
		if (b == 0) {
			throw new ArithmeticException();

		}
		return a / b;
	}
}
