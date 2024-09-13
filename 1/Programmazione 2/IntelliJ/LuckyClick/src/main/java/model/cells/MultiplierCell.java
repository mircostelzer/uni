package model.cells;

import model.Player;
import model.cells.functions.Multiply;
import model.cells.functions.MyConsumer;
import model.cells.functions.PlayerSideEffect;

public class MultiplierCell extends AbstractCell implements PlayerSideEffect {

    public MultiplierCell() {
        super();
        this.cellType = CellType.Multiplier;
        this.content = "x2";
    }

    @Override
    public MyConsumer<Player> reveal() {
        this.isActive = true;
        return new Multiply();
    }
}
