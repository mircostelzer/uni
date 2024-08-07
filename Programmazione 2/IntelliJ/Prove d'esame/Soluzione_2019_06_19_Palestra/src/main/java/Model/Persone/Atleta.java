package Model.Persone;

/**
 * Classe che rappresenta un atleta.
 * Estende la classe SpecificPerson.
 */
public class Atleta extends SpecificPerson {

    /**
     * Costruttore della classe Atleta.
     *
     * @param nome          Il nome dell'atleta.
     * @param cognome       Il cognome dell'atleta.
     * @param codiceFiscale Il codice fiscale dell'atleta.
     * @param annoNascita   L'anno di nascita dell'atleta.
     * @param disciplina    Disciplina sportiva praticata dall'atleta (attributo1).
     * @param isNazionale   Indica se l'atleta fa parte della nazionale (attributo2).
     */
    public Atleta(String nome, String cognome, String codiceFiscale, String annoNascita, String disciplina, boolean isNazionale) {
        super(nome, cognome, codiceFiscale, annoNascita, disciplina, isNazionale);
    }

    /**
     * Override del metodo trovaSconto per calcolare lo sconto atleti in base all'attributo2.
     */
    @Override
    public void trovaSconto() {
        super.trovaSconto();
        double nuovoSconto = (isAttributo2())? 0.3 : 0.5;

        if (nuovoSconto > getSconto()) {
            setSconto(nuovoSconto);
        }
    }

    /**
     * Override del metodo decodificaAttributo2 per restituire una stringa rappresentativa dell'attributo2.
     *
     * @return Una stringa "nazionale" se isNazionale è true, altrimenti "internazionale".
     */
    @Override
    public String decodificaAttributo2() {
        return (isAttributo2()) ? "nazionale" : "internazionale";
    }
}
