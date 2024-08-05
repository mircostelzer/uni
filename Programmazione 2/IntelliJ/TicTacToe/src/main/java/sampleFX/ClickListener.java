package sampleFX;

import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class ClickListener implements EventHandler<MouseEvent> {
    private Controller controller;
    private int x;
    private int y;

    public ClickListener(Controller controller, int x, int y) {
        this.controller = controller;
        this.x = x;
        this.y = y;
    }
    @Override
    public void handle(MouseEvent mouseEvent) {
        this.controller.move(this.x, this.y, "X");
//        try {
//            this.controller.wait(10000);
//        }
//        catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        if (!this.controller.isGameOver()) {
            this.controller.computer();
        }
        else {
            Stage winStage = new Stage();
            StackPane root = new StackPane();
            Scene winScene = new Scene(root, 200, 150);
            Text text = new Text("You won!");
            text.setFont(Font.font("VERDANA", 20));
            root.getChildren().add(text);
            winStage.setScene(winScene);
            winStage.show();
        }
    }
}
