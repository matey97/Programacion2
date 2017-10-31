package practica2.ejercicio04;

import java.util.Scanner;
import practica2.ejercicio03.Fecha;

public class Ejercicio4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Fecha diaActual=Fecha.hoy();
		Scanner sc =new Scanner (System.in);
		System.out.println("Escribe tu fecha de cumpleaños");
		System.out.print("Dia: ");
		int dia=sc.nextInt();
		System.out.print("Mes: ");
		int mes=sc.nextInt();
		System.out.print("Año: ");
		int año=sc.nextInt();
		
		Fecha diaNacimiento=new Fecha(dia,mes,año);
		int diasTranscurridos=diaActual.restarFechas(diaNacimiento);
		if (diasTranscurridos>=0){
			System.out.println("Desde que naciste han pasado "+diasTranscurridos+" días.");
		}else{
			System.out.println("Aún no has nacido.");
		}
		sc.close();
	}

}
