package main;

import utils.MapCoordinates;
import visual.textual.MainUI;

import java.util.Scanner;

public class Main {
    private static final int INTERACTIONS = 10;

    public static void main(String[] args){
//         change_at_coords();
//         test_gravity();
//        test_smelting();
        test_picking();
    }

    private static void change_at_coords(){
        MainUI m = new MainUI();
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
        MainUI m = new MainUI(false);
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
        MainUI m = new MainUI();
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
                m.move_into_furnace_from_map(c);
            }
            m.display_on_out();
        }
    }
    private static void test_picking(){
        MainUI m = new MainUI();
        m.display_on_out();
        for (int i = 0 ; i < INTERACTIONS ; i++){
            System.out.println("Enter row and then column to pick that block");
            System.out.println("Enter '9' and the item number to move the item to the furnace");
            System.out.println("Enter '99' and then '9' to smelt");
            System.out.println("Enter '99' and then '0' to toggle the inventory sorting");
            System.out.println("Enter '99' and then any number to take from the furnace into the inventory");
            Scanner myObj = new Scanner(System.in);
            int row = myObj.nextInt();
            int col = myObj.nextInt();
            if (row == 9){
                m.move_into_furnace_from_inventory(col);
            }else if( row == 99 ){
                if (col == 9) {
                    m.smelt();
                }else if (col == 0){
                    m.toggle_inventory_comparator();
                }else {
                    m.move_into_inventory_from_furnace();
                }
            } else{
                MapCoordinates c = new MapCoordinates(row,col);
                m.pick_up_block(c);
            }
            m.display_on_out();
        }
    }
}
