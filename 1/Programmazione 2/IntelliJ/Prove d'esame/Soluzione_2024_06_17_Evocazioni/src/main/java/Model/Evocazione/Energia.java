package Model.Evocazione;

import javafx.scene.paint.Color;

/**
 * L'enum Energia rappresenta i diversi tipi di energia con un colore associato.
 */
public enum Energia {
    ACQUA(Color.AQUAMARINE),
    FUOCO(Color.FIREBRICK),
    TENEBRA(Color.DARKVIOLET),
    NEUTRA(Color.HONEYDEW);

    private final Color colore;

    /**
     * Costruttore per inizializzare il tipo di energia con un colore specifico.
     *
     * @param colore Il colore associato al tipo di energia.
     */
    Energia(Color colore) {
        this.colore = colore;
    }

    /**
     * Restituisce il colore associato al tipo di energia.
     *
     * @return Il colore associato.
     */
    public Color getColore() {
        return colore;
    }
}
