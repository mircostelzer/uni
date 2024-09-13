package Model;

import javafx.scene.control.Alert;

public class AlertDisplayer {

    /**
     * mostra un Alert di errore con la stringa inserita da parametro
     * @param s
     */
    public static void displayErrorAlert(String s){
        Alert a = new Alert(Alert.AlertType.ERROR);
        a.setTitle("ERRORE");
        a.setHeaderText("ATTENTO");
        a.setContentText(s);
        a.show();
    }
}
