package model;

import model.comparators.NameComparator;
import model.shows.Anime;
import model.shows.Film;
import model.shows.TVShow;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class FilmCatalog {
    private List<Film> shows;
    private Comparator<Film> comparator;

    public FilmCatalog() {
        shows = new ArrayList<>();
        comparator = new NameComparator();
        shows.add(new TVShow("Boris", 2010, "Italiano", 10, 4));
        shows.add(new Anime("Attack on Titan", 2013, "Giapponese", 10, "Inglese"));
        shows.add(new Film("Parasite", 2019, "Inglese", 20));
        shows.add(new Anime("Pokemon", 2010, "Inglese", 10, "No sottotitoli"));
        shows.add(new Film("The Irishman", 2019, "Inglese", 5));
        shows.add(new TVShow("1994", 2019, "Italiano", 10, 3));
        shows.add(new Film("Her", 2013, "Inglese", 20));
        shows.sort(comparator);
    }

    public List<Film> getShows() {
        return shows;
    }

    public void toggleComparator(Comparator<Film> comparator) {
        this.comparator = comparator;
        shows.sort(comparator);
    }
}
