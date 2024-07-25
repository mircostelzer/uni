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
        this.setInput(new BlockPane(new BlockFactory().nullBlock()));
        this.addArrow();
        this.setOutput(new BlockPane(new BlockFactory().nullBlock()));
        this.setAlignment(Pos.TOP_CENTER);
        this.setSpacing(10);
    }

    public void setInput(BlockPane b) {
        this.input = b;
        super.getChildren().add(this.input);
    }

    public void setOutput(BlockPane b) {
        this.output = b;
        super.getChildren().addAll(this.output);
    }

    public void addText() {
        Text text = new Text("Furnace");
        super.getChildren().add(text);
    }

    public void addArrow() {
        Text arrow = new Text("-->");
        arrow.setRotate(90);
        super.getChildren().add(arrow);
    }
}