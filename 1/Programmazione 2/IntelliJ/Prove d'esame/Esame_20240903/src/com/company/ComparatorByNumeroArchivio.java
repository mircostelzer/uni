package com.company;

import java.util.Comparator;

/**
 * Implementazione dell'ordinamento per numero d'archivio
 */
public class ComparatorByNumeroArchivio implements Comparator<Pubblicazione> {

    /**
     * Implementa l'ordinamento per numero d'archivio per le pubblicazioni.
     *
     * @param o1 primo oggetto da comparare.
     * @param o2 secondo oggetto da comparare
     *
     * @return <ul>
     * <li>un valore minore di 0 se <code>o1</code> è minore di <code>o2</code></li>
     * <li><code>0</code> se <code>o1</code> e <code>o2</code> sono uguali </li>
     * <li>un valore maggiore di 0 se <code>o1</code> è maggiore di <code>o2</code></li>
     * </ul>
     */
    @Override
    public int compare(Pubblicazione o1, Pubblicazione o2) {
        return o1.numero_archivio - o2.numero_archivio;
    }
}
