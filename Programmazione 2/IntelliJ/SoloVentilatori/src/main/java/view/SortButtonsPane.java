package view;

import controller.Controller;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import model.comparators.PriceComparator;
import model.comparators.TypeComparator;

public class SortButtonsPane extends VBox {
    private Button sortByType;
    private Button sortByPrice;
    private Controller controller;

    public SortButtonsPane(Controller controller) {
        sortByType = new Button("Ordina per tipo");
        sortByPrice = new Button("Ordina per costo");
        this.getChildren().addAll(sortByType, sortByPrice);
        this.controller = controller;

        sortByType.setOnMouseClicked(mouseEvent -> {
            this.controller.toggleComparator(new TypeComparator());
        });

        sortByPrice.setOnMouseClicked(mouseEvent -> {
            this.controller.toggleComparator(new PriceComparator());
        });
    }
}
