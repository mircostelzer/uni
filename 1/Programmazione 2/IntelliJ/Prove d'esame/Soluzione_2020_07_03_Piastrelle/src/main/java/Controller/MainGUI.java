package Controller;

import Model.Catalogo;
import View.ButtonPane;
import View.PiastrellaCorrente;
import View.TestoPane;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

/**
 * La classe MainGUI rappresenta l'interfaccia principale dell'applicazione.
 * Contiene i componenti per visualizzare e navigare tra le piastrelle.
 */
public class MainGUI extends AnchorPane {
    private TestoPane testoPane;
    private ButtonPane buttonPane;
    private Catalogo catalogo;
    private PiastrellaCorrente piastrellaCorrente;
    private static int GENERAL_INDEX;

    /**
     * Costruttore della classe MainGUI.
     * Inizializza l'interfaccia utente con i componenti necessari.
     */
    public MainGUI() {
        super();
        GENERAL_INDEX = 0;
        catalogo = new Catalogo();
        testoPane = new TestoPane(catalogo);
        buttonPane = new ButtonPane(this);
        piastrellaCorrente = new PiastrellaCorrente(catalogo);

        VBox vb = new VBox(testoPane, buttonPane);
        vb.setSpacing(5);

        super.getChildren().addAll(vb, piastrellaCorrente);

        AnchorPane.setLeftAnchor(vb, 20.0);
        AnchorPane.setTopAnchor(vb, 30.0);

        AnchorPane.setRightAnchor(piastrellaCorrente, 20.0);
        AnchorPane.setTopAnchor(piastrellaCorrente, 20.0);
    }

    /**
     * Restituisce l'oggetto PiastrellaCorrente.
     *
     * @return L'oggetto PiastrellaCorrente.
     */
    public PiastrellaCorrente getPiastrellaCorrente() {
        return piastrellaCorrente;
    }

    /**
     * Restituisce l'oggetto TestoPane.
     *
     * @return L'oggetto TestoPane.
     */
    public TestoPane getTestoPane() {
        return testoPane;
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
}
