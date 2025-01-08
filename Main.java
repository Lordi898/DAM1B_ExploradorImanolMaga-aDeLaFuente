package Clases;

import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        //Inicia el Scanner
        Scanner scanner = new Scanner(System.in);

        //Bienvenida
        System.out.println(" *******************************************************");
        System.out.println("Bienvenido al Juego del explorador ");
        System.out.println(" *******************************************************");

        //Crea el mapa
        Mapa mapa = new Mapa();

        //Crea el Explorador
        System.out.println("Ingrese el nombre del explorador: ");
        String nombreExplorador = scanner.nextLine();
        Explorador explorador = new Explorador(nombreExplorador);

        //Iniciar el Jugador en el mapa
        Posicion posJugador = explorador.getPosicionActual();
        mapa.getTablero()[posJugador.getCoordenadaFila()][posJugador.getCoordenadaCol()] = 'J';

        //Creo los enemigos
        Enemigo[] enemigos = new Enemigo[3];

        //Inicia los enemigos en el mapa
        for (int i = 0; i < 3; i++) {
            enemigos[i] = new Enemigo("Enemigo" + (i + 1));
            Posicion posEnemigo = enemigos[i].getPosicionActual();
            mapa.getTablero()[posEnemigo.getCoordenadaFila()][posEnemigo.getCoordenadaCol()] = 'E';
        }

        //Muestra una version incompleta del mapa
        mapa.mostrar();

        //Juego

        boolean jugando = true;

        Random random = new Random();

        //Pide que accion quieres realizar y la guarda
        while (jugando) {
            System.out.println("");
            System.out.println("");
            System.out.println("W=Arriba     A=Izquierda     S=Abajo     D=Derecha");
            System.out.print("¿Qué acción quieres realizar? ");
            char accion = scanner.next().toUpperCase().charAt(0);

            int direccion;
            if (accion == 'W') {
                direccion = Explorador.Arriba;
            } else if (accion == 'S') {
                direccion = Explorador.Abajo;
            } else if (accion == 'D') {
                direccion = Explorador.Derecha;
            } else if (accion == 'A') {
                direccion = Explorador.Izquierda;
            } else {
                System.out.println("Tecla invalida, introduzca A, W, S, D");
                direccion = 0;
            }

            //Mover el explorador
            explorador.moverse(direccion);
            Posicion nuevaPosJugador = explorador.getPosicionActual();

            //Mueve el enemigo
            for (Enemigo enemigo : enemigos) {
                int dirEnemigo = random.nextInt(4) + 1; //Numero aleatorio entre (0 y 3) + 1, es decir entre 1 y 4
                enemigo.moverse(dirEnemigo, mapa.getTablero());
            }

            //Actualiza el mapa
            mapa.mostrar();

            // Verificar si el jugador pierde al ser atrapado por un enemigo
            for (Enemigo enemigo : enemigos) {
                if (enemigo.getPosicionActual().getCoordenadaFila() == posJugador.getCoordenadaFila() &&
                        enemigo.getPosicionActual().getCoordenadaCol() == posJugador.getCoordenadaCol()) {
                    System.out.println("¡Te han capturado! Fin del juego :( ");
                    jugando = false;
                    break;
                }
            }

            // Verificar si el jugador encuentra el tesoro
            Posicion posTesoro = mapa.getPosTesoro();
            if (posTesoro.getCoordenadaFila() == posJugador.getCoordenadaFila() &&
                    posTesoro.getCoordenadaCol() == posJugador.getCoordenadaCol()) {
                System.out.println("¡Felicidades encontrastes el TESORO! ¡Has GANADO! :) ");
                jugando = false;
            }
        }

    }

}