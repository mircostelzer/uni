package com.company;

/**
 * Sottoclasse di <code>Pubblicazione</code> per un ebook.
 *
 * Un Ebook si caratterizza per il numero di pagine e il formato digitale.
 */
public class EBook extends Libro {

    String formato;

    /**
     * Costruttore della classe <code>EBook</code>>

     *
     *  @param titolo            titolo della pubblicazione
     *  @param annoPubblicazione primo anno di pubblicazione
     *  @param autore            autore della pubblicazione
     *  @param numPagine         il numero di pagine del ebook
     * @param formato            il formato digitale del ebook
     *  @param prestabile        booleano che indica se è ammesso il prestito
     */
    public EBook(String titolo, int annoPubblicazione, String autore, int numPagine, String formato, boolean prestabile) {
        super(titolo, annoPubblicazione, autore, numPagine, prestabile);
        this.formato = formato;
    }

    /**
     * Ritorna una stringa che indica che la pubblicazione è un ebook, il formato digitale e il numero di pagina.
     * @return stringa con le caratteristiche del film
     */
    @Override
    public String caratteristiche() {
        return "EBook " + formato + " " + numPagine + " pagine";
    }

    /**
     * Metodo per registrare un prestito.
     *
     * Prima di chiamare l'implementazione della classe padre controlla che non si richiesto il libro per più di 20
     * giorni.
     *
     * @param giorni il numero di giorni per cui si richiede il prestito.
     * @return <code>true</code> se il prestito è accettato, <code>false</code> altrimenti.
     */
    @Override
    public boolean richiediPrestito(int giorni) {
        if(giorni > 20)
            return false;

        return super.richiediPrestito(giorni);
    }
}
