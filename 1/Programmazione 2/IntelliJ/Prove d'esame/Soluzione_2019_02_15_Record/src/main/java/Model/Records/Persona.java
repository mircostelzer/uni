package Model.Records;

import Model.Record;

/**
 * Questa classe rappresenta un record di una persona.
 * Estende la classe astratta Record e ha tre campi: nome, cognome e anno di nascita.
 */
public class Persona extends Record {

    /**
     * Costruttore per creare un nuovo record di una persona.
     *
     * @param nome        Il nome della persona.
     * @param cognome     Il cognome della persona.
     * @param annoNascita L'anno di nascita della persona.
     */
    public Persona(String nome, String cognome, Integer annoNascita) {
        super(nome, cognome, annoNascita);
    }
}
