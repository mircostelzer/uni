package Model;

/**
 * Classe che rappresenta una Persona con informazioni di base.
 */
public class Persona {
    private String nome;
    private String cognome;
    private String codiceFiscale;
    private String annoNascita;
    private double prezzoAbbonamento;
    private double sconto;

    /**
     * Costruttore della classe Persona.
     *
     * @param cognome       Il cognome della persona.
     * @param nome          Il nome della persona.
     * @param codiceFiscale Il codice fiscale della persona.
     * @param annoNascita   L'anno di nascita della persona.
     */
    public Persona(String cognome, String nome, String codiceFiscale, String annoNascita) {
        this.nome = nome;
        this.cognome = cognome;
        this.codiceFiscale = codiceFiscale;
        this.annoNascita = annoNascita;
        prezzoAbbonamento = 1000;
        sconto = 0;
    }

    /**
     * Restituisce il cognome della persona.
     *
     * @return Il cognome della persona.
     */
    public String getCognome() {
        return cognome;
    }

    /**
     * Restituisce l'anno di nascita della persona.
     *
     * @return L'anno di nascita della persona.
     */
    public String getAnnoNascita() {
        return annoNascita;
    }

    /**
     * Restituisce lo sconto applicato all'abbonamento della persona.
     *
     * @return Lo sconto applicato.
     */
    public double getSconto() {
        return sconto;
    }

    /**
     * Imposta lo sconto da applicare all'abbonamento della persona.
     *
     * @param sconto Lo sconto da applicare (in percentuale).
     */
    public void setSconto(double sconto) {
        this.sconto = sconto;
    }

    /**
     * Calcola lo sconto in base all'anno di nascita della persona.
     * Applica uno sconto del 35% se la persona è nata prima del 1968.
     */
    public void trovaSconto() {
        //sconto senior
        if (Integer.parseInt(annoNascita) < 1968)
            sconto = 0.35;
    }

    /**
     * Restituisce una stringa aggiuntiva per la persona.
     *
     * @return Una stringa vuota (implementazione base, può essere sovrascritta nelle sottoclassi).
     */
    public String stringaAddizionale() {
        return "";
    }

    /**
     * Applica lo sconto trovato con l'apposito metodo
     */
    public void applicaSconto(){
        trovaSconto();
        prezzoAbbonamento -= prezzoAbbonamento * sconto;
    }

    /**
     * Override del metodo toString per ottenere una rappresentazione testuale della persona.
     *
     * @return Una stringa contenente cognome, nome, codice fiscale, anno di nascita,
     *         informazioni addizionali e prezzo dell'abbonamento.
     */
    @Override
    public String toString() {
        return cognome + " " + nome + " " + codiceFiscale + " " + annoNascita + " " + stringaAddizionale() + " | tariffa: " + prezzoAbbonamento;
    }
}
