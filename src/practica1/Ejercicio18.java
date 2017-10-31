package practica1;

import java.util.Arrays;
import java.util.Scanner;

public class Ejercicio18 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int[]vector=new int[0];
		System.out.print("Introduce números (00 para acabar): ");
		int numero=sc.nextInt();
		while (numero!=00){
			int[] aux=new int[vector.length+1];
			for (int i=0;i<vector.length;i++){
				aux[i]=vector[i];
			}
			aux[aux.length-1]=numero;
			vector=aux;
			System.out.print("Introduce números (00 para acabar): ");
			numero=sc.nextInt();
		}
		System.out.print("Introduce una posición: ");
		int posicion=sc.nextInt();
		System.out.println("Vector original: "+ Arrays.toString(vector));
		System.out.println("Vector modificado: "+Arrays.toString(eliminarPosicion(vector,posicion)));
		sc.close();

	}
	public static int[] eliminarPosicion(int[]vector, int posicion){
		if (posicion<=vector.length){
			int[]aux=new int[vector.length-1];
			for (int i=0;i<aux.length;i++){
				if (i+1!=posicion){			//Tomo la posición empezando desde 1, es decir la posicion 0 es el 1, la 1 es el 2...
					if (i+1>posicion){
						aux[i]=vector[i+1];
					}else{
						aux[i]=vector[i];
					}
				}else{
					aux[i]=vector[i+1];
					
				}
			}
			vector=aux;
			return vector;
		}
		return vector;
	}
}
