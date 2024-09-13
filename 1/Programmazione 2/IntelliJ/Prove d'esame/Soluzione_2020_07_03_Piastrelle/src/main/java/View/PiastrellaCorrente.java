package View;

import Controller.MainGUI;
import Model.Catalogo;
import javafx.scene.layout.Pane;

/**
 * La classe PiastrellaCorrente rappresenta il pannello che visualizza la piastrella corrente selezionata.
 */
public class PiastrellaCorrente extends Pane {
    private Catalogo catalogo;

    /**
     * Costruttore della classe PiastrellaCorrente.
     * Inizializza il catalogo e aggiorna la piastrella mostrata.
     *
     * @param catalogo Il catalogo contenente le piastrelle.
     */
    public PiastrellaCorrente(Catalogo catalogo) {
        super();
        this.catalogo = catalogo;
        aggiornaPiastrellaMostrata();
    }

    /**
     * Aggiorna la piastrella mostrata nel pannello, basandosi sull'indice generale.
     */
    public void aggiornaPiastrellaMostrata() {
        super.getChildren().clear();
        super.getChildren().add(catalogo.getPiastrelle().get(MainGUI.getGeneralIndex()));
    }
}
