package practica4;

public class Ejercicio1 {
	public static void variacionesRepetición(int n, int m){
		variacionesRepetición(n,m,"");
	}
	
	private static void variacionesRepetición(int n, int m, String prefijo){
		if (m==0){
			System.out.println(prefijo);
		}else{
			for (int i=1; i<=n; i++){
				variacionesRepetición(n,m-1,prefijo+i);
			}
		
		}
	}
	
	
	
	public static void main(String[] args){
		variacionesRepetición(4,3);
	}
}
