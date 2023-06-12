package BlackJack;

import java.util.ArrayList;
import java.util.List;

class Jugador {
	private String nombre;
	protected List<Carta> mano;

	public Jugador(String nombre) {
		this.nombre = nombre;
		mano = new ArrayList<>();
	}

	public String getNombre() {
		return nombre;
	}

	public void pedirCarta(Baraja baraja) {
		Carta carta = baraja.repartir();
		mano.add(carta);
		System.out.println(nombre + " ha recibido la carta: " + carta);
	}

	public void plantarse() {
		System.out.println(nombre + " se ha plantado.");
	}

	public int calcularPuntaje() {
		int puntaje = 0;
		for (Carta carta : mano) {
			puntaje += carta.getValor();
		}
		return puntaje;
	}

	public void mostrarMano() {
		System.out.println(nombre + " tiene las siguientes cartas en la mano:");
		for (Carta carta : mano) {
			System.out.println(carta);
		}
		System.out.println("Puntaje total: " + calcularPuntaje());
	}
}