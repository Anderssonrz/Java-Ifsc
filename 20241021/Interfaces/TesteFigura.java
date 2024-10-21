package com.ifsc.ctds;

public class TesteFigura {

	public static void main(String[] args) {
		Quadrado quadrado = new Quadrado();
		
		quadrado.setLado(2);
		System.out.println("=====Info=======");
		System.out.println("Figura: " + quadrado.getFigura());
		System.out.println("Area: " + quadrado.getArea());
		System.out.println("Perimetro: " + quadrado.getPerimetro());



	}

}
