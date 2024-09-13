package View;

import Model.Ventilatore;
import Model.VentilatoriDB;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

/**
 * Classe per visualizzare il pannello dei ventilatori.
 */
public class VentilatoriPane extends VBox {

    /**
     * Costruttore per creare il pannello dei ventilatori.
     *
     * @param ventilatoriDB Il database dei ventilatori.
     */
    public VentilatoriPane(VentilatoriDB ventilatoriDB) {
        super();
        creaPane(ventilatoriDB);
    }

    /**
     * Crea e aggiorna il pannello con i ventilatori dal database.
     *
     * @param ventilatoriDB Il database dei ventilatori.
     */
    public void creaPane(VentilatoriDB ventilatoriDB) {
        getChildren().clear();
        for (Ventilatore v : ventilatoriDB.getVentilatori()) {
            getChildren().add(creaHB(v));
        }
    }

    /**
     * Crea un HBox contenente il ventilatore e il suo testo descrittivo.
     *
     * @param v Il ventilatore da visualizzare.
     * @return Un HBox contenente il ventilatore e il suo testo descrittivo.
     */
    private HBox creaHB(Ventilatore v) {
        return new HBox(v, new Text(v.toString()));
    }
}