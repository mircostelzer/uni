package Model.Ventilatori;

import Controller.MainGUI;
import Model.Alimentazione;
import Model.Ventilatore;

/**
 * Classe che rappresenta un ventilatore a soffitto.
 */
public class Soffitto extends Ventilatore {

    /**
     * Costruttore per creare un ventilatore a soffitto.
     *
     * @param marca La marca del ventilatore.
     * @param alimentazione Il tipo di alimentazione del ventilatore.
     * @param mg L'istanza di MainGUI.
     * @throws Exception Se l'alimentazione per il ventilatore a soffitto è meccanica.
     */
    public Soffitto(String marca, Alimentazione alimentazione, MainGUI mg) throws Exception {
        super(marca, alimentazione, mg);
    }

    /**
     * Calcola il costo del ventilatore a soffitto.
     */
    @Override
    public void calcolaCosto() {
        setCosto((getCosto() + 2) * getAumentoAlimentazione());
    }
}
