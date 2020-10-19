package formas;

import formas.Rectangulo.*;
import utilidades.ES;

/**
 * Clase principal del programa, que consiste en un bucle que estar� 
 *  iterando continuamente mientras que el usuario no introduzca un 0.
 * 
 * @author Adri�n Romero
 */
public class Principal {
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        /**
         * Lo primero que hago es meter todo el c�digo en un try/catch para que
         * captures las excepciones que pueda encontrar, que ente caso ser�a el
         * error de poner un m�nimo mayor que el m�ximo a la hora de leer 
         * enteros dentro de un rango y el error de crear un rect�ngulo cuyas
         * filas o columnas sean igual o menor que 0. Y en el caso que las 
         * capture, finalice el programa sin que aborte e imprima un mensaje
         * por pantalla.
         */
        Rectangulo hola = new Rectangulo ('t',0,6,Color.AMARILLO);
        try{
        ES.msgln("Vamos a cear un primer rect�ngulo.");
        
        /*Aqu� creamos e inicializamos las variables columnas, filas, y numColor
        para darle los valores iniciales introducidos por el usuario, al primer
        rect�ngulo. Tambi�n convertimos el entero numColor en un enum creado en
        la clase Rect�ngulo para que pueda leerlo el m�todo que le corresponda.
        */
   
        int columnas = ES.leeEntero("\nEscribe el n�mero de columnas que tendr� el rect�ngulo (entre 1 y 80)", 1, 80);
        int filas = ES.leeEntero("\nEscribe el n�mero de filas que tendr� el rect�ngulo (entre 1 y 40)", 1, 40);
        int numColor = ES.leeEntero("\nEscriba el color del rect�ngulo (1-> ROJO, 2-> VERDE, 3-> AZUL, 4-> AMARILLO)", 1, 4);
        Color color = Rectangulo.enteroAcolor(numColor);
        int opcion;
        
        /**
         * Creamos el objeto rect�ngulo de la clase Rect�ngulo con los datos
         * introducidos por el usuario.
         */
        Rectangulo rectangulo = new Rectangulo ('*', filas, columnas, color);
        
        /**
         * Con un bucle do/while creo una iteraci�n para que se est� mostrando 
         * el men� con las diferentes opciones y se pueda interactuar con el
         * hasta que el usuario introduzca 0 para terminar la ejecuci�n del
         * programa.
         */

        do{
        
            ES.msgln("\n     ========================================\n" +
                 "     ============== Rect�ngulos =============\n" +
                 "     ========================================\n" +
                 "\n" +
                 "         1.- Mostrar los datos del rect�ngulo.\n" +
                 "         2.- Dibujar rect�ngulo.\n" +
                 "         3.- Dibujar rect�ngulo relleno.\n" +
                 "         4.- Modificar altura (filas) del rect�ngulo.\n" +
                 "         5.- Modificar anchura (columnas) del rect�ngulo.\n" +
                 "         6.- Girar rect�ngulo.\n" +
                 "         7.- Modificar color del rect�ngulo.\n" +
                 "         8.- Dibujar tres rect�ngulos: el primero relleno el segundo solo con borde y el tercero relleno.\n" +
                 "         9.- Dibujar dos rect�ngulos e interambiar (usando los sets y los gets) las filas y columnas de uno al otro.\n" +
                 "\n" +
                 "         0.- Salir de la aplicaci�n.\n" +
                 "     ========================================\n" +
                 "     Introduzca la opci�n elegida: ");

            opcion = ES.leeEntero(0, 9);
        
        
            switch (opcion){
            case 1:
                //Se muestra los datos del rect�ngulo usando el m�todo toString
                ES.msgln("\nMostramos los datos del rect�ngulo:");
                ES.msgln(rectangulo.toString());
                break;
            case 2:
                /*
                Se dibuja el rect�ngulo sin relleno usando el m�todo dibujar2D
                con el par�metro "false"
                */
                ES.msgln("\nDibujamos el rect�ngulo (sin relleno):\n");
                ES.msgln(rectangulo.dibujar2D(false));
                break;
            case 3:
                /*
                Se dibuja el rect�ngulo con relleno usando el m�todo dibujar2D
                con el par�matro "true"
                */
                ES.msgln("\nDibujamos el rect�ngulo (relleno):\n");
                ES.msgln(rectangulo.dibujar2D(true));
                break;
            case 4:
                /*
                Se le pide al usuario que introduzca un numero entre unos valores
                para modificar la altura del rect�ngulo y se modifica la altura
                con el m�todo modificarAltura con el par�metro introducido por 
                el usuario y se le avisa con un mensaje en pantalla si a sido 
                posible modificar la altura o no
                */
                ES.msgln("\nEscriba un n�mero entre -10 y 10 para aumentar la altura del rect�ngulo en ese tama�o:");
                int diferenciaAltura = ES.leeEntero(-10, 10);
                boolean alturaModificada = rectangulo.modificarAltura(diferenciaAltura);
                if (alturaModificada)
                    ES.msgln("Altura modificada correctamente.");
                else
                    ES.msgln("No fue posible modificar la altura.");
                break;
            case 5:
                /*
                Hace lo mismo que el anterior pero con la anchura y el m�todo
                modificarAnchura
                */
                ES.msgln("\nEscriba un n�mero entre -10 y 10 para aumentar la anchura del rect�ngulo en ese tama�o:");
                int diferenciaAnchura = ES.leeEntero(-10, 10);
                boolean anchuraModificada = rectangulo.modificarAnchura(diferenciaAnchura);
                if (anchuraModificada)
                    ES.msgln("Anchura modificada correctamente");
                else
                    ES.msgln("No fue posible modificar la anchura");
                break;
            case 6:
                //Gira el rect�ngulo con el m�todo girarRectangulo
                rectangulo.girarRectangulo();
                ES.msgln("\nRect�ngulo girado");
                break;
            case 7:
                /*
                Se le pide al usuario que elija un nuevo color y se modifica el
                color en el rect�ngulo con el m�todo setColor
                */
                ES.msgln("\nEscriba el color del rect�ngulo (1-> ROJO, 2-> VERDE, 3-> AZUL, 4-> AMARILLO)");
                int numNuevoColor = ES.leeEntero(1, 4);
                ES.msgln("Color cambiado");
                Color nuevoColor = Rectangulo.enteroAcolor(numNuevoColor);
                rectangulo.setColor(nuevoColor);
                break;
            case 8:
                /*
                Se crean 3 rect�ngulos y se muestran en pantalla igual que 
                anteriormente, pero esta vez con uno par�metros predefinidos
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
                Se crean dos rect�ngulos, se muestran en pantalla y despu�s con
                los sets y gets intercambiar las columnas y filas entre ellos
                para mostrarlos nuevamente por pantalla
                */
                Rectangulo primerRec = new Rectangulo ('@', 7, 4, Color.VERDE);
                ES.msgln("\nPrimero dibujamos un rect�ngulo de 7 filas y 4 columnas\n");
                ES.msgln(primerRec.dibujar2D(true));
                Rectangulo segundoRec = new Rectangulo ('/', 5, 10, Color.AMARILLO);
                ES.msgln("Y ahora un rect�ngulo de 5 filas y 10 columnas\n");
                ES.msgln(segundoRec.dibujar2D(false));
                ES.msgln("Ahora, cambiamos con los sets los valores de filas y columnas del primer rect�ngulo con los del segundo");
                int filasPrimer = primerRec.getFilas();
                int columnasPrimer = primerRec.getColumnas();
                int filasSegundo = segundoRec.getFilas();
                int columnasSegundo = segundoRec.getColumnas();
                primerRec.setFilas(filasSegundo);
                primerRec.setColumnas(columnasSegundo);
                segundoRec.setFilas(filasPrimer);
                segundoRec.setColumnas(columnasPrimer);
                ES.msgln("Y as� el primer rect�ngulo queda ahora:\n");
                ES.msgln(primerRec.dibujar2D(true));
                ES.msgln("Y el segundo rect�ngulo queda como:\n");
                ES.msgln(segundoRec.dibujar2D(false));
                
            }
        }while (opcion != 0);
        
        }catch(IllegalArgumentException ex){
            ES.msgln(ex.toString());
        }
        /**
         * Y para finalizar, mostramos un mensaje de fin de programa cuando el 
         * usuario introduzca un 0 y finalice la ejecuci�n del programa para que 
         * sepa que ha finalizado correctamente.
         */
        ES.msgln("\nFin del programa.");
        
        /**
         * PD: He intercalado algunas secuencias de escape "\n" en las cadenas
         * de texto para que el resultado en pantalla sea m�s est�tico.
         */
    }
    
}