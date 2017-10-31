package tests.practica2; // Indica aquí el nombre del paquete que utilizas

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

//Importa la clase del ejercicio 9 o del ejercicio 10, según la implementación que quieras utilizar
import practica2.ejercicio09.LineaPoligonal;
import practica2.ejercicio01.Punto;

public class TestLineaPoligonal {

	LineaPoligonal líneaInicial, líneaLarga;
	String representaciónLíneaLarga;
	int longitudInicialLíneaLarga;
	Punto [] puntosLíneaLarga;
	
	@Before
	public void setUp() throws Exception {
		líneaInicial = new LineaPoligonal();
		puntosLíneaLarga = new Punto [] {
			new Punto(1,2), new Punto(3,4), new Punto(5,6), new Punto(7,8)
		};
		líneaLarga = construyeLínea(puntosLíneaLarga);
		representaciónLíneaLarga = "(1.00, 2.00)--(3.00, 4.00)--(5.00, 6.00)--(7.00, 8.00)";
		longitudInicialLíneaLarga = puntosLíneaLarga.length;
	}
	
	private LineaPoligonal construyeLínea(Punto[] puntos) {
		LineaPoligonal línea = new LineaPoligonal();
		for (Punto punto : puntos)
			línea.añadir(punto);
		return línea;
	}

	@Test
	public void testLineaPoligonal() {
		longitudBien(líneaInicial, 0, "en el constructor");
		representaciónBien(líneaInicial, "", "en el constructor");
	}

	@Test
	public void testAñadir() {
		líneaInicial.añadir(new Punto(4, 5));
		longitudBien(líneaInicial, 0, "al añadir un punto");
		representaciónBien(líneaInicial, "(4.00, 5.00)", "al añadir un punto");
		líneaInicial.añadir(new Punto(5, 5));
		longitudBien(líneaInicial, 1, "al añadir un punto");
		representaciónBien(líneaInicial, "(4.00, 5.00)--(5.00, 5.00)", "al añadir un punto");
		líneaInicial.añadir(new Punto(15, 5));
		longitudBien(líneaInicial, 11, "al añadir un punto");
		representaciónBien(líneaInicial, "(4.00, 5.00)--(5.00, 5.00)--(15.00, 5.00)", "al añadir un punto");
	}

	@Test
	public void testQuitarNegativoNoInfluye() {
		líneaLarga.quitar(-1);
		representaciónBien(líneaLarga, representaciónLíneaLarga, "al intentar quitar el elemento -1");
	}
	
	@Test
	public void testQuitarMuyGrandeNoInfluye() {
		líneaLarga.quitar(longitudInicialLíneaLarga);
		representaciónBien(líneaLarga, representaciónLíneaLarga, "al intentar quitar el elemento después del último");
	}
	
	@Test
	public void testQuitarElementoCero() {
		líneaLarga.quitar(0);
		String rep = eliminaEnRepresentación(representaciónLíneaLarga, 0);
		representaciónBien(líneaLarga, rep, "al intentar quitar el elemento cero");
	}

	@Test
	public void testQuitarÚltimoElemento() {
		líneaLarga.quitar(longitudInicialLíneaLarga - 1);
		String rep = eliminaEnRepresentación(representaciónLíneaLarga, longitudInicialLíneaLarga - 1);
		representaciónBien(líneaLarga, rep, "al intentar quitar el último elemento");
	}
	
	@Test
	public void testQuitarPunto() {
		líneaLarga.quitar(2);
		String rep = eliminaEnRepresentación(representaciónLíneaLarga, 2);
		representaciónBien(líneaLarga, rep, "al intentar quitar el segundo elemento");
	}

	@Test
	public void testTrasladar() {
		int desplazamientoX = 2, desplazamientoY = 4;
		Punto[] puntosTrasladados = new Punto[puntosLíneaLarga.length];
		for (int i = 0 ; i < puntosLíneaLarga.length ; i++)
			puntosTrasladados[i] = puntosLíneaLarga[i].desplazar(desplazamientoX, desplazamientoY);
		LineaPoligonal trasladada = construyeLínea(puntosTrasladados);
		líneaLarga.trasladar(desplazamientoX, desplazamientoY);
		assertEquals("Error al desplazar la línea", trasladada, líneaLarga);
	}

	@Test
	public void testLongitud() {
		double l = 0;
		assertEquals("La longitud de una línea vacía debe ser cero.", líneaInicial.longitud(), l, 1e-6);
		Punto punto = puntosLíneaLarga[0];
		líneaInicial.añadir(punto);
		assertEquals("La longitud de una línea de un punto debe ser cero.", líneaInicial.longitud(), l, 1e-6);
		for (int i = 1 ; i < puntosLíneaLarga.length ; i++) {
			l += punto.distancia(puntosLíneaLarga[i]);
			punto = puntosLíneaLarga[i];
			líneaInicial.añadir(punto);
			assertEquals("Error en la longitud de la línea " + líneaInicial, líneaInicial.longitud(), l, 1e-6);
		}
	}

	@Test
	public void testToString() {
		representaciónBien(líneaInicial, "", "vacía");
		líneaInicial.añadir(new Punto(2,3));
		representaciónBien(líneaInicial, "(2.00, 3.00)", "con un punto");
		representaciónBien(líneaLarga, representaciónLíneaLarga, representaciónLíneaLarga);
	}

	@Test
	public void testUnaLíneaVacíaNoEsLarga() {
		assertNotEquals("La línea vacía y otra línea no son iguales", líneaInicial, líneaLarga);
	}
	
	public void testIgualesCopia() {
		LineaPoligonal otraLínea = new LineaPoligonal();
		for (Punto punto: puntosLíneaLarga)
			otraLínea.añadir(punto);
		assertEquals("Estas líneas son iguales", líneaLarga, otraLínea);
	}

	public void testDistintasOrdenInverso() {
		LineaPoligonal otraLínea = new LineaPoligonal();
		for (int i = puntosLíneaLarga.length - 1 ; i >= 0 ; i--)
			otraLínea.añadir(puntosLíneaLarga[i]);
		assertEquals("Estas líneas son distintas por el orden de los puntos", líneaLarga, otraLínea);
	}

	private void representaciónBien(LineaPoligonal línea, String esperado,
			String mensaje) {
		assertEquals("Error en la representación de la línea " + mensaje, esperado, línea.toString());
	}

	private void longitudBien(LineaPoligonal línea, double l, String mensaje) {
		assertEquals("Error en la longitu de la línea " + mensaje, l, línea.longitud(), 1e-6);
	}
	
	private String eliminaEnRepresentación(String representación, int posición) {
		String[] partes = representación.split("--");
		StringBuilder r = new StringBuilder();
		String sep = "";
		for (int i = 0 ; i < partes.length ; i++)
			if (i != posición) {
			r.append(sep);
			r.append(partes[i]);
			sep = "--";
		}
		return r.toString();
	}	
}
