package practica4;

public class Ejercicio3 {
	
	public static int validas=0;
	
	public static void ochoReinas(){
		int[] filas = new int[8];
		for (int i=0;i<filas.length;i++)
			filas[i]=i+1;
		ochoReinas(filas, "");
	}
	
	public static boolean esCorrecta(String solucion){
		for (int i=0; i<solucion.length()-1;i++){
			for (int j=i+1;j<solucion.length();j++){
				if (Math.abs(solucion.charAt(i)-solucion.charAt(j))==Math.abs(i-j))
					return false;
			}
		}
		return true;
	}
	
	public static void ochoReinas (int[] disponibles,String prefijo){
		if (disponibles.length==0){
			if (esCorrecta(prefijo)){
				System.out.println(prefijo);
				validas++;
			}	
		}else{
			int[] auxiliar= new int[disponibles.length-1];
			for (int e: disponibles){
				int j=0;
				for (int i=0; i<auxiliar.length;){
					if (disponibles[j]!=e){
						auxiliar[i++]=disponibles[j];
					}
					j++;
				}
				ochoReinas(auxiliar,prefijo+e);
			}
		}
	}
	
	public static void main (String[] args){
		ochoReinas();
		System.out.println("Hay un total de "+validas+" soluciones.");
	}
}
