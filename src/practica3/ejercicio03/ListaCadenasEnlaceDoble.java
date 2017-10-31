package practica3.ejercicio03;

import practica3.ejercicio02.ListaCadenas;


public class ListaCadenasEnlaceDoble implements ListaCadenas{
	
	private static class Nodo{
		String dato;
		Nodo sig;
		Nodo ant;
		
		Nodo (String dato, Nodo sig, Nodo ant){
			this.dato=dato;
			this.sig=sig;
			this.ant=ant;
		}
	}
	
	private Nodo primero;
	private Nodo ultimo;
	private int talla;
	
	public boolean add(String s){
		Nodo nuevo=new Nodo(s,null,null);
		if (isEmpty()){			//Lista vacia
			primero=nuevo;
			ultimo=primero;
		}else{					//Lista no vacia
			ultimo.sig=nuevo;
			nuevo.ant=ultimo;
			ultimo=ultimo.sig;
		}
		talla++;
		return true;
	}
	
	public void add(int i, String s){
		if (i<0 || i>size()){
			throw new IndexOutOfBoundsException();
		}
		Nodo nuevo=new Nodo(s,null,null);
		Nodo aux;						//Cambio el nombre de la variable de actual a aux, por claridad.
		if (isEmpty()){					//Lista vacia
			primero=nuevo;
			ultimo=primero;
		}else{
			if (i==0){					//Añade en posicion 0
				nuevo.sig=primero;
				primero=nuevo;
				nuevo.sig.ant=nuevo;		
			}else if (size()==i){		//Añade en ultima posicion
				ultimo.sig=nuevo;
				nuevo.ant=ultimo;
				ultimo=ultimo.sig;
			}else{
				if (i<=(size()-1)/2){ //Primera mitad
					aux=primero;
					for (int indice=0;indice<i;indice++){
						aux=aux.sig;
					}
				}else{						//Segunda mitad
					aux=ultimo;
					for (int indice=0;indice<size()-1-i;i++){
						aux=aux.ant;
					}
				}
				nuevo.ant= aux.ant;
				nuevo.sig=aux;
				aux.ant.sig=nuevo;
				aux.ant=nuevo;	
			}
		}
		talla++;
	}
	
	public void clear(){
		primero=null;
		ultimo=null;
		talla=0;
	}
	
	public String get (int i){
		if (i<0 || i>=size()){
			throw new IndexOutOfBoundsException();
		}
		Nodo aux;
		if (i<=(size()-1)/2){	//Primera mitad
			aux=primero;
			for (int indice=0;indice<i;indice++){
				aux=aux.sig;
			}
		}else{					//Segunda mitad
			aux=ultimo;
			for (int indice=0;indice<size()-1-i;i++){
				aux=aux.ant;
			}
		}
		return aux.dato;
	}
	
	public int indexOf(String s){
		Nodo aux=primero;
		for (int i=0; i<size();i++){
			if (aux.dato.equals(s))
				return i;
			aux=aux.sig;
		}
		return -1;
	}
	
	public int lastIndexOf(String s){
		Nodo aux=ultimo;
		for (int i=0; i<size();i++){
			if (aux.dato.equals(s))
				return size()-1-i;
			aux=aux.ant;
		}
		return -1;
	}
	
	public boolean isEmpty(){
		return talla==0;
	}
	
	public String remove(int i){
		if (i<0 || i>=size()){
			throw new IndexOutOfBoundsException();
		}
		String dato;
		if (i==0){					//Borra posicion 0
			dato=primero.dato;
			primero=primero.sig;
			if (!(size()==1))
				primero.ant=null;
			else
				ultimo=null;
		}else if (i==size()-1){		//Borra ultima posicion
			dato=ultimo.dato;
			ultimo=ultimo.ant;
			ultimo.sig=null;
		}else{
			Nodo aux;
			if (i<=(size()-1)/2){	//Primera mitad
				aux=primero;
				for (int indice=0;indice<i;indice++){
					aux=aux.sig;
				}
			}else{					//Segunda mitad
				aux=ultimo;
				for (int indice=0;indice<size()-1-i;i++){
					aux=aux.ant;
				}		
			}
			dato=aux.dato;
			aux.ant.sig=aux.sig; 
			aux.sig.ant=aux.ant;
		}
		talla--;
		return dato;
	}
	
	public boolean remove (String s){
		int i=indexOf(s);
		if (i==-1){					//No se encuentra
			return false;
		}else if(i==0){				//Borrar primera posicion
			if (!(size()==1)){
				primero.sig.ant=null;
				primero=primero.sig;
			}else{
				primero=null;
				ultimo=null;
			}	
		}else if (i==size()-1){		//Borrar ultima posicion
			ultimo.ant.sig=null;
			ultimo=ultimo.ant;
		}else{
			Nodo aux;
			if (i<=(size()-1)/2){	//Primera mitad
				aux=primero;
				for (int indice=0;indice<i;indice++){
					aux=aux.sig;
				}
			}else{					//Segunda mitad
				aux=ultimo;
				for (int indice=0;indice<size()-1-i;i++){
					aux=aux.ant;
				}			
			}
			aux.ant.sig=aux.sig; 
			aux.sig.ant=aux.ant;
		}	
		talla--;
		return true;
	}
	
	public String set (int i, String s){
		if (i<0 || i>=size()){
			throw new IndexOutOfBoundsException();
		}
		String cadena;
		Nodo nuevo=new Nodo(s,null,null);
		if (i==0){						//Sustituir en primera posicion
			cadena=primero.dato;
			nuevo.sig=primero.sig;
			primero=nuevo;
			if (!(size()==1))
				primero.sig.ant=nuevo;
		}else if (i==size()-1){			//Sustituir en ultima posicion
			cadena=ultimo.dato;
			nuevo.ant=ultimo.ant;
			ultimo.ant.sig=nuevo;
			ultimo=nuevo;
		}else{
			Nodo aux;
			if (i<=(size()-1)/2){	//Primera mitad
				aux=primero;
				for (int indice=0;indice<i;indice++){
					aux=aux.sig;
				}
			}else{					//Segunda mitad
				aux=ultimo;
				for (int indice=0;indice<size()-1-i;i++){
					aux=aux.ant;
				}
			}
			cadena=aux.dato;
			nuevo.sig=aux.sig;
			nuevo.ant=aux.ant;
			nuevo.sig.ant=nuevo;
			nuevo.ant.sig=nuevo;
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
	
/*	public static void main(String[] args) {
		ListaCadenasEnlaceDoble l = new ListaCadenasEnlaceDoble();
		l.add("1"); System.out.println(l);
		l.add("2"); System.out.println(l);
		l.add("3"); System.out.println(l);
		l.add("4"); System.out.println(l);
		l.add("5"); System.out.println(l);
		l.remove(4); System.out.println(l);
		l.remove(2); System.out.println(l);
		l.remove(1); System.out.println(l);	
		
	}*/
}
