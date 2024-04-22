package Main;

import Utils.MapCoordinates;
import visual.MainGui;

import java.util.Scanner;

public class Main {
    private static final int INTERACTIONS = 6;

    public static void main(String[] args){
//         change_at_coords();
//         test_gravity();
        test_smelting();
    }

    private static void change_at_coords(){
        MainGui m = new MainGui();
        m.display_on_out();
        for (int i = 0 ; i < INTERACTIONS ; i++){
            System.out.print("Enter row: ");
            Scanner myObj = new Scanner(System.in);
            int row = myObj.nextInt();

            System.out.print("Enter column: ");
            int col = myObj.nextInt();

            MapCoordinates c = new MapCoordinates(row,col);
            System.out.println("Setting Sand for: "+c.toString()+" - attention, it may fall");
            m.change_cell_with_Sand(c);

            m.display_on_out();
        }
    }
    private static void test_gravity(){
        MainGui m = new MainGui(false);
        m.display_on_out();
        for (int i = 0 ; i < INTERACTIONS ; i++){
            System.out.print("Enter column where to drop a block: ");
            Scanner myObj = new Scanner(System.in);
            int col = myObj.nextInt();

            System.out.println("Dropping a new block in column: "+col);
            MapCoordinates c = new MapCoordinates(0,col);
            m.change_cell_with_Sand(c);

            m.display_on_out();
        }
    }
    private static void test_smelting(){
        MainGui m = new MainGui();
        m.display_on_out();
        for (int i = 0 ; i < INTERACTIONS ; i++){
            System.out.print("Enter row and then column, or enter '9' and then '9' for smelting: ");
            Scanner myObj = new Scanner(System.in);
            int row = myObj.nextInt();
            int col = myObj.nextInt();
            if (row == 9 && col == 9){
                m.smelt();
            }else{
                MapCoordinates c = new MapCoordinates(row,col);
                m.move_into_furnace(c);
            }
            m.display_on_out();
        }
    }
}
