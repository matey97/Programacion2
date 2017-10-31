package practica1;

import java.util.Scanner;

public class Ejercicio10 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.print("Introduce un numero entero: ");
		int numero = sc.nextInt();
		int numMaxDivisores=0;
		int maxDivisores = 0;
		for (int i = 1; i<=numero; i++){
			int divisores = contarDivisores(i);
			if (divisores>=maxDivisores){
				maxDivisores=divisores;
				numMaxDivisores=i;
			}
		}
		System.out.println("El número con mas divisores es "+numMaxDivisores+" ("+maxDivisores+" divisores)");
		sc.close();
	}
	
	public static int contarDivisores(int numero){
		int divisores = 0;
		for (int i = 1; i<=numero; i++){
			if (numero%i==0){
				divisores++;
			}
		}
		return divisores;
	}
}
