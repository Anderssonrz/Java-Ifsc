package com.ifsc.ctds;

public class Gerente extends Funcinario{
	
	private int senha;
	
	
	public int getSenha() {
		return senha;
	}


	public void setSenha(int senha) {
		this.senha = senha;
	}


	public boolean validarSenha(int valorSenha) {
		if (this.senha == valorSenha) {
			return true;
		}

		return false;
	}
}
