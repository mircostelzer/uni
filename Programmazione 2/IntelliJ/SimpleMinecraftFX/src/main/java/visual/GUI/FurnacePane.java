package visual.GUI;

import data.BlockFactory;
import javafx.geometry.Pos;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class FurnacePane extends VBox {
    private BlockPane input;
    private BlockPane output;

    public FurnacePane() {
        super();
        this.addText();
        this.input = new BlockPane(new BlockFactory().nullBlock());
        super.getChildren().add(this.input);
        this.addArrow();
        this.output = new BlockPane(new BlockFactory().nullBlock());
        super.getChildren().addAll(this.output);

        this.setAlignment(Pos.TOP_CENTER);
        this.setSpacing(10);
    }

    private void addText() {
        Text text = new Text("Furnace");
        super.getChildren().add(text);
    }

    private void addArrow() {
        Text arrow = new Text("-->");
        arrow.setRotate(90);
        super.getChildren().add(arrow);
    }
}