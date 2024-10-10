/* 10 – Faça um programa para ler e imprimir uma matriz 2 × 4 de números inteiros.*/

package com.ifsc.ctds;

import java.util.Scanner;

public class Matriz2x4 {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		int[][] matriz = new int[2][4];

		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < 4; j++) {
				System.out.print("Digite o valor para a posição [" + i + "][" + j + "]: ");
				matriz[i][j] = scanner.nextInt();
			}
		}

		System.out.println("Matriz 2x4:");
		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < 4; j++) {
				System.out.print(matriz[i][j] + " ");
			}
			System.out.println();
		}

		scanner.close();
	}
}
