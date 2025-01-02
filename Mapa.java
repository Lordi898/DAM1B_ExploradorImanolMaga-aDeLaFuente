package Clases;

public class Mapa {

    private char[][] tablero;

    public Mapa() {

        // Inicializar el tablero. Se genera una columna de 20 espacios vacios"for j" 6 veces"por 6 filas for i"
        tablero = new char[6][20];
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 20; j++) {
                tablero[i][j] = ' ';
            }
        }

        //generar posicion del jugador


    }
}
