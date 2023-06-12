package BlackJack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Baraja {
	private List<Carta> cartas;

	public Baraja() {
		cartas = new ArrayList<>();
		String[] pintas = {"Corazón", "Trébol", "Diamante", "Pica"};
		String[] valores = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jota", "Quina", "Kaiser", "As"};

		for (String pinta : pintas) {
			for (String valor : valores) {
				Carta carta = new Carta(valor, pinta);
				cartas.add(carta);
			}
		}
	}

	public void mezclar() {
		Collections.shuffle(cartas);
	}

	public Carta repartir() {
		Carta carta = cartas.get(0);
		cartas.remove(0);
		return carta;
	}
}

