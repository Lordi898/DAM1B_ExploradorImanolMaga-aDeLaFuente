package Clases;

import java.util.Random;

public class Explorador {

    String nombre;
    Posicion posicionActual;

    Random random = new Random();
    int filaAleatoria = random.nextInt(100);

    public Explorador(String nombre) {
        this.nombre = nombre;

        this.posicionActual = new Posicion(filaAleatoria, 0);
    }
}
