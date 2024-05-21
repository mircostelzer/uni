package visual.GUI;

import data.BlockFactory;
import javafx.scene.layout.VBox;
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
    }

    private void addText() {
        Text text = new Text("Furnace");
        super.getChildren().add(text);
    }

    private void addArrow() {
        Text arrow = new Text("-->");
        super.getChildren().add(arrow);
    }
}