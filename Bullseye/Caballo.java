package Bullseye;

import java.util.Random;

class Caballo {
    private String nombre;
    private int id;
    private String color;

    public Caballo(String nombre, int id, String color) {
        this.nombre = nombre;
        this.id = id;
        this.color = color;
    }

    public String getNombre() {
        return nombre;
    }

    public int getId() {
        return id;
    }

    public String getColor() {
        return color;
    }

    // Simulamos la carrera generando un tiempo aleatorio de llegada.
    public double correr() {
        Random random = new Random();
        return random.nextDouble() * 10.0;
    }
    public String toString() {
        return this.nombre;
    }

}
