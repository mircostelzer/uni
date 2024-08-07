package View.Bottoni;

import Controller.MainGUI;
import Model.Utils.AlertDisplayer;
import Model.Celle.Prato;
import Model.Celle.Strada;
import Model.Celle.Strade.StradaEst;
import Model.Celle.Strade.StradaNord;
import Model.Celle.Strade.StradaOvest;
import Model.Celle.Strade.StradaSud;
import Model.Utils.Coordinate;
import View.Auto;
import View.MappaPane;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;

/**
 * La classe BottoniGestione estende VBox e gestisce una serie di bottoni per la gestione delle auto nella griglia.
 */
public class BottoniGestione extends VBox {
    private Button aggiungiAuto;
    private Button muoviAuto;
    private Button reset;

    /**
     * Costruisce una nuova istanza di BottoniGestione.
     * Inizializza i bottoni e imposta le loro azioni.
     *
     * @param mg L'oggetto MainGUI associato.
     */
    public BottoniGestione(MainGUI mg) {
        super();
        aggiungiAuto = new Button("Aggiungi auto");
        muoviAuto = new Button("Muovi auto");
        reset = new Button("Reset");

        muoviAuto.setDisable(true);

        aggiungiAuto.setPrefSize(100, 10);
        muoviAuto.setPrefSize(100, 10);
        reset.setPrefSize(100, 10);

        setAggiungiAutoAction(mg);
        setMuoviAutoAction(mg);
        setResetAction(mg);

        super.getChildren().addAll(aggiungiAuto, muoviAuto, reset);
    }

    /**
     * Restituisce il bottone per aggiungere un'auto.
     *
     * @return Il bottone per aggiungere un'auto.
     */
    public Button getAggiungiAuto() {
        return aggiungiAuto;
    }

    /**
     * Restituisce il bottone per muovere un'auto.
     *
     * @return Il bottone per muovere un'auto.
     */
    public Button getMuoviAuto() {
        return muoviAuto;
    }

    /**
     * Imposta l'azione del bottone per aggiungere un'auto.
     *
     * @param mg L'oggetto MainGUI associato.
     */
    public void setAggiungiAutoAction(MainGUI mg) {
        aggiungiAuto.setOnAction(event -> {
            aggiungiAuto.setDisable(true);
            muoviAuto.setDisable(false);
            mg.getBottoniCelle().abilitaBottoni();
        });
    }

    /**
     * Imposta l'azione del bottone per muovere un'auto.
     *
     * @param mg L'oggetto MainGUI associato.
     */
    public void setMuoviAutoAction(MainGUI mg) {
        muoviAuto.setOnAction(event -> {
            if (MainGUI.getCoordinateAuto() != null) {
                Coordinate coordinateAuto = MainGUI.getCoordinateAuto();
                MappaPane mp = mg.getMappaPane();
                Strada s = (Strada) mp.getElementAt(coordinateAuto.getX(), coordinateAuto.getY());

                if (s.getChildren().get(s.getChildren().size() - 1) instanceof Auto)
                    s.getChildren().remove(s.getChildren().size() - 1);

                int nuovaCoordinataX = coordinateAuto.getX(), nuovaCoordinataY = coordinateAuto.getY();
                switch (s) {
                    case StradaNord stradaNord -> nuovaCoordinataY = coordinateAuto.getY() - 1;
                    case StradaSud stradaSud -> nuovaCoordinataY = coordinateAuto.getY() + 1;
                    case StradaEst stradaEst -> nuovaCoordinataX = coordinateAuto.getX() + 1;
                    case StradaOvest stradaOvest -> nuovaCoordinataX = coordinateAuto.getX() - 1;
                    default -> System.err.println("ERRORE");
                }

                Node cella = mg.getMappaPane().getElementAt(nuovaCoordinataX, nuovaCoordinataY);
                if (cella instanceof Prato || controllaCoordinate(nuovaCoordinataX, nuovaCoordinataY)) {
                    AlertDisplayer.display_warning_alert("CRASH");
                    MainGUI.setCoordinateAuto(null);
                    aggiungiAuto.setDisable(false);
                    muoviAuto.setDisable(true);
                } else {
                    MainGUI.setCoordinateAuto(new Coordinate(nuovaCoordinataX, nuovaCoordinataY));
                    ((Strada) cella).aggiungiAuto();
                }
            } else
                AlertDisplayer.display_warning_alert("prima devi aggiungere l'auto");
        });
    }

    /**
     * Imposta l'azione del bottone di reset per ripristinare lo stato iniziale della griglia.
     *
     * @param mg L'oggetto MainGUI associato.
     */
    public void setResetAction(MainGUI mg) {
        reset.setOnAction(event -> {
            mg.getBottoniCelle().abilitaBottoni();
            aggiungiAuto.setDisable(false);
            muoviAuto.setDisable(true);
            mg.getMappaPane().creaMappa(mg);
        });
    }

    /**
     * Controlla se le coordinate specificate sono valide.
     *
     * @param x La coordinata x da controllare.
     * @param y La coordinata y da controllare.
     * @return true se le coordinate sono fuori dai limiti, false altrimenti.
     */
    private boolean controllaCoordinate(int x, int y) {
        return x == 10 || y == 10 || x < 0 || y < 0;
    }
}
