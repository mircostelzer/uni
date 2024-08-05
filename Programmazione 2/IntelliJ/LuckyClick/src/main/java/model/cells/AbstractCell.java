package model.cells;

import model.Player;
import model.cells.functions.MyConsumer;

public abstract class AbstractCell {
    protected CellType cellType;
    protected String content;
    protected boolean isActive = false;

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public String getContent() {
        return content;
    }

    public CellType getCellType() {
        return cellType;
    }
}
