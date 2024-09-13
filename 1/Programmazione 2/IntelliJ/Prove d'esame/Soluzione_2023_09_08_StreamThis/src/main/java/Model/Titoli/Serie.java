package Model.Titoli;

import Model.Titolo;

/**
 * Rappresenta un titolo di serie, che è un tipo specializzato di titolo con stagioni.
 */
public class Serie extends Titolo {
    private int nStagioni;
    private int nStagioniSelezionate;

    /**
     * Costruisce una nuova istanza di Serie.
     *
     * @param titolo Il nome del titolo.
     * @param anno L'anno di rilascio.
     * @param lingua La lingua del titolo.
     * @param prezzoBase Il prezzo base del titolo.
     * @param nStagioni Il numero di stagioni della serie.
     */
    public Serie(String titolo, String anno, String lingua, double prezzoBase, int nStagioni) {
        super(titolo, anno, lingua, prezzoBase);
        this.nStagioni = nStagioni;
        nStagioniSelezionate = 0;
    }

    /**
     * Restituisce il numero di stagioni della serie.
     *
     * @return Il numero di stagioni.
     */
    public int getnStagioni() {
        return nStagioni;
    }

    /**
     * Incrementa il numero di stagioni selezionate.
     */
    public void incrementaStagioniSelezionate() {
        nStagioniSelezionate++;
    }

    /**
     * Applica uno sconto basato sul numero di stagioni selezionate.
     */
    public void scontoStagioni() {
        double nuovoPrezzo = calcolaSconto();
        if (nStagioniSelezionate > 1 && nStagioniSelezionate < nStagioni) {
            setPrezzoScontato(nuovoPrezzo - nuovoPrezzo * 0.25);
        } else if (nStagioniSelezionate == nStagioni) {
            setPrezzoScontato(nuovoPrezzo / 2);
        }
    }

    /**
     * Reimposta il prezzo scontato e il numero di stagioni selezionate.
     */
    @Override
    public void resetPrezzo() {
        super.resetPrezzo();
        nStagioniSelezionate = 0;
    }
}
