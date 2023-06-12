package BlackJack;

class Crupier extends Jugador {
	public Crupier(String nombre) {
		super(nombre);
	}

	public Carta mostrarCarta() {
		return mano.get(0);
	}

	@Override
	public void mostrarMano() {
		System.out.println("El crupier tiene la siguiente carta visible:");
		System.out.println(mostrarCarta());
	}
}

