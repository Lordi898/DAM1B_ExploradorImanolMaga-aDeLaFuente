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
    public Enemigo(String nombreExplorador) {
        this.posicionActual = new Posicion(filaAleatoria, 0);
    }

    //Metodos

    public Posicion getPosicionActual() {
        return posicionActual;
    }

    public void setPosicionActual(Posicion posicionActual) {
        this.posicionActual = posicionActual;
    }

    //Metodo moverse
    public void moverse(int direccion, char[][] tablero) {

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
            System.out.println("Dirección de Enemigo Incorrecta");
        }

        //Comprobar que no haya nada en la nueva posicion del enemigo
        if (tablero[filaNueva][columnaNueva] == ' ' || tablero[filaNueva][columnaNueva] == 'J') {

            //Actualiza la posicion actual en el tablero y la nueva, es decir hacer que la nueva fila sea 'E' y la anterior vuelva a ser ' '
            tablero[posicionActual.getCoordenadaFila()][posicionActual.getCoordenadaCol()] = ' ';
            tablero[filaNueva][columnaNueva] = 'E';

            //Actualizar la posición del enemigo
            posicionActual.setCoordenadaFila(filaNueva);
            posicionActual.setCoordenadaCol(columnaNueva);
        } else {
            System.out.println("Movimiento del enemigo invalido");
        }

    }

}
