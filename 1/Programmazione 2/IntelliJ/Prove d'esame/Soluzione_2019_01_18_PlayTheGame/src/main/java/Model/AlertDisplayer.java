package Model;

import javafx.application.Platform;
import javafx.scene.control.Alert;

/**
 * Classe per la visualizzazione di alert di vittoria e sconfitta nel gioco.
 */
public class AlertDisplayer {
    /**
     * Visualizza un alert di sconfitta.
     */
    public static void display_LOOSE_Alert(){
        String s = "Peccato, hai perso!";
        Alert a = new Alert(Alert.AlertType.ERROR);
        a.setTitle("GAME OVER!");
        a.setContentText(s);
        System.out.println(s);
        a.setOnCloseRequest(event -> Platform.exit());
        a.showAndWait();
    }

    /**
     * Visualizza un alert di vittoria.
     */
    public static void display_WIN_Alert(){
        String s = "Complimenti, hai vinto!";
        Alert a = new Alert(Alert.AlertType.INFORMATION);
        a.setTitle("GAME OVER!");
        a.setContentText(s);
        System.out.println(s);
        a.showAndWait();
    }
}
