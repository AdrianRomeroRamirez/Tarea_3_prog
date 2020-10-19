package formas;

import utilidades.ES;

/**
 * Clase que representa un rectángulo, que tendrá un número de columnas, filas,
 * se representará por un carácter determinado, que repetido en filas y columnas
 * formará el rectángulo. Y que estará realizado con un color determiando, 
 * representado en un enumerado.
 * 
 * @author José Javier Bermúdez Hernández
 */
public class Rectangulo {
    
    public static final int MAX_FILAS = 40 ;
    public static final int MAX_COLUMNAS = 80 ;
    
    /** Carácter usado para dibujar el rectángulo por consola */
    private char caracter ;     
    /** Columnas que tendrá el dibujo */
    private int columnas ;      
    /** Filas que tendrá el dibujo */
    private int filas ;         
    /** ColorTexto del rectángulo */
    private Color color ; 

    
    /** Enumerado con los valores que se permiten como atributo del color. */
    public enum Color {
        /** ColorTexto rojo */
        ROJO,
        /** ColorTexto verde */
        VERDE, 
        /** ColorTexto azul */
        AZUL, 
        /** ColorTexto amarillo */
        AMARILLO} ;

    /**
     * Constructor por defecto de la clase. Inicializa un objeto con los
     * valores * para carácter, 6 para las columnas, 3 para las filas y ROJO
     * como color.
     */
    public Rectangulo() {
        this.caracter = '*' ;
        this.columnas = 6 ;
        this.filas = 3 ;
        this.color = Color.ROJO ;
    }
    
    /**
     * Constructor con parámetros.
     * @param caracter  Carácter con el que se dibujará por consola el rectángulo.
     * @param filas     Filas de el rectángulo.
     * @param columnas  Columnas de el rectángulo.
     * @param color  ColorTexto con el que se hace el rectángulo. 
     * @throws IllegalArgumentException Se lanza la excepción si las filas y/o 
     *  las columnas recibidas como parámetro son iguales a 0 o negativas.
     */
    public Rectangulo(char caracter, int filas, int columnas, Color color) throws IllegalArgumentException {
        if (columnas > 0 && filas > 0) {
            this.caracter = caracter;
            this.columnas = columnas;
            this.filas = filas;
            this.color = color ;
        }
        else  {
            throw new IllegalArgumentException("Medida(s) no permitidas") ;
        }
    }
    
    /**
     * Devuelve el carácter de el rectángulo.
     * @return Carácter de al caja.
     */
    public char getCaracter() {
        return caracter;
    }

    /**
     * Establece el carácter del rectángulo.
     * @param caracter Carácter del rectángulo.
     */
    public void setCaracter(char caracter) {
        this.caracter = caracter;
    }

    /**
     * Devuelve las columnas del rectángulo.
     * @return Columnas del rectángulo.
     */
    public int getColumnas() {
        return columnas;
    }

    /**
     * Establece las columnas del rectángulo.
     * @param columnas Columnas del rectángulo.
     */
    public void setColumnas(int columnas) {
        this.columnas = columnas;
    }

    /**
     * Devuelve las filas del rectángulo.
     * @return filas del rectángulo.
     */
    public int getFilas() {
        return filas;
    }

    /**
     * Establece las filas del rectángulo.
     * @param filas Filas del rectángulo
     */
    public void setFilas(int filas) {
        this.filas = filas;
    }
 
    /**
     * ColorTexto de el rectángulo.
     * @return Devuelve el color del rectángulo.
     */
    public Color getColor() {
        return this.color ;
    }

    
    /**
     * Asigna un color al objeto.
     * @param color ColorTexto que se asignará al objeto.
     */
    public void setColor(Color color) {
        this.color = color ;
    }

    /**
     * Construye y devuelve la cadena de caracteres con la información del
     * rectángulo.
     * @return cadena de caracteres con la información del rectángulo.
     */
    @Override
    public String toString() {
        return "El rectángulo se dibuja con el carácter: " + this.caracter + 
                " y se dibujará con: " + this.columnas + " columnas y " +
                this.filas + " filas. El color del rectángulo es: " + 
                this.color ;
    }
    
    
    
