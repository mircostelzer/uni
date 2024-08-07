package Model;

import Controller.MainGUI;
import Model.Tessere.TesseraP;
import Model.Tessere.TesseraS;
import Model.Tessere.TesseraV;
import org.example.soluzione_2019_01_18.MainFX;

import java.util.ArrayList;
import java.util.Random;

/**
 * Rappresenta la griglia di gioco contenente le tessere.
 */
public class Griglia {
    private Tessera[][] griglia;

    /**
     * Costruttore della griglia di gioco.
     *
     * @param mg MainGUI a cui la griglia appartiene.
     */
    public Griglia(MainGUI mg) {
        griglia = creaGriglia(mg);
    }

    /**
     * Restituisce la griglia di gioco.
     *
     * @return La griglia di gioco.
     */
    public Tessera[][] getGriglia() {
        return griglia;
    }

    /**
     * Imposta la griglia di gioco.
     *
     * @param griglia La griglia di gioco da impostare.
     */
    public void setGriglia(Tessera[][] griglia) {
        this.griglia = griglia;
    }

    /**
     * Crea una nuova griglia di gioco.
     *
     * @param mg MainGUI a cui la griglia appartiene.
     * @return La nuova griglia di gioco.
     */
    public Tessera[][] creaGriglia(MainGUI mg){
        System.out.println("CREO UNA NUOVA GRIGLIA DI GIOCO");
        Tessera[][] griglia = new Tessera[MainFX.getLATO()][MainFX.getLATO()];
        ArrayList<Tessera> tessere = new ArrayList<>();

        for (int i = 0; i < (MainFX.getLATO()*MainFX.getLATO()) - 2; i++) {
            tessere.add(new TesseraS(mg));
        }
        tessere.add(new TesseraP(mg));
        tessere.add(new TesseraV(mg));
        Random r = new Random();

        for (int i = 0; i < MainFX.getLATO(); i++) {
            for (int j = 0; j < MainFX.getLATO(); j++) {
                int index = r.nextInt(tessere.size());
                Tessera t = tessere.get(index);
                tessere.remove(index);
                griglia[i][j] = t;
            }
        }

        return griglia;
    }

    /**
     * Stampa la griglia di gioco.
     */
    public void stampaGriglia(){
        for (int i = 0; i < MainFX.getLATO(); i++) {
            for (int j = 0; j < MainFX.getLATO(); j++) {
                System.out.print(griglia[i][j] + " ");
            }
            System.out.println();
        }
    }
}
