package Model;

/**
 * La classe Coordinate rappresenta una coppia di coordinate (x, j) utilizzate per identificare la posizione in una griglia.
 */
public class Coordinate {
    private int x; // Coordinata x
    private int j; // Coordinata j

    /**
     * Costruttore per la classe Coordinate.
     *
     * @param j La coordinata j
     * @param x La coordinata x
     */
    public Coordinate(int j, int x) {
        this.x = x;
        this.j = j;
    }

    /**
     * Restituisce la coordinata x.
     *
     * @return La coordinata x
     */
    public int getX() {
        return x;
    }

    /**
     * Restituisce la coordinata j.
     *
     * @return La coordinata j
     */
    public int getJ() {
        return j;
    }
}
