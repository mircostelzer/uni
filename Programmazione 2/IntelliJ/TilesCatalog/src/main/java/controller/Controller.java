package controller;

import view.InfoPane;
import view.MainGui;
import model.tiles.*;
import view.TilesPane;

import java.util.*;

public class Controller {
    private MainGui mainGui;
    private List<TileInterface> tiles;
    public static int GENERAL_INDEX = 0;

    public Controller() {
        tiles = new LinkedList<>();
        tiles.add(new P1Tile());
        tiles.add(new P2Tile());
        tiles.add(new P3Tile());
        tiles.add(new B1Tile());
        tiles.add(new B2Tile());
        tiles.add(new B3Tile());
        this.mainGui = new MainGui(this);
    }

    public void incrementIndex() {
        if (GENERAL_INDEX < tiles.size()) {
            GENERAL_INDEX++;
        }
    }

    public void decrementIndex() {
        if (GENERAL_INDEX > 0) {
            GENERAL_INDEX--;
        }
    }

    public void changeView(TileInterface tile) {
        mainGui.setContent(tile);
        mainGui.redraw();
    }

    public int getSetSize() {
        return tiles.size();
    }

    public List<TileInterface> getTiles() {
        return tiles;
    }

    public MainGui getMainGui() {
        return mainGui;
    }
}
