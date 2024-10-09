package com.ifsc.ctds;

import java.util.Scanner;

public class TesteEmprestimo {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite o valor do emprestimo: ");
        double valorEmprestimo = scanner.nextDouble();

        System.out.print("Digite o numero de parcelas: ");
        int numeroParcelas = scanner.nextInt(); 

        System.out.print("Digite o salario do solicitante: ");
        double salario = scanner.nextDouble(); 

        Solicitante solicitante = new Solicitante(salario);
        Emprestimo emprestimo = new Emprestimo(valorEmprestimo, numeroParcelas);

        if (emprestimo.isAprovado(solicitante.getSalario())) {
            System.out.println("Empréstimo aprovado!");
        } else {
            System.out.println("Empréstimo não aprovado. O valor da parcela excede 30% do salário.");
        }

        scanner.close();
    }
}
