package Model;

import Model.Titoli.Anime;
import Model.Titoli.Film;
import Model.Titoli.Serie;

import java.util.ArrayList;
import java.util.Comparator;

/**
 * Classe che rappresenta un database di titoli.
 */
public class TitoliDB {
    private ArrayList<Titolo> archivio;

    /**
     * Costruttore per creare il database dei titoli.
     */
    public TitoliDB() {
        archivio = new ArrayList<>();

        archivio.add(new Serie  ("Boris",           "2010", "Italiano",     10, 4));
        archivio.add(new Anime  ("Attack on titan", "2013", "Giapponese",   10, "inglese"));
        archivio.add(new Film   ("Parasite",        "2019", "Inglese",      20));
        archivio.add(new Anime  ("Pokemon",         "2010", "Inglese",      10, "no"));
        archivio.add(new Film   ("The Irishman",    "2019", "Inglese",      5));
        archivio.add(new Serie  ("1994",            "2019", "Italiano",     10, 3));
        archivio.add(new Film   ("Her",             "2013", "Inglese",      20));

        sortByName();
    }

    /**
     * Restituisce l'archivio dei titoli.
     *
     * @return La lista dei titoli.
     */
    public ArrayList<Titolo> getArchivio() {
        return archivio;
    }

    /**
     * Ordina i titoli per nome.
     */
    public void sortByName() {
        archivio.sort(Comparator.comparing(Titolo::getTitolo));
    }

    /**
     * Ordina i titoli per anno.
     */
    public void sortByAnno(){
        archivio.sort(Comparator.comparingInt(titolo -> Integer.parseInt(titolo.getAnno())));
    }

    /**
     * Ordina i titoli per tipo (Film, Anime, Serie).
     * A parità di anno di pubblicazione e/o tipologia, si ordina alfabeticamente.
     */
    public void sortByType() {
        archivio.sort(Comparator.comparing((Titolo titolo) -> {
            if (titolo instanceof Film) {
                return 1;
            } else if (titolo instanceof Anime) {
                return 2;
            } else if (titolo instanceof Serie) {
                return 3;
            }
            return 4;
        }).thenComparing(Titolo::getTitolo));
    }
}