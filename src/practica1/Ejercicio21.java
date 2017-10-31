package practica1;

import java.util.Arrays;
import java.util.Scanner;

public class Ejercicio21 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[]vector={1,3,5,7,9,11};
		Scanner sc=new Scanner(System.in);
		System.out.print("Escribe un número para saber en que posición estaría (o está) en el vector "+Arrays.toString(vector)+": ");
		int numero=sc.nextInt();
		System.out.println("El numero "+numero+" estaría (o está) en la posicion "+posicionInserción(vector,numero));
		sc.close();
	}
	
	public static int posicionInserción(int[]vector,int numero){
		for (int i=0; i<vector.length-1;i++){
			if (vector[i]==numero){
				return i+1; //+1 para numeración 1,2,3...
			}else{
				if (vector[i]<numero && vector[i+1]>numero){
					return i+2; //+1 para numeración 1,2,3... y +1 porque la posicion sera después de vector[i].
				}
			}
		}
		return -1; 
	}
}
