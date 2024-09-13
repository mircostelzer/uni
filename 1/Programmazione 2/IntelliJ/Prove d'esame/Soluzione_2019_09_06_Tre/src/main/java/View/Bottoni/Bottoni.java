package View.Bottoni;

import Model.Figure.Cerchio;
import Model.Figure.EmptyFigure;
import Model.Figure.Triangolo;
import View.Casella;
import com.soluzione_2019_09_06.MainFX;
import javafx.scene.control.Button;
import javafx.scene.shape.Shape;

import java.util.Random;

/**
 * La classe Bottoni gestisce una serie di bottoni che permettono di cambiare la forma all'interno di una Casella.
 */
public class Bottoni {
    private Button cancella;
    private Button cerchio;
    private Button triangolo;
    private Button random;

    /**
     * Costruisce una nuova istanza di Bottoni associati ad una specifica Casella.
     * Inizializza i bottoni e imposta le loro azioni.
     *
     * @param c La Casella associata ai bottoni.
     */
    public Bottoni(Casella c) {
        cancella = new Button("C");
        cerchio = new Button("O");
        triangolo = new Button("T");
        random = new Button("R");

        setCancellaAction(c);
        setCerchioAction(c);
        setTriangoloAction(c);
        setRandomAction(c);
    }

    /**
     * Imposta l'azione del bottone cancella per impostare una figura vuota nella Casella.
     *
     * @param c La Casella su cui agire.
     */
    private void setCancellaAction(Casella c){
        cancella.setOnAction(event -> c.setForma(new EmptyFigure(MainFX.getLATO_EMPTY_FIGURE())));
    }

    /**
     * Imposta l'azione del bottone cerchio per impostare un cerchio nella Casella.
     *
     * @param c La Casella su cui agire.
     */
    private void setCerchioAction(Casella c){
        cerchio.setOnAction(event -> c.setForma(new Cerchio(MainFX.getRAGGIO_CERCHIO())));
    }

    /**
     * Imposta l'azione del bottone triangolo per impostare un triangolo nella Casella.
     *
     * @param c La Casella su cui agire.
     */
    private void setTriangoloAction(Casella c){
        triangolo.setOnAction(event -> c.setForma(new Triangolo(MainFX.getLATO_TRIANGOLO())));
    }

    /**
     * Imposta l'azione del bottone random per impostare una forma casuale (cerchio o triangolo) nella Casella.
     *
     * @param c La Casella su cui agire.
     */
    private void setRandomAction(Casella c){
        random.setOnAction(event -> {
            Random r = new Random();
            Shape forma;
            if(r.nextBoolean())
                forma = new Triangolo(MainFX.getLATO_TRIANGOLO());
            else
                forma = new Cerchio(MainFX.getRAGGIO_CERCHIO());
            c.setForma(forma);
        });
    }

    /**
     * Restituisce il bottone cancella.
     *
     * @return Il bottone cancella.
     */
    public Button getCancella() {
        return cancella;
    }

    /**
     * Restituisce il bottone cerchio.
     *
     * @return Il bottone cerchio.
     */
    public Button getCerchio() {
        return cerchio;
    }

    /**
     * Restituisce il bottone triangolo.
     *
     * @return Il bottone triangolo.
     */
    public Button getTriangolo() {
        return triangolo;
    }

    /**
     * Restituisce il bottone random.
     *
     * @return Il bottone random.
     */
    public Button getRandom() {
        return random;
    }
}
