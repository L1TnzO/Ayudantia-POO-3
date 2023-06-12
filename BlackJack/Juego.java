package BlackJack;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Juego {
	private Baraja baraja;
	Crupier crupier;
	private List<Jugador> jugadores;

	public Juego() {
		baraja = new Baraja();
		crupier = new Crupier("Crupier");
		jugadores = new ArrayList<>();
	}

	public void iniciar() {
		baraja.mezclar();
	}

	public void repartirInicial() {
		for (int i = 0; i < 2; i++) {
			for (Jugador jugador : jugadores) {
				jugador.pedirCarta(baraja);
			}
			crupier.pedirCarta(baraja);
		}
	}

	public void jugar() {
		for (Jugador jugador : jugadores) {
			boolean seguirJugando = true;
			while (seguirJugando) {
				jugador.mostrarMano();
				Scanner scanner = new Scanner(System.in);
				System.out.println(jugador.getNombre() + ", ¿quieres pedir otra carta? (s/n)");
				String respuesta = scanner.nextLine();
				if (respuesta.equalsIgnoreCase("s")) {
					jugador.pedirCarta(baraja);
					int puntaje = jugador.calcularPuntaje();
					if (puntaje > 21) {
						System.out.println(jugador.getNombre() + " ha perdido.");
						seguirJugando = false;
					}
				} else {
					jugador.plantarse();
					seguirJugando = false;
				}
			}
		}
	}

	public String determinarGanador() {
		int puntajeCrupier = crupier.calcularPuntaje();
		String ganador = "Crupier";

		for (Jugador jugador : jugadores) {
			int puntajeJugador = jugador.calcularPuntaje();
			if (puntajeJugador > puntajeCrupier && puntajeJugador <= 21) {
				ganador = jugador.getNombre();
				break;
			} else if (puntajeCrupier > 21 && puntajeJugador <= 21) {
				ganador = jugador.getNombre();
				break;
			} else if (puntajeJugador == puntajeCrupier) {
				ganador = "Empate";
				break;
			}
		}

		return ganador;
	}

	public void agregarJugador(Jugador jugador) {
		jugadores.add(jugador);
	}
}

