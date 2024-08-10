package view;

import controller.Controller;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import model.MultiColorTileInterface;
import model.tiles.TileInterface;

public class InfoPane extends VBox {
    private VBox info;
    private HBox buttons;
    private Button prev;
    private Button next;
    private TileInterface content;
    private Controller controller;

    public InfoPane(Controller controller) {
        super();
        this.controller = controller;
        this.setSpacing(40);
        info = new VBox();
        buttons = new HBox();
        prev = new Button("<prev");
        prev.setDisable(true);
        next = new Button("next>");
        buttons.getChildren().addAll(prev, next);
        this.content = this.controller.getTiles().stream().toList().get(0);
        this.redraw();

        prev.setOnMouseClicked(mouseEvent -> {
            if (Controller.GENERAL_INDEX == 1) {
                prev.setDisable(true);
            }
            if (Controller.GENERAL_INDEX == this.controller.getSetSize()-1) {
                next.setDisable(false);
            }
            this.controller.decrementIndex();
            this.controller.changeView(this.controller.getTiles().stream().toList().get(Controller.GENERAL_INDEX));
        });

        next.setOnMouseClicked(mouseEvent -> {
            if (Controller.GENERAL_INDEX == this.controller.getSetSize()-2) {
                next.setDisable(true);
            }
            if (Controller.GENERAL_INDEX == 0) {
                prev.setDisable(false);
            }
            this.controller.incrementIndex();
            this.controller.changeView(this.controller.getTiles().stream().toList().get(Controller.GENERAL_INDEX));
        });
    }

    public void redraw() {
        this.getChildren().clear();
        info.getChildren().clear();
        Text code = new Text("Codice: "+this.content.getCode());
        Text price = new Text("Materiale: "+this.content.getPrice());
        Text dimension = new Text("Dimensione: "+this.content.getDimension());
        Text colorChoice = new Text();
        if (content instanceof MultiColorTileInterface) {
            colorChoice.setText("Scelta colore: SI");
        }
        else {
            colorChoice.setText("Scelta colore: NO");
        }

        this.info.getChildren().addAll(code, price, dimension, colorChoice);
        this.getChildren().addAll(info, buttons);
    }

    public void setContent(TileInterface content) {
        this.content = content;
    }
}
