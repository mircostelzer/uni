package Controller;

import Model.Direzione;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;

/**
 * Gestore degli eventi da tastiera per il movimento del giocatore e l'aggiunta dei nemici.
 */
public class KeyHandler {
    private Scene scene;
    private MainGUI mg;

    /**
     * Costruttore della classe KeyHandler.
     *
     * @param scene la scena su cui gestire gli eventi da tastiera.
     * @param mg    l'istanza di MainGUI per accedere ai metodi del gioco.
     */
    public KeyHandler(Scene scene, MainGUI mg) {
        this.scene = scene;
        this.mg = mg;
    }

    /**
     * Gestisce gli eventi da tastiera per il movimento del giocatore e l'aggiunta dei nemici.
     */
    public void handleKeys() {
        scene.setOnKeyPressed(event -> {
            if ((event.getCode() == KeyCode.UP || event.getCode() == KeyCode.DOWN ||
                    event.getCode() == KeyCode.RIGHT || event.getCode() == KeyCode.LEFT) && !MainGUI.isLoose()) {

                Direzione dir = null;
                MainGUI.incrementGeneralIndex();

                if (MainGUI.getGeneralIndex() % 5 == 0)
                    mg.cambiaDirezione();

                if (MainGUI.getGeneralIndex() % 10 == 0)
                    mg.aggiungiNemico(mg.creaNemicoCasuale());

                if (event.getCode() == KeyCode.UP) {
                    dir = Direzione.SU;
                } else if (event.getCode() == KeyCode.DOWN) {
                    dir = Direzione.GIU;
                } else if (event.getCode() == KeyCode.RIGHT) {
                    dir = Direzione.DESTRA;
                } else if (event.getCode() == KeyCode.LEFT) {
                    dir = Direzione.SINISTRA;
                }

                mg.getUser().muoviInDirezione(dir);
                mg.muoviNemici();
                mg.checkLoose();

                if (MainGUI.isLoose())
                    mg.getStatsStage().aggiornaTextSconfitta();
                else {
                    mg.getStatsStage().aggiornaPunteggio();
                    mg.riposizionaPalline();
                }
            }
        });
    }
}
