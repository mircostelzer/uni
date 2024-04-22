package visual;

import Utils.MapCoordinates;
import data.BlockFactory;

public class MainGui {
    private Map m ;
    private Furnace f;
    private BlockFactory bf;

    public MainGui(){
        this(true);
    }
    public MainGui(boolean random){
        bf = new BlockFactory();
        m = new Map(bf,random);
        f = new Furnace(bf);
    }

    public void display_on_out(){
        print_headerfooter();
        print_map_columns();
        m.display_on_out();
        print_separator();
        f.display_on_out();
        print_separator();
        print_headerfooter();
    }

    private static void print_headerfooter() {
        for (int i = 0; i < MapCoordinates.DIMENSION_COLUMNS+4 ; i ++ ){
            System.out.print("_");
        }
        System.out.println();
    }
    private static void print_separator() {
        System.out.print("|");
        for (int i = 0; i < MapCoordinates.DIMENSION_COLUMNS+2 ; i ++ ){
            System.out.print("=");
        }
        System.out.print("|");
        System.out.println();
    }
    private static void print_map_columns(){
        System.out.print("||");
        for (int i = 0; i < MapCoordinates.DIMENSION_COLUMNS ; i++){
            System.out.print(i);
        }
        System.out.print("||");
        System.out.println();
    }

    public void change_cell_with_Sand(MapCoordinates c){
        m.change_cell_with_Sand(c);
    }

    public void smelt(){
        f.smelt();
    }
    public void move_into_furnace(MapCoordinates c){f.move_into_furnace(c, m);
    }

}
