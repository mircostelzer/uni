package View;

import Model.Cella;
import Model.Celle.CellaBase;
import Model.Celle.CellaBoom;
import Model.Celle.CellaDivisore;
import Model.Celle.CellaMoltiplicatore;
import Model.Coordinate;
import Controller.MainGUI;
import javafx.scene.Node;
import javafx.scene.layout.GridPane;

import java.util.ArrayList;
import java.util.Random;

/**
 * La classe CellePane rappresenta il pannello contenente le celle del gioco.
 * Gestisce la creazione e il riempimento della griglia di celle.
 */
public class CellePane extends GridPane {

    /**
     * Costruttore per la classe CellePane.
     *
     * @param mg Il controller principale dell'applicazione
     */
    public CellePane(MainGUI mg) {
        super();
        riempiGriglia(mg);
    }

    /**
     * Riempie la griglia con le celle del gioco.
     * 75 Base, 10 Molt, 10 Div, 5 Boom disposte casualmente nella griglia.
     *
     * @param mg Il controller principale dell'applicazione
     */
    private void riempiGriglia(MainGUI mg){
        ArrayList<Cella> celle = new ArrayList<>();
        for(int i = 0; i < 100; i++){
            if(i < 75)
                celle.add(i, new CellaBase(mg));
            else if(i < 85)
                celle.add(i, new CellaDivisore(mg));
            else if(i < 95)
                celle.add(i, new CellaMoltiplicatore(mg));
            else
                celle.add(i, new CellaBoom(mg));
        }

        Random r = new Random();
        int bound = 100;

        for(int i = 0; i < 10; i++){
            for (int j = 0; j < 10; j++) {
                int randomIndex = r.nextInt(bound);
                Cella c = celle.get(randomIndex);

                if(c instanceof CellaBoom)
                    ((CellaBoom) c).setC(new Coordinate(i, j));

                celle.remove(randomIndex);
                super.add(c, j, i);
                bound--;
                //System.out.print(c.getContenuto() + " ");
            }
            //System.out.println();
        }
    }

    /**
     * Restituisce l'elemento della griglia alla posizione specificata.
     *
     * @param y La coordinata y della cella
     * @param x La coordinata x della cella
     * @return L'elemento della griglia alla posizione specificata
     */
    public Node getElementAt(int y, int x) {
        Node result = null;
        for (Node node : getChildren()) {
            if (GridPane.getRowIndex(node) == y && GridPane.getColumnIndex(node) == x) {
                result = node;
                break;
            }
        }
        return result;
    }
}
