package sampleFX;

import Utils.Coordinates;
import controllers.text.MainTextController;
import visual.textual.MainView;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        test_picking();
    }

    private static void test_picking(){
        MainView view = new MainView();
        MainTextController m = new MainTextController(view);
        m.update_and_display();
        for (int i = 0 ; i < 5 ; i++){
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
                Coordinates c = new Coordinates(row,col);
                m.pick_up_block(c);
            }
            m.update_and_display();
        }
    }
}
