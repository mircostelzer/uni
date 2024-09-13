package Model;

/**
 * Classe che rappresenta una coppia di coordinate bidimensionali (x, y).
 */
public class Coordinate {

    /** La coordinata x. */
    private double x;

    /** La coordinata y. */
    private double y;

    /**
     * Costruttore della classe Coordinate.
     * Inizializza le coordinate x e y con i valori specificati.
     *
     * @param x La coordinata x.
     * @param y La coordinata y.
     */
    public Coordinate(double x, double y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Restituisce la coordinata x.
     *
     * @return La coordinata x.
     */
    public double getX() {
        return x;
    }

    /**
     * Restituisce la coordinata y.
     *
     * @return La coordinata y.
     */
    public double getY() {
        return y;
    }
}
