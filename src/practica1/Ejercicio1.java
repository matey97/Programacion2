package practica1;

import java.util.Scanner;

public class Ejercicio1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.print("Introduce un número entero: ");
		int entero = sc.nextInt();
		long factorial = 1;
		for (int i = 1 ; i <= entero ; i++) {
			factorial *= i;
		}
		System.out.println(entero + "! = " + factorial) ;
		sc.close();
	}

}
