package View;

import Controller.MainGUI;
import Model.Catalogo;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;

/**
 * La classe TestoPane rappresenta un pannello che visualizza le informazioni della piastrella corrente sotto forma di testo.
 */
public class TestoPane extends Pane {
    private Catalogo catalogo;
    private Text testo;

    /**
     * Costruttore della classe TestoPane.
     * Inizializza il catalogo e aggiorna il testo mostrato.
     *
     * @param catalogo Il catalogo contenente le piastrelle.
     */
    public TestoPane(Catalogo catalogo) {
        super();
        this.catalogo = catalogo;
        testo = new Text();
        aggiornaTesto();
    }

    /**
     * Aggiorna il testo mostrato nel pannello, basandosi sull'indice generale.
     */
    public void aggiornaTesto() {
        super.getChildren().clear();
        testo.setText(catalogo.getPiastrelle().get(MainGUI.getGeneralIndex()).toString());
        super.getChildren().add(testo);
    }
}
