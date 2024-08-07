package Controller;

import Model.TitoliDB;
import Model.Titolo;
import View.BottoniDirezione;
import View.BottoniSorting;
import View.TitoliPane;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;

/**
 * Questa classe gestisce l'interfaccia grafica principale dell'applicazione.
 */
public class MainGUI extends BorderPane {
    private static int GENERAL_INDEX;
    private TitoliDB titoliDB;
    private TitoliPane titoliPane;
    private BottoniDirezione bottoniDirezione;
    private BottoniSorting bottoniSorting;
    private Button clear;

    /**
     * Costruisce una nuova istanza di MainGUI.
     */
    public MainGUI() {
        super();
        GENERAL_INDEX = 0;
        clear = new Button("Clear");
        setClearAction();
        titoliDB = new TitoliDB();
        titoliPane = new TitoliPane(this);
        bottoniDirezione = new BottoniDirezione(this);
        bottoniSorting = new BottoniSorting(this);

        Button indietro = bottoniDirezione.getBack();
        Button avanti = bottoniDirezione.getNext();

        HBox hb = new HBox(indietro, titoliPane, avanti);

        super.setTop(hb);
        super.setLeft(clear);
        super.setRight(bottoniSorting);
    }

    /**
     * Imposta l'azione per il bottone "Clear".
     */
    private void setClearAction() {
        clear.setOnAction(event -> {
            GENERAL_INDEX = 0;
            titoliDB.sortByName();
            setCenter(null);
            titoliPane.aggiornaTitoliPane();
            for (Titolo t : titoliDB.getArchivio()) {
                t.resetPrezzo();
            }
        });
    }

    /**
     * Restituisce l'indice generale.
     *
     * @return L'indice generale.
     */
    public static int getGeneralIndex() {
        return GENERAL_INDEX;
    }

    /**
     * Incrementa l'indice generale.
     */
    public static void incrementGeneralIndex() {
        GENERAL_INDEX++;
    }

    /**
     * Decrementa l'indice generale.
     */
    public static void decrementGeneralIndex() {
        GENERAL_INDEX--;
    }

    /**
     * Reimposta l'indice generale a 0.
     */
    public static void resetGeneralIndex() {
        GENERAL_INDEX = 0;
    }

    /**
     * Restituisce il database dei titoli.
     *
     * @return Il database dei titoli.
     */
    public TitoliDB getTitoliDB() {
        return titoliDB;
    }

    /**
     * Restituisce il pannello dei titoli.
     *
     * @return Il pannello dei titoli.
     */
    public TitoliPane getTitoliPane() {
        return titoliPane;
    }
}
