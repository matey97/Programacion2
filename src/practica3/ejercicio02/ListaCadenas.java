package practica3.ejercicio02;

public interface ListaCadenas {
	boolean add(String s);
	void add(int i, String s);
	void clear();
	String get(int i);
	int indexOf(String s);
	int lastIndexOf(String s);
	boolean isEmpty();
	String remove(int i);
	boolean remove(String s);
	String set(int i, String s);
	int size();
}
