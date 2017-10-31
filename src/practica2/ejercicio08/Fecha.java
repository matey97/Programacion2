package practica2.ejercicio08;

import java.util.Calendar;

public class Fecha {
	private int dia;
	private int mes;
	private int año;
	
	public Fecha(int dia, int mes, int año)throws ExcepcionFechaInvalida{
		if (díasMes(mes,año)<dia){
			throw new ExcepcionFechaInvalida();
		}
		this.dia=dia;
		this.mes=mes;
		this.año=año;
	}
	
	public Fecha (Fecha otraFecha){
		otraFecha.dia=this.dia;
		otraFecha.mes=this.mes;
		otraFecha.año=this.año;
	}
	
	public String toString(){
		return this.dia+"/"+this.mes+"/"+this.año;
	}
	
	public boolean equals(Object otraFecha){
		if( this==otraFecha)
			return true;
		if (!(otraFecha instanceof Fecha))
			return false;
		Fecha fecha=(Fecha)otraFecha;
		return this.dia==fecha.dia && this.mes==fecha.mes && this.año==fecha.año;
	}
	
	public int compareTo(Fecha otraFecha){
		if (this.equals(otraFecha))
			return 0;
		if (this.año>otraFecha.año || (this.año==otraFecha.año && this.mes>otraFecha.mes) || (this.año==otraFecha.año && this.mes==otraFecha.mes && this.dia>otraFecha.dia))
			return 1;
		return -1;
	}
	
	public int getDía(){
		return this.dia;
	}
	
	public int getMes(){
		return this.mes;
	}
	
	public int getAño(){
		return this.año;
	}
	
	public static boolean añoBisiesto (int año){
		if ((año%4==0 && año%100!=0) || año%400==0)
			return true;
		return false;
	}
	
	public static int díasMes(int mes, int año)throws ExcepcionFechaInvalida{
		if (mes<1 || mes > 12){
			throw new ExcepcionFechaInvalida();
		}
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
		
		case 4:
		case 6:
		case 9:
		case 11:
			return 30;
		}
		return 0; //Por si hay mes invalido
	}
	
	public static Fecha hoy()throws ExcepcionFechaInvalida{
		Calendar calendario = Calendar.getInstance();
		int día = calendario.get(Calendar.DAY_OF_MONTH);
		int mes = calendario.get(Calendar.MONTH)+1;
		int año = calendario.get(Calendar.YEAR);
		return new Fecha(día,mes,año);
	}
	
	public Fecha díaSiguiente()throws ExcepcionFechaInvalida{
		int nuevoDía;
		int nuevoMes=this.mes;
		int nuevoAño=this.año;
		if (this.dia==0 && this.mes==0 && this.año==0){
			nuevoDía=1;
			nuevoMes=1;
			nuevoAño=1;
			return new Fecha (nuevoDía,nuevoMes,nuevoAño);
		}
		int limiteDías= díasMes(this.mes,this.año);
		if (this.dia<limiteDías){
			nuevoDía=this.dia+1;
		}else{
			nuevoDía=1;
			if (this.mes<12){
				nuevoMes=this.mes+1;
			}else{
				nuevoMes=1;
				nuevoAño=this.año+1;
			}

		}
		return new Fecha(nuevoDía,nuevoMes,nuevoAño);	
	}
	
	public Fecha sumarDías(int dias)throws ExcepcionFechaInvalida{
		if (dias==0)
			return this;
		Fecha sumaDias=this.díaSiguiente();
		for (int i=1; i<dias;i++){
			sumaDias=sumaDias.díaSiguiente();
		}
		return sumaDias;
	}
	
	public int restarFechas(Fecha otraFecha)throws ExcepcionFechaInvalida{
		int dias=0;
		Fecha diaADia;
		if (this.compareTo(otraFecha)==0){
			return 0;
		}else{
			if (this.compareTo(otraFecha)>0){//this posterior a otraFecha
				diaADia=otraFecha;
				while(!(diaADia.equals(this))){
					diaADia=diaADia.díaSiguiente();
					dias++;
				}
				
			}else{ //this anterior
				diaADia=this;
				while(!(diaADia.equals(otraFecha))){
					diaADia=diaADia.díaSiguiente();
					dias++;
				}
				dias=-dias;
			}
		}
		return dias;
	}
}
