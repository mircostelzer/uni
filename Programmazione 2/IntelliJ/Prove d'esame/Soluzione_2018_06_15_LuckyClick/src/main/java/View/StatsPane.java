package View;

import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

/**
 * La classe StatsPane rappresenta il pannello di visualizzazione del punteggio e dei tentativi di gioco.
 */
public class StatsPane extends VBox {
    private int punteggio; // Punteggio corrente del giocatore
    private int tentativi; // Numero di tentativi rimanenti
    private boolean gameOver; // Flag che indica se il gioco è finito

    private Text punteggioText; // Testo per visualizzare il punteggio
    private Text tentativiText; // Testo per visualizzare i tentativi rimanenti

    /**
     * Costruttore per la classe StatsPane.
     * Inizializza il pannello di visualizzazione del punteggio e dei tentativi di gioco.
     */
    public StatsPane() {
        super();
        punteggio = 0;
        tentativi = 10;
        gameOver = false;

        punteggioText = new Text("Punteggio= " + punteggio);
        tentativiText = new Text("Tentativi = " + tentativi);

        punteggioText.setFont(Font.font("Arial", FontWeight.BOLD, 20));
        punteggioText.setStyle("-fx-font-weight: bold; -fx-font-size: 20px;");
        tentativiText.setFont(Font.font("Arial", FontWeight.BOLD, 20));
        tentativiText.setStyle("-fx-font-weight: bold; -fx-font-size: 20px;");

        super.getChildren().addAll(punteggioText, tentativiText);
    }

    /**
     * Verifica se il gioco è finito.
     *
     * @return true se il gioco è finito, false altrimenti
     */
    public boolean isGameOver() {
        return gameOver;
    }

    /**
     * Restituisce il punteggio corrente del giocatore.
     *
     * @return Il punteggio corrente del giocatore
     */
    public int getPunteggio() {
        return punteggio;
    }

    /**
     * Restituisce il numero di tentativi rimanenti.
     *
     * @return Il numero di tentativi rimanenti
     */
    public int getTentativi() {
        return tentativi;
    }

    /**
     * Imposta il punteggio del giocatore e aggiorna la visualizzazione.
     *
     * @param punteggio Il nuovo punteggio del giocatore
     */
    public void setPunteggio(int punteggio) {
        this.punteggio = punteggio;
        punteggioText.setText("Punteggio= " + punteggio);
    }

    /**
     * Imposta il numero di tentativi rimanenti e aggiorna la visualizzazione.
     * Se il numero di tentativi è 0, imposta il flag gameOver a true e mostra "GAME OVER!".
     *
     * @param tentativi Il nuovo numero di tentativi rimanenti
     */
    public void setTentativi(int tentativi) {
        if(tentativi == 0){
            gameOver = true;
            tentativiText.setText("GAME OVER!");
        }else {
            this.tentativi = tentativi;
            tentativiText.setText("Tentativi = " + tentativi);
        }
    }
}
