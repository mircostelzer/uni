package View;

import javafx.geometry.Pos;
import javafx.scene.layout.VBox;

/**
 * La classe ButtonPane estende VBox e rappresenta un pannello contenente pulsanti per manipolare una lista di record.
 * Il layout dei pulsanti varia a seconda del tipo di lista.
 */
public class ButtonPane extends VBox {

    /**
     * Costruisce un nuovo oggetto ButtonPane con i pulsanti appropriati.
     *
     * @param bottoni       L'oggetto Bottoni contenente i pulsanti da aggiungere al pannello.
     * @param isAutoList    Indica se la lista è una lista di automobili (true) o di persone (false).
     */
    public ButtonPane(Bottoni bottoni, boolean isAutoList) {
        super();
        super.getChildren().addAll(bottoni.getMescola(), bottoni.getOrdina(), bottoni.getConta(), bottoni.getOrdinaPer());

        // Posiziona i pulsanti a destra se la lista non è una lista di automobili
        if (!isAutoList) {
            this.setAlignment(Pos.CENTER_RIGHT);
        }
    }
}
