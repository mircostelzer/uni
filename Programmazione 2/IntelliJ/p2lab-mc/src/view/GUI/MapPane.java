package view.GUI;

import data.BlockFactory;
import data.blocks.interfaces.Block;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import utils.MapCoordinates;
import view.GUI.clickablePanes.ClickableExternalBlockPane;
import view.GUI.handlers.BlockPaneClickHandlerFactory;

public class MapPane extends GridPane {
    private BlockPaneClickHandlerFactory bcphf;

    public MapPane(BlockPaneClickHandlerFactory bcphf){
        super();
        this.bcphf = bcphf;
        initialise_air();
    }

    public void initialise_air(){
        for(int i = 0 ; i < MapCoordinates.DIMENSION_ROWS ; i++){
            for (int k = 0 ; k < MapCoordinates.DIMENSION_COLUMNS ; k++){
                MapCoordinates c = new MapCoordinates(i,k);
                this.setCell(c,new BlockFactory().default_block());
            }
        }
    }

    public BlockPane getBlockAtCoord(MapCoordinates c){
        if (!c.is_inbound()){
            return null;
        }
        int row = c.getRow();
        int col = c.getCol();
        return (BlockPane) MapPane.getElementAt(this,row,col);
    }

    public void setCell(MapCoordinates c, Block b){
        BlockPane toremove = this.getBlockAtCoord(c);
        if (toremove == null){
            EventHandler<MouseEvent> eh =  this.bcphf.createNewPickUpHandler(c);
            super.add(new ClickableExternalBlockPane(b,eh), c.getCol(), c.getRow());
        }else {
            toremove.changeBlock(b);
        }
//        System.err.println("Re-printed cell "+c);
    }

    public static Node getElementAt(GridPane gp, int i, int j) {
        for (Node x :gp. getChildren()) {
            if ((GridPane.getRowIndex(x) == i) && (GridPane.getColumnIndex(x) == j)) {
                return x;
            }
        }
        return null;
    }
}
