package com.ifsc.ctds;

public class Emprestimo {

    private double valorEmprestimo;
    private int numeroParcelas;

    public Emprestimo(double valorEmprestimo, int numeroParcelas) {
        this.valorEmprestimo = valorEmprestimo;
        this.numeroParcelas = numeroParcelas;
    }

    public double calcularValorParcela() {
        return valorEmprestimo / numeroParcelas;
    }

    public boolean isAprovado(double salario) {
        double valorParcela = calcularValorParcela(); 
        return valorParcela <= (0.3 * salario);
    }
}
