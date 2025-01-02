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
    private static final int Limite_Arriba = 100;
    private static final int Limite_Abajo = 0;
    private static final int Limite_Derecha = 100;
    private static final int Limite_Izquierda = 0;

    //filaAleatoria entre 0 y 100
    Random random = new Random();
    int filaAleatoria = random.nextInt(101);

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

    //Métodos

    public void moverse(int direccion) {
        int filaNueva = posicionActual.getCoordenadaFila();
        int columnaNueva = posicionActual.getCoordenadaCol();

        if (direccion == Arriba && filaNueva < Limite_Arriba) {
            filaNueva++;
        } else if (direccion == Abajo && filaNueva > Limite_Abajo) {
            filaNueva--;
        } else if (direccion == Derecha && columnaNueva < Limite_Derecha) {
            columnaNueva++;
        } else if (direccion == Izquierda && columnaNueva > Limite_Izquierda) {
            columnaNueva--;
        } else {
            System.out.println("Dirección Incorrecta");
        }

    }

}
