package practica1;

public class Ejercicio11 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String a = "Hola";
		String b = "la";
		String c = "ol";
		if (esSufijo(a,b)){
			System.out.println(b+" es sufijo de "+a);	
		}else{
			System.out.println(b+" no es sufijo de "+a);
		}
		if (esSufijo(a,c)){
			System.out.println(c+" es sufijo de "+a);	
		}else{
			System.out.println(c+" no es sufijo de "+a);
		}
	}
	public static boolean esSufijo(String cadena1,String cadena2){
		int longitudPalabra= cadena1.length();
		int longitudSufijo = cadena2.length();
		for (int i=1;i<=longitudSufijo;i++){
			if (cadena1.charAt(longitudPalabra-i) != cadena2.charAt(longitudSufijo-i)){
				return false;
			}	
		}
		return true;
	}
}
