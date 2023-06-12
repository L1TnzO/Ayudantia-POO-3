package UI;
import BlackJack.Blackjack;
import Bullseye.Bullseye;
import Util.Validaciones;

import java.util.Scanner;

class Menu {
    public void mostrarMenu() {
        String opcion;
        Scanner scanner = new Scanner(System.in);

        System.out.println("Bienvenido al Casino Deluxe. ¿Cuál es tu nombre?");
        String nombre = scanner.nextLine();

        do {
            System.out.println("Hola, " + nombre + ". ¿Qué juego te gustaría jugar?");
            System.out.println("1. Blackjack");
            System.out.println("2. Bullseye");
            System.out.println("3. Salir");
            opcion = scanner.nextLine();

            if (Validaciones.esNumero(opcion)) {
                int eleccion = Integer.parseInt(opcion);
                if (Validaciones.estaEnRango(eleccion, 1, 3)) {
                    switch(eleccion) {
                        case 1:
                            Blackjack blackjack = new Blackjack(nombre);
                            blackjack.jugarBlackjack();
                            break;
                        case 2:
                            Bullseye bullseye = new Bullseye(nombre);
                            bullseye.jugarBullseye();
                            break;
                        case 3:
                            System.out.println("Gracias por visitar el Casino Deluxe. ¡Hasta pronto!");
                            break;
                    }
                } else {
                    System.out.println("Opción no válida. Inténtalo de nuevo.");
                }
            } else {
                System.out.println("Por favor, ingresa un número.");
            }
        } while(!opcion.equals("3"));
    }
}

