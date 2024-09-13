package com.company;

/**
 * Classe che rappresenta una generica pubblicazione.
 * La classe gestisce automaticamente un numero d'archivio, che è un intero che cresce autonomamente alla creazione di
 * un nuovo oggetto.
 */
public abstract class Pubblicazione implements Comparable<Pubblicazione> {
    static int id_counter = 0;
    int numero_archivio;

    String titolo;

    int annoPubblicazione;

    String autore;


    boolean prestabile = true;
    boolean prestato = false;
    Integer ritorno = 0;

    /**
     * Costruttore della classe.
     *
     * @param titolo            titolo della pubblicazione
     * @param annoPubblicazione primo anno di pubblicazione
     * @param autore            autore della pubblicazione
     * @param prestabile        booleano che indica se è ammesso il prestito
     */
    public Pubblicazione(String titolo, int annoPubblicazione, String autore, boolean prestabile) {
        this.titolo = titolo;
        this.annoPubblicazione = annoPubblicazione;
        this.autore = autore;
        this.prestabile = prestabile;

        numero_archivio = ++id_counter;
    }


    /**
     * Metodo per ottenere una stringa con tutte le informazioni che riguardano la pubblicazione
     */
    @Override
    public String toString() {
        String res = numero_archivio + " - " + titolo + " (" + autore + "," + annoPubblicazione + ") - " + caratteristiche() + " - ";
        res += getPrestitoString();
        return res;
    }

    /**
     * Metodo per ottenere le informazioni sul prestito
     *
     * @return stringa con le informazioni sul solo prestito
     */
    public String getPrestitoString() {
        String res;
        if (!prestabile) {
            res = "non prestabile";
        } else if (prestato) {
            res = "non disponibile per " + ritorno + " giorni";
        } else
            res = "disponibile";
        return res;
    }

    /**
     * Restituisce il numero d'archivio
     *
     * @return numero d'archivio
     */
    public int getNumero_archivio() {
        return numero_archivio;
    }

    /**
     * Ritorna il titolo della pubblicazione
     *
     * @return titolo della pubblicazione
     */
    public String getTitolo() {
        return titolo;
    }

    /**
     * Ritorna l'anno di prima pubblicazione
     *
     * @return anno di prima pubblicazione
     */
    public int getAnnoPubblicazione() {
        return annoPubblicazione;
    }

    /**
     * Ritorna l'autore della pubblicazione
     *
     * @return autore della pubblicazione
     */
    public String getAutore() {
        return autore;
    }

    /**
     * Ritorna se la pubblicazione è disponibile al prestito
     *
     * @return <code>true</code> se la pubblicazione è disponibile al prestito, <code>false</code> altrimenti
     */
    public boolean isPrestabile() {
        return prestabile;
    }

    /**
     * Ritorna se la pubblicazione è in prestito
     *
     * @return <code>true</code> la pubblicazione è già prestata, altrimenti <code>false</code>
     */
    public boolean isPrestato() {
        return prestato;
    }

    /**
     * Ritorna fra quanti giorni la pubblicazione è di nuovo disponibile al prestito.
     *
     * @return <code>null</code> se la pubblicazione non è in prestito, altrimenti un numero intero di giorni
     */
    public Integer getRitorno() {
        return ritorno;
    }

    /**
     * Metodo per ottenere una stringa con le caratteristiche tipiche di una pubblicazione
     *
     * @return stringa con le caratteristiche specifiche della pubblicazione
     */
    public abstract String caratteristiche();

    /**
     * Registra un prestito per la pubblicazione.
     * <p>
     * Il metodo esegue anche i controlli base: se la pubblicazione è disponibile al prestito e se è già in prestito.
     * Delega alle sottoclassi gli ulteriori controlli specifici.
     *
     * @param giorni il numero di giorni per cui si richiede il prestito.
     * @return <code>true</code> se il prestito è accettato, <code>false</code> altrimenti
     */
    public boolean richiediPrestito(int giorni) {
        if(!prestabile || prestato) {
            return false;
        } else {
            prestato = true;
            ritorno = giorni;
            return true;
        }
    }

    /**
     * Registra la restituzione di un prestito.
     */
    public void restituisci() {
        prestato = false;
        ritorno = null;
    }

    /**
     * Implementa l'ordinamento naturale per le pubblicazioni titolo/anno di pubblicazione
     *
     * @param o l'oggetto da comparare.
     * @return <ul>
     * <li>un valore minore di 0 se <code>this</code> è minore di <code>o</code></li>
     * <li><code>0</code> se <code>this</code> e <code>o</code> sono uguali </li>
     * <li>un valore maggiore di 0 se <code>this</code> è maggiore di <code>o</code></li>
     * </ul>
     */
    @Override
    public int compareTo(Pubblicazione o) {
        int r = titolo.compareTo(o.titolo);
        if(r == 0) {
            r = annoPubblicazione - o.annoPubblicazione;
        }
        if(r == 0) {
            r = numero_archivio - o.numero_archivio;
        }
        return r;
    }
}
