package Model.Ventilatori;

import Controller.MainGUI;
import Model.Alimentazione;
import Model.Ventilatore;

/**
 * Classe che rappresenta un ventilatore a piantana.
 */
public class Piantana extends Ventilatore {

    /**
     * Costruttore per creare un ventilatore a piantana.
     *
     * @param marca La marca del ventilatore.
     * @param alimentazione Il tipo di alimentazione del ventilatore.
     * @param mg L'istanza di MainGUI.
     * @throws Exception Se si verifica un errore durante la creazione del ventilatore.
     */
    public Piantana(String marca, Alimentazione alimentazione, MainGUI mg) throws Exception {
        super(marca, alimentazione, mg);
    }

    /**
     * Calcola il costo del ventilatore a piantana.
     */
    @Override
    public void calcolaCosto() {
        setCosto((getCosto() + 10) * getAumentoAlimentazione());
    }
}
