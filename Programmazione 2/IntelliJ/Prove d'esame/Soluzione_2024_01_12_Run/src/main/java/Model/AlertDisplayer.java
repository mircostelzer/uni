package Model;

import javafx.scene.control.Alert;

/**
 * La classe AlertDisplayer fornisce metodi statici per visualizzare messaggi di avviso all'utente.
 */
public class AlertDisplayer {
    /**
     * Visualizza un avviso informativo con il punteggio totalizzato dall'utente.
     *
     * @param n il punteggio totalizzato dall'utente
     */
    public static void displayAlert(int n){
        Alert a = new Alert(Alert.AlertType.INFORMATION);
        a.setTitle("ATTENTION");
        a.setHeaderText("GAME OVER");
        a.setContentText("Hai totalizzato " + n + " punti");
        a.showAndWait();
    }

    /**
     * Visualizza un avviso informativo quando l'utente ha terminato le vite a disposizione.
     */
    public static void displayAlertSconfitta(){
        Alert a = new Alert(Alert.AlertType.INFORMATION);
        a.setTitle("ATTENTION");
        a.setHeaderText("GAME OVER");
        a.setContentText("Hai terminato le vite a disposizione");
        a.showAndWait();
    }
}
