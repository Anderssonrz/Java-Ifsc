package com.ifsc.ctds.banco;

public class TesteBanco {

	public static void main(String[] args) {
		Conta minhaConta = new Conta(500.00);
		minhaConta.saque(150.00);
		minhaConta.deposito(22.50);
		minhaConta.saque(47.62);
		System.out.println("+======== SALDO =======+");

		System.out.println("|Saldo: R$"+ String.format("%.2f     +", minhaConta.getSaldo()));
	}

}
