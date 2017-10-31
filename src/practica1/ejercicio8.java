package practica1;

import java.util.Scanner;

public class ejercicio8 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.print("Introduce un número entero: ");
		int numero = sc.nextInt();
		System.out.print("Los números primos menores que " +  numero + " son: ");
		for (int i = 2 ; i < numero; i++){
			if (esPrimo(i)){
				System.out.print(i+ " ");
			}
		}
		sc.close();
	}



	public static boolean esPrimo (int numero) {
		if (numero<2){
			return false ;
		}
		for (int i =2; i<numero; i++){
			if (numero%i==0){
				return false ;
			}
		}
		return true ;
	}
}