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

    // Límites mapa de 6 filas y 20 columnas
    private static final int Limite_Arriba = 6;
    private static final int Limite_Abajo = 0;
    private static final int Limite_Derecha = 20;
    private static final int Limite_Izquierda = 0;

    //filaAleatoria entre 0 y 6
    Random random = new Random();
    int filaAleatoria = random.nextInt(6);

    //Constructor
    public Explorador(String nombre) {
        this.nombre = nombre;

        //Posicion inicial jugador
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

    //Metodo moverse
    public void moverse(int direccion) {

        //Variables para ayudar con el desplazamiento y los limites del mapa
        int filaNueva = posicionActual.getCoordenadaFila();
        int columnaNueva = posicionActual.getCoordenadaCol();

        //Desplazamiento en uno en la direccion indicada siempre que no supere los limites del mapa
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
