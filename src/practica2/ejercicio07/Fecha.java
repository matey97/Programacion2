package practica2.ejercicio07;

import java.util.Calendar;


public class Fecha {
	
	private int díasDesdeOrigen;
	public static final int PRIMER_AÑO=1800;
	public static final int ÚLTIMO_AÑO=2500;
	
	private static final int[] díasHastaPrimeroDeMesNoBisiesto={0,31,59,90,120,151,181,212,243,273,304,334};
	private static final int[] díasHastaPrimeroDeMesBisiesto={0,31,60,91,121,152,182,213,244,274,305,335};
	private static final int[] díasHasta1Enero=new int[ÚLTIMO_AÑO-PRIMER_AÑO+1];
	
	static{
		díasHasta1Enero[0]=0;
		for (int i=1; i<díasHasta1Enero.length; i++){
			díasHasta1Enero[i]=díasHasta1Enero[i-1]+365;
			if (añoBisiesto(PRIMER_AÑO+i-1)){
				díasHasta1Enero[i]+=1;
			}
		}
	}
	
	public Fecha (int ndias){
		this.díasDesdeOrigen=ndias;
	}
	
	public Fecha (int dia,int mes, int año){
		this.díasDesdeOrigen=calcularDíasDesdeOrigen(dia,mes,año);
	}
	
	public Fecha(Fecha otraFecha){
		this.díasDesdeOrigen=otraFecha.díasDesdeOrigen;
	}
	
	public String toString(){
		int[]vector=díaMesAño(this.díasDesdeOrigen);
		return vector[0]+"/"+vector[1]+"/"+vector[2];
	}
	
	public boolean equals(Object otraFecha){
		if (this==otraFecha)
			return true;
		if (!(otraFecha instanceof Fecha))
			return false;
		Fecha fecha=(Fecha)otraFecha;
		return this.díasDesdeOrigen==fecha.díasDesdeOrigen;
	}
	
	public int compareTo(Fecha otraFecha){
		if (this.equals(otraFecha))
			return 0;
		if (this.díasDesdeOrigen>otraFecha.díasDesdeOrigen)
			return 1;
		return -1;
	}
	
	public int getDía(){
		int[]vector=díaMesAño(this.díasDesdeOrigen);
		return vector[0];
	}
	
	public int getMes(){
		int[]vector=díaMesAño(this.díasDesdeOrigen);
		return vector[1];
	}
	
	public int getAño(){
		int[]vector=díaMesAño(this.díasDesdeOrigen);
		return vector[2];
	}
	
	public static boolean añoBisiesto (int año){
		if ((año%4==0 && año%100!=0) || año%400==0)
			return true;
		return false;
	}
	
	public static int díasMes(int mes, int año){
		switch (mes){
		case 2:
			if (añoBisiesto(año))
				return 29;
			return 28;
		case 1:
		case 3:
		case 5:
		case 7:
		case 8:
		case 10:
		case 12:
			return 31;
		}	
		return 30; 
	}
	
	public static Fecha hoy(){
		Calendar calendario = Calendar.getInstance();
		int día = calendario.get(Calendar.DAY_OF_MONTH);
		int mes = calendario.get(Calendar.MONTH)+1;
		int año = calendario.get(Calendar.YEAR);
		return new Fecha(calcularDíasDesdeOrigen(día,mes,año));
	}
	
	public Fecha díaSiguiente(){
		int díaSumado=this.díasDesdeOrigen+1;
		return new Fecha(díaSumado); 
	} 
	
	
	private static int calcularDíasDesdeOrigen(int día, int mes, int año) {
		int ndías = díasHasta1Enero[año - PRIMER_AÑO];
		if (añoBisiesto(año))
			ndías += díasHastaPrimeroDeMesBisiesto[mes - 1];
		else
			ndías += díasHastaPrimeroDeMesNoBisiesto[mes - 1];
		ndías += día - 1;
		return ndías;
	}

	private static int[] díaMesAño(int ndías) {
		int[] díasHastaPrimeroDeMes;

		// Hallar año
		int año = buscarPosición(ndías, díasHasta1Enero) + PRIMER_AÑO;

		// Hallar mes
		ndías -= díasHasta1Enero[año - PRIMER_AÑO];
		if (añoBisiesto(año))
			díasHastaPrimeroDeMes = díasHastaPrimeroDeMesBisiesto;
		else
			díasHastaPrimeroDeMes = díasHastaPrimeroDeMesNoBisiesto;
		int mes = buscarPosición(ndías, díasHastaPrimeroDeMes) + 1;
		ndías -= díasHastaPrimeroDeMes[mes - 1];

		// Hallar día
		int día = ndías +1;

		int[] v = { día, mes, año };
		return v;
	}

	// Búsqueda secuencial
	private static int buscarPosición(int dato, int[] vector) {
		int i = 0;
		while (i < vector.length - 1 && dato >= vector[i + 1])
			i++;
		return i;
	}


	public Fecha sumarDías(int dias){
		int díasSumados=this.díasDesdeOrigen+dias;
		return new Fecha(díasSumados);
		
	}
	
	public int restarFechas(Fecha otraFecha){
		int diferencia=this.díasDesdeOrigen-otraFecha.díasDesdeOrigen;
		return diferencia;
	}
}