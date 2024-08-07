package View;

import Controller.MainGUI;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * Classe che gestisce la finestra delle statistiche di gioco.
 * Mostra il punteggio e il testo di game over se il giocatore perde.
 */
public class StatsStage {
    private int punteggio;
    private Text punteggioText;
    private Text gameOverText;
    private VBox vBox;

    /**
     * Costruttore della classe StatsStage.
     * Inizializza il punteggio a 0 e crea la scena della finestra delle statistiche.
     */
    public StatsStage() {
        punteggio = 0;
        punteggioText = new Text("Points: " + punteggio);
        gameOverText = new Text("GAME OVER");
        punteggioText.setFont(Font.font("Arial", 20));
        gameOverText.setFont(Font.font("Arial", 20));

        vBox = new VBox(punteggioText);
        vBox.setAlignment(Pos.CENTER);

        Scene scene = new Scene(vBox, 200, 100);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
    }

    /**
     * Aggiorna il punteggio aggiungendo 100 punti.
     */
    public void aggiornaPunteggio() {
        punteggio += 100;
        punteggioText.setText("Points: " + punteggio);
    }

    /**
     * Aggiorna il testo di sconfitta nella finestra delle statistiche.
     * Aggiunge il testo "GAME OVER" se il giocatore ha perso.
     */
    public void aggiornaTextSconfitta() {
        if (MainGUI.isLoose())
            vBox.getChildren().add(gameOverText);
    }
}
