package View;

import Controller.MainGUI;
import Model.AlertDisplayer;
import javafx.scene.control.Button;

/**
 * Questa classe gestisce i bottoni di direzione "avanti" e "indietro" per la navigazione.
 */
public class BottoniDirezione {
    private Button back;
    private Button next;

    /**
     * Costruisce una nuova istanza di BottoniDirezione.
     *
     * @param mg L'istanza di MainGUI usata per gestire le azioni dei bottoni.
     */
    public BottoniDirezione(MainGUI mg) {
        super();
        back = new Button("<");
        next = new Button(">");
        setBackAction(mg);
        setNextAction(mg);
    }

    /**
     * Imposta l'azione per il bottone "avanti".
     *
     * @param mg L'istanza di MainGUI usata per gestire l'azione del bottone.
     */
    private void setNextAction(MainGUI mg) {
        next.setOnAction(event -> {
            MainGUI.incrementGeneralIndex();
            if (MainGUI.getGeneralIndex() > 4) {
                AlertDisplayer.display_ERROR_Alert("Non puoi andare avanti");
                MainGUI.decrementGeneralIndex();
            } else {
                mg.getTitoliPane().aggiornaTitoliPane();
            }
        });
    }

    /**
     * Imposta l'azione per il bottone "indietro".
     *
     * @param mg L'istanza di MainGUI usata per gestire l'azione del bottone.
     */
    private void setBackAction(MainGUI mg) {
        back.setOnAction(event -> {
            MainGUI.decrementGeneralIndex();
            if (MainGUI.getGeneralIndex() < 0) {
                AlertDisplayer.display_ERROR_Alert("Non puoi andare indietro");
                MainGUI.incrementGeneralIndex();
            } else {
                mg.getTitoliPane().aggiornaTitoliPane();
            }
        });
    }

    /**
     * Restituisce il bottone "indietro".
     *
     * @return Il bottone "indietro".
     */
    public Button getBack() {
        return back;
    }

    /**
     * Restituisce il bottone "avanti".
     *
     * @return Il bottone "avanti".
     */
    public Button getNext() {
        return next;
    }
}
