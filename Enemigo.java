package Clases;

import java.util.Random;

public class Enemigo {

    //Random
    Random random = new Random();
    int filaAleatoria = random.nextInt(6);

    //Atributos
    Posicion posicionActual;

    //Constantes Direcciones
    public static final int Arriba = 1;
    public static final int Abajo = 2;
    public static final int Derecha = 3;
    public static final int Izquierda = 4;

    // Límites mapa de 6 filas y 20 columnas
    private static final int Limite_Arriba = 6;
    private static final int Limite_Abajo = 0;
    private static final int Limite_Derecha = 20;
    private static final int Limite_Izquierda = 0;

    //Constructor
    public Enemigo(Posicion Posicion) {
        this.posicionActual = new Posicion(filaAleatoria, 0);
    }



}
