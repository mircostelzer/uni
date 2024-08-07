package Model;

import java.util.ArrayList;
import java.util.Comparator;

/**
 * La classe Mano rappresenta una mano di carte di un giocatore.
 */
public class Mano {
    private String giocatore; // Nome del giocatore
    private ArrayList<Carta> carte; // Lista delle carte nella mano

    /**
     * Costruttore per la classe Mano.
     *
     * @param giocatore Nome del giocatore
     * @param carte     Lista delle carte nella mano
     */
    public Mano(String giocatore, ArrayList<Carta> carte) {
        this.giocatore = giocatore;
        this.carte = new ArrayList<>(carte);
        sortMano(); // Ordina le carte nella mano
    }

    /**
     * Restituisce la lista delle carte nella mano.
     *
     * @return Lista delle carte nella mano
     */
    public ArrayList<Carta> getCarte() {
        return carte;
    }

    /**
     * Restituisce il nome del giocatore.
     *
     * @return Nome del giocatore
     */
    public String getGiocatore() {
        return giocatore;
    }

    /**
     * Ordina le carte nella mano in base al loro valore e al loro seme.
     */
    public void sortMano(){
        carte.sort(Comparator.comparingInt(Carta :: getValore).thenComparing(Carta :: getSeme));
    }

    /**
     * Aggiunge una carta alla mano e riordina le carte.
     *
     * @param c La carta da aggiungere
     */
    public void aggiungiCarta(Carta c){
        carte.add(c);
        sortMano(); // Riordina le carte nella mano
    }

    /**
     * Rimuove una carta dalla mano in base all'indice specificato e riordina le carte.
     *
     * @param index L'indice della carta da rimuovere
     */
    public void rimuoviCarta(int index){
        carte.remove(index);
        sortMano(); // Riordina le carte nella mano
    }

    /**
     * Restituisce una rappresentazione testuale della mano, che include il nome del giocatore e le carte nella mano.
     *
     * @return Rappresentazione testuale della mano
     */
    @Override
    public String toString() {
        return giocatore + ": " + carte.toString();
    }
}
