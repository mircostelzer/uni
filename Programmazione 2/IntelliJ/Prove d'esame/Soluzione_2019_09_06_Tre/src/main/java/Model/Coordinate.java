package Model;

/**
 * La classe Coordinate rappresenta una coordinata che può essere una riga o una colonna in una griglia.
 */
public class Coordinate {
    private boolean isRiga;
    private int coordinata;

    /**
     * Costruisce una nuova Coordinate con la specifica se è una riga e il valore della coordinata.
     *
     * @param isRiga Indica se la coordinata rappresenta una riga (true) o una colonna (false).
     * @param coordinata Il valore della coordinata.
     */
    public Coordinate(boolean isRiga, int coordinata) {
        this.isRiga = isRiga;
        this.coordinata = coordinata;
    }

    /**
     * Restituisce true se la coordinata rappresenta una riga, false se rappresenta una colonna.
     *
     * @return true se la coordinata è una riga, false se è una colonna.
     */
    public boolean isRiga() {
        return isRiga;
    }

    /**
     * Restituisce il valore della coordinata.
     *
     * @return Il valore della coordinata.
     */
    public int getCoordinata() {
        return coordinata;
    }
}
