package Model.Celle;

import Model.Cella;
import Controller.MainGUI;
import View.StatsPane;
import javafx.scene.paint.Color;

import java.util.Random;

/**
 * La classe CellaBase rappresenta una cella di base del gioco.
 * Ogni cella di base ha un colore nascosto bianco e un contenuto generato casualmente.
 */
public class CellaBase extends Cella {

    /**
     * Costruttore per la classe CellaBase.
     *
     * @param mg Il controller principale dell'applicazione
     */
    public CellaBase(MainGUI mg) {
        super(mg, Color.WHITE);
    }

    /**
     * Metodo che attiva la cella quando viene scoperta.
     * Aggiorna il punteggio del giocatore con il valore contenuto nella cella.
     */
    @Override
    public void attivaCella() {
        StatsPane sp = getMg().getStatsPane();
        int nuovoPunteggio = sp.getPunteggio() + Integer.parseInt(getContenuto());
        sp.setPunteggio(nuovoPunteggio);
    }

    /**
     * Metodo per impostare il contenuto della cella.
     * Il contenuto viene generato casualmente come un numero compreso tra 100 e 1000.
     */
    @Override
    public void setCont() {
        Random r = new Random();
        int contenuto = (r.nextInt(10)+1)*100;
        super.setContenuto(String.valueOf(contenuto));
    }
}
