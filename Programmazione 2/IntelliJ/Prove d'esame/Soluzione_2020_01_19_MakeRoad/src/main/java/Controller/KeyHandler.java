package Controller;

import View.Bottoni.BottoniCelle;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;

/**
 * La classe KeyHandler gestisce gli eventi della tastiera per un oggetto MainGUI in una specifica scena.
 */
public class KeyHandler {
    private Scene scene;
    private MainGUI mg;

    /**
     * Costruisce una nuova istanza di KeyHandler.
     *
     * @param scene La scena in cui gli eventi della tastiera saranno gestiti.
     * @param mg L'oggetto MainGUI associato.
     */
    public KeyHandler(Scene scene, MainGUI mg) {
        this.scene = scene;
        this.mg = mg;
    }

    /**
     * Imposta i gestori degli eventi della tastiera per la scena.
     * I tasti W, A, S, D e P attivano rispettivamente i bottoni StradaNord, StradaOvest, StradaSud, StradaEst e Prato.
     */
    public void handleKeysPressed() {
        scene.setOnKeyPressed(event -> {
            BottoniCelle bc = mg.getBottoniCelle();
            if (event.getCode() == KeyCode.W) {
                bc.azioneBottone(bc.getStradaNord());
            } else if (event.getCode() == KeyCode.A) {
                bc.azioneBottone(bc.getStradaOvest());
            } else if (event.getCode() == KeyCode.S) {
                bc.azioneBottone(bc.getStradaSud());
            } else if (event.getCode() == KeyCode.D) {
                bc.azioneBottone(bc.getStradaEst());
            } else if (event.getCode() == KeyCode.P) {
                bc.azioneBottone(bc.getPrato());
            }
        });
    }
}
