package View;

import Controller.MainGUI;
import Model.Tessera;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import org.example.soluzione_2019_01_18.MainFX;

/**
 * Rappresenta il pannello dei bottoni nella GUI principale del gioco.
 */
public class ButtonPane extends HBox {
    private Button reset;
    private Button cheat;

    /**
     * Costruttore del pannello dei bottoni.
     *
     * @param mg MainGUI a cui il pannello appartiene.
     */
    public ButtonPane(MainGUI mg) {
        super();
        reset = new Button("reset");
        cheat = new Button("cheat");

        setResetAction(mg);
        setCheatAction(mg);

        super.getChildren().addAll(reset, cheat);
    }

    /**
     * Imposta l'azione del pulsante di reset.
     *
     * @param mg MainGUI a cui il pannello appartiene.
     */
    private void setResetAction(MainGUI mg){
        reset.setOnAction(event -> {
            System.out.println("RESETTO TUTTO!");
            mg.resetAll();
        });
    }

    /**
     * Imposta l'azione del pulsante di cheat.
     *
     * @param mg MainGUI a cui il pannello appartiene.
     */
    private void setCheatAction(MainGUI mg){
        cheat.setOnAction(event -> {
            Tessera[][] grid = mg.getGriglia().getGriglia();
            GridPane gp = creaGriglia(grid);
            Scene scene = new Scene(gp, MainFX.getLATO()*41, MainFX.getLATO()*41);
            Stage s = new Stage();
            s.setTitle("CHEATS");
            s.setResizable(false);
            s.setScene(scene);
            s.show();
            System.out.println("CHEAT ATTIVATI, STAMPO LA GRIGLIA:");
            mg.getGriglia().stampaGriglia();
        });
    }

    /**
     * Crea una tessera cheat.
     *
     * @param s Contenuto della tessera.
     * @return StackPane contenente la tessera cheat.
     */
    private StackPane creaTesseraCheat(String s){
        Rectangle r = new Rectangle(40, 40);
        r.setFill(Color.YELLOW);
        r.setStroke(Color.BLACK);

        Text t = new Text(s);

        return new StackPane(r, t);
    }

    /**
     * Crea la griglia di tessere cheat.
     *
     * @param grid Griglia di tessere del gioco.
     * @return GridPane contenente le tessere cheat.
     */
    private GridPane creaGriglia(Tessera[][] grid){
        GridPane gp = new GridPane();
        for (int i = 0; i < MainFX.getLATO(); i++) {
            for (int j = 0; j < MainFX.getLATO(); j++) {
                gp.add(creaTesseraCheat(grid[i][j].getContenuto()), j, i);
            }
        }
        return gp;
    }
}
