package Model;

import javafx.scene.control.Alert;

/**
 * Classe per visualizzare avvisi di errore utilizzando JavaFX.
 */
public class AlertDisplayer {

    /**
     * Visualizza un avviso di errore con il messaggio specificato.
     *
     * @param s Il messaggio di errore da visualizzare nell'avviso.
     */
    public static void display_error_alert(String s) {
        Alert a = new Alert(Alert.AlertType.ERROR);
        a.setHeaderText("ATTENZIONE");
        a.setTitle("ERRORE");
        a.setContentText(s);
        a.show();
    }
}
