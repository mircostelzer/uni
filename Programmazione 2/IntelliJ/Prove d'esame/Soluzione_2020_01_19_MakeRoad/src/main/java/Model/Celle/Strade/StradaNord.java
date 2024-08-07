package Model.Celle.Strade;

import Controller.MainGUI;
import Model.Celle.Strada;
import Model.Utils.Coordinate;
import javafx.geometry.Pos;
import javafx.scene.layout.BorderPane;
import javafx.scene.shape.Circle;

/**
 * La classe StradaNord estende Strada e rappresenta una cella di strada orientata verso nord.
 */
public class StradaNord extends Strada {

    /**
     * Costruisce una nuova istanza di StradaNord con il colore predefinito.
     *
     * @param mg L'oggetto MainGUI associato.
     * @param coordinate La coordinata della cella nella griglia.
     */
    public StradaNord(MainGUI mg, Coordinate coordinate) {
        super(mg, coordinate);
    }

    /**
     * Aggiunge un cerchio alla parte superiore della cella per indicare la direzione nord.
     * Utilizza un BorderPane per posizionare il cerchio al centro del bordo superiore.
     */
    @Override
    public void aggiungiDirezione() {
        BorderPane bp = new BorderPane();
        Circle circle = getCerchio();
        BorderPane.setAlignment(circle, Pos.CENTER);
        bp.setTop(circle);
        super.getChildren().add(bp);
    }
}
