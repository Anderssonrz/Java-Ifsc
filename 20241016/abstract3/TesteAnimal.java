package com.ifsc.ctds;

import java.util.ArrayList;

public class TesteAnimal {

	public static void main(String[] args) {
		ArrayList<Animal> listaAnimais = new ArrayList<Animal>();
		Cachorro rex = new Cachorro();
		rex.emitirSom();

		Gato garfeld = new Gato();
		garfeld.emitirSom();

		Animal gato2 = new Gato();
		gato2.emitirSom();
		
		Leao lion = new Leao();
		lion.emitirSom();

		for (int i = 0; i < listaAnimais.size(); i++) {
			Animal umAnimal = listaAnimais.get(i);
			umAnimal.emitirSom();
		}
	}

}
