package Controller;

import javafx.scene.Scene;
import javafx.scene.input.KeyCode;

/**
 * La classe KeyHandler gestisce gli eventi della tastiera per un oggetto MainGUI in una specifica scena.
 */
public class KeyHandler {
    private MainGUI mg;
    private Scene scene;

    /**
     * Costruisce una nuova istanza di KeyHandler.
     *
     * @param mg L'oggetto MainGUI da controllare.
     * @param scene La scena in cui gli eventi della tastiera saranno gestiti.
     */
    public KeyHandler(MainGUI mg, Scene scene) {
        this.mg = mg;
        this.scene = scene;
    }

    /**
     * Imposta i gestori degli eventi della tastiera per la scena.
     * Il tasto 'A' cancella tutte le forme nella ScacchieraPane impostandole a EmptyFigure.
     * Il tasto 'C' controlla se ci sono tre forme uguali in una riga o colonna nella ScacchieraPane e mostra un avviso se ne trova.
     */
    public void handleKeys() {
        scene.setOnKeyPressed(event -> {
            if (event.getCode() == KeyCode.A)
                mg.getBottoniPerGestire().clearAllAction(mg.getScacchieraPane());
            else if (event.getCode() == KeyCode.C)
                mg.getBottoniPerGestire().checkAction(mg.getScacchieraPane());
        });
    }
}
