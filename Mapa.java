package Clases;

import java.util.Random;

public class Mapa {

    //Inicializar random
    Random random = new Random();

    //fila random inicio Jugador
    int filaJugador = random.nextInt(6);

    //fila y columna random para el tesoro
    int filaTesoro = random.nextInt(6);
    int colTesoro = random.nextInt(20);

    //Atributos
    private char[][] tablero;
    private Posicion posJugador;
    private Posicion posTesoro;
    private Posicion[] listadoEnemigos;
    private Posicion[] posicionTrampas;

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

        //generar posicion del tesoro sin mostrarlo en el tablero
        posTesoro = new Posicion(filaTesoro, colTesoro);

        //generar posicion de enemigos
        listadoEnemigos = new Posicion[3];

        for (int i = 0; i < 3; i++) {

            int filaEnemigo;
            int colEnemigo;

            do {
                filaEnemigo = random.nextInt(6);
                colEnemigo = random.nextInt(20);
            }
            //El while es para que donde se genere un enemigo no sea igual a un espacio vacio, es decir != ' '
            while (tablero[filaEnemigo][colEnemigo] != ' ');

            //Crear un objeto Posicion que representa la ubicacion de un enemigo en el tablero. Se almacena en listadoEnemigos, y puede ser 0, 1, o 2, (la i)
            listadoEnemigos[i] = new Posicion(filaEnemigo, colEnemigo);
            tablero[filaEnemigo][colEnemigo] = 'E';
        }

        //generar posicion de trampas
        posicionTrampas = new Posicion[3];

        //Es el mismo codigo que generar posicion enemigos pero cambiando los nombres
        for (int i = 0; i < 3; i++) {

            int filaTrampa;
            int colTrampa;

            do {
                filaTrampa = random.nextInt(6);
                colTrampa = random.nextInt(20);
            }
            while (tablero[filaTrampa][colTrampa] != ' ');
            posicionTrampas[i] = new Posicion(filaTrampa, colTrampa);
            tablero[filaTrampa][colTrampa] = 'T';
        }
    }

    //Metodos

    public char[][] getTablero() {
        return tablero;
    }

    public Posicion getPosTesoro() {
        return posTesoro;
    }

    // Mostrar el tablero
    public void mostrar() {
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 20; j++) {
                System.out.print(tablero[i][j] + " ");
            }
        }
    }

}
