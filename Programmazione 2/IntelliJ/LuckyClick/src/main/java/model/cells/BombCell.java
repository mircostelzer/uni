package model.cells;

import model.Grid;
import model.Player;
import model.cells.functions.MyConsumer;

public class BombCell extends AbstractCell {

    public BombCell() {
        super();
        this.cellType = CellType.Bomb;
        this.content = "BOOM!";
    }
}
