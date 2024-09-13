package Model;

import javafx.scene.control.Alert;

/**
 * La classe AlertDisplayer fornisce metodi statici per visualizzare diversi tipi di avvisi (alert) nell'interfaccia utente.
 */
public class AlertDisplayer {

    /**
     * Visualizza un avviso di errore con un messaggio specificato.
     *
     * @param s Il messaggio di errore da visualizzare.
     */
    public static void display_ERROR_alert(String s){
        Alert a = new Alert(Alert.AlertType.ERROR);
        a.setTitle("ERROR");
        a.setContentText(s);
        a.setHeaderText("ERROR");
        a.show();
    }

    /**
     * Visualizza un avviso di conferma con il messaggio "GAME OVER".
     */
    public static void display_CONFIRMATION_alert(){
        Alert a = new Alert(Alert.AlertType.CONFIRMATION);
        a.setTitle("GAME OVER");
        a.setContentText("GAME OVER");
        a.setHeaderText("GAME OVER");
        a.showAndWait();
    }
}
