package practica1;

import java.util.Scanner;

public class ejercicio5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.print("Introduce un número entero: ");
		int numero = sc.nextInt();
		int primorial = 1;
		for (int i = 2; i <=numero; i++){
			int divisores=2;
			for (int j =2; j<i; j++){
				if (i%j==0){
					divisores++;
					break;
				}
			}
			if (divisores==2){
				primorial*=i;
			}
		}
	
	
		System.out.println(numero+"# = "+primorial);
		sc.close();
		
	}

}
