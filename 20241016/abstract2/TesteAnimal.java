package com.ifsc.ctds;

public class TesteAnimal {

	public static void main(String[] args) {
		Cachorro rex = new Cachorro();
		Gato garfeld = new Gato();
		
		rex.emitirSom();
		garfeld.emitirSom();

		Animal gato2 = new Gato();
		gato2.emitirSom();
	}

}
