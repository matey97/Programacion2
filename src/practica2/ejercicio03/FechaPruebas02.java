package practica2.ejercicio03;

// Importa la clase del ejercicio 3 o del ejercicio 7, según la implementación que quieras utilizar
import practica2.ejercicio07.Fecha;

public class FechaPruebas02 {

    public static void main(String[] args) {
	
	int numDías = 1;
	Fecha fechaInicial = new Fecha(31, 12, 1999);
	Fecha fecha1 = fechaInicial;
	Fecha fecha2 = fecha1.díaSiguiente();
	
	if (! fechaInicial.equals(new Fecha(31,12,1999))
	    || ! fecha1.equals(new Fecha(31,12,1999))
	    || ! fecha2.equals(new Fecha(1, 1, 2000)))
	    System.out.println("Se ha producido un error en las inicializaciones.");

	for (int año = 2000; año <= 2400; año++) {
	    System.out.println("probando año " + año);
	    for (int mes = 1; mes <= 12; mes++) {
		int últimoDía = Fecha.díasMes(mes, año);
		for (int día = 1; día <= últimoDía; día++) {
		    fecha1 = fecha1.díaSiguiente();
		    fecha2 = fechaInicial.sumarDías(numDías);
		    if (!fecha1.equals(fecha2) || !fecha1.equals(new Fecha(día, mes, año))) {
			System.out.println("Se ha producido un error: " + fecha1 + " " + fecha2 + " " + día+"-"+mes+"-"+año);
		    }
		    numDías++;
		}
	    }
	}
	System.out.println("No hay más comprobaciones. Verificados " + numDías + " días.");
	if  (numDías != 146464) {
	    System.out.println("La cantidad de días verificados no es la esperada. Revisa los métodos díasMes y añoBisiesto.");
	}
    }
}
