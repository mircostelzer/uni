package Model;

import javafx.scene.control.Alert;

/**
 * Questa classe fornisce metodi statici per visualizzare messaggi di avviso o errore tramite finestre di dialogo.
 */
public class AlertDisplayer {

    /**
     * Mostra un messaggio di errore tramite una finestra di dialogo.
     *
     * @param s Il testo da visualizzare nella finestra di dialogo.
     */
    public static void display_ERROR_alert(String s){
        Alert a = new Alert(Alert.AlertType.ERROR);
        a.setTitle("ERRORE");
        a.setContentText(s);
        System.out.println(s);
        a.showAndWait();
    }
}
