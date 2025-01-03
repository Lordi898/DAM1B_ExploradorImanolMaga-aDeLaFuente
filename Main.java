package Clases;

import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        //Inicio el Scanner
        Scanner scanner = new Scanner(System.in);

        //Bienvenida
        System.out.println(" *******************************************************");
        System.out.println("Bienvenido al Juego del explorador ");
        System.out.println(" *******************************************************");

        //Muestra el mapa "Version incompleta"
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

        //Mostrar mapa
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

            //Actualizar el explorador en el tablero
            mapa.getTablero()[posJugador.getCoordenadaFila()][posJugador.getCoordenadaCol()] = ' ';
            mapa.getTablero()[nuevaPosJugador.getCoordenadaFila()][nuevaPosJugador.getCoordenadaCol()] = 'J';
            posJugador = nuevaPosJugador;

            for (Enemigo enemigo : enemigos) {
                int dirEnemigo = random.nextInt(4) + 1; //Numero aleatorio entre (0 y 3) + 1, es decir entre 1 y 4
                enemigo.moverse(dirEnemigo, mapa.getTablero());
            }


        }

    }

}
