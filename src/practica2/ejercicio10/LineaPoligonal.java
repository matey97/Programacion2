package practica2.ejercicio10;

import practica2.ejercicio01.Punto;

public class LineaPoligonal {
	Punto[] vector;
	int ocupados;
	
	public LineaPoligonal(){
		this.vector=new Punto[10];
		ocupados=0;
	}
	
	public void añadir(Punto punto){
		if (ocupados==this.vector.length){
			Punto[]aux= new Punto[this.vector.length*2];
			for (int i=0;i<this.vector.length;i++){
				aux[i]=vector[i];
			}
			this.vector=aux;
		}
		this.vector[ocupados++]=punto;		
	}
	
	public void quitar(int posición){
		if (!(posición<0 || posición>=this.vector.length)){	
			Punto[]aux=new Punto[(this.vector.length-1)];
			int j=0;
			for (int i=0;i<this.vector.length;i++){
				if (!(posición==i)){
					aux[j++]=this.vector[i];
				}
			}
			this.vector=aux;
		}
	}
	
	public void quitar(Punto punto){
		for (int i=0;i<this.vector.length;i++){
			if (this.vector[i].equals(punto)){
				this.quitar(i);
				break;
			}
		}
	}
	
	public void trasladar(double desplazamientoX,double desplazamientoY){
		for (int i=0; i<this.vector.length;i++){
			this.vector[i].desplazar(desplazamientoX,desplazamientoY);
		}
	}
	
	public double longitud(){
		if (this.vector.length<=1)
			return 0;
		double distancia=0;
		for (int i=0;i<this.vector.length-1;i++){
			distancia+=this.vector[i].distancia(this.vector[i+1]);
		}
		return distancia;
	}
	
	public String toString(){
		if (this.vector.length==0)
			return "";
		if (this.vector.length==1)
			return this.vector[0].toString();
		String cadena=vector[0].toString();
		for (int i=1;i<this.vector.length;i++){
			cadena+="--"+this.vector[i].toString();
		}
		return cadena;			
	}
	
	public boolean equals(Object otroObjeto){
		if (this.vector==otroObjeto)
			return true;
		if (!(otroObjeto instanceof LineaPoligonal))
			return false;
		LineaPoligonal otraLinea=(LineaPoligonal) otroObjeto;
		if (this.vector.length!=otraLinea.vector.length)
			return false;
		for (int i=0; i<this.vector.length;i++){
			if (this.vector[i].equals(otraLinea.vector[i]))
				return false;
		}
		return true;
					
	}
}
