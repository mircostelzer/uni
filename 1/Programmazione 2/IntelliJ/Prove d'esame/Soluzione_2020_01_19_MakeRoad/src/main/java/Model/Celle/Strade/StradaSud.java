package Model.Celle.Strade;

import Controller.MainGUI;
import Model.Celle.Strada;
import Model.Utils.Coordinate;
import javafx.geometry.Pos;
import javafx.scene.layout.BorderPane;
import javafx.scene.shape.Circle;

/**
 * La classe StradaSud estende Strada e rappresenta una cella di strada orientata verso sud.
 */
public class StradaSud extends Strada {

    /**
     * Costruisce una nuova istanza di StradaSud con il colore predefinito.
     *
     * @param mg L'oggetto MainGUI associato.
     * @param coordinate La coordinata della cella nella griglia.
     */
    public StradaSud(MainGUI mg, Coordinate coordinate) {
        super(mg, coordinate);
    }

    /**
     * Aggiunge un cerchio alla parte inferiore della cella per indicare la direzione sud.
     * Utilizza un BorderPane per posizionare il cerchio al centro del bordo inferiore.
     */
    @Override
    public void aggiungiDirezione() {
        BorderPane bp = new BorderPane();
        Circle circle = getCerchio();
        BorderPane.setAlignment(circle, Pos.CENTER);
        bp.setBottom(circle);
        super.getChildren().add(bp);
    }
}
