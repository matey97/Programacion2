package practica3.ejercicio01;  // Indica aquí el nombre del paquete que utilizas.

import practica2.ejercicio01.Punto; // Importa aquí la clase Punto

//Importa la clase del ejercicio 9 o del ejercicio 10, según la implementación que quieras utilizar
import practica3.ejercicio01.LineaPoligonal;

//
// Para que este programa de prueba funcione correctamente es importante:
//   1. Que el método toString() de la clase LineaPoligonal use el formato indicado en el enunciado, y
//   2. Que el método toString() de la clase Punto cumpla los requisitos de formato siguientes: 
//         a) usar un punto en lugar de una coma para separar la parte entera de la parte decimal, y 
//         b) usar siempre dos dígitos en la parte decimal.
//      Si tu clase Punto no cumple estos requisitos, debes sustituir tu implementación por la siguiente:
//
//      public String toString() {
//          return String.format(Locale.UK, "(%.2f, %.2f)", this.x, this.y);
//      }
//

public class LineaPoligonalPruebas01 {

    public static void main(String[] args) {
        System.out.println("Comprobamos el constructor de LineaPoligonal...");
        LineaPoligonal miLinea = new LineaPoligonal();
        verificaResultado(miLinea, "", 0);

        Punto p = new Punto(1, 1);
        System.out.println("Añadimos el punto " + p + "...");
        miLinea.añadir(p);
        verificaResultado(miLinea, "(1.00, 1.00)", 0);

        System.out.println("Quitamos el punto " + p + "...");
        miLinea.quitar(p);
        verificaResultado(miLinea, "", 0);

        p = new Punto(0, 0);
        System.out.println("Añadimos el punto " + p + "...");
        miLinea.añadir(p);
        verificaResultado(miLinea, "(0.00, 0.00)", 0);

        p = new Punto(10, 0);
        System.out.println("Añadimos el punto " + p + "...");
        miLinea.añadir(p);
        verificaResultado(miLinea, "(0.00, 0.00)--(10.00, 0.00)", 10);

        p = new Punto(0, 10);
        System.out.println("Añadimos el punto " + p + "...");
        miLinea.añadir(p);
        verificaResultado(miLinea, "(0.00, 0.00)--(10.00, 0.00)--(0.00, 10.00)", 24.14213562373095);

        p = new Punto(0, 0);
        System.out.println("Añadimos el punto " + p + "...");
        miLinea.añadir(p);
        verificaResultado(miLinea, "(0.00, 0.00)--(10.00, 0.00)--(0.00, 10.00)--(0.00, 0.00)",
                34.14213562373095);

        System.out.println("Trasladamos 100 unidades en X y 100 en Y...");
        miLinea.trasladar(100, 100);
        verificaResultado(miLinea,
                "(100.00, 100.00)--(110.00, 100.00)--(100.00, 110.00)--(100.00, 100.00)",
                34.14213562373095);

        System.out.println("Quitamos el primer punto...");
        miLinea.quitar(0);
        verificaResultado(miLinea, "(110.00, 100.00)--(100.00, 110.00)--(100.00, 100.00)",
                24.14213562373095);

        System.out.println("Quitamos el punto de la posición 8 (que no existe)...");
        miLinea.quitar(8);
        verificaResultado(miLinea, "(110.00, 100.00)--(100.00, 110.00)--(100.00, 100.00)",
                24.14213562373095);

        p = new Punto(12, 34);
        System.out.println("Quitamos el punto " + p + " (que no existe)...");
        miLinea.quitar(p);
        verificaResultado(miLinea, "(110.00, 100.00)--(100.00, 110.00)--(100.00, 100.00)",
                24.14213562373095);

        p = new Punto(100, 100);
        System.out.println("Quitamos el punto " + p + "...");
        miLinea.quitar(p);
        verificaResultado(miLinea, "(110.00, 100.00)--(100.00, 110.00)", 14.142135623730951);

        p = new Punto(200, 200);
        System.out.println("Añadimos el punto " + p + "...");
        miLinea.añadir(p);
        System.out.println("Y lo trasladamos (solo el punto) un desplazamiento de -100 en X y -100 en Y...");
        p = p.desplazar(-100, -100);
        verificaResultado(miLinea, "(110.00, 100.00)--(100.00, 110.00)--(200.00, 200.00)", 148.67837609446806);
        
        System.out.println("Comparamos consigo mismo");
        boolean sonIguales = miLinea.equals(miLinea);
        if (sonIguales) {
            System.out.println("  (ok)");
        } else {
            System.out.println("  INCORRECTO Debería ser TRUE");
        }

        System.out.println();
        System.out.println("Comparamos con otra linea poligonal diferente");
        LineaPoligonal otraLinea = new LineaPoligonal();
        otraLinea.añadir(new Punto(110, 100));
        otraLinea.añadir(new Punto(110, 110));
        otraLinea.añadir(new Punto(200, 210));
        sonIguales = miLinea.equals(otraLinea);
        if (sonIguales) {
            System.out.println("  INCORRECTO Debería ser FALSE");
        } else {
            System.out.println("  (ok)");
        }

        System.out.println();
        System.out.println("Comparamos con otra linea poligonal creada con objetos Punto "
                + "diferentes, pero que contienen los mismos valores en X e Y");
        LineaPoligonal otraIgual = new LineaPoligonal();
        otraIgual.añadir(new Punto(110, 100));
        otraIgual.añadir(new Punto(100, 110));
        otraIgual.añadir(new Punto(200, 200));
        sonIguales = miLinea.equals(otraIgual);
        if (sonIguales) {
            System.out.println("  (ok)");
        } else {
            System.out.println("  INCORRECTO Debería ser TRUE");
        }
    }


    public static void verificaResultado(LineaPoligonal l, String resultadoCorrecto,
            double longitudCorrecta) {

        String miResultado = l.toString();
        double miLongitud = l.longitud();

        System.out.println("  linea poligonal = " + miResultado);
        System.out.println("  con longitud = " + miLongitud);

        if (miResultado.equals(resultadoCorrecto) && Math.abs(miLongitud - longitudCorrecta) < 1E-6) {
            System.out.println("  (ok)");
        } else {
            System.out.println("  INCORRECTO: Debería ser  " + resultadoCorrecto + " con longitud "
                    + longitudCorrecta);
        }
        System.out.println();
    }
}
