package com.ifsc.ctds;
import java.util.Scanner;
public class MinhaTabuada {
public static void main(String[] args) {
Scanner scanner = new Scanner(System.in);
System.out.print("Informe um número N para exibir as tabuadas de 1 até N: ");
int n = scanner.nextInt();

for (int i = 1; i <= n; i++) {
System.out.println("Tabuada de " + i + ":");
for (int j = 1; j <= 10; j++) {
System.out.println(i + " x " + j + " = " + (i * j));
}
System.out.println();
}
scanner.close();
}
}  
