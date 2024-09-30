package com.ifsc.ctds.banco;

import java.util.Scanner;

public class TesteBanco {

	public static void main(String[] args) {
		
		Conta minhaConta;
		Scanner teclado = new Scanner(Scanner.in);
		double valor = 0;
		
		System.out.println("Digite o valor inical da conta: ");
		valor = teclado.nextDouble();
		minhaConta.saque(valor);

		System.out.println("Digite o valor do saque: ");

		minhaConta.deposito(valor);
		valor = teclado.nextDouble();

		System.out.println("Digite o valor do deposito: ");
		valor = teclado.nextDouble();
		minhaConta.saque(valor);
		
		System.out.println("+======== SALDO =======+");
		System.out.println("|Saldo: R$"+ String.format("%.2f     +", minhaConta.getSaldo()));
		
		teclado.close();
	}

}
