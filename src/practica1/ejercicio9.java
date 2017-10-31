package practica1;

import java.util.Scanner;

public class ejercicio9 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.print("Introduce un número entero: ");
		int numero = sc.nextInt();
		int primorial = 1;
		for (int i = 2; i <=numero; i++){
			if (esPrimo(i)){
				primorial*=i;
			}
		}
		System.out.println(numero+"# = "+primorial);
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
