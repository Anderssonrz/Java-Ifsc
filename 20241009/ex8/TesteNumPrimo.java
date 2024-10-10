package com.ifsc.ctds;

import java.util.Scanner;
public class TesteNumPrimo {
public static void main(String[] args) {
Scanner teclado = new Scanner(System.in);
System.out.printf("Informe o número inicial: ");
int numInicial = teclado.nextInt();
System.out.printf("Informe o número final: ");
int numFinal = teclado.nextInt();
// Passando os valores corretos para o construtor
NumPrimo meuPrimo = new NumPrimo(numInicial, numFinal);
// Chamando o método que separa os números primos
int resultado = meuPrimo.separarPrimo();
System.out.println("Total de números primos encontrados: " + resultado);
teclado.close();
}
}
