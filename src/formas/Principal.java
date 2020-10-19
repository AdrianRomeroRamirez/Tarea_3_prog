package formas;

import formas.Rectangulo.*;
import utilidades.ES;

/**
 * Clase principal del programa, que consiste en un bucle que estará 
 *  iterando continuamente mientras que el usuario no introduzca un 0.
 * 
 * @author Adrián Romero
 */
public class Principal {
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        /**
         * Lo primero que hago es meter todo el código en un try/catch para que
         * captures las excepciones que pueda encontrar, que ente caso sería el
         * error de poner un mínimo mayor que el máximo a la hora de leer 
         * enteros dentro de un rango y el error de crear un rectángulo cuyas
         * filas o columnas sean igual o menor que 0. Y en el caso que las 
         * capture, finalice el programa sin que aborte e imprima un mensaje
         * por pantalla.
         */
        Rectangulo hola = new Rectangulo ('t',0,6,Color.AMARILLO);
        try{
        ES.msgln("Vamos a cear un primer rectángulo.");
        
        /*Aquí creamos e inicializamos las variables columnas, filas, y numColor
        para darle los valores iniciales introducidos por el usuario, al primer
        rectángulo. También convertimos el entero numColor en un enum creado en
        la clase Rectángulo para que pueda leerlo el método que le corresponda.
        */
   
        int columnas = ES.leeEntero("\nEscribe el número de columnas que tendrá el rectángulo (entre 1 y 80)", 1, 80);
        int filas = ES.leeEntero("\nEscribe el número de filas que tendrá el rectángulo (entre 1 y 40)", 1, 40);
        int numColor = ES.leeEntero("\nEscriba el color del rectángulo (1-> ROJO, 2-> VERDE, 3-> AZUL, 4-> AMARILLO)", 1, 4);
        Color color = Rectangulo.enteroAcolor(numColor);
        int opcion;
        
        /**
         * Creamos el objeto rectángulo de la clase Rectángulo con los datos
         * introducidos por el usuario.
         */
        Rectangulo rectangulo = new Rectangulo ('*', filas, columnas, color);
        
        /**
         * Con un bucle do/while creo una iteración para que se esté mostrando 
         * el menú con las diferentes opciones y se pueda interactuar con el
         * hasta que el usuario introduzca 0 para terminar la ejecución del
         * programa.
         */

        do{
        
            ES.msgln("\n     ========================================\n" +
                 "     ============== Rectángulos =============\n" +
                 "     ========================================\n" +
                 "\n" +
                 "         1.- Mostrar los datos del rectángulo.\n" +
                 "         2.- Dibujar rectángulo.\n" +
                 "         3.- Dibujar rectángulo relleno.\n" +
                 "         4.- Modificar altura (filas) del rectángulo.\n" +
                 "         5.- Modificar anchura (columnas) del rectángulo.\n" +
                 "         6.- Girar rectángulo.\n" +
                 "         7.- Modificar color del rectángulo.\n" +
                 "         8.- Dibujar tres rectángulos: el primero relleno el segundo solo con borde y el tercero relleno.\n" +
                 "         9.- Dibujar dos rectángulos e interambiar (usando los sets y los gets) las filas y columnas de uno al otro.\n" +
                 "\n" +
                 "         0.- Salir de la aplicación.\n" +
                 "     ========================================\n" +
                 "     Introduzca la opción elegida: ");

            opcion = ES.leeEntero(0, 9);
        
        
            switch (opcion){
            case 1:
                //Se muestra los datos del rectángulo usando el método toString
                ES.msgln("\nMostramos los datos del rectángulo:");
                ES.msgln(rectangulo.toString());
                break;
            case 2:
                /*
                Se dibuja el rectángulo sin relleno usando el método dibujar2D
                con el parámetro "false"
                */
                ES.msgln("\nDibujamos el rectángulo (sin relleno):\n");
                ES.msgln(rectangulo.dibujar2D(false));
                break;
            case 3:
                /*
                Se dibuja el rectángulo con relleno usando el método dibujar2D
                con el parámatro "true"
                */
                ES.msgln("\nDibujamos el rectángulo (relleno):\n");
                ES.msgln(rectangulo.dibujar2D(true));
                break;
            case 4:
                /*
                Se le pide al usuario que introduzca un numero entre unos valores
                para modificar la altura del rectángulo y se modifica la altura
                con el método modificarAltura con el parámetro introducido por 
                el usuario y se le avisa con un mensaje en pantalla si a sido 
                posible modificar la altura o no
                */
                ES.msgln("\nEscriba un número entre -10 y 10 para aumentar la altura del rectángulo en ese tamaño:");
                int diferenciaAltura = ES.leeEntero(-10, 10);
                boolean alturaModificada = rectangulo.modificarAltura(diferenciaAltura);
                if (alturaModificada)
                    ES.msgln("Altura modificada correctamente.");
                else
                    ES.msgln("No fue posible modificar la altura.");
                break;
            case 5:
                /*
                Hace lo mismo que el anterior pero con la anchura y el método
                modificarAnchura
                */
                ES.msgln("\nEscriba un número entre -10 y 10 para aumentar la anchura del rectángulo en ese tamaño:");
                int diferenciaAnchura = ES.leeEntero(-10, 10);
                boolean anchuraModificada = rectangulo.modificarAnchura(diferenciaAnchura);
                if (anchuraModificada)
                    ES.msgln("Anchura modificada correctamente");
                else
                    ES.msgln("No fue posible modificar la anchura");
                break;
            case 6:
                //Gira el rectángulo con el método girarRectangulo
                rectangulo.girarRectangulo();
                ES.msgln("\nRectángulo girado");
                break;
            case 7:
                /*
                Se le pide al usuario que elija un nuevo color y se modifica el
                color en el rectángulo con el método setColor
                */
                ES.msgln("\nEscriba el color del rectángulo (1-> ROJO, 2-> VERDE, 3-> AZUL, 4-> AMARILLO)");
                int numNuevoColor = ES.leeEntero(1, 4);
                ES.msgln("Color cambiado");
                Color nuevoColor = Rectangulo.enteroAcolor(numNuevoColor);
                rectangulo.setColor(nuevoColor);
                break;
            case 8:
                /*
                Se crean 3 rectángulos y se muestran en pantalla igual que 
                anteriormente, pero esta vez con uno parámetros predefinidos
                */
                Rectangulo recPredefinido1 = new Rectangulo ('@', 6, 13, Color.AMARILLO);
                Rectangulo recPredefinido2 = new Rectangulo ('/', 10, 12, Color.AZUL);
                Rectangulo recPredefinido3 = new Rectangulo ('$', 3, 7, color.ROJO);
                ES.msgln(recPredefinido1.dibujar2D(true));
                ES.msgln(recPredefinido2.dibujar2D(false));
                ES.msgln(recPredefinido3.dibujar2D(true));
                break;
            case 9:
                /*
                Se crean dos rectángulos, se muestran en pantalla y después con
                los sets y gets intercambiar las columnas y filas entre ellos
                para mostrarlos nuevamente por pantalla
                */
                Rectangulo primerRec = new Rectangulo ('@', 7, 4, Color.VERDE);
                ES.msgln("\nPrimero dibujamos un rectángulo de 7 filas y 4 columnas\n");
                ES.msgln(primerRec.dibujar2D(true));
                Rectangulo segundoRec = new Rectangulo ('/', 5, 10, Color.AMARILLO);
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
        }while (opcion != 0);
        
        }catch(IllegalArgumentException ex){
            ES.msgln(ex.toString());
        }
        /**
         * Y para finalizar, mostramos un mensaje de fin de programa cuando el 
         * usuario introduzca un 0 y finalice la ejecución del programa para que 
         * sepa que ha finalizado correctamente.
         */
        ES.msgln("\nFin del programa.");
        
        /**
         * PD: He intercalado algunas secuencias de escape "\n" en las cadenas
         * de texto para que el resultado en pantalla sea más estético.
         */
    }
    
}