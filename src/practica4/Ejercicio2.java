package practica4;



public class Ejercicio2 {
	public static void permutaciones (int n){
		int [] disponibles = new int[n];
		for (int i=0; i<n;i++)
			disponibles[i]=i+1;
		permutaciones(disponibles,"");
	}
	
	public static void permutaciones (int[] disponibles, String prefijo){
		if (disponibles.length == 0)
			System.out.println(prefijo);
		else{
			int[] auxiliar= new int[disponibles.length-1];
			for (int e: disponibles){
				int j=0;
				for (int i=0; i<auxiliar.length;){
					if (disponibles[j]!=e){
						auxiliar[i++]=disponibles[j];
					}
					j++;
				}
				permutaciones(auxiliar,prefijo+e);
			}
		}
	}
	
	public static void main (String[] args){
		permutaciones(4);
	}
}
