package Model;

import Model.Evocazione.Attacco;
import Model.Evocazione.Energia;
import Model.Evocazione.Evocazione;
import Model.Evocazione.EvocazioneSuprema;

import java.util.ArrayList;

/**
 * La classe Gioco rappresenta un gioco con due giocatori, ognuno dei quali ha una lista di evocazioni e energie.
 */
public class Gioco {
    private Giocatore g1;
    private Giocatore g2;

    /**
     * Costruttore per inizializzare il gioco con due giocatori e le loro rispettive evocazioni ed energie.
     */
    public Gioco() {
        ArrayList<Evocazione> evocazioni = new ArrayList<>();
        ArrayList<Energia> energie = new ArrayList<>();

        evocazioni.add(new Evocazione("Irift", 30, Energia.FUOCO, new Attacco("Hellflame", Energia.FUOCO, 2, 20)));
        evocazioni.add(new EvocazioneSuprema("Phoenix", 50, Energia.FUOCO, new Attacco("Fiammata", Energia.FUOCO, 2, 20)));
        evocazioni.add(new Evocazione("Diablos", 50, Energia.TENEBRA, new Attacco("Demi", Energia.TENEBRA, 1, 20)));

        energie.add(Energia.FUOCO);
        energie.add(Energia.FUOCO);
        energie.add(Energia.NEUTRA);
        energie.add(Energia.NEUTRA);
        energie.add(Energia.TENEBRA);

        g1 = new Giocatore(evocazioni, energie, true);

        evocazioni.clear();
        energie.clear();

        evocazioni.add(new Evocazione("Leviathan", 30, Energia.ACQUA, new Attacco("Tsunami", Energia.ACQUA, 1, 10)));
        evocazioni.add(new EvocazioneSuprema("Bahamut", 60, Energia.NEUTRA, new Attacco("MegaFlare", Energia.NEUTRA, 3, 40)));
        evocazioni.add(new Evocazione("Alexander", 30, Energia.NEUTRA, new Attacco("Judgement", Energia.NEUTRA, 1, 10)));

        energie.add(Energia.ACQUA);
        energie.add(Energia.ACQUA);
        energie.add(Energia.NEUTRA);
        energie.add(Energia.TENEBRA);

        g2 = new Giocatore(evocazioni, energie, false);
    }

    /**
     * Aggiunge un numero specifico di energie di vari tipi alla lista di energie fornita.
     *
     * @param energie La lista di energie a cui aggiungere le nuove energie.
     * @param acqua Il numero di energie di tipo ACQUA da aggiungere.
     * @param fuoco Il numero di energie di tipo FUOCO da aggiungere.
     * @param neutra Il numero di energie di tipo NEUTRA da aggiungere.
     * @param tenebra Il numero di energie di tipo TENEBRA da aggiungere.
     */
    private void aggiungiEnergie(ArrayList<Energia> energie, int acqua, int fuoco, int neutra, int tenebra) {
        for (int i = 0; i < acqua; i++) {
            energie.add(Energia.ACQUA);
        }
        for (int i = 0; i < fuoco; i++) {
            energie.add(Energia.FUOCO);
        }
        for (int i = 0; i < neutra; i++) {
            energie.add(Energia.NEUTRA);
        }
        for (int i = 0; i < tenebra; i++) {
            energie.add(Energia.TENEBRA);
        }
    }

    /**
     * Restituisce il primo giocatore.
     *
     * @return Il primo giocatore.
     */
    public Giocatore getG1() {
        return g1;
    }

    /**
     * Restituisce il secondo giocatore.
     *
     * @return Il secondo giocatore.
     */
    public Giocatore getG2() {
        return g2;
    }
}
