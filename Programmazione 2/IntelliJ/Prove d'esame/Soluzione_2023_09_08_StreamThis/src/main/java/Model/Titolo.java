package Model;

/**
 * Una classe astratta che rappresenta un titolo con un nome, anno, lingua e prezzo base.
 */
public abstract class Titolo {
    private String titolo;
    private String anno;
    private String lingua;
    private double prezzoBase;
    private double prezzoScontato;

    /**
     * Costruisce una nuova istanza di Titolo.
     *
     * @param titolo Il nome del titolo.
     * @param anno L'anno di rilascio.
     * @param lingua La lingua del titolo.
     * @param prezzoBase Il prezzo base del titolo.
     */
    public Titolo(String titolo, String anno, String lingua, double prezzoBase) {
        this.titolo = titolo;
        this.anno = anno;
        this.lingua = lingua;
        this.prezzoBase = prezzoBase;
        prezzoScontato = prezzoBase;
        prezzoScontato = calcolaSconto();
    }

    /**
     * Restituisce l'anno del titolo.
     *
     * @return L'anno di rilascio.
     */
    public String getAnno() {
        return anno;
    }

    /**
     * Restituisce il nome del titolo.
     *
     * @return Il nome del titolo.
     */
    public String getTitolo() {
        return titolo;
    }

    /**
     * Calcola lo sconto in base all'anno di rilascio.
     *
     * @return Il prezzo scontato.
     */
    public double calcolaSconto() {
        double sconto = 0;
        if (Integer.parseInt(anno) < 2015) {
            sconto = 0.1;
        }
        return prezzoBase - prezzoBase * sconto;
    }

    /**
     * Restituisce il prezzo scontato del titolo.
     *
     * @return Il prezzo scontato.
     */
    public double getPrezzoScontato() {
        return prezzoScontato;
    }

    /**
     * Imposta il prezzo scontato del titolo.
     *
     * @param prezzoScontato Il prezzo scontato da impostare.
     */
    public void setPrezzoScontato(double prezzoScontato) {
        this.prezzoScontato = prezzoScontato;
    }

    /**
     * Reimposta il prezzo scontato in base al prezzo base corrente e all'anno.
     */
    public void resetPrezzo() {
        prezzoScontato = calcolaSconto();
    }

    /**
     * Restituisce una rappresentazione sotto forma di stringa del Titolo.
     *
     * @return Una rappresentazione sotto forma di stringa del titolo.
     */
    @Override
    public String toString() {
        return "     Titolo: " + titolo + "\n" +
                "    Anno: " + anno + "\n" +
                "   Lingua: " + lingua + "\n" +
                "Prezzo base: " + prezzoBase + "€";
    }
}
