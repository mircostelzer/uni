package Model.Celle.Strade;

import Controller.MainGUI;
import Model.Celle.Strada;
import Model.Utils.Coordinate;
import javafx.geometry.Pos;
import javafx.scene.layout.BorderPane;
import javafx.scene.shape.Circle;

/**
 * La classe StradaOvest estende Strada e rappresenta una cella di strada orientata verso ovest.
 */
public class StradaOvest extends Strada {

    /**
     * Costruisce una nuova istanza di StradaOvest con il colore predefinito.
     *
     * @param mg L'oggetto MainGUI associato.
     * @param coordinate La coordinata della cella nella griglia.
     */
    public StradaOvest(MainGUI mg, Coordinate coordinate) {
        super(mg, coordinate);
    }

    /**
     * Aggiunge un cerchio alla parte sinistra della cella per indicare la direzione ovest.
     * Utilizza un BorderPane per posizionare il cerchio al centro del bordo sinistro.
     */
    @Override
    public void aggiungiDirezione() {
        BorderPane bp = new BorderPane();
        Circle circle = getCerchio();
        BorderPane.setAlignment(circle, Pos.CENTER);
        bp.setLeft(circle);
        super.getChildren().add(bp);
    }
}
