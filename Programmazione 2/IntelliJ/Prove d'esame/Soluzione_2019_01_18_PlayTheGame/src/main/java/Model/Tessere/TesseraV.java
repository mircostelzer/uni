package Model.Tessere;

import Controller.MainGUI;
import Model.AlertDisplayer;
import Model.Tessera;

/**
 * Rappresenta una tessera specifica per il gioco, contrassegnata dalla lettera "V".
 */
public class TesseraV extends Tessera {

    /**
     * Costruttore della tessera "V".
     *
     * @param mg MainGUI a cui la tessera appartiene.
     */
    public TesseraV(MainGUI mg) {
        super(mg);
    }

    /**
     * Imposta il contenuto della tessera come "V".
     */
    @Override
    public void impostaContenuto() {
        setContenuto("V");
    }

    /**
     * Mostra il contenuto della tessera "V" e aggiorna le statistiche della GUI principale.
     * Visualizza un messaggio di vittoria, resetta il gioco e le statistiche.
     */
    @Override
    public void scopri(){
        super.scopri();
        getMg().getStatsPane().aggiornaPartiteVinteText();
        System.out.println("Hai vinto " + getMg().getStatsPane().getPartiteVinte() + " partite!");
        AlertDisplayer.display_WIN_Alert();
        getMg().resetAll();
    }
}
