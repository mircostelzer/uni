package Model.Celle;

import Model.Cella;
import Controller.MainGUI;
import View.StatsPane;
import javafx.scene.paint.Color;

/**
 * La classe CellaMoltiplicatore rappresenta una cella speciale che moltiplica il punteggio del giocatore.
 * Quando viene attivata, il punteggio del giocatore viene moltiplicato per 2.
 */
public class CellaMoltiplicatore extends Cella {

    /**
     * Costruttore per la classe CellaMoltiplicatore.
     *
     * @param mg Il controller principale dell'applicazione
     */
    public CellaMoltiplicatore(MainGUI mg) {
        super(mg, Color.GREEN);
    }

    /**
     * Metodo che attiva la cella quando viene scoperta.
     * Il punteggio del giocatore viene moltiplicato per 2.
     */
    @Override
    public void attivaCella() {
        StatsPane sp = getMg().getStatsPane();
        int nuovoPunteggio = sp.getPunteggio() * 2;
        sp.setPunteggio(nuovoPunteggio);
    }

    /**
     * Metodo per impostare il contenuto della cella.
     * Il contenuto della cella è "x2" per indicare che il punteggio verrà moltiplicato per 2 quando la cella viene attivata.
     */
    @Override
    public void setCont() {
        super.setContenuto("x2");
    }
}
