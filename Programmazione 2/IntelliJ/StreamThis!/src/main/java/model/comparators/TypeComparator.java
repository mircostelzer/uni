package model.comparators;

import model.shows.Anime;
import model.shows.Film;
import model.shows.TVShow;

import java.util.Comparator;

public class TypeComparator implements Comparator<Film> {
    @Override
    public int compare(Film o1, Film o2) {
        int f1 = generateNumber(o1);
        int f2 = generateNumber(o2);
        if (f1 == f2) {
            return o1.getTitle().compareTo(o2.getTitle());
        }
        return f1 - f2;
    }

    private int generateNumber(Film film) {
        if (film instanceof TVShow) {
            return 1;
        } else if (film instanceof Anime) {
            return 2;
        } else {
            return 3;
        }
    }
}
