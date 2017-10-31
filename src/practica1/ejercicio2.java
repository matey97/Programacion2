package practica1;

import java.util.Scanner;

public class ejercicio2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in) ;
		System.out.print("Introduce un número entero: ");
		int entero = sc.nextInt();
		long dobleFactorial = 1;
		if (entero == 0 || entero ==1) {
			System.out.println(entero + "!! = " + dobleFactorial);
		}else{ 
			if (entero % 2 ==0){
				for (int i = 2 ; i<=entero ; i+=2){
					dobleFactorial*=i ;
				}
				System.out.println(entero + "!! = " + dobleFactorial);
			}else{
				for (int i = 1 ; i<=entero ; i+=2){
					dobleFactorial*=i ;
				}
				System.out.println(entero + "!! = " + dobleFactorial);
			}
			
		}
		sc.close();
				
	}

}
