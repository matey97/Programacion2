package practica1;

import java.util.Scanner;

public class ejercicio7 {
		
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
	


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.print("Introduce un número entero: ");
		int numero = sc.nextInt();
		boolean primo=esPrimo(numero);
		if (primo){
			System.out.println("Es primo");
		}else{
			System.out.println("No es primo");
		}
		sc.close();
	}
}