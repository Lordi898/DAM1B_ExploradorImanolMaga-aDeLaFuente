package Clases;

import java.util.Random;

//Clase explorador
public class Explorador {

    //Variables
    String nombre;
    Posicion posicionActual;

    //Constantes Direcciones
    public static final int Arriba = 1;
    public static final int Abajo = 2;
    public static final int Derecha = 3;
    public static final int Izquierda = 4;

    // Límites mapa de 100 filas y 100 columnas
    private static final int LIMITE_SUPERIOR = 0;
    private static final int LIMITE_INFERIOR = 100;
    private static final int LIMITE_DERECHA = 100;
    private static final int LIMITE_IZQUIERDA = 0;

    //filaAleatoria entre 0 y 100
    Random random = new Random();
    int filaAleatoria = random.nextInt(100);

    //Constructor
    public Explorador(String nombre) {
        this.nombre = nombre;

        this.posicionActual = new Posicion(filaAleatoria, 0);
    }

    // Getters y setters
    public String getNombre() {
        return nombre;
    }

    public Posicion getPosicionActual() {
        return posicionActual;
    }

    public void setPosicionActual(Posicion posicionActual) {
        this.posicionActual = posicionActual;
    }

}