    /**
     * Construye la cadena de caracteres que representa el rectángulo dibujado.
     * @param relleno Si se quiere dibujar el rectángulo relleno o sólo el borde.
     * @return La cadena de caracteres que representa el rectángulo.
     */
    public String dibujar2D(boolean relleno) {
        StringBuilder resultado = new StringBuilder();
        String secEscColor="";
        switch (this.color)
        {
            case ROJO: secEscColor=ES.ColorTexto.ROJO.codigoColorTexto(); break;
            case VERDE: secEscColor=ES.ColorTexto.VERDE.codigoColorTexto(); break;
            case AZUL: secEscColor=ES.ColorTexto.AZUL.codigoColorTexto(); break;
            case AMARILLO: secEscColor=ES.ColorTexto.AMARILLO.codigoColorTexto(); break;
        }
        for (int y=0; y<this.filas; y++) {
            resultado.append(secEscColor);
            for (int x=0; x<this.columnas; x++) {
                
                if (x==0 || y==0 || y==this.filas-1 ||x==this.columnas-1 ) {
                    resultado.append(caracter) ;
                } else {
                    if (relleno) {
                        resultado.append(caracter) ;
                    } else {
                        resultado.append(" ") ;
                    }
                    
                }
   
            }
            resultado.append("\n");
        }
        resultado.append(ES.ColorTexto.RESET.codigoColorTexto());
        // Devolvemos la cadena construida*/
        return resultado.toString();
    }
        
    
    /**
     * Convertir número a tipo de color 
     * @param   elColor Número entero que representa el tipo de color.
     * @return  Devolverá el valor del enumerado segúnn el entero recibido como
 parámetro. Así, para 1 se devolverá ROJO, para 2 se devolverá NEGRO, 
 para 3 se devolverá BLANCO y para 4 AMARILLO.
 En caso de recibir cualquier otro valor, devolverá ColorTexto.ROJO
     */
    public static Color enteroAcolor(int elColor) {
        Color tipo = Color.ROJO ;
                
        switch(elColor) {
            case 1: 
                tipo = Color.ROJO ;
                break ;
            case 2:
                tipo = Color.VERDE ;
                break ;
            case 3:
                tipo = Color.AZUL ;
                break ;
            case 4:
                tipo = Color.AMARILLO ;
                break ;
        }
        return tipo ;
    }
    
            
    /**
     * Aumentar o disminuir las filas (altura) de un recángulo en las unidades
     * que se pasen como parámetro.
     * Se comprueba en el caso de que el valor de las unidades pasadas como 
     * parámetro sean positivas, si al sumarlas a las dimensiones actuales nos
     * pasamos del tamaño máximo, y en ese caso no se incrementará el valor.
     * Del mismo modo, si se psa un valor negativo, se comprueba antes de 
     * asignar si el resultado de la opración ocasionaría un valor de filas de
     * 0 o menos, lo cual no estaría permitido tampoco.
     * 
     * @param unidades Unidades a agrandar o disminuir.
     * @return true si se agrandó o disminuyó, y false si no se hizo.
     */
    public boolean modificarAltura(int unidades){
        boolean resultado = false ;
        if ((unidades > 0 || (this.filas + unidades >= 0)) && (this.filas + unidades <= MAX_FILAS) && (this.filas + unidades >= 1))  {
            this.filas += unidades ;
            resultado = true ;
        }
        return resultado ;
    }
    
    
    /**
     * Aumentar o disminuir anchura en las unidades que se pasen como parámetro, 
     * si el parámetro que se pasa es un entero mayor de 0.
     * @param unidades Unidades a agrandar o disminuir.
     * @return true si se modificó o false si no se hizo.
     */
    public boolean modificarAnchura(int unidades) {
        boolean resultado = false ;
        if ((unidades > 0 || (this.columnas + unidades >= 0)) && (this.columnas + unidades <= MAX_COLUMNAS)&& (this.columnas + unidades >= 1))  {
            this.columnas += unidades ;
            resultado = true ;
        }
        return resultado ;
        
    }
    
    /**
     * Girar el rectángulo. Consiste en intercambiar el valor de las filas por
     * las columnas.
     */
    public void girarRectangulo() {    
        int temp = this.columnas ;
        this.columnas = this.filas ;
        this.filas = temp ;
    }
        
}