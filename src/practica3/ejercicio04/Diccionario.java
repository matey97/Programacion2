package practica3.ejercicio04;

public class Diccionario {
	private static class Nodo{
		String cadena;
		int cantidad;
		Nodo sig;
		
		Nodo(String cadena, int cantidad, Nodo sig){
			this.cadena=cadena;
			this.cantidad=cantidad;
			this.sig=sig;
		}
		
		public String toString(){
			return this.cadena+"-->"+this.cantidad;
		}
	}
	private Nodo primero;
	private int talla;
	
	public void añadir (String unaCadena, int unaCantidad){
		Nodo aux=primero;
		Nodo anterior=null;
		Nodo nuevo=new Nodo(unaCadena,unaCantidad,null);
		if (talla==0){											
			primero=nuevo;
			talla++;
		}else if (talla==1){
			if (unaCadena.equals(primero.cadena))
				primero.cantidad+=unaCantidad;
			else if (unaCadena.compareTo(primero.cadena)<0){
				nuevo.sig=primero;
				primero=nuevo;
				talla++;
			}else{
				primero.sig=nuevo;
				talla++;
			}													
		}else{
			for (int i=0;i<=talla-1;i++){
				if (unaCadena.equals(aux.cadena)){
					aux.cantidad+=unaCantidad;							
				}else if(i==0 && unaCadena.compareTo(aux.cadena)<0){
					nuevo.sig=primero;
					primero=nuevo;
					talla++;
					break;
				}else if(i==talla-1 && unaCadena.compareTo(aux.cadena)>0){
					aux.sig=nuevo;
					talla++;
					break;
				}else if(i!=0 && unaCadena.compareTo(anterior.cadena)>0 && unaCadena.compareTo(aux.cadena)<0){
					anterior.sig=nuevo;				//Cuidado con el compareTo. Funciona.
					nuevo.sig=aux;
					talla++;
					break;
				}
				anterior=aux;
				aux=aux.sig;
			}
			
		}
	}
		
	
	public String cadenaConMayorCantidad(){
		String mayorCantidad=null;
		if (talla==0)
			return mayorCantidad;
		Nodo aux=primero;
		mayorCantidad=primero.cadena;
		int maximo=primero.cantidad;
		for (int i=0;i<=talla-1;i++){
			if (aux.cantidad>maximo){
				mayorCantidad=aux.cadena;
				maximo=aux.cantidad;
			}
			aux=aux.sig;
		}
		return mayorCantidad;
	}
	
	public int cantidad (String unaCadena){
		Nodo aux=primero;
		for (int i=0; i<talla;i++){
			if (aux.cadena.equals(unaCadena))
				return aux.cantidad;
			aux=aux.sig;
		}
		return 0;
	}
	
	public String toString(){
		if (talla==0)
			return "{}";
		Nodo aux=primero;
		String cadena="{"+aux;
		aux=aux.sig;
		for (int i=0; i<talla-1;i++){
			cadena+=", "+aux;
			aux=aux.sig;
		}
		return cadena+"}";
	}
}
