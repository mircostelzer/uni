package View;

import Controller.Bottoni;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

/**
 * Classe che rappresenta il pannello superiore dell'interfaccia grafica.
 * Estende la classe javafx.scene.layout.StackPane.
 */
public class TopPane extends StackPane {
    /**
     * Costruttore della classe TopPane.
     * Costruisce il pannello superiore con i pulsanti e le relative azioni.
     *
     * @param bottoni Oggetto Bottoni che gestisce i pulsanti.
     */
    public TopPane(Bottoni bottoni) {
        super();
        Rectangle rectangle = new Rectangle(500, 50);
        rectangle.setFill(Color.CADETBLUE);
        rectangle.setStroke(Color.DARKGREEN);

        bottoni.getTutti().setDisable(true);
        HBox hbLeft = new HBox(bottoni.getTutti(), bottoni.getStudenti(), bottoni.getAtleti());
        hbLeft.setSpacing(10);

        bottoni.getPerNome().setDisable(true);
        HBox hbRight = new HBox(bottoni.getPerNome(), bottoni.getPerEta());
        hbRight.setSpacing(10);

        AnchorPane ap = new AnchorPane(hbLeft, hbRight);

        AnchorPane.setTopAnchor(hbLeft, 13.0);
        AnchorPane.setLeftAnchor(hbLeft, 10.0);

        AnchorPane.setTopAnchor(hbRight, 13.0);
        AnchorPane.setRightAnchor(hbRight, 10.0);

        super.getChildren().addAll(rectangle, ap);
    }
}
