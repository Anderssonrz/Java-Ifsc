package com.ifsc.ctds.banco;

public class Conta {

	private double saldo;

	public Conta(double valor) {
		this.saldo = valor;
	}
/**
 * Retorna o saldo da conta.
 * 
 * @return double
 * */
	public double getSaldo() {
		return this.saldo;
	}

	public void deposito(double valor) {
		this.saldo = this.saldo + valor;
	}

	public void saque(double valor) {
		this.saldo = this.saldo - valor;

	}
}
