package Bullseye;

public class JugadorBullseye {
    private String nombre;
    private double dinero;
    private Caballo caballo;
    private double apuesta;

    public JugadorBullseye(String nombre, double dinero, Caballo caballo) {
        this.nombre = nombre;
        this.dinero = dinero;
        this.caballo = caballo;
    }

    public void setApuesta(double apuesta) {
        this.apuesta = apuesta;
    }

    public Caballo getCaballo() {
        return caballo;
    }

    public double getDinero() {
        return dinero;
    }

    public void ganarDinero(double ganancia) {
        this.dinero += ganancia;
    }

    public void perderDinero() {
        this.dinero -= this.apuesta;
    }
}
