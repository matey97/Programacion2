package practica1;

import java.util.Scanner;

public class Ejercicio14 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int[]vector= new int[0];
		
		System.out.print("Introduce un entero (00 para acabar): ");
		int entero=sc.nextInt();
		while (entero!=00){
			int []aux= new int[vector.length+1];
			for (int i =0; i<vector.length; i++){
				aux[i]=vector[i];	
			}
			aux[aux.length-1]=entero;
			vector=aux;
			
			System.out.print("Introduce un entero (00 para acabar): ");
			entero=sc.nextInt();
		}
		System.out.print("Dame un número: ");
		int numero=sc.nextInt();
		int posicion=ultimaPosicion(vector,numero);
		if (posicion>0){
			System.out.println("El "+numero+" está en la posición "+ ultimaPosicion(vector,numero));
		}else{
			System.out.println("El "+numero+" no se encuentra en el vector.");
		}
		sc.close();
		
	}
	public static int ultimaPosicion(int[] vector,int entero){
		int posicion=-1;
		for (int i=0; i<vector.length;i++){
			if (vector[i]==entero){
				posicion=i+1; //Devolvera la posición empezando a contar desde 1, no desde 0.
			}
		}
		return posicion;
	}
}
