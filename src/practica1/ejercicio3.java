package practica1;

import java.util.Scanner;

public class ejercicio3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.print("Introduce un número entero: ");
		int numero = sc.nextInt();
		int divisores = 2;
		for (int i = 2; i<numero; i++){
			if (numero%i == 0){
				divisores++;
				break;
			}
		}
		if (divisores==2 && numero > 1){
			System.out.println("Es primo");
		}else{
			System.out.println("No es primo");
		}
		sc.close();
	}

}
