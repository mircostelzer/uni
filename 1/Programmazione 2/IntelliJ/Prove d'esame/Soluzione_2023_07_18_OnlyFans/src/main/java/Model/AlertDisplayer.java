package Model;

import javafx.scene.control.Alert;

/**
 * Classe per visualizzare avvisi di errore utilizzando JavaFX.
 */
public class AlertDisplayer {

    /**
     * Visualizza un avviso di errore con un messaggio di fondi insufficienti.
     */
    public static void display_ERROR_Alert() {
        Alert a = new Alert(Alert.AlertType.ERROR);
        a.setTitle("ERRORE");
        a.setHeaderText("ATTENZIONE");
        a.setContentText("Non hai abbastanza fondi per passare al mese successivo!");
        a.show();
    }
}
