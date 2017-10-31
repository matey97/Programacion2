package practica3.ejercicio01; // Indica aquí el nombre del paquete que utilizas.

import practica2.ejercicio01.Punto; // Importa aquí la clase Punto

//Importa la clase del ejercicio 9 o del ejercicio 10, según la implementación que quieras utilizar
import practica3.ejercicio01.LineaPoligonal;

//
// TODO: Si tu clase Punto está en otro paquete de este mismo proyecto impórtala con
//
//          import nombre-del-paquete.Punto;
//
//       Si, por el contrario, tu clase Punto está en otro proyecto,
//       copia el fichero Punto.java a este proyecto.
//

public class LineaPoligonalPruebas02 {

	private static final int LÍMITE = 100000;

	public static void main(String[] args) {
		LineaPoligonal línea = new LineaPoligonal();
		System.out.println("Creada línea poligonal vacía");
		System.out.println("\nAñadiendo puntos a la línea...");
		for (int i = 1; i <= LÍMITE; i++) {
			if (i % 10000 == 0)
				System.out.println("  " + i + " puntos");
			línea.añadir(new Punto(i, i));
		}
		System.out.println("\nLongitud de la línea: " + línea.longitud());
	}

}
