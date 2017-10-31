package practica1;

import java.util.Arrays;
import java.util.Scanner;

public class Ejercicio19 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[]vector = {1,2,3,6,4,2,2,3};
		Scanner sc=new Scanner(System.in);
		System.out.print("Elige un numero del vector "+Arrays.toString(vector)+" para eliminarlo: ");
		int numero=sc.nextInt();
		System.out.println("El vector queda así: "+Arrays.toString(eliminarValor(vector,numero)));
		sc.close();
	}
	public static int[] eliminarValor (int[]vector,int numero){
		int coinciden=0;
		for (int i=0; i<vector.length;i++){
			if (vector[i]==numero){
				coinciden++;
			}
		}
		int[] nuevo=new int[vector.length-coinciden];
		for (int i=0,j=0; i<vector.length;i++){
			if (vector[i]!=numero){
				nuevo[j++]=vector[i];
			}
		}
		vector=nuevo;
		return vector;
	}
}
