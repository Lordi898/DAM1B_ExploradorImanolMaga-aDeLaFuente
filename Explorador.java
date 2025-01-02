package Clases;

import java.util.Random;

//Clase explorador
public class Explorador {

    //Variables
    String nombre;
    Posicion posicionActual;

    //filaAleatoria entre 0 y 100
    Random random = new Random();
    int filaAleatoria = random.nextInt(100);

    //Constructor
    public Explorador(String nombre) {
        this.nombre = nombre;

        this.posicionActual = new Posicion(filaAleatoria, 0);
    }
}
