package Model.Titoli;

import Model.Titolo;

/**
 * Rappresenta un titolo di film.
 */
public class Film extends Titolo {

    /**
     * Costruisce una nuova istanza di Film.
     *
     * @param titolo Il nome del titolo.
     * @param anno L'anno di rilascio.
     * @param lingua La lingua del titolo.
     * @param prezzoBase Il prezzo base del titolo.
     */
    public Film(String titolo, String anno, String lingua, double prezzoBase) {
        super(titolo, anno, lingua, prezzoBase);
    }
}
