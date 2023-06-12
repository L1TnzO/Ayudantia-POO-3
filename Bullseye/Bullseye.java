package Bullseye;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

public class Bullseye {
    private List<Caballo> caballos;
    private List<JugadorBullseye> jugadores;
    private JugadorBullseye jugadorPrincipal;
    private Map<Double, Integer> tablaApuestas;

    public Bullseye(String nombre) {
        // Inicializar la lista de caballos
        caballos = new ArrayList<>();
        caballos.add(new Caballo("Blitz", 1, "Negro"));
        caballos.add(new Caballo("Thunder", 2, "Marrón"));
        caballos.add(new Caballo("Spirit", 3, "Blanco"));
        caballos.add(new Caballo("Shadow", 4, "Gris"));
        caballos.add(new Caballo("Dash", 5, "Negro y Blanco"));
        caballos.add(new Caballo("Ace", 6, "Marrón Oscuro"));

        // Inicializar la tabla de apuestas
        tablaApuestas = new HashMap<>();
        tablaApuestas.put(500.0, 2);
        tablaApuestas.put(1000.0, 3);
        tablaApuestas.put(5000.0, 4);
        tablaApuestas.put(10000.0, 5);
        tablaApuestas.put(25000.0, 7);
        tablaApuestas.put(50000.0, 10);
    }

    public void jugarBullseye() {
        // Mostrar los caballos disponibles
        System.out.println("Estos son los caballos disponibles:");
        for (int i = 0; i < caballos.size(); i++) {
            System.out.println((i + 1) + ". " + caballos.get(i));
        }

        // Permitir que el jugador elija un caballo
        System.out.println("¿Qué caballo elijes?");
        int caballoElegido = new Scanner(System.in).nextInt();
        JugadorBullseye jugador = new JugadorBullseye("Jugador Principal", 50000, caballos.get(caballoElegido - 1));
        this.jugadorPrincipal = jugador;

        // Mostrar las opciones de apuesta
        System.out.println("Aquí están las opciones de apuesta:");
        for (Double apuesta : tablaApuestas.keySet()) {
            System.out.println("Apostar $" + apuesta + " - Multiplicador: x" + tablaApuestas.get(apuesta));
        }

        // Permitir que el jugador realice una apuesta
        Double apuesta;
        do {
            System.out.println("¿Cuánto quieres apostar? Tienes $" + this.jugadorPrincipal.getDinero() + " disponibles. Las opciones son " + tablaApuestas.keySet());
            apuesta = new Scanner(System.in).nextDouble();
            if (apuesta > this.jugadorPrincipal.getDinero()) {
                System.out.println("No puedes apostar más dinero del que tienes. Inténtalo de nuevo.");
            } else if (!tablaApuestas.containsKey(apuesta)) {
                System.out.println("Debes apostar un monto que se encuentre en las opciones disponibles. Inténtalo de nuevo.");
                apuesta = null;
            }
        } while(apuesta == null || apuesta > this.jugadorPrincipal.getDinero());

        this.jugadorPrincipal.setApuesta(apuesta);


        // Generar otros jugadores automáticamente
        this.jugadores = generarJugadores();

        // Simular la carrera
        Caballo caballoGanador = simularCarrera();

        // Determinar el ganador
        if (this.jugadorPrincipal.getCaballo() == caballoGanador) {
            // Si el jugador principal gana, se actualiza su dinero en base a la tabla de apuestas
            double ganancias = apuesta * tablaApuestas.get(apuesta);
            this.jugadorPrincipal.ganarDinero(ganancias);
            System.out.println("¡Felicidades! Has ganado la carrera. Tus ganancias son $" + ganancias);
        } else {
            // Si el jugador principal pierde, se le quita el dinero apostado
            this.jugadorPrincipal.perderDinero();
            System.out.println("Lo siento, has perdido la carrera. Has perdido $" + apuesta);
            System.out.println("Tu saldo actual es de $" + this.jugadorPrincipal.getDinero());

        }
    }

    private List<JugadorBullseye> generarJugadores() {
        List<JugadorBullseye> jugadoresGenerados = new ArrayList<>();
        for(int i=0; i<5; i++){
            // Asignamos a cada jugador un caballo al azar
            int indiceCaballo = new Random().nextInt(caballos.size());
            JugadorBullseye jugador = new JugadorBullseye("Jugador " + (i+1), 50000, caballos.get(indiceCaballo));
            jugadoresGenerados.add(jugador);
        }
        return jugadoresGenerados;
    }
    private Caballo simularCarrera() {
        Map<Caballo, Integer> tiempos = new HashMap<>();
        Caballo caballoGanador = null;
        int menorTiempo = Integer.MAX_VALUE;

        // Generamos un tiempo aleatorio para cada caballo y nos quedamos con el que tenga el menor tiempo
        for (Caballo caballo : caballos) {
            int tiempo = new Random().nextInt(100);
            tiempos.put(caballo, tiempo);
            if (tiempo < menorTiempo) {
                menorTiempo = tiempo;
                caballoGanador = caballo;
            }
        }

        // Mostramos los tiempos obtenidos
        for (Caballo caballo : tiempos.keySet()) {
            System.out.println("El caballo " + caballo + " ha llegado a la meta en " + tiempos.get(caballo) + " segundos.");
        }

        return caballoGanador;
    }

}

