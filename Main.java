package Clases;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        //Inicio el Scanner
        Scanner scanner = new Scanner(System.in);

        //Bienvenida
        System.out.println(" *******************************************************");
        System.out.println("Bienvenido al Juego del explorador ");
        System.out.println(" *******************************************************");

        //Creo el Mapa
        Mapa mapa = new Mapa();

        //Creo el Explorador
        System.out.println("Ingrese el nombre del explorador: ");
        String nombreExplorador = scanner.nextLine();
        Explorador explorador = new Explorador(nombreExplorador);

        //Iniciar el Jugador en el mapa
        Posicion posJugador = explorador.getPosicionActual();
        mapa.getTablero()[posJugador.getCoordenadaFila()][posJugador.getCoordenadaCol()] = 'J';

        //Creo los enemigos
        Enemigo[] enemigos = new Enemigo[3];

        //Inicio los enemigos en el mapa
        for (int i = 0; i < 3; i++) {
            enemigos[i] = new Enemigo("Enemigo" + (i + 1));
            Posicion posEnemigo = enemigos[i].getPosicionActual();
            mapa.getTablero()[posEnemigo.getCoordenadaFila()][posEnemigo.getCoordenadaCol()] = 'E';
        }

    }

}
