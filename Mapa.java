package Clases;

import java.util.Random;

public class Mapa {

    //Inicializar random
    Random random = new Random();

    //fila random inicio Jugador
    int filaJugador = random.nextInt(6);

    //Atributos
    private char[][] tablero;
    private Posicion posJugador;

    //Constructor
    public Mapa() {

        // Inicializar el tablero. Se genera una columna de 20 espacios vacios"for j" 6 veces"por 6 filas for i"
        tablero = new char[6][20];
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 20; j++) {
                tablero[i][j] = ' ';
            }
        }

        //generar posicion del jugador
        posJugador = new Posicion(filaJugador, 0);
        tablero[filaJugador][0] = 'J';

        //generar posicion del tesoro


    }
}
