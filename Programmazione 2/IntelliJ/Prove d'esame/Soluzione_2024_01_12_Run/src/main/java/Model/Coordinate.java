package Model;

/**
 * La classe Coordinate rappresenta una coppia di coordinate bidimensionali (x, y).
 */
public class Coordinate {
    private double x;
    private double y;

    /**
     * Costruttore della classe Coordinate.
     *
     * @param x la coordinata x
     * @param y la coordinata y
     */
    public Coordinate(double x, double y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Restituisce la coordinata x.
     *
     * @return la coordinata x
     */
    public double getX() {
        return x;
    }

    /**
     * Restituisce la coordinata y.
     *
     * @return la coordinata y
     */
    public double getY() {
        return y;
    }
}
