package com.ifsc.ctds;

public class Media {

		private double media;

		public void calcularMedia(double somaNotas, int quantNotas) {
			this.media = somaNotas / quantNotas;
		}

		public void imprimirMedia() {
			System.out.println("A m�dia �: " + String.format("%.2f", this.media));
		}

}
