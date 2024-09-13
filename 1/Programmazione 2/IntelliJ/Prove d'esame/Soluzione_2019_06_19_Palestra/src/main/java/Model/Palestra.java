package Model;

import Model.Persone.Atleta;
import Model.Persone.AtletaStudente;
import Model.Persone.Studente;

import java.util.ArrayList;
import java.util.Comparator;

/**
 * Classe che rappresenta una palestra con elenco di persone.
 */
public class Palestra {
    private ArrayList<Persona> persone;

    /**
     * Costruttore della classe Palestra.
     * Inizializza l'elenco delle persone e aggiunge alcuni esempi di persone.
     */
    public Palestra() {
        persone = new ArrayList<>();
        persone.add(new Studente("Bianchi", "Anna", "4", "1990", "UNIPD", false));
        persone.add(new Studente("Bianchi", "Giovanni", "3", "1995", "UNITN", true));
        persone.add(new AtletaStudente("Ferrari", "Alberto", "7", "1993", "UNITN", false, "atletica", false));
        persone.add(new AtletaStudente("Ferrari", "Vincenzo", "8", "1997", "UNIVR", true, "atletica", true));
        persone.add(new Persona("Rossi", "Carla", "2", "1990"));
        persone.add(new Persona("Rossi", "Mario", "1", "1950"));
        persone.add(new Atleta("Verdi", "Alice", "6", "1967", "curling", false));
        persone.add(new Atleta("Verdi", "Giacomo", "5", "1991", "nuoto", true));

        for(Persona pers : persone){
            pers.applicaSconto();
        }

        sortBySurname(persone);
    }

    /**
     * Restituisce l'elenco delle persone nella palestra.
     *
     * @return ArrayList di Persona.
     */
    public ArrayList<Persona> getPersone() {
        return persone;
    }

    /**
     * Ordina l'elenco delle persone per cognome.
     *
     * @param persone ArrayList di Persona da ordinare.
     */
    public void sortBySurname(ArrayList<Persona> persone) {
        persone.sort(Comparator.comparing(Persona::getCognome));
    }

    /**
     * Ordina l'elenco delle persone per anno di nascita (età).
     *
     * @param persone ArrayList di Persona da ordinare.
     */
    public void sortByEta(ArrayList<Persona> persone) {
        persone.sort(Comparator.comparing(Persona::getAnnoNascita));
    }

    /**
     * Restituisce l'elenco degli studenti (Studente e AtletaStudente) presenti nella palestra.
     *
     * @return ArrayList di Persona che sono studenti.
     */
    public ArrayList<Persona> getStudenti() {
        ArrayList<Persona> studenti = new ArrayList<>();
        for (Persona pers : persone) {
            if (pers instanceof Studente || pers instanceof AtletaStudente)
                studenti.add(pers);
        }
        return studenti;
    }

    /**
     * Restituisce l'elenco degli atleti (Atleta e AtletaStudente) presenti nella palestra.
     *
     * @return ArrayList di Persona che sono atleti.
     */
    public ArrayList<Persona> getAtleti() {
        ArrayList<Persona> atleti = new ArrayList<>();
        for (Persona pers : persone) {
            if (pers instanceof Atleta || pers instanceof AtletaStudente)
                atleti.add(pers);
        }
        return atleti;
    }

    /**
     * Genera una stringa contenente la rappresentazione testuale di tutte le persone fornite.
     *
     * @param persone ArrayList di Persona da rappresentare.
     * @return Una stringa contenente la rappresentazione testuale di tutte le persone.
     */
    public String stampa(ArrayList<Persona> persone) {
        StringBuilder str = new StringBuilder();

        for (Persona pers : persone) {
            str.append(pers.toString()).append("\n");
        }

        return str.toString();
    }
}
