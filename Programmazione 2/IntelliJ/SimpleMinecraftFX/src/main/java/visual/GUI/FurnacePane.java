package visual.GUI;

import controllers.MainSimpleController;
import data.BlockFactory;
import javafx.geometry.Pos;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class FurnacePane extends VBox {
    private FurnaceBlockPane input;
    private FurnaceBlockPane output;
    private MainSimpleController mainController;

    public FurnacePane(MainSimpleController mainController) {
        super();
        this.mainController = mainController;
        this.addText();
        this.setInput(new FurnaceBlockPane(new BlockFactory().nullBlock(), mainController));
        this.addArrow();
        this.setOutput(new FurnaceBlockPane(new BlockFactory().nullBlock(), mainController));
        this.setAlignment(Pos.TOP_CENTER);
        this.setSpacing(10);
    }

    public void setInput(FurnaceBlockPane b) {
        this.input = b;
        super.getChildren().add(this.input);
    }

    public void setOutput(FurnaceBlockPane b) {
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