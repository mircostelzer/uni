package Model;

import javafx.scene.control.Alert;

/**
 * Classe utilitaria per mostrare finestre di dialogo di avviso agli utenti.
 * Fornisce metodi statici per visualizzare avvisi di vittoria, pareggio e sconfitta.
 */
public class AlertDisplayer {

    /**
     * Mostra un avviso di vittoria.
     * Utilizza una finestra di dialogo di tipo informazione per comunicare all'utente che ha vinto.
     */
    public static void displayAlertWin() {
        Alert a = new Alert(Alert.AlertType.INFORMATION);
        a.setTitle("VITTORIA");
        a.setHeaderText("Vittoria");
        a.setContentText("Complimenti, hai vinto!");
        a.show();
    }

    /**
     * Mostra un avviso di pareggio.
     * Utilizza una finestra di dialogo di tipo informazione per comunicare all'utente che ha pareggiato.
     */
    public static void displayAlertDraw() {
        Alert a = new Alert(Alert.AlertType.INFORMATION);
        a.setTitle("PAREGGIO");
        a.setHeaderText("Pareggio");
        a.setContentText("Hai pareggiato!");
        a.show();
    }

    /**
     * Mostra un avviso di sconfitta.
     * Utilizza una finestra di dialogo di tipo errore per comunicare all'utente che ha perso.
     */
    public static void displayAlertLoose() {
        Alert a = new Alert(Alert.AlertType.ERROR);
        a.setTitle("SCONFITTA");
        a.setHeaderText("Sconfitta");
        a.setContentText("Mi dispiace, hai perso!");
        a.show();
    }
}
