package practica1;



public class ejercicio15 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String[]vector={"Adios","Bolo","Casa","Dinosaurio"};
		String[]vector2={"Adios","Casa","Bolo","Dinosaurio"};
		if (estaOrdenado(vector)){
			System.out.println("El vector esta ordenado de menor a mayor");
		}else{
			System.out.println("El vector no esta ordenado de menor a mayor");
		}
		if (estaOrdenado(vector2)){
			System.out.println("El vector esta ordenado de menor a mayor");
		}else{
			System.out.println("El vector no esta ordenado de menor a mayor");
		}
	
	}
	public static boolean estaOrdenado(String[] vector){
		for (int i =0; i<vector.length-1;i++){
			if (vector[i].compareTo(vector[i+1])>0){
				return false;
			}
		}
		return true;
	}
}
