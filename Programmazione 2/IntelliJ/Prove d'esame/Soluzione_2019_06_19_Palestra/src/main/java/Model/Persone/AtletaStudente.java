package Model.Persone;

import Model.Persona;

/**
 * Classe che rappresenta una persona che è contemporaneamente uno studente e un atleta.
 * Estende la classe Persona.
 */
public class AtletaStudente extends Persona {
    private Atleta atleta;
    private Studente studente;

    /**
     * Costruttore della classe AtletaStudente.
     *
     * @param nome            Il nome della persona.
     * @param cognome         Il cognome della persona.
     * @param codiceFiscale   Il codice fiscale della persona.
     * @param annoNascita     L'anno di nascita della persona.
     * @param attrStudente1   Attributo aggiuntivo dello studente (attributo1).
     * @param attrStudente2   Attributo aggiuntivo dello studente (attributo2).
     * @param attrAtleta1     Attributo aggiuntivo dell'atleta (attributo1).
     * @param attrAtleta2     Attributo aggiuntivo dell'atleta (attributo2).
     */
    public AtletaStudente(String nome, String cognome, String codiceFiscale, String annoNascita, String attrStudente1, boolean attrStudente2, String attrAtleta1, boolean attrAtleta2) {
        super(nome, cognome, codiceFiscale, annoNascita);
        atleta = new Atleta(nome, cognome, codiceFiscale, annoNascita, attrAtleta1, attrAtleta2);
        studente = new Studente(nome, cognome, codiceFiscale, annoNascita, attrStudente1, attrStudente2);
    }

    /**
     * Override del metodo trovaSconto per calcolare lo sconto combinato per lo studente atleta.
     */
    public void trovaSconto() {
        super.trovaSconto();
        double nuovoScontoStudente = studente.isAttributo2() ? 0.4 : 0.2;

        double nuovoScontoAtleta = atleta.isAttributo2() ? 0.3 : 0.5;

        double nuovoSconto = Math.max(nuovoScontoStudente, nuovoScontoAtleta);

        if (nuovoSconto > getSconto()) {
            setSconto(nuovoSconto);
        }
    }

    /**
     * Override del metodo stringaAddizionale per aggiungere informazioni
     * specifiche alla rappresentazione testuale della persona.
     *
     * @return Una stringa contenente gli attributi aggiuntivi dello studente
     * e dell'atleta.
     */
    @Override
    public String stringaAddizionale() {
        return " " + studente.getAttributo1() + " " + studente.decodificaAttributo2() + " " + atleta.getAttributo1() + " " + atleta.decodificaAttributo2();
    }
}
