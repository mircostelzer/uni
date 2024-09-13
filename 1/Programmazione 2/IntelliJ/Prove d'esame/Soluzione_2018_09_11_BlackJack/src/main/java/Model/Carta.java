package Model;

/**
 * La classe Carta rappresenta una singola carta da gioco.
 */
public class Carta {
    private int valore; // Valore della carta (da 0 a 4)
    private Semi seme; // Seme della carta (Cuori, Quadri, Fiori, Picche, J)

    /**
     * Costruttore per la classe Carta.
     *
     * @param valore Valore della carta (da 0 a 4)
     * @param seme   Seme della carta (Cuori, Quadri, Fiori, Picche, J)
     */
    public Carta(int valore, Semi seme) {
        this.valore = valore;
        this.seme = seme;
    }

    /**
     * Restituisce il valore della carta.
     *
     * @return Il valore della carta
     */
    public int getValore() {
        return valore;
    }

    /**
     * Restituisce il seme della carta.
     *
     * @return Il seme della carta
     */
    public Semi getSeme() {
        return seme;
    }

    /**
     * Restituisce una rappresentazione testuale della carta nel formato "valore-seme".
     *
     * @return Rappresentazione testuale della carta
     */
    @Override
    public String toString() {
        return valore + "-" + seme.name().charAt(0);
    }
}
