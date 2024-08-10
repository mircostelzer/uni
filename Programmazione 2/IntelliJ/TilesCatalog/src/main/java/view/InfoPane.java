package view;

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

    public InfoPane() {
        super();
        this.setSpacing(10);
        info = new VBox();
        buttons = new HBox();
        prev = new Button("Prev");
        next = new Button("Next");
        this.redraw();
    }

    public void redraw() {
        this.getChildren().clear();
        info.getChildren().clear();
        Text code = new Text("Codice: "+this.content.getCode());
        Text price = new Text("Materiale: "+this.content.getPrice());
        Text dimension = new Text("Dimensione: "+this.content.getDimension());
        Text colorChoice = new Text();
        if (content instanceof MultiColorTileInterface) {
            colorChoice.setText("SI");
        }
        else {
            colorChoice.setText("NO");
        }

        this.info.getChildren().addAll(code, price, dimension, colorChoice);
        this.getChildren().addAll(info, buttons);
    }

    public void setContent(TileInterface content) {
        this.content = content;
    }
}
