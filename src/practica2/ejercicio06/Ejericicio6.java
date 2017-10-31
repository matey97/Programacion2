package practica2.ejercicio06;

import java.util.Scanner;

import practica2.ejercicio03.Fecha;

public class Ejericicio6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner (System.in);
		Fecha limSup=new Fecha (1,1,2000);
		Fecha limInf=new Fecha (1,1,1900);
		Fecha nacimiento=new Fecha(2,4,1997);
		Fecha mínimaFechaPosterior=limSup;
		Fecha máximaFechaAnterior=limInf;
		boolean acierta=false;
		System.out.println("Intenta adivinar mi cumpleaños");
		while (!acierta){
			System.out.print("Introduce día:");
			int dia=sc.nextInt();
			System.out.print("Introduce mes:");
			int mes=sc.nextInt();
			System.out.print("Introduce año:");
			int año=sc.nextInt();
			Fecha intento=new Fecha(dia,mes,año);
			if (intento.compareTo(limInf)==1 && intento.compareTo(limSup)==-1){
				if (intento.compareTo(nacimiento)==1){
					if (intento.compareTo(mínimaFechaPosterior)==1){
						System.out.println("Incorrecto. Antes he dicho que era anterior a "+mínimaFechaPosterior);
					}else{
						mínimaFechaPosterior=intento;
						System.out.println("Mi fecha de nacimiento es anterior. Vuelve a probar.");
					}
				}else if (intento.compareTo(nacimiento)==-1){
					if (intento.compareTo(máximaFechaAnterior)==-1){
						System.out.println("Incorrecto. Antes he dicho que era posterior a "+máximaFechaAnterior);
					}else{
						máximaFechaAnterior=intento;
						System.out.println("Mi fecha de nacimiento es posterior. Vuelve a probar.");
					}
				}else{
					System.out.println("Has acertado!!!");
					acierta=true;
				}
			}else{
				System.out.println("Fecha introducida fuera de rango. Vuelve a probar.");
			}
		}
		sc.close();
	}

}
