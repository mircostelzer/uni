package Model.Utils;

import javafx.scene.control.Alert;

/**
 * La classe AlertDisplayer fornisce un metodo per visualizzare avvisi di tipo warning.
 */
public class AlertDisplayer {

    /**
     * Visualizza un avviso di tipo warning con il messaggio specificato.
     *
     * @param message Il messaggio da visualizzare nell'avviso.
     */
    public static void display_warning_alert(String message) {
        Alert a = new Alert(Alert.AlertType.WARNING);
        a.setTitle("ATTENZIONE");
        a.setContentText(message);
        a.showAndWait();
    }
}
