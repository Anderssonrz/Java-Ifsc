package com.ifsc.ctds;

import java.util.ArrayList;

public class TesteAnimal {

	public static void main(String[] args) {
		ArrayList<Animal> listaAnimais = new ArrayList<Animal>();
		Cachorro dog = new Cachorro();
		listaAnimais.add(dog);

		Cachorro dog2 = new Cachorro();
		listaAnimais.add(dog2);

		Gato garfeld = new Gato();
		listaAnimais.add(garfeld);

		Animal gato2 = new Gato();
		listaAnimais.add(gato2);

		Leao lion = new Leao();
		listaAnimais.add(lion);

		for (int i = 0; i < listaAnimais.size(); i++) {
			Animal umAnimal = listaAnimais.get(i);
			umAnimal.emitirSom();

		}
		Animal animal = new Gato();
		if (animal instanceof Gato) {
			Gato umGato = (Gato) animal;
			umGato.emitirSom();
		}
	}

}
