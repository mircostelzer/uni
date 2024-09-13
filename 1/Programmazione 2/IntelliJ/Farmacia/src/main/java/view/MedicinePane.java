package view;

import controller.MedicineClickHandler;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import model.Farmacia;
import model.Medicina;

public class MedicinePane extends VBox {

    public MedicinePane(Farmacia farmacia, MainGui mainGui) {
        this.setSpacing(10);
        for (Medicina m : farmacia) {
            Text text = new Text(m.toString());
            text.setFont(new Font(11));
            text.setTextAlignment(TextAlignment.JUSTIFY);
            this.getChildren().add(text);
            text.setOnMouseClicked(new MedicineClickHandler(m, mainGui));
        }

    }

}
