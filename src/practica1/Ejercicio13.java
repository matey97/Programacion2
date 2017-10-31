package practica1;

import java.util.Scanner;

public class Ejercicio13 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.print("Escribe una frase: ");
		String frase= new String(sc.nextLine());
		System.out.print("Escribe un número: ");
		int numero=sc.nextInt();
		
		if (obtenerPalabra(frase,numero)==null){
			System.out.println("Índice no válido.");
		}else{
			System.out.println("La palabra que está en la posición "+ numero+" es "+obtenerPalabra(frase,numero));
		}
		sc.close();
	}
	public static String obtenerPalabra(String cadena, int numero){
		String palabra;
		int inicioPalabra=0;
		int finPalabra=0;
		int palabras= 0 ;
		boolean esPalabra=false;
		for (int i=0; i<cadena.length();i++){
			if (cadena.charAt(i)!=' ' && esPalabra==false){
				esPalabra=true;
				palabras++;
				if (palabras==numero){
					inicioPalabra=i;	
				}
				
			}else{
				if (cadena.charAt(i)==' ' || i==cadena.length()-1){
					esPalabra=false;
					if (palabras==numero){
						finPalabra=i+1;
						break;
					}
				}
			}
		}
		if (inicioPalabra==0 && finPalabra ==0){
			return null;
		}else{
			palabra= new String(cadena.substring(inicioPalabra,finPalabra));
		}
		return palabra;
	}
}