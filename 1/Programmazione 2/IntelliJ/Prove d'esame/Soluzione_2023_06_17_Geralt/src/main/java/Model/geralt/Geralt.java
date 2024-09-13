package Model.geralt;

import java.util.ArrayList;
import java.util.HashSet;

/**
 * Classe che rappresenta il personaggio Geralt con le sue caratteristiche,
 * incantesimi e mutazioni.
 */
public class Geralt {
    public static final int MAX_MUTATIONS = 4;

    private int forza = 10;
    private int velocita = 10;
    private int tolleranza = 2;
    private int livello = 0;

    private HashSet<Spell> spells;
    private ArrayList<Mutation> mutations;

    /**
     * Costruttore della classe Geralt.
     * Inizializza gli incantesimi come un HashSet vuoto e le mutazioni con
     * quattro elementi vuoti.
     */
    public Geralt() {
        spells = new HashSet<>();
        mutations = new ArrayList<>(4);

        for (int i = 0; i < MAX_MUTATIONS; i++)
            mutations.add(Mutation.Empty);
    }

    /**
     * Restituisce l'insieme degli incantesimi di Geralt.
     * @return HashSet degli incantesimi.
     */
    public HashSet<Spell> getSpells() {
        return spells;
    }

    /**
     * Restituisce la lista delle mutazioni di Geralt.
     * @return ArrayList delle mutazioni.
     */
    public ArrayList<Mutation> getMutations() {
        return mutations;
    }

    /**
     * Restituisce il valore della forza di Geralt.
     * @return Valore della forza.
     */
    public int getForza() {
        return forza;
    }

    /**
     * Restituisce il valore della velocità di Geralt.
     * @return Valore della velocità.
     */
    public int getVelocita() {
        return velocita;
    }

    /**
     * Restituisce il valore della tolleranza di Geralt.
     * @return Valore della tolleranza.
     */
    public int getTolleranza() {
        return tolleranza;
    }

    /**
     * Imposta il valore della forza di Geralt.
     * @param forza Nuovo valore della forza.
     */
    public void setForza(int forza) {
        this.forza = forza;
    }

    /**
     * Imposta il valore della velocità di Geralt.
     * @param velocita Nuovo valore della velocità.
     */
    public void setVelocita(int velocita) {
        this.velocita = velocita;
    }

    /**
     * Imposta il valore della tolleranza di Geralt.
     * @param tolleranza Nuovo valore della tolleranza.
     */
    public void setTolleranza(int tolleranza) {
        this.tolleranza = tolleranza;
    }

    /**
     * Aggiunge un incantesimo all'insieme degli incantesimi di Geralt.
     * @param s Incantesimo da aggiungere.
     */
    public void addSpell(Spell s) {
        spells.add(s);
    }

    /**
     * Rimuove un incantesimo dall'insieme degli incantesimi di Geralt.
     * @param s Incantesimo da rimuovere.
     */
    public void removeSpell(Spell s) {
        spells.remove(s);
    }

    /**
     * Aggiunge una mutazione alla lista delle mutazioni di Geralt.
     * @param m Mutazione da aggiungere.
     * @return true se la mutazione è stata aggiunta con successo, false altrimenti.
     */
    public boolean addMutation(Mutation m) {
        int index = 4;

        if ((m == Mutation.Str || m == Mutation.Vel) && check_mutation_position_empty(0))
            index = 0;
        else if ((m == Mutation.Igni || m == Mutation.Quen) && check_mutation_position_empty(1))
            index = 1;
        else if (m == Mutation.Tol && check_mutation_position_empty(2))
            index = 2;
        else if (check_mutation_position_empty(3))
            index = 3;

        if (index != 4) {
            mutations.remove(index);
            mutations.add(index, m);
            return true;
        }
        return false;
    }

    /**
     * Rimuove una mutazione dalla lista delle mutazioni di Geralt.
     * @param m Mutazione da rimuovere.
     */
    public void removeMutation(Mutation m) {
        int index = position_of(m);
        if (((m == Mutation.Str || m == Mutation.Vel) && index == 0) && (mutations.get(3) == Mutation.Str || mutations.get(3) == Mutation.Vel)) {
            mutations.remove(3);
            mutations.add(3, Mutation.Empty);
            mutations.remove(0);
            if (m == Mutation.Str)
                mutations.add(0, Mutation.Vel);
            else
                mutations.add(0, Mutation.Str);
        } else if ((m == Mutation.Igni || m == Mutation.Quen) && index == 1 && (mutations.get(3) == Mutation.Igni || mutations.get(3) == Mutation.Quen)) {
            mutations.remove(3);
            mutations.add(3, Mutation.Empty);
            mutations.remove(1);
            if (m == Mutation.Igni)
                mutations.add(1, Mutation.Quen);
            else
                mutations.add(1, Mutation.Igni);
        } else {
            mutations.remove(m);
            mutations.add(index, Mutation.Empty);
        }
    }

    /**
     * Controlla se la posizione di una mutazione è vuota.
     * @param index Indice della posizione da controllare.
     * @return true se la posizione è vuota, false altrimenti.
     */
    private boolean check_mutation_position_empty(int index) {
        return mutations.get(index) == Mutation.Empty;
    }

    /**
     * Controlla se una mutazione è presente nella lista delle mutazioni di Geralt.
     * @param m Mutazione da controllare.
     * @return "-" se la mutazione è presente, "+" altrimenti.
     */
    public String isPresent(Mutation m) {
        for (Mutation k : mutations) {
            if (k == m)
                return "-";
        }
        return "+";
    }

    /**
     * Restituisce la posizione di una mutazione nella lista delle mutazioni di Geralt.
     * @param m Mutazione da cercare.
     * @return Indice della posizione della mutazione.
     */
    public int position_of(Mutation m) {
        int i = 0;
        for (Mutation a : mutations) {
            if (a == m)
                break;
            i++;
        }
        return i;
    }

    /**
     * Restituisce una stringa che rappresenta le statistiche di Geralt.
     * @return Stringa con le statistiche.
     */
    public String stringaStats() {
        return "Lvl: " + livello + "\n" +
                "Str: " + forza + "\n" +
                "Vel: " + velocita + "\n" + "\n" +
                "Tol: " + tolleranza;
    }
}
