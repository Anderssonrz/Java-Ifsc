	package com.ifsc.ctds;

	import java.util.Scanner;

	public class Principal {

		public static void main(String[] args) {
			Scanner teclado = null;
			Media media = null;
			double nota1 = 0;
			double nota2 = 0;
			double nota3 = 0;
			double nota4 = 0;
			double soma = 0;

			try {
				teclado = new Scanner(System.in);

				System.out.println("Digite a primeira nota: ");
				nota1 = teclado.nextDouble();

				System.out.println("Digite a segunda nota: ");
				nota2 = teclado.nextDouble();

				System.out.println("Digite a terceira nota: ");
				nota3 = teclado.nextDouble();

				System.out.println("Digite a quarta nota: ");
				nota4 = teclado.nextDouble();

				soma = nota1 + nota2 + nota3 + nota4;

				media = new Media();

				media.calcularMedia(soma, 4);
				media.imprimirMedia();
			} catch (IllegalStateException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				teclado.close();
			}
		}
	}
