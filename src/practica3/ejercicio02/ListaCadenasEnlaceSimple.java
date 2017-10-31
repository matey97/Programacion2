package practica3.ejercicio02;

public class ListaCadenasEnlaceSimple implements ListaCadenas{
	private static class Nodo{
		String dato;
		Nodo sig;
		
		Nodo (String dato, Nodo sig){
			this.dato=dato;
			this.sig=sig;
		}
	}
	
	private Nodo primero;
	private int talla;
	
	public boolean add (String s){
		Nodo nuevo= new Nodo (s,null);
		if (isEmpty()){
			primero=nuevo;
		}else{
			Nodo actual;
			for (actual=primero; actual.sig!=null;actual=actual.sig);
			actual.sig=nuevo;
		}
		talla++;
		return true;
	}
	
	public void add(int i, String s){
		if (i<0 || i> talla)
			throw new IndexOutOfBoundsException();
		Nodo nuevo=new Nodo(s,null);
		if (size()==0){
			primero=nuevo;
			talla++;
		}else{
			if (i==0){
				nuevo.sig=primero;
				primero=nuevo;
			}else{
				
				Nodo aux = primero;
				for (int indice=0;indice<i-1;indice++){ //o 0 o 1
					aux=aux.sig;
				}
				nuevo.sig=aux.sig;
				aux.sig=nuevo;	
				
			}
			talla++;
		}	
	}
	
	public void clear(){
		primero=null;
		talla=0;
	}
	
	public String get(int i) {
		if (i<0 || i>= talla)
			throw new IndexOutOfBoundsException();
		Nodo aux=primero;
		for (int indice=0;indice<i;indice++){ //o 0 o 1
			aux=aux.sig;
		}
		return aux.dato;
	}
	
	public int indexOf(String s){
		Nodo aux=primero;
		for (int i=0; i<talla;i++){//posible error en indices
			if (aux.dato.equals(s))
				return i;
			aux=aux.sig;
		}
		return -1;
	}
	
	public int lastIndexOf(String s){
		Nodo aux=primero;
		int posibleIndice=-1;
		for (int i=0; i<talla;i++){//posible error en indices
			if (aux.dato.equals(s))
				posibleIndice=i;
			aux=aux.sig;
		}
		return posibleIndice;
	}
	
	public boolean isEmpty(){
		return talla==0;
		
	}
	
	public String remove(int i){
		if (i<0 || i>=talla)
			throw new IndexOutOfBoundsException();
		String dato;
		if (i==0){
			dato=primero.dato;
			primero=primero.sig;
			talla--;
		}else{
			Nodo aux=primero;
			for (int indice=0;indice<i-1;indice++){
				aux=aux.sig;
			}
			dato=aux.sig.dato;
			aux.sig=aux.sig.sig;
			talla--;
		}	
		return dato;
	}
	
	public boolean remove (String s){
		Nodo aux=primero;
		Nodo sig=primero.sig;
		if (aux.dato.equals(s)){
			primero=primero.sig;
			talla--;
			return true;
		}else{
			for (int indice=0; indice<talla; indice++){
				if (sig.dato.equals(s)){
					aux.sig=sig.sig;
					talla--;
					return true;
				}
				aux=aux.sig;
				sig=sig.sig;
			}
		}
		return false;
	}
	
	public String set(int i, String s) {
		if (i<0 || i>=size())
			throw new IndexOutOfBoundsException();
		String cadena;
		Nodo nuevo=new Nodo(s,null);
		if( i==0){
			cadena=primero.dato;
			nuevo.sig=primero.sig;
			primero=nuevo;
		}else{
			Nodo aux=primero;
			for (int indice=0;indice<i-1;indice++){
				aux=aux.sig;
			}
			cadena=aux.sig.dato;
			nuevo.sig=aux.sig.sig;
			aux.sig=nuevo;
		}
		return cadena;
	}
	
	public int size(){
		return talla;
	}
	
	public String toString(){
		String cadena;
		if (size()==0){
			return "[]";
		}
		if (size()==1)
			return "["+primero.dato+"]";
		cadena=primero.dato;
		Nodo aux=primero.sig;
		for (int i=1; i<talla;i++){
			cadena+=", "+aux.dato;
			aux=aux.sig;
		}
		return "["+cadena+"]";
	}
}
