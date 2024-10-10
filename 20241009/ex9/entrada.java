/*9 – Fazer um algoritmo que calcule e imprima o soma, a média, o maior e o menor dos valores armazenados
em um vetor A de 7 elementos numéricos a serem lidos do dispositivo de entrada padrão.*/


import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        double[] A = new double[7]; // Vetor para armazenar os 7 elementos
        double soma = 0;
        double maior = Double.MIN_VALUE; // Inicializa com o menor valor possível
        double menor = Double.MAX_VALUE;  // Inicializa com o maior valor possível
        
        // Lendo os valores do vetor
        for (int i = 0; i < A.length; i++) {
            System.out.print("Digite o valor " + (i + 1) + ": ");
            A[i] = scanner.nextDouble();
            soma += A[i]; // Acumulando a soma
            
            // Verificando o maior e menor valor
            if (A[i] > maior) {
                maior = A[i];
            }
            if (A[i] < menor) {
                menor = A[i];
            }
        }
        
        // Calculando a média
        double media = soma / A.length;
        
        // Imprimindo os resultados
        System.out.println("Soma: " + soma);
        System.out.println("Média: " + media);
        System.out.println("Maior valor: " + maior);
        System.out.println("Menor valor: " + menor);
        
        scanner.close();
    }
}
