package formas;

import formas.Rectangulo.Color;
import utilidades.ES;

/**
 * Clase para probar el funcionamiento de los métodos realizando operaciones
 * @author Adrián Roemro
 */
public class TestMetodos {
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        /**
         * En este código he usado los mismos métodos y objetos que en la clase
         * principal, para probar su correcto funcionamiento.
         */
        
        ES.msgln("Intento crear un rectángulo de 0 filas y 3 columnas");
        try{
            Rectangulo rectangulo1 = new Rectangulo('#', 0, 3, Color.ROJO);
        }catch(IllegalArgumentException ex){
            ES.msgln(ex.toString());
        }
        
        Rectangulo rectangulo1 = new Rectangulo('#', 6, 10, Color.AZUL);
        ES.msgln("\nMostramos los datos de el rectángulo:");
        ES.msgln(rectangulo1.toString());
        
        ES.msgln("\nDibujamos el rectángulo (sin relleno)\n");
        ES.msgln(rectangulo1.dibujar2D(false));
        
        ES.msgln("Dibujamos el rectángulo (relleno)\n");
        ES.msgln(rectangulo1.dibujar2D(true));
        
        rectangulo1.modificarAltura(20);
        ES.msgln("Volver a dibujar el rectángulo (sin relleno)\n");
        ES.msgln(rectangulo1.dibujar2D(false));
        
        rectangulo1.modificarAnchura(20);
        ES.msgln("Volvemos a dibujar el rectángulo (sin relleno)\n");
        ES.msgln(rectangulo1.dibujar2D(false));
        
        rectangulo1.girarRectangulo();
        ES.msgln("Rectángulo girado\n");
        ES.msgln(rectangulo1.dibujar2D(false));
        
        rectangulo1.setColor(Color.AMARILLO);
        ES.msgln("Color cambiado.\n");
        
        ES.msgln("Mostramos los datos del rectángulo:");
        ES.msgln(rectangulo1.toString()+"\n");
        
        Rectangulo recPredefinido1 = new Rectangulo ('@', 6, 13, Color.AZUL);
        Rectangulo recPredefinido2 = new Rectangulo ('/', 10, 12, Color.ROJO);
        Rectangulo recPredefinido3 = new Rectangulo ('$', 3, 7, Color.VERDE);
        ES.msgln(recPredefinido1.dibujar2D(true));
        ES.msgln(recPredefinido2.dibujar2D(false));
        ES.msgln(recPredefinido3.dibujar2D(true));
        
        Rectangulo primerRec = new Rectangulo ('@', 7, 4, Color.AMARILLO);
        ES.msgln("Primero dibujamos un rectángulo de 7 filas y 4 columnas\n");
        ES.msgln(primerRec.dibujar2D(true));
        Rectangulo segundoRec = new Rectangulo ('/', 5, 10, Color.ROJO);
        ES.msgln("Y ahora un rectángulo de 5 filas y 10 columnas\n");
        ES.msgln(segundoRec.dibujar2D(false));
        ES.msgln("Ahora, cambiamos con los sets los valores de filas y columnas del primer rectángulo con los del segundo");
        int filasPrimer = primerRec.getFilas();
        int columnasPrimer = primerRec.getColumnas();
        int filasSegundo = segundoRec.getFilas();
        int columnasSegundo = segundoRec.getColumnas();
        primerRec.setFilas(filasSegundo);
        primerRec.setColumnas(columnasSegundo);
        segundoRec.setFilas(filasPrimer);
        segundoRec.setColumnas(columnasPrimer);
        ES.msgln("Y así el primer rectángulo queda ahora:\n");
        ES.msgln(primerRec.dibujar2D(true));
        ES.msgln("Y el segundo rectángulo queda como:\n");
        ES.msgln(segundoRec.dibujar2D(false));
                      
    }
       
}
