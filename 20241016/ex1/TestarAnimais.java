package com.ifsc.ctds;

public class TestarAnimais {

	public static void main(String[] args) {
		
		Mamifero camelo = new Mamifero("Camelo", 150f, 4, "Amarelo", "Terra", 2.0f, "Água");
		
		Peixe tubarao = new Peixe("Tubarao", 150f, 4, "Cinzento", "Mar", 1.5f, "Barbatanas e cauda");

		Mamifero ursocanada = new Mamifero("Urso-do-canadá", 180f, 4, "Vermelho", "Terra", 0.5f, "Mel");

		Oviparo tataruga = new Oviparo("Tartaruga", 1.0f, 4, "Verde", "Agua doce", 2.0f, false);

		camelo.imprimirDados();
		tubarao.imprimirDados();
		ursocanada.imprimirDados();
		tataruga.imprimirDados();

		
	}
	

}
