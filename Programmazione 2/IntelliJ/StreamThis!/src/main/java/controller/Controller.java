package controller;

import model.FilmCatalog;
import model.shows.Film;
import view.CatalogPane;
import view.InfoPane;
import view.MainGui;

import java.util.Comparator;

public class Controller {
    private MainGui mainGui;
    private FilmCatalog filmCatalog;
    private InfoPane infoPane;
    private CatalogPane catalogPane;

    public Controller(FilmCatalog filmCatalog) {
        this.filmCatalog = filmCatalog;
        this.mainGui = new MainGui(filmCatalog, this);
        this.infoPane = mainGui.getInfoPane();
        this.catalogPane = mainGui.getCatalogPane();
    }

    public MainGui getMainGui() {
        return mainGui;
    }

    public void toggleComparator(Comparator<Film> comparator) {
        filmCatalog.toggleComparator(comparator);
        catalogPane.redraw();
    }

    public void selectShow(Film film) {
        this.infoPane.setShow(film);
    }
}
