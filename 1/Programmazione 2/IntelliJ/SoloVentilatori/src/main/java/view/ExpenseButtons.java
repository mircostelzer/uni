package view;

import controller.Controller;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import model.User;

public class ExpenseButtons extends VBox {
    private Button nextMonthButton;
    private Button addCapitalButton;
    private Controller controller;

    public ExpenseButtons(Controller controller) {
        nextMonthButton = new Button("Prox. Mese");
        addCapitalButton = new Button("+100 fondi");
        getChildren().addAll(nextMonthButton, addCapitalButton);
        this.controller = controller;

        nextMonthButton.setOnMouseClicked(e -> {
            this.controller.advanceMonth();
        });

        addCapitalButton.setOnMouseClicked(e -> {
            this.controller.addToCapital(100);
        });
    }
}
