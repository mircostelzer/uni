package model.comparators;

import model.shows.Film;

import java.util.Comparator;

public class YearComparator implements Comparator<Film> {
    @Override
    public int compare(Film o1, Film o2) {
        if (o1.getYear() == o2.getYear()) {
            return o1.getTitle().compareTo(o2.getTitle());
        }
        else {
            return o1.getYear() - o2.getYear();
        }
    }
}
