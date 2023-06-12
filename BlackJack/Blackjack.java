package BlackJack;

public class Blackjack {
    private Juego juego;

    public Blackjack(String nombre) {
        juego = new Juego();
        juego.agregarJugador(new Jugador("Jugador1"));
        juego.agregarJugador(new Jugador("Jugador2"));
    }

    public void jugarBlackjack() {
        juego.iniciar();
        juego.repartirInicial();
        juego.jugar();
        juego.crupier.mostrarMano();
        String ganador = juego.determinarGanador();
        System.out.println("El ganador es: " + ganador);
    }
}
