package practica2.ejercicio08;

import java.util.Scanner;

import practica2.ejercicio08.Fecha;

public class Ejercicio4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc =new Scanner (System.in);
		boolean noValido=false;
		do{
			try{
				Fecha diaActual=Fecha.hoy();
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
			}catch(ExcepcionFechaInvalida e){
				noValido=true;
				System.out.println("Fecha no valida. Introduce otra fecha.");
			}
		}while(noValido);
		
		sc.close();
	}

}
