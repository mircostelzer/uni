package View;

import Controller.MainGUI;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;

/**
 * La classe Bottoni rappresenta un HBox personalizzato contenente tre pulsanti:
 * uno per cambiare un valore, uno per cambiare una riga e uno per cambiare una colonna.
 */
public class Bottoni extends HBox {
    private Button valore;
    private Button cambiaRiga;
    private Button cambiaColonna;

    /**
     * Costruisce un nuovo oggetto Bottoni con il controller MainGUI specificato.
     *
     * @param mg il controller MainGUI
     */
    public Bottoni(MainGUI mg) {
        super();
        valore = new Button("1");
        cambiaRiga = new Button("Cambia Riga");
        cambiaColonna = new Button("Cambia Colonna");

        setValoreAction();
        setCambiaRigaAction(mg);
        setCambiaColonnaAction(mg);

        super.getChildren().addAll(valore, cambiaRiga, cambiaColonna);
    }

    /**
     * Disabilita tutti i pulsanti in questo HBox.
     */
    public void disabilitaBottoni() {
        for (Node node : getChildren()) {
            if (node instanceof Button button)
                button.setDisable(true);
        }
    }

    /**
     * Imposta l'azione per il pulsante 'valore'.
     * Questa azione incrementa il valore visualizzato sul pulsante.
     */
    private void setValoreAction() {
        valore.setOnAction(event -> {
            if (MainGUI.getVal() + 1 == 5)
                setValoreText(1);
            else
                setValoreText(MainGUI.getVal() + 1);
        });
    }

    /**
     * Imposta il testo del pulsante 'valore' al valore specificato.
     * Aggiorna anche il valore in MainGUI.
     *
     * @param nuovoValore il nuovo valore da impostare
     */
    public void setValoreText(int nuovoValore) {
        MainGUI.setVal(nuovoValore);
        valore.setText(String.valueOf(MainGUI.getVal()));
    }

    /**
     * Imposta l'azione per il pulsante 'cambiaRiga'.
     * Questa azione attiva l'aggiornamento di una riga nel MainGUI.
     *
     * @param mg il controller MainGUI
     */
    private void setCambiaRigaAction(MainGUI mg) {
        cambiaRiga.setOnAction(event -> mg.getCellePane().aggiornaRiga());
    }

    /**
     * Imposta l'azione per il pulsante 'cambiaColonna'.
     * Questa azione attiva l'aggiornamento di una colonna nel MainGUI.
     *
     * @param mg il controller MainGUI
     */
    private void setCambiaColonnaAction(MainGUI mg) {
        cambiaColonna.setOnAction(event -> mg.getCellePane().aggiornaColonna());
    }
}