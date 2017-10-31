package practica1;

import java.util.Scanner;

public class ejercicio4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.print("Introduce un número entero: ");
		int numero = sc.nextInt();
		System.out.print("Los números primos menores que " +  numero + " son: ");
		for (int i = 2 ; i < numero; i++){
			int divisores = 2 ;
			for (int j = 2 ; j< i; j++){
				if (i%j==0){
					divisores++;
					break;
				}
			}
			if (divisores==2){
				System.out.print(i+ " ");
			}
		}
		sc.close();
	}

}
