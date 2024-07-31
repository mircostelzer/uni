package view.textual;

import utils.MapCoordinates;

public class MainPrinter implements TextPrinter{
    MapPrinter m;
    FurnacePrinter f;
    InventoryPrinter i;

    public MainPrinter(){}

    public void update(MapPrinter m, FurnacePrinter f, InventoryPrinter i){
        this.m = m;
        this.f = f;
        this.i = i;
    }

    public void display_on_out(){
        print_headerfooter();
        print_map_columns();
        m.display_on_out();
        print_separator();
        f.display_on_out();
        print_separator();
        i.display_on_out();
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
}
