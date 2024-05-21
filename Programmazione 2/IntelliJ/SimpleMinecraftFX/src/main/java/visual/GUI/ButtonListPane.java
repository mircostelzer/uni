package visual.GUI;

import javafx.scene.control.Button;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.VBox;

public class ButtonListPane extends VBox {
    private Button button;

    public ButtonListPane() {
        super();
        this.button = new Button();
        this.button.setOnKeyPressed((KeyEvent event) -> {});
        this.getChildren().add(this.button);
    }
}
