package Controller;

import View.Bottoni;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;

/**
 * La classe KeyHandler gestisce gli eventi di pressione dei tasti per l'interfaccia utente.
 */
public class KeyHandler {
    private Scene scene;
    private MainGUI mg;

    /**
     * Costruisce un nuovo oggetto KeyHandler con la scena e il controller MainGUI specificati.
     *
     * @param scene la scena associata a questo KeyHandler
     * @param mg il controller MainGUI
     */
    public KeyHandler(Scene scene, MainGUI mg) {
        this.scene = scene;
        this.mg = mg;
    }

    /**
     * Imposta il gestore degli eventi per la pressione dei tasti.
     */
    public void handleKeys() {
        scene.setOnKeyPressed(event -> {
            Bottoni bottoni = mg.getBottoni();
            if (event.getCode() == KeyCode.DIGIT1)
                bottoni.setValoreText(1);
            else if (event.getCode() == KeyCode.DIGIT2)
                bottoni.setValoreText(2);
            else if (event.getCode() == KeyCode.DIGIT3)
                bottoni.setValoreText(3);
            else if (event.getCode() == KeyCode.DIGIT4)
                bottoni.setValoreText(4);
        });
    }
}