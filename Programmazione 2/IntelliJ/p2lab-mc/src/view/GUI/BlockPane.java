package view.GUI;

import data.blocks.interfaces.Block;
import data.blocks.utils.BlockComparator;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Tooltip;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

public class BlockPane extends StackPane {
    private Rectangle sfondo;
    private Text testo;

    public static final int DIM_SQUARE = 50;
    private static final String FONT_NAME = "Verdana";
    private static final int FONT_SIZE = 18;
    private static final FontWeight FONT_WEIGHT = FontWeight.BOLD;
    private static final Color BLOCK_BORDER = Color.BLACK;
    private static final Color FONT_FILL = Color.BLACK;
    private static final Color FONT_BORDER = Color.BLACK;

    private Block b;

    public BlockPane(Block bb){
        super();
        b = bb;
        initialise();
    }

    private void initialise(){
        sfondo = new Rectangle(DIM_SQUARE,DIM_SQUARE);
        sfondo.setFill(this.chooseColorFromBlock(b));
        sfondo.setStroke(BLOCK_BORDER);
        testo = new Text(""+b.display());
        testo.setFont(Font.font(FONT_NAME, FONT_WEIGHT, FONT_SIZE));
        testo.setFill(FONT_FILL);
        testo.setStroke(FONT_BORDER);
        super.getChildren().addAll(sfondo,testo);
        super.setAlignment(Pos.CENTER);
        Tooltip t = new Tooltip(b.toString());
        Tooltip.install(this,t);
    }

    public void changeBlock(Block bb){
        this.b = bb;
        this.initialise();
    }

    private Color chooseColorFromBlock(Block b){
        int int_of_block = BlockComparator.get_value_of_block(b);
        Color ret = null;
        switch (int_of_block){
            case 0:
                ret = Color.BLACK;
                break;
            case 1:
                ret = Color.WHITE;
                break;
            case 2:
                ret = Color.AQUA;
                break;
            case 3:
                ret = Color.GREEN;
                break;
            case 4:
                ret = Color.BEIGE;
                break;
            case 5:
                ret = Color.AZURE;
                break;
            case 6:
                ret = Color.DARKGRAY;
                break;
            case 7:
                ret = Color.SILVER;
                break;
        }
        return ret;
    }
}

