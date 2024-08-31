package view;

import controller.RicetteClickHandler;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import model.Ricetta;

import java.util.List;

public class RicettePane extends VBox {
    private List<Ricetta> ricette;
    private MainGui mainGui;

    public RicettePane(List<Ricetta> ricette, MainGui mainGui) {
        this.ricette = ricette;
        this.mainGui = mainGui;
        this.setSpacing(10);
        this.refresh();
    }

    public void refresh() {
        this.getChildren().clear();
        for (Ricetta ricetta : ricette) {
            Button button = new Button(ricetta.toString());
            if (ricetta.isSelected() || ricetta.getExpirationDate().isExpired()) {
                button.setDisable(true);
            }
            button.setOnMouseClicked(new RicetteClickHandler(mainGui, ricetta));
            this.getChildren().add(button);
        }
    }
}
