package com.company;

/**
 * Sottoclasse di <code>Pubblicazione</code> per un film
 *
 * I film sono caratterizzati per la durata in minuti.
 */
public class Film extends Pubblicazione {

    int durata;

    /**
     * Costruttore della classe <code>Film</code>>

     *
     *  @param titolo            titolo della pubblicazione
     *  @param annoPubblicazione primo anno di pubblicazione
     *  @param autore            autore della pubblicazione
     *  @param durata            durata in minuti del film
     *  @param prestabile        booleano che indica se è ammesso il prestito
     */
    public Film(String titolo, int annoPubblicazione, String autore, int durata, boolean prestabile) {
        super(titolo, annoPubblicazione, autore, prestabile);
        this.durata = durata;
    }

    /**
     * Ritorna una stringa che indica che la pubblicazione è un film e la sua durata,
     * @return stringa con le caratteristiche del film
     */
    @Override
    public String caratteristiche() {
        return "Film " + durata + " min";
    }

    /**
     * Metodo per registrare un prestito.
     *
     * Prima di chiamare l'implementazione della classe padre controlla che non si richiesto il libro per più di 5
     * giorni.
     *
     * @param giorni il numero di giorni per cui si richiede il prestito.
     * @return <code>true</code> se il prestito è accettato, <code>false</code> altrimenti.
     */
    @Override
    public boolean richiediPrestito(int giorni) {
        if(giorni > 5)
            return false;

        return super.richiediPrestito(giorni);
    }
}
