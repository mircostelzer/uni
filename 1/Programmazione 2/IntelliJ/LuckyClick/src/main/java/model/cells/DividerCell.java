package model.cells;

import model.Player;
import model.cells.functions.Divide;
import model.cells.functions.MyConsumer;
import model.cells.functions.PlayerSideEffect;

public class DividerCell extends AbstractCell implements PlayerSideEffect {

    public DividerCell() {
        super();
        this.cellType = CellType.Divider;
        this.content = "/2";
    }

    @Override
    public MyConsumer<Player> reveal() {
        this.isActive = true;
        return new Divide();
    }
}
