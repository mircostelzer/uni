package view;

import controller.Controller;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import model.comparators.NameComparator;
import model.comparators.TypeComparator;
import model.comparators.YearComparator;

public class SortButtonsPane extends VBox {
    private Text text;
    private Button nameButton;
    private Button yearButton;
    private Button typeButton;
    private Controller controller;

    public SortButtonsPane(Controller controller) {
        this.controller = controller;
        text = new Text("Ordina per:");
        nameButton = new Button("Nome");
        yearButton = new Button("Anno");
        typeButton = new Button("Tipo");
        this.setSpacing(10);
        this.setButtons();
        this.getChildren().addAll(text, nameButton, yearButton, typeButton);
    }

    private void setButtons() {
        nameButton.setOnMouseClicked(e -> {
            controller.toggleComparator(new NameComparator());
        });

        yearButton.setOnMouseClicked(e -> {
            controller.toggleComparator(new YearComparator());
        });

        typeButton.setOnMouseClicked(e -> {
            controller.toggleComparator(new TypeComparator());
        });
    }
}
