package com.ifsc.ctds;

import java.util.Scanner;

public class Principal {

    public static void main(String[] args) {
        Scanner teclado = null;
        Media media = null;
        double nota1, nota2, nota3, nota4, soma;

        try {
            teclado = new Scanner(System.in);
            media = new Media(); // Inicializa a classe Media

            // Lendo as notas
            System.out.print("Digite a primeira nota: ");
            nota1 = teclado.nextDouble();

            System.out.print("Digite a segunda nota: ");
            nota2 = teclado.nextDouble();

            System.out.print("Digite a terceira nota: ");
            nota3 = teclado.nextDouble();

            System.out.print("Digite a quarta nota: ");
            nota4 = teclado.nextDouble();

            // Calculando a soma das notas
            soma = nota1 + nota2 + nota3 + nota4;

            // Calculando e imprimindo a média
            media.calcularMedia(soma, 4);
            media.imprimirMedia();

            // Verificando a situação do aluno
            if (media.isAprovado()) {
                System.out.println("Aluno aprovado!");
            } else if (media.ficouEmExame()) {
                System.out.println("Aluno em exame.");
                System.out.print("Digite a nota do exame: ");
                double notaExame = teclado.nextDouble();

                // Calculando a nova média
                double novaMedia = (media.getMedia() + notaExame) / 2;
                System.out.println("A nova média: " + String.format("%.2f", novaMedia));

                // Verificando a aprovação após o exame
                if (novaMedia >= 5) {
                    System.out.println("Aluno aprovado após exame!");
                } else {
                    System.out.println("Aluno reprovado.");
                }
            } else {
                System.out.println("Aluno reprovado.");
            }
        } catch (IllegalStateException e) {
            System.out.println("Erro no estado do scanner: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Ocorreu um erro: " + e.getMessage());
        } finally {
            if (teclado != null) {
                teclado.close(); // Fecha apenas se teclado foi inicializado
            }
        }
    }
}
