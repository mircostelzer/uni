package Model;

import Model.Evocazione.Energia;
import Model.Evocazione.Evocazione;

import java.util.ArrayList;

/**
 * La classe Giocatore rappresenta un giocatore nel gioco, con attributi come evocazioni, energie e stato del turno.
 */
public class Giocatore {
    private ArrayList<Evocazione> evocazioni;
    private ArrayList<Energia> energie;
    private boolean isTurno;

    /**
     * Costruttore per creare un nuovo giocatore.
     *
     * @param evocazioni La lista delle evocazioni del giocatore.
     * @param energie La lista delle energie del giocatore.
     * @param isTurno Lo stato del turno del giocatore, true se è il turno del giocatore, altrimenti false.
     */
    public Giocatore(ArrayList<Evocazione> evocazioni, ArrayList<Energia> energie, boolean isTurno) {
        this.isTurno = isTurno;
        this.evocazioni = new ArrayList<>(evocazioni);
        this.energie = new ArrayList<>(energie);
    }

    /**
     * Restituisce la lista delle evocazioni del giocatore.
     *
     * @return La lista delle evocazioni.
     */
    public ArrayList<Evocazione> getEvocazioni() {
        return evocazioni;
    }

    /**
     * Restituisce la lista delle energie del giocatore.
     *
     * @return La lista delle energie.
     */
    public ArrayList<Energia> getEnergie() {
        return energie;
    }

    /**
     * Verifica se è il turno del giocatore.
     *
     * @return true se è il turno del giocatore, altrimenti false.
     */
    public boolean isTurno() {
        return isTurno;
    }
}
