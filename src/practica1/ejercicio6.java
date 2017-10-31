package practica1;

import java.util.Scanner;

public class ejercicio6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.print("Introduce un numero entero: ");
		int numero = sc.nextInt();
		int numMaxDivisores=0;
		int maxDivisores = 0;
		for (int i = 1 ; i <= numero; i++){
			int divisores = 0;
			for (int j =1 ; j <=i; j++){
				if (i%j==0){
					divisores++;
				}
			}
			if (divisores>=maxDivisores){
				maxDivisores=divisores;
				numMaxDivisores=i;
			}
		}
		System.out.println("El número con mas divisores es "+numMaxDivisores+" ("+maxDivisores+" divisores)");
		sc.close();
	}

}
