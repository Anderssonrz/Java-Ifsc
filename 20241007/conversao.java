package com.ifsc.ctds.conversao;

public class Principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int x = 10;
		float y = 5.5f;
		float z = 0;
		String valor = "10";
		String valor2 = "10.25";
		
		
		x = (int) y;
		System.out.println(x);
		
		y = x;
		System.out.println(y);

		x = Integer.parseInt(valor);
		System.out.println(x);
		
		
		z = Float.parseFloat(valor2);
		System.out.println(z);
		

		
	}

}
