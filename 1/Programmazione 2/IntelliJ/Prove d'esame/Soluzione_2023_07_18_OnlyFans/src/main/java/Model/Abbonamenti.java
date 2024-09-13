package Model;

import java.util.ArrayList;

/**
 * Classe che rappresenta una lista di abbonamenti a ventilatori.
 */
public class Abbonamenti extends ArrayList<Ventilatore> {

    /**
     * Costruttore per creare una lista di abbonamenti con una capacità iniziale specificata.
     *
     * @param initialCapacity La capacità iniziale della lista.
     */
    public Abbonamenti(int initialCapacity) {
        super(initialCapacity);
    }

    /**
     * Verifica se un ventilatore è presente nella lista.
     *
     * @param v Il ventilatore da verificare.
     * @return true se il ventilatore è presente, false altrimenti.
     */
    public boolean isPresente(Ventilatore v) {
        for (Ventilatore ventilatore : this) {
            if (v.toString().equals(ventilatore.toString())) {
                return true;
            }
        }
        return false;
    }

    /**
     * Rimuove il ventilatore più costoso dalla lista.
     */
    public void rimuoviPiuCostoso() {
        if (isEmpty()) {
            return; // Se la lista è vuota, non fare nulla
        }

        int maxCosto = get(0).getCosto();
        int index = 0;

        for (int i = 1; i < size(); i++) {
            if (get(i).getCosto() > maxCosto) {
                maxCosto = get(i).getCosto();
                index = i;
            }
        }

        get(index).rimuoviVentilatore();
    }
}
