package Model.Celle;

import Model.Cella;
import Controller.MainGUI;
import View.StatsPane;
import javafx.scene.paint.Color;

/**
 * La classe CellaDivisore rappresenta una cella speciale che divide il punteggio del giocatore.
 * Quando viene attivata, il punteggio del giocatore viene diviso per 2.
 */
public class CellaDivisore extends Cella {

    /**
     * Costruttore per la classe CellaDivisore.
     *
     * @param mg Il controller principale dell'applicazione
     */
    public CellaDivisore(MainGUI mg) {
        super(mg, Color.RED);
    }

    /**
     * Metodo che attiva la cella quando viene scoperta.
     * Il punteggio del giocatore viene diviso per 2.
     */
    @Override
    public void attivaCella() {
        StatsPane sp = getMg().getStatsPane();
        int nuovoPunteggio = sp.getPunteggio() / 2;
        sp.setPunteggio(nuovoPunteggio);
    }

    /**
     * Metodo per impostare il contenuto della cella.
     * Il contenuto della cella è "/2" per indicare che il punteggio verrà diviso per 2 quando la cella viene attivata.
     */
    @Override
    public void setCont() {
        super.setContenuto("/2");
    }
}
