package Controller;

import Model.AlertDisplayer;
import Model.Stats;
import View.Omino;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;

/**
 * La classe KeyHandler gestisce gli eventi della tastiera per controllare l'omino nel gioco.
 */
public class KeyHandler {
    private MainGUI mg;
    private Scene scene;

    /**
     * Costruttore della classe KeyHandler.
     *
     * @param scene la scena principale del gioco
     * @param mg il pannello principale dell'interfaccia grafica
     */
    public KeyHandler(Scene scene, MainGUI mg) {
        this.scene = scene;
        this.mg = mg;
    }

    /**
     * Gestisce gli eventi della tastiera per controllare l'omino.
     * Il movimento è limitato ai tasti UP, DOWN e SPACE quando l'omino è vivo.
     */
    public void handleKeys() {
        scene.setOnKeyPressed(event -> {
            if ((event.getCode() == KeyCode.UP || event.getCode() == KeyCode.DOWN || event.getCode() == KeyCode.SPACE) && MainGUI.isALIVE()) {
                Omino omino = mg.getOmino();
                Stats stats = mg.getStats();

                if (event.getCode() == KeyCode.UP) {
                    double h = omino.getLayoutY() - 10;
                    if (h > 0)
                        omino.setLayoutY(omino.getLayoutY() - 10);
                } else if (event.getCode() == KeyCode.DOWN) {
                    double h = omino.getLayoutY() + 10;
                    if (h < 180)
                        omino.setLayoutY(omino.getLayoutY() + 10);
                }

                mg.shiftAllLeft();
                Shape shape = mg.getCoordinateHelper().checkCollision();
                if (shape == null) {
                    stats.bonusPunteggio();
                } else {
                    if (shape instanceof Circle c && c.getFill() != Color.TRANSPARENT) {
                        c.setFill(Color.TRANSPARENT);
                        c.setStroke(Color.BLUE);
                        stats.penalitaPunteggio();
                    } else if (shape instanceof Rectangle r && r.getFill() != Color.TRANSPARENT) {
                        r.setFill(Color.TRANSPARENT);
                        r.setStroke(Color.RED);
                        stats.setVite();
                        if (stats.getVite() == 0) {
                            AlertDisplayer.displayAlertSconfitta();
                            MainGUI.setALIVE();
                        }
                    }
                }

                if (mg.getCoordinateHelper().checkWin())
                    MainGUI.setALIVE();
            }
        });
    }
}
