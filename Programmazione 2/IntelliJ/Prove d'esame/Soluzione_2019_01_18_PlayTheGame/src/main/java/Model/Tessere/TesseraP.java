package Model.Tessere;

import Controller.MainGUI;
import Model.AlertDisplayer;
import Model.Tessera;

/**
 * Rappresenta una tessera specifica per il gioco contrassegnata dalla lettera "P".
 */
public class TesseraP extends Tessera {

    /**
     * Costruttore della tessera "P".
     *
     * @param mg MainGUI a cui la tessera appartiene.
     */
    public TesseraP(MainGUI mg) {
        super(mg);
    }

    /**
     * Imposta il contenuto della tessera come "P".
     */
    @Override
    public void impostaContenuto() {
        setContenuto("P");
    }

    /**
     * Mostra il contenuto della tessera "P" e visualizza un messaggio di sconfitta.
     */
    @Override
    public void scopri(){
        super.scopri();
        AlertDisplayer.display_LOOSE_Alert();
    }
}
