package View.Bottoni;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

import java.util.ArrayList;

/**
 * La classe BottoniCelle estende BorderPane e gestisce una serie di bottoni per costruire una strada.
 */
public class BottoniCelle extends BorderPane {
    private Button stradaNord;
    private Button stradaSud;
    private Button stradaEst;
    private Button stradaOvest;
    private Button prato;

    /**
     * Costruisce una nuova istanza di BottoniCelle.
     * Inizializza i bottoni e imposta le loro azioni.
     */
    public BottoniCelle() {
        super();
        stradaNord = new Button("Strada NORD");
        stradaSud = new Button("Strada SUD");
        stradaEst = new Button("Strada EST");
        stradaOvest = new Button("Strada OVEST");
        prato = new Button("PRATO");

        stradaNord.setPrefSize(100, 10);
        stradaSud.setPrefSize(100, 10);
        stradaEst.setPrefSize(100, 10);
        stradaOvest.setPrefSize(100, 10);
        prato.setPrefSize(100, 10);

        VBox topContainer = new VBox(stradaNord);
        VBox bottomContainer = new VBox(stradaSud);
        VBox rightContainer = new VBox(stradaEst);
        VBox leftContainer = new VBox(stradaOvest);

        topContainer.setAlignment(Pos.CENTER);
        bottomContainer.setAlignment(Pos.CENTER);
        leftContainer.setAlignment(Pos.CENTER);
        rightContainer.setAlignment(Pos.CENTER);

        for (Button b : getButtons()) {
            setButtonAction(b);
        }

        super.setTop(topContainer);
        super.setBottom(bottomContainer);
        super.setLeft(leftContainer);
        super.setRight(rightContainer);
        super.setCenter(prato);
    }

    /**
     * Restituisce il bottone per la strada nord.
     *
     * @return Il bottone per la strada nord.
     */
    public Button getStradaNord() {
        return stradaNord;
    }

    /**
     * Restituisce il bottone per la strada sud.
     *
     * @return Il bottone per la strada sud.
     */
    public Button getStradaSud() {
        return stradaSud;
    }

    /**
     * Restituisce il bottone per la strada est.
     *
     * @return Il bottone per la strada est.
     */
    public Button getStradaEst() {
        return stradaEst;
    }

    /**
     * Restituisce il bottone per la strada ovest.
     *
     * @return Il bottone per la strada ovest.
     */
    public Button getStradaOvest() {
        return stradaOvest;
    }

    /**
     * Restituisce il bottone per il prato.
     *
     * @return Il bottone per il prato.
     */
    public Button getPrato() {
        return prato;
    }

    /**
     * Imposta l'azione per un bottone specifico.
     *
     * @param b Il bottone per cui impostare l'azione.
     */
    private void setButtonAction(Button b) {
        b.setOnAction(event -> azioneBottone(b));
    }

    /**
     * Disabilita il bottone selezionato e abilita tutti gli altri bottoni.
     *
     * @param b Il bottone selezionato.
     */
    public void azioneBottone(Button b) {
        b.setDisable(true);
        abilitaAltriBottoni(b);
    }

    /**
     * Abilita tutti i bottoni tranne quello selezionato.
     *
     * @param b Il bottone che deve rimanere disabilitato.
     */
    private void abilitaAltriBottoni(Button b) {
        for (Button button : getButtons()) {
            button.setDisable(false);
        }
        b.setDisable(true);
    }

    /**
     * Restituisce una lista di tutti i bottoni.
     *
     * @return Una lista di tutti i bottoni.
     */
    public ArrayList<Button> getButtons() {
        ArrayList<Button> a = new ArrayList<>();
        a.add(stradaNord);
        a.add(stradaSud);
        a.add(stradaEst);
        a.add(stradaOvest);
        a.add(prato);
        return a;
    }

    /**
     * Restituisce il bottone disabilitato corrente.
     *
     * @return Il bottone disabilitato, o null se nessuno è disabilitato.
     */
    public Button getDisabled() {
        for (Button b : getButtons()) {
            if (b.isDisabled())
                return b;
        }
        return null;
    }

    /**
     * Abilita tutti i bottoni che sono attualmente disabilitati.
     */
    public void abilitaBottoni() {
        for (Button b : getButtons()) {
            if (b.isDisabled())
                b.setDisable(false);
        }
    }
}
