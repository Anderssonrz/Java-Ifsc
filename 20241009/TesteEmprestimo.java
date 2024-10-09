import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Ler informações do usuário
        System.out.print("Digite o valor do empréstimo: ");
        double valorEmprestimo = scanner.nextDouble();

        System.out.print("Digite o número de parcelas: ");
        int numeroParcelas = scanner.nextInt();

        System.out.print("Digite o salário do solicitante: ");
        double salario = scanner.nextDouble();

        // Criar objetos
        Solicitante solicitante = new Solicitante(salario);
        Emprestimo emprestimo = new Emprestimo(valorEmprestimo, numeroParcelas);

        // Verificar aprovação
        if (emprestimo.isAprovado(solicitante.getSalario())) {
            System.out.println("Empréstimo aprovado!");
        } else {
            System.out.println("Empréstimo não aprovado. O valor da parcela excede 30% do salário.");
        }

        scanner.close();
    }
}
