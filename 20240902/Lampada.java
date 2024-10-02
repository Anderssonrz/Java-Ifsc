package com.ifsc.ctds.lampada;

public class Lampada {
	private boolean acesa;
	private double potencia;

	public void acender() {
	        this.acesa = true;
	}
	public void apagar() {
		this.acesa = false;
	}


	public void informarSituacao() {
		if (this.acesa) {
			System.out.println("A luz está acesa");
		} else {
			System.out.println("A luz está apagada");
		}
	}

	public void informarPotencia(double valorPotencia) {
		potencia = valorPotencia;
		System.out.println("A potência da lâmpada é " + this.potencia);
	}
}
