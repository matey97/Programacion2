package practica1;

import java.util.Scanner;

public class Ejercicio12 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.print("Escribe una frase: ");
		String frase= new String(sc.nextLine());
		System.out.println("La frase tiene "+ contarPalabras(frase)+ " palabras.");
		sc.close();
	}
	public static int contarPalabras(String cadena){
		int palabras=0;
		boolean esPalabra=false;
		for (int i=0; i<cadena.length();i++){
			if (cadena.charAt(i)!= ' ' && esPalabra==false){
				esPalabra=true;
				palabras++;
			}else{
				if (cadena.charAt(i)==' '){
					esPalabra=false;
				}
			}
		}
		return palabras;
	}
}
