package GUI;

import data.blocks.SandBlock;
import data.blocks.WaterBlock;
import data.blocks.interfaces.Block;
import data.blocks.solids.GlassBlock;
import data.blocks.solids.RawIronBlock;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

public class BlockPane extends StackPane {
    private Block content;
    private Rectangle rectangle;
    private Text text;

    public static final int DIM_SQUARE = 50;
    private static final String FONT_NAME = "Verdana";
    private static final int FONT_SIZE = 18;
    private static final FontWeight FONT_WEIGHT = FontWeight.BOLD;
    private static final Color BLOCK_BORDER = Color.BLACK;
    private static final Color FONT_FILL = Color.BLACK;
    private static final Color FONT_BORDER = Color.BLACK;

    public BlockPane(Block b) {
        super();
        this.content = b;
        this.intialise();
        this.getChildren().addAll(rectangle, text);
    }

    private void intialise() {
        this.rectangle = new Rectangle();
        this.rectangle.setHeight(DIM_SQUARE);
        this.rectangle.setWidth(DIM_SQUARE);
        this.rectangle.setStroke(BLOCK_BORDER);
        this.rectangle.setFill(this.blockColor(this.content));
        this.text = new Text(""+this.content.display()+"");
        this.text.setFill(FONT_FILL);
        this.text.setFont(Font.font(FONT_NAME, FONT_WEIGHT, FONT_SIZE));
        this.text.setStroke(FONT_BORDER);
    }

    private Color blockColor(Block b) {
        if (this.content instanceof SandBlock) {
            return Color.SANDYBROWN;
        }
        else if (this.content instanceof GlassBlock) {
            return Color.AZURE;
        }
        else if (this.content instanceof WaterBlock) {
            return Color.AQUA;
        }
        else if (this.content instanceof RawIronBlock) {
            return Color.GRAY;
        }
        else {
            return Color.WHITE;
        }
    }

    public void changeBlock(Block b) {
        this.content = b;
        intialise();
    }

}
