package Controller;

import View.Bottoni;
import View.CellePane;
import javafx.scene.layout.AnchorPane;

/**
 * La classe MainGUI rappresenta il layout principale dell'interfaccia utente,
 * contenente un pannello di celle e una serie di pulsanti.
 */
public class MainGUI extends AnchorPane {
    private static int val;
    private Bottoni bottoni;
    private CellePane cellePane;

    /**
     * Costruisce un nuovo oggetto MainGUI.
     */
    public MainGUI() {
        super();
        val = 1;
        cellePane = new CellePane(this);
        bottoni = new Bottoni(this);

        super.getChildren().addAll(cellePane, bottoni);

        AnchorPane.setTopAnchor(cellePane, 0.0);
        AnchorPane.setLeftAnchor(cellePane, 0.0);

        AnchorPane.setBottomAnchor(bottoni, 0.0);
        AnchorPane.setLeftAnchor(bottoni, 15.0);
    }

    /**
     * Restituisce l'istanza dei bottoni.
     *
     * @return l'istanza di Bottoni
     */
    public Bottoni getBottoni() {
        return bottoni;
    }

    /**
     * Restituisce il valore corrente.
     *
     * @return il valore corrente
     */
    public static int getVal() {
        return val;
    }

    /**
     * Imposta il valore specificato.
     *
     * @param val il valore da impostare
     */
    public static void setVal(int val) {
        MainGUI.val = val;
    }

    /**
     * Restituisce l'istanza del pannello di celle.
     *
     * @return l'istanza di CellePane
     */
    public CellePane getCellePane() {
        return cellePane;
    }
}