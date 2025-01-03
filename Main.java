package Clases;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        //Inicio el Scanner
        Scanner scanner = new Scanner(System.in);

        //Bienvenida
        System.out.println(" *******************************************************");
        System.out.println("Bienvenido al Juego del Explorador");
        System.out.println(" *******************************************************");

        //Creo el Mapa
        Mapa mapa = new Mapa();

        //Creo el Explorador
        System.out.println("Ingrese el nombre del Explorador: ");
        String nombreExplorador = scanner.nextLine();
        Explorador explorador = new Explorador(nombreExplorador);

        //Iniciar el Jugador en el mapa
        Posicion posJugador = explorador.getPosicionActual();
        mapa.getTablero()[posJugador.getCoordenadaFila()][posJugador.getCoordenadaCol()] = 'J';

    }

}
