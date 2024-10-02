package com.ifsc.ctds.lampada;

public class TesteLampada {

	public static void main(String[] args) {
		Lampada  lampadaP = new Lampada();
		
		lampadaP.acender();
		lampadaP.informarSituacao();
		lampadaP.apagar();
		lampadaP.informarSituacao();
		lampadaP.informarPotencia(150.5);

 	}

}
