package Model.Persone;

/**
 * Classe che rappresenta uno studente.
 * Estende la classe SpecificPerson.
 */
public class Studente extends SpecificPerson {

    /**
     * Costruttore della classe Studente.
     *
     * @param nome          Il nome dello studente.
     * @param cognome       Il cognome dello studente.
     * @param codiceFiscale Il codice fiscale dello studente.
     * @param annoNascita   L'anno di nascita dello studente.
     * @param universita    Università dello studente (attributo1).
     * @param isTriennale   Indica se lo studente è in corso di laurea triennale (attributo2).
     */
    public Studente(String cognome, String nome, String codiceFiscale, String annoNascita, String universita, boolean isTriennale) {
        super(cognome, nome, codiceFiscale, annoNascita, universita, isTriennale);
    }

    /**
     * Override del metodo trovaSconto per calcolare lo sconto studenti in base all'attributo2.
     */
    @Override
    public void trovaSconto() {
        super.trovaSconto();
        double nuovoSconto = (isAttributo2())? 0.4 : 0.2;

        if (nuovoSconto > getSconto()) {
            setSconto(nuovoSconto);
        }
    }

    /**
     * Override del metodo decodificaAttributo2 per restituire una stringa rappresentativa dell'attributo2.
     *
     * @return Una stringa "LT" se isTriennale è true, altrimenti "LM".
     */
    @Override
    public String decodificaAttributo2() {
        return (isAttributo2()) ? "LT" : "LM";
    }
}
