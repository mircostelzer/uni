package model.cells;

import model.Player;
import model.cells.functions.Increment;
import model.cells.functions.MyConsumer;
import model.cells.functions.PlayerSideEffect;

public class BaseCell extends AbstractCell implements PlayerSideEffect {
    private int value;

    public BaseCell(int v) {
        super();
        this.value = v;
        this.content = ""+value;
        this.cellType = CellType.Base;
    }

    public MyConsumer<Player> reveal() {
        this.isActive = true;
        return new Increment(this);
    }

    public int getValue() {
        return value;
    }
}
