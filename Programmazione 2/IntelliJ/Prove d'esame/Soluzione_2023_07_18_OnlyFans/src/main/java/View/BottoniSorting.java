package View;

import Controller.MainGUI;
import Model.VentilatoriDB;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;

/**
 * Classe per creare il pannello dei bottoni per l'ordinamento dei ventilatori.
 */
public class BottoniSorting extends VBox {
    private Button perTipo;
    private Button perData;

    /**
     * Costruttore per creare il pannello dei bottoni per l'ordinamento.
     *
     * @param mg L'istanza di MainGUI.
     */
    public BottoniSorting(MainGUI mg) {
        super();
        perTipo = new Button("Ordina per Tipo");
        perData = new Button("Ordina per Data");

        perTipo.setPrefSize(110, 10);
        perData.setPrefSize(110, 10);

        perTipo.setDisable(true);

        setButtonAction(perData, perTipo, mg);
        setButtonAction(perTipo, perData, mg);

        super.getChildren().addAll(perTipo, perData);
    }

    /**
     * Imposta l'azione per i bottoni di ordinamento.
     *
     * @param b Il bottone a cui impostare l'azione.
     * @param altroBottone L'altro bottone che verrà abilitato/disabilitato.
     * @param mg L'istanza di MainGUI.
     */
    private void setButtonAction(Button b, Button altroBottone, MainGUI mg) {
        b.setOnAction(event -> {
            if (altroBottone.isDisabled()) {
                VentilatoriDB db = mg.getVentilatoriDB();
                db.cambiaSort();
                mg.getVentilatoriPane().creaPane(db);
                b.setDisable(true);
                altroBottone.setDisable(false);
            }
        });
    }
}
