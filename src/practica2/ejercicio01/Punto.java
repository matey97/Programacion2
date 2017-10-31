package practica2.ejercicio01;

import java.util.Locale;

public class Punto {

	private double x;
	private double y;
	
	public Punto (double x, double y){
		this.x=x;
		this.y=y;
	}
	
	public Punto (Punto otroPunto){
		this.x=otroPunto.x;
		this.y=otroPunto.y;
	}
	
	public Punto(){
		this.x=0;
		this.y=0;
	}
	
	public double getX(){
		return this.x;
	}
	
	public double getY(){
		return this.y;
	}
	
	public Punto desplazar (double desplazamientoX, double desplazamientoY){
		return new Punto(this.x+desplazamientoX,this.y+desplazamientoY);
	}
	
	public double distancia(Punto otroPunto){
		return Math.sqrt((Math.pow(otroPunto.x-this.x, 2))+(Math.pow(otroPunto.y-this.y, 2)));
	}
	
	public String toString(){
		return String.format(Locale.UK,"(%.2f, %.2f)",getX(),getY());
	}
	
	public boolean equals(Object otroObjeto){
		if (this==otroObjeto)
			return true;
		if (!(otroObjeto instanceof Punto))
			return false;
		Punto otroPunto=(Punto)otroObjeto;
		return this.x==otroPunto.x && this.y==otroPunto.y; 
	}
}
