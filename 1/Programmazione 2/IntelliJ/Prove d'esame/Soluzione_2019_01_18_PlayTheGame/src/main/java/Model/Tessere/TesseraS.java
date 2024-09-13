package Model.Tessere;

import Controller.MainGUI;
import Model.Tessera;
import java.util.Random;

/**
 * Rappresenta una tessera specifica per il gioco, che contiene un valore numerico casuale compreso tra 1 e 8.
 */
public class TesseraS extends Tessera {

    /**
     * Costruttore della tessera "S".
     *
     * @param mg MainGUI a cui la tessera appartiene.
     */
    public TesseraS(MainGUI mg) {
        super(mg);
    }

    /**
     * Imposta il contenuto della tessera con un valore numerico casuale compreso tra 1 e 8.
     */
    @Override
    public void impostaContenuto() {
        Random r = new Random();
        int val = r.nextInt(8) + 1;
        super.setContenuto(String.valueOf(val));
    }

    /**
     * Mostra il contenuto della tessera "S" e aggiorna il punteggio nella GUI principale.
     */
    @Override
    public void scopri() {
        super.scopri();
        int nuovoPunteggio = getMg().getStatsPane().getPunteggio() + Integer.parseInt(getContenuto());
        System.out.println("Punteggio tessera scoperta: " + getContenuto());
        getMg().getStatsPane().aggiornaPunteggioText(nuovoPunteggio);
    }

    /**
     * Nasconde il contenuto della tessera "S", aggiornando il punteggio nella GUI principale.
     */
    @Override
    public void nascondi() {
        super.nascondi();
        int nuovoPunteggio = getMg().getStatsPane().getPunteggio() - Integer.parseInt(getContenuto());
        getMg().getStatsPane().aggiornaPunteggioText(nuovoPunteggio);
        System.out.println("Copro la tessera con valore: " + getContenuto());
        System.out.println("Punteggio totale: " + getMg().getStatsPane().getPunteggio());
    }
}
