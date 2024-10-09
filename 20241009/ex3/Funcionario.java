package com.ifsc.ctds;

public class Funcionario {
    private String nome;
    private String sobrenome;
    private double horasTrabalhadas;
    private double valorPorHora;
    
    public void informarNome(String meuNome, String meuSobrenome) {
        this.nome = meuNome;
        this.sobrenome = meuSobrenome;
    }

    public void nomeCompleto() {
        System.out.println("Nome completo: " + this.nome + " " + this.sobrenome);
    }
    
    public void calcularSalario() {
        double salarioBase = this.horasTrabalhadas * this.valorPorHora;
        double salarioTotal = salarioBase;

        if (this.horasTrabalhadas > 160) { // Considera horas extras
            double horasExtras = this.horasTrabalhadas - 160;
            double valorHoraExtra = this.valorPorHora * 1.5; // 50% a mais
            salarioTotal += horasExtras * valorHoraExtra;
        }

        System.out.println("Salário total R$: " + String.format("%.2f", salarioTotal));
    }

    public void incrementarHoras(double horas) {
        this.horasTrabalhadas += horas; 
    }

    public void setValorPorHora(double valorPorHora) {
        this.valorPorHora = valorPorHora;
    }
    
    public void setHorasTrabalhadas(double horasTrabalhadas) {
        this.horasTrabalhadas = horasTrabalhadas;
    }
}
