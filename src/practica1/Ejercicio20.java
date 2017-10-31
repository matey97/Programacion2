package practica1;
import java.util.Arrays;

public class Ejercicio20 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[]vector1={1,2,3,4,5};
		int[]vector2={1,2,3,4,5,6,7};
		System.out.println("Vector1: "+Arrays.toString(vector1));
		System.out.println("Vector2: "+Arrays.toString(vector2));
		System.out.println("¿Aparecen todos los numeros del Vector1 en el Vector2? "+contiene(vector2,vector1));
		System.out.println("¿Aparecen todos los numeros del Vector2 en el Vector1? "+contiene(vector1,vector2));
	}
	
	public static boolean contiene (int[]vector, int numero){
		boolean aparece=false;
		for (int i=0; i<vector.length; i++){
			if (vector[i]==numero){
				aparece=true;
				break;
			}
		}
		return aparece;
	}
	
	public static boolean contiene (int[]vector1, int[]vector2){
		boolean aparecenTodos=true;
		for (int i=0; i<vector2.length;i++){
			if (!contiene(vector1,vector2[i])){
				aparecenTodos=false;
				break;
			}
		}
		return aparecenTodos;
	}
}
