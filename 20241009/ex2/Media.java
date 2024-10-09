/*
2 – Faça um programa onde serão informados as quatro notas do aluno. O programa irá então apresentar a
média, se foi aprovado (nota ≥ 7) ou se ficou em exame.

Caso o aluno ficou em exame, o programa irá então
perguntar qual foi a nota do exame e então calculará a nova média (média anterior com a nota do exame) e
informar se ele foi aprovado (nova média ≥ 5) ou se foi reprovado. 
*/

package com.ifsc.ctds;

public class Media {
	private double media;

	public void calcularMedia(double somaNotas, int quantNotas) {
		this.media = somaNotas / quantNotas;
	}

	public void imprimirMedia() {
		System.out.println("A média : " + String.format("%.2f", this.media));
	}
	
	public double getMedia() {
		return this.media;
	}
	
	public boolean  aprovado() {
		return this.media >= 7;

	}
	public boolean  exame() {
    return this.media >= 5 && this.media < 7;

	}

}

