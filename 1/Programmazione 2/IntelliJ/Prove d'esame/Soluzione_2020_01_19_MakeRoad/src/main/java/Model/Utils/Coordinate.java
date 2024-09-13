package Model.Utils;

/**
 * La classe Coordinate rappresenta una coordinata con valori x e y.
 */
public class Coordinate {
    private int x;
    private int y;

    /**
     * Costruisce una nuova istanza di Coordinate con i valori specificati.
     *
     * @param x Il valore della coordinata x.
     * @param y Il valore della coordinata y.
     */
    public Coordinate(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Restituisce il valore della coordinata x.
     *
     * @return Il valore della coordinata x.
     */
    public int getX() {
        return x;
    }

    /**
     * Restituisce il valore della coordinata y.
     *
     * @return Il valore della coordinata y.
     */
    public int getY() {
        return y;
    }
}
