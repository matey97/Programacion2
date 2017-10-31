package practica1;

import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;
public class Ejercicio24 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public static char[][] crearMatrizResultados(String[] equipos,String nombreFichero)
			throws FileNotFoundException {
		char[][] matrizRes= new char[equipos.length][equipos.length];
		Scanner entrada= new Scanner(new File(nombreFichero));
		while (entrada.hasNextLine()){
			String local=entrada.next();
			int localIndice=-1;	     //-1 para evitar que eclipse de error por si no entra al for
			int golesLocal=entrada.nextInt();
			String visitante=entrada.next();
			int visitanteIndice=-1; //-1 para evitar que eclipse de error por si no entra al for
			int golesVisitante=entrada.nextInt();
			for (int i=0; i<equipos.length;i++){
				if (equipos[i].equals(local)){
					localIndice=i;
				}else{
					if (equipos[i].equals(visitante)){
						visitanteIndice=i;
					}
				}
			}
			if (golesLocal>golesVisitante){
				matrizRes[localIndice][visitanteIndice]='1';
			}else{
				if (golesLocal<golesVisitante){
					matrizRes[localIndice][visitanteIndice]='2';
				}else{
					matrizRes[localIndice][visitanteIndice]='X';
				}
			}
			for (int i=0;i<matrizRes.length;i++){
				for (int j=0;j<matrizRes.length;j++){
					if (matrizRes[i][j]=='0'){
						matrizRes[i][j]='-';
					}
				}
			}
			
		}
		entrada.close();
		return matrizRes;
	}
}
