package com.company;

/**
 * Sottoclasse di <code>Pubblicazione</code> per un libro.
 *
 * Un libro si caratterizza per il numero di pagine.
 */
public class Libro extends Pubblicazione {

    int numPagine;

    /**
     * Costruttore della classe <code>Libro</code>>

     *
     *  @param titolo            titolo della pubblicazione
     *  @param annoPubblicazione primo anno di pubblicazione
     *  @param autore            autore della pubblicazione
     *  @param numPagine         il numero di pagine del libro
     *  @param prestabile        booleano che indica se è ammesso il prestito
     */
    public Libro(String titolo, int annoPubblicazione, String autore, int numPagine, boolean prestabile) {
        super(titolo, annoPubblicazione, autore, prestabile);
        this.numPagine = numPagine;
    }

    /**
     * Restituisce la stringa che indica che la pubblicazione è un libro e il numero di pagine
     * @return stringa con le caratteristiche del libro
     */
    @Override
    public String caratteristiche() {
        return "Libro " + numPagine + " pagine";
    }

    /**
     * Metodo per registrare un prestito.
     *
     * Prima di chiamare l'implementazione della classe padre controlla che non si richiesto il libro per più di 30
     * giorni.
     *
     * @param giorni il numero di giorni per cui si richiede il prestito.
     * @return <code>true</code> se il prestito è accettato, <code>false</code> altrimenti.
     */
    @Override
    public boolean richiediPrestito(int giorni) {
        if(giorni > 30)
            return false;

        return super.richiediPrestito(giorni);
    }
}
