package com.ifsc.ctds;
public class NumPrimo {
private int numInicial;
private int numFinal;
public NumPrimo(int numInicial, int numFinal) {
this.numInicial = numInicial;
this.numFinal = numFinal;
}
public int getNumInicial() {
return numInicial;
}
public int getNumFinal() {
return numFinal;
}
public int separarPrimo() {
int contagemPrimo = 0;
for (int num = this.numInicial; num <= this.numFinal; num++) {
if (isPrimo(num)) {
System.out.println(num);
contagemPrimo++;

}
}
return contagemPrimo;
}
private boolean isPrimo(int num) {
if (num <= 1) return false; // Números menores ou iguais a 1 não são primos
for (int i = 2; i <= Math.sqrt(num); i++) {
if (num % i == 0) return false; // Se for divisível por i, não é primo
}
return true; // Se não for divisível por nenhum, é primo
}
}
