package BlackJack;

class Carta {
	private String valor;
	private String pinta;

	public Carta(String valor, String pinta) {
		this.valor = valor;
		this.pinta = pinta;
	}

	public int getValor() {
		if (valor.equals("Jota") || valor.equals("Quina") || valor.equals("Kaiser")) {
			return 10;
		} else if (valor.equals("As")) {
			return 11;
		} else {
			return Integer.parseInt(valor);
		}
	}

	@Override
	public String toString() {
		return valor + " de " + pinta;
	}
}