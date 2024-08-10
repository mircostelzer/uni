package controller;

import view.MainGui;
import model.tiles.*;

import java.util.HashSet;
import java.util.Set;

public class Controller {
    private MainGui mainGui;
    private Set<TileInterface> tiles;
    private static int GENERAL_INDEX = 0;

    public Controller(MainGui mainGui) {
        this.mainGui = mainGui;
        tiles = new HashSet<>();
        tiles.add(new P1Tile());
        tiles.add(new P2Tile());
        tiles.add(new P3Tile());
        tiles.add(new B1Tile());
        tiles.add(new B2Tile());
        tiles.add(new B3Tile());
    }




}
