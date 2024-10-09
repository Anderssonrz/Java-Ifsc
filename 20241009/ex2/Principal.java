package com.ifsc.ctds;

import java.util.Scanner;

public class Principal {

	public static void main(String[] args) {

		Scanner teclado = null;
		Media media = null;
		double nota1, nota2, nota3, nota4, soma;

		try {
			teclado = new Scanner(System.in);
			media = new Media();

			System.out.println("Digite a primeira nota: ");
			nota1 = teclado.nextDouble();

			System.out.println("Digite a segunda nota: ");
			nota2 = teclado.nextDouble();

			System.out.println("Digite a terceira nota: ");
			nota3 = teclado.nextDouble();

			System.out.println("Digite a quarta nota: ");
			nota4 = teclado.nextDouble();

			soma = nota1 + nota2 + nota3 + nota4;

			media.calcularMedia(soma, 4);
			media.imprimirMedia();

			if (media.aprovado()) {
				System.out.println("Aluno aprovado");
			} else if (media.exame()) {
				System.out.println("Aluno ficou em exame! ");
				System.out.println("digite a nota do exame: ");
				double notaExame = teclado.nextDouble();

				double novaMedia = (media.getMedia() + notaExame / 2);
				System.out.println("A nova media:" + String.format("%.2f", novaMedia));

				if (novaMedia >= 5) {
					System.out.println("Aluno aprovado por conta do exame");
				} else {
					System.out.println("Aluno reprovado");
				}
			} else {
				System.out.println("Aluno reprovado");

			}

		} catch (IllegalStateException e) {
			System.out.println("Erro no estado do scanner: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Ocorreu um erro: " + e.getMessage());
		} finally {
			if (teclado != null) {
				teclado.close();

			}
		}
	}
}
