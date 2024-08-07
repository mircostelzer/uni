package Model.Persone;

import Model.Persona;

/**
 * Classe astratta che rappresenta una persona specifica con attributi aggiuntivi.
 * Estende la classe Persona.
 */
public abstract class SpecificPerson extends Persona {
    private String attributo1;
    private boolean attributo2;

    /**
     * Costruttore della classe SpecificPerson.
     *
     * @param nome          Il nome della persona.
     * @param cognome       Il cognome della persona.
     * @param codiceFiscale Il codice fiscale della persona.
     * @param annoNascita   L'anno di nascita della persona.
     * @param attributo1    Attributo aggiuntivo 1.
     * @param attributo2    Attributo aggiuntivo 2.
     */
    public SpecificPerson(String cognome, String nome, String codiceFiscale, String annoNascita, String attributo1, boolean attributo2) {
        super(cognome, nome, codiceFiscale, annoNascita);
        this.attributo1 = attributo1;
        this.attributo2 = attributo2;
    }

    /**
     * Restituisce l'attributo aggiuntivo 1 della persona specifica.
     *
     * @return L'attributo aggiuntivo 1.
     */
    public String getAttributo1() {
        return attributo1;
    }

    /**
     * Verifica se l'attributo aggiuntivo 2 è true o false.
     *
     * @return true se l'attributo aggiuntivo 2 è true, altrimenti false.
     */
    public boolean isAttributo2() {
        return attributo2;
    }

    /**
     * Metodo astratto per decodificare l'attributo 2.
     *
     * @return Una stringa che rappresenta la decodifica dell'attributo 2.
     */
    public abstract String decodificaAttributo2();

    /**
     * Override del metodo stringaAddizionale per aggiungere informazioni
     * specifiche alla rappresentazione testuale della persona.
     *
     * @return Una stringa contenente l'attributo aggiuntivo 1 e la decodifica
     * dell'attributo 2.
     */
    @Override
    public String stringaAddizionale() {
        return " " + attributo1 + " " + decodificaAttributo2();
    }
}
