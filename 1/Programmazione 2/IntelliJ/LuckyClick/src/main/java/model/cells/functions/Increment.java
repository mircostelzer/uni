package model.cells.functions;

import model.Player;
import model.cells.BaseCell;

public class Increment implements MyConsumer<Player>{
    private BaseCell cell;

    public Increment(BaseCell cell) {
        this.cell = cell;
    }

    @Override
    public void accept(Player p) {
        p.setPoints(p.getPoints() + cell.getValue());
    }
}
