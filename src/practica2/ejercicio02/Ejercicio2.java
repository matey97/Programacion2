package practica2.ejercicio02;

import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.File;
import practica2.ejercicio01.Punto;

public class Ejercicio2 {

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		Scanner entrada=new Scanner(new File("src/practica2/ejercicio02/restaurantes.txt"));
		int numeroRestaurantes=entrada.nextInt();
		Punto[] vectorPuntos=new Punto[10];
		for (int i=0; i<numeroRestaurantes;i++){
			double x=entrada.nextDouble();
			double y=entrada.nextDouble();
			vectorPuntos[i]=new Punto(x,y);
		}
		entrada.close();
		Scanner sc=new Scanner(System.in);
		System.out.println("Indique su posición actual ");
		System.out.print("Coordenada X: ");
		double coordenadaX = sc.nextDouble();
		System.out.print("Coordenada Y: ");
		double coordenadaY = sc.nextDouble();
		Punto posActual=new Punto(coordenadaX,coordenadaY);
		System.out.println("El restaurante más cercano a su posición se encuentra en el punto "+puntoMásPróximo(vectorPuntos,posActual));
		sc.close();
		
	}
	public static Punto puntoMásPróximo(Punto[] v, Punto p){
		double distMínima = p.distancia(v[0]);
		Punto masCercano = v[0];
		for (int i=1; i<v.length;i++){
			if (p.distancia(v[i])<distMínima){
				distMínima=p.distancia(v[i]);
				masCercano=v[i];
			}
		}
		return masCercano;
	}
}
