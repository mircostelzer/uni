package Model.Celle.Strade;

import Controller.MainGUI;
import Model.Celle.Strada;
import Model.Utils.Coordinate;
import javafx.geometry.Pos;
import javafx.scene.layout.BorderPane;
import javafx.scene.shape.Circle;

/**
 * La classe StradaEst estende Strada e rappresenta una cella di strada orientata verso est.
 */
public class StradaEst extends Strada {

    /**
     * Costruisce una nuova istanza di StradaEst con il colore predefinito.
     *
     * @param mg L'oggetto MainGUI associato.
     * @param coordinate La coordinata della cella nella griglia.
     */
    public StradaEst(MainGUI mg, Coordinate coordinate) {
        super(mg, coordinate);
    }

    /**
     * Aggiunge un cerchio alla parte destra della cella per indicare la direzione est.
     * Utilizza un BorderPane per posizionare il cerchio al centro del bordo destro.
     */
    @Override
    public void aggiungiDirezione() {
        BorderPane bp = new BorderPane();
        Circle circle = getCerchio();
        BorderPane.setAlignment(circle, Pos.CENTER);
        bp.setRight(circle);
        super.getChildren().add(bp);
    }
}
