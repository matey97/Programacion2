package practica1;

import java.util.Arrays;
import java.util.Scanner;

public class Ejercicio17 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int[]vector=new int[0];
		System.out.print("Introduce números (-1 para acabar): ");
		int numero=sc.nextInt();
		while (numero!=-1){
			int[] aux=new int[vector.length+1];
			for (int i=0;i<vector.length;i++){
				aux[i]=vector[i];
			}
			aux[aux.length-1]=numero;
			vector=aux;
			System.out.print("Introduce números (-1 para acabar): ");
			numero=sc.nextInt();
		}
		if (hayRepetidos(vector)){
			System.out.println("En el vector "+Arrays.toString(vector)+" hay números repetidos");
		}else{
			System.out.println("En el vector "+Arrays.toString(vector)+" no hay números repetidos");
		}
		sc.close();
	}
	public static boolean hayRepetidos(int[]vector){
		for (int i=0;i<vector.length-1;i++){
			for(int j=i;j<vector.length-1;j++){
				if (vector[i]==vector[j+1]){
					return true;
				}
			}
		}
		return false;
	}
}
