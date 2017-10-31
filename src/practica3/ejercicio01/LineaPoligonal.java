package practica3.ejercicio01;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
//import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

import practica2.ejercicio01.Punto;


public class LineaPoligonal implements List{
	
	private List<Punto>vector;
	
	public LineaPoligonal(){
		this.vector=new ArrayList<Punto>();
		//this.vector=new LinkedList<Punto>();		
	}
	
	public void añadir(Punto punto){
		vector.add(punto);
	}
	
	public void quitar(int posición){
		if (posición>=0 && posición<vector.size()){
			vector.remove(posición);
		}
		
	}
	
	public void quitar(Punto punto){
		vector.remove(punto);
	}
	
	public void trasladar(double desplazamientoX,double desplazamientoY){
		for (int i=0; i<vector.size();i++){
			vector.set(i,vector.get(i).desplazar(desplazamientoX,desplazamientoY));
		}
	}
	
	public double longitud(){
		if (vector.size()<=1)
			return 0;
		double distancia=0;
		for (int i=0;i<vector.size()-1;i++){
			distancia+=vector.get(i).distancia(vector.get(i+1));
		}
		return distancia;
	}
	
	public String toString(){
		if (vector.size()==0)
			return "";
		if (vector.size()==1)
			return vector.get(0).toString();
		String cadena=vector.get(0).toString();
		for (int i=1;i<vector.size();i++){
			cadena+="--"+vector.get(i).toString();
		}
		return cadena;			
	}
	
	public boolean equals(Object otroObjeto){
		if (this.vector==otroObjeto)
			return true;
		if (!(otroObjeto instanceof LineaPoligonal))
			return false;
		LineaPoligonal otraLinea=(LineaPoligonal) otroObjeto;
		if (vector.size()!=otraLinea.vector.size())
			return false;
		for (int i=0; i<vector.size();i++){
			if (!(vector.get(i).equals(otraLinea.vector.get(i))))
				return false;
		}
		return true;
					
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean contains(Object o) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Iterator iterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object[] toArray() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object[] toArray(Object[] a) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean add(Object e) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean remove(Object o) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean containsAll(Collection c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addAll(Collection c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addAll(int index, Collection c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean removeAll(Collection c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean retainAll(Collection c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Object get(int index) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object set(int index, Object element) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void add(int index, Object element) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Object remove(int index) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int indexOf(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int lastIndexOf(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ListIterator listIterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ListIterator listIterator(int index) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List subList(int fromIndex, int toIndex) {
		// TODO Auto-generated method stub
		return null;
	}
}
