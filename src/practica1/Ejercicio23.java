package practica1;

import java.util.Arrays;
import java.util.Scanner;

public class Ejercicio23 {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int[][]matriz={{1,2,3},{4,1,5},{2,3,2},{5,1,1}}; //Aparecen en todas el 1 y el 2
		System.out.print("Escribe un número para saber si está en todas las columnas de la matriz "+Arrays.deepToString(matriz)+": ");
		int numero=sc.nextInt();
		if (estáEnTodasLasColumnas(matriz,numero)){
			System.out.println("El número "+numero+" está en todas la columnas de la matriz.");
		}else{	
			System.out.println("El número "+numero+" no está en todas la columnas de la matriz.");
		}
		sc.close();
	}
	
	public static boolean estáEnTodasLasColumnas(int[][]matriz,int numero){
		for (int j=0;j<matriz[0].length;j++){
			boolean apareceEnUna=false;
			for (int i=0; i<matriz.length;i++){
				if (matriz[i][j]==numero){
					apareceEnUna=true;
					break;
				}
			}
			if (!apareceEnUna){
				return false;
			}
		}
		return true;
	}
}
