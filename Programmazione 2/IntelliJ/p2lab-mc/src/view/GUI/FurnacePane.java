package view.GUI;

import data.BlockFactory;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

public class FurnacePane extends VBox {
    BlockPane input;
    BlockPane output;

    public FurnacePane(){
        super();
        addText();
        input = new BlockPane(new BlockFactory().nullBlock());
        super.getChildren().add(input);
        addArrow();
        output = new BlockPane(new BlockFactory().nullBlock());
        super.getChildren().add(output);
    }
    public void addText(){
        Text f = new Text("Furnace");
        super.getChildren().add(f);
    }
    public void addArrow(){
        Text f = new Text("-->");
        super.getChildren().add(f);
    }
}
