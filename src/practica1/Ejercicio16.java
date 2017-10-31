package practica1;

public class Ejercicio16 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double[]vector1={-3.4,-10,-5.6,-2.1,1.5,-1.7,-0.4,-0.2,2.9};
		double[]vector2={5.6,2.4,0.7,-0.4,-2.4,-1.3,2.1,4.0,6.7};
		System.out.println("Ha habido "+contarOlasDeFrio(vector1,2) +" olas de frio." );
		System.out.println("Ha habido "+contarOlasDeFrio(vector1,3) +" olas de frio." );
		System.out.println("Ha habido "+contarOlasDeFrio(vector2,2) +" olas de frio." );
		System.out.println("Ha habido "+contarOlasDeFrio(vector2,3) +" olas de frio." );
	}
	public static int contarOlasDeFrio(double[]vector,int numero){
		int olas=0;
		int consecutivos=0;
		boolean contada=false;
		for (int i=0;i<vector.length;i++){
			if (vector[i]<0){
				consecutivos++;
				if (consecutivos>numero && !contada){
					contada=true;
					olas++;
				}
			}else{
				consecutivos=0;
				contada=false;
			}
		}
		return olas;
	}
}
