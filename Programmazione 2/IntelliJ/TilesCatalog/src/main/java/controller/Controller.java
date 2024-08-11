package controller;

import javafx.scene.Scene;
import javafx.scene.paint.Color;
import model.MultiBiColorInterface;
import model.MultiColorTileInterface;
import view.MainGui;
import model.tiles.*;
import view.TilesPane;

import java.util.*;

public class Controller {
    private MainGui mainGui;
    private List<TileInterface> tiles;
    public static final ArrayList<Color> colorRotation = new ArrayList<>();
    public static int PRIMARY_COLOR_INDEX = 0;
    public static int SECONDARY_COLOR_INDEX = 1;
    public static int GENERAL_INDEX = 0;


    public Controller() {
        colorRotation.add(Color.BROWN);
        colorRotation.add(Color.WHEAT);
        colorRotation.add(Color.TEAL);
        colorRotation.add(Color.DARKBLUE);
        colorRotation.add(Color.OLIVE);
        colorRotation.add(Color.GOLD);
        tiles = new LinkedList<>();
        tiles.add(new P1Tile(colorRotation.get(0)));
        tiles.add(new P2Tile(colorRotation.get(0)));
        tiles.add(new P3Tile(colorRotation.get(0)));
        tiles.add(new B1Tile(colorRotation.get(0), colorRotation.get(1)));
        tiles.add(new B2Tile(colorRotation.get(0), colorRotation.get(1)));
        tiles.add(new B3Tile(colorRotation.get(0), colorRotation.get(1)));
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

    public void incrementPrimaryColorIndex() {
        if (PRIMARY_COLOR_INDEX < colorRotation.size()-1) {
            PRIMARY_COLOR_INDEX++;
        } else {
            PRIMARY_COLOR_INDEX = 0;
        }
    }

    public void incrementSecondaryColorIndex() {
        if (SECONDARY_COLOR_INDEX < colorRotation.size()-1) {
            SECONDARY_COLOR_INDEX++;
        } else {
            SECONDARY_COLOR_INDEX = 0;
        }
    }

    public void changeView(TileInterface tile) {
        mainGui.setContent(tile);
        mainGui.redraw();
        PRIMARY_COLOR_INDEX = 0;
        SECONDARY_COLOR_INDEX = 1;
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
