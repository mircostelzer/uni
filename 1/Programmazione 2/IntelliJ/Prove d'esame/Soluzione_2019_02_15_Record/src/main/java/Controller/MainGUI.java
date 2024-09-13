package Controller;

import Model.ListaRecord;
import View.ContenitorePane;
import javafx.scene.layout.HBox;

/**
 * La classe MainGUI estende HBox e rappresenta l'interfaccia principale dell'applicazione.
 * Contiene due pannelli, uno per la lista di automobili e uno per la lista di persone.
 */
public class MainGUI extends HBox {

    private ContenitorePane auto;
    private ContenitorePane persona;

    /**
     * Costruisce un nuovo oggetto MainGUI con i pannelli per le liste di record di automobili e persone.
     */
    public MainGUI() {
        super();
        auto = new ContenitorePane(new ListaRecord(), true);
        persona = new ContenitorePane(new ListaRecord(), false);

        // Aggiunge i pannelli alla MainGUI
        super.getChildren().addAll(persona, auto);
    }
}
