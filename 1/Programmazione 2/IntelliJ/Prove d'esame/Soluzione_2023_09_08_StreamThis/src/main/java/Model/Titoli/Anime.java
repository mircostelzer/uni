package Model.Titoli;

import Model.Titolo;

/**
 * Rappresenta un titolo di anime, che è un tipo specializzato di titolo con sottotitoli.
 */
public class Anime extends Titolo {
    private String sottotitoli;

    /**
     * Costruisce una nuova istanza di Anime.
     *
     * @param titolo Il nome del titolo.
     * @param anno L'anno di rilascio.
     * @param lingua La lingua del titolo.
     * @param prezzoBase Il prezzo base del titolo.
     * @param sottotitoli I sottotitoli disponibili per l'anime.
     */
    public Anime(String titolo, String anno, String lingua, double prezzoBase, String sottotitoli) {
        super(titolo, anno, lingua, prezzoBase);
        this.sottotitoli = sottotitoli;
    }

    /**
     * Restituisce una rappresentazione sotto forma di stringa dell'Anime.
     *
     * @return Una rappresentazione sotto forma di stringa dell'anime, inclusi i sottotitoli.
     */
    @Override
    public String toString() {
        return super.toString() + "\n   Sottotitoli: " + sottotitoli;
    }
}
