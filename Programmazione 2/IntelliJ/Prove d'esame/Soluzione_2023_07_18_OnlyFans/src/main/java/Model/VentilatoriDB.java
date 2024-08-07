package Model;

import Controller.MainGUI;
import Model.Ventilatori.Parete;
import Model.Ventilatori.Piantana;
import Model.Ventilatori.Soffitto;

import java.util.ArrayList;
import java.util.Comparator;

/**
 * Classe che rappresenta un database di ventilatori.
 */
public class VentilatoriDB {
    private ArrayList<Ventilatore> ventilatori;
    private boolean sort;
    private MainGUI mg;

    /**
     * Costruttore per creare un database di ventilatori.
     *
     * @param mg L'istanza di MainGUI.
     * @throws Exception Se si verifica un errore durante la creazione del database.
     */
    public VentilatoriDB(MainGUI mg) throws Exception {
        sort = true;
        this.mg = mg;

        ventilatori = new ArrayList<>();

        ventilatori.add(new Piantana("Ariete", Alimentazione.Batteria, mg));
        ventilatori.add(new Parete("Bosch", Alimentazione.Presa, mg));
        ventilatori.add(new Parete("Bosch", Alimentazione.Meccanico, mg));
        ventilatori.add(new Soffitto("Bosch", Alimentazione.Batteria, mg));
        ventilatori.add(new Soffitto("Parkside", Alimentazione.Presa, mg));

        cambiaSort();
    }

    /**
     * Restituisce la lista dei ventilatori.
     *
     * @return La lista dei ventilatori.
     */
    public ArrayList<Ventilatore> getVentilatori() {
        return ventilatori;
    }

    /**
     * Cambia l'ordinamento della lista dei ventilatori.
     */
    public void cambiaSort(){
        if (sort) {
            sortByName();
            invertiSort();
        } else {
            sortByPrice();
            invertiSort();
        }
    }

    /**
     * Inverte l'ordinamento corrente.
     */
    private void invertiSort() {
        sort = !sort;
    }

    /**
     * Ordina i ventilatori per nome della classe e poi per costo.
     */
    private void sortByName() {
        ventilatori.sort(Comparator.comparing((Ventilatore v) -> v.getClass().getSimpleName()).thenComparing(Ventilatore::getCosto));
    }

    /**
     * Ordina i ventilatori per costo e poi per nome della classe.
     */
    private void sortByPrice() {
        ventilatori.sort(Comparator.comparing(Ventilatore::getCosto).thenComparing((Ventilatore v) -> v.getClass().getSimpleName()));
    }

    /**
     * Restituisce una lista dei ventilatori non abbonati.
     *
     * @return La lista dei ventilatori non abbonati.
     */
    public ArrayList<Ventilatore> getNonAbbonati() {
        ArrayList<Ventilatore> nonAbbonati = new ArrayList<>(5);
        for (Ventilatore v : ventilatori) {
            if (!mg.getAbbonamenti().isPresente(v))
                nonAbbonati.add(v);
        }
        return nonAbbonati;
    }

    /**
     * Resetta i ventilatori, rimuovendo quelli abbonati.
     */
    public void resetVentilatori() {
        for (Ventilatore v : ventilatori) {
            if (mg.getAbbonamenti().isPresente(v))
                v.rimuoviVentilatore();
        }
    }
}
