package com.ifsc.ctds;

public class TesteFuncionario {

    public static void main(String[] args) {
        Funcionario eu = new Funcionario();

        eu.informarNome("Fulano", "Ciclano");
        eu.incrementarHoras(10); // Exemplo de incremento de horas
        eu.setValorPorHora(25.50);
        
        eu.nomeCompleto();
        eu.setHorasTrabalhadas(170); // Total de horas trabalhadas
        eu.calcularSalario(); // Calcula e imprime o salário total
    }
}
