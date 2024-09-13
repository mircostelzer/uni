package controller;

import model.Archive;
import view.MainGui;

public class Controller {
    private MainGui mainGui;
    Archive archive;

    public Controller(Archive archive) {
        this.mainGui = new MainGui(archive, this);
        this.archive = archive;
    }

    public void toggleComparator() {
        archive.toggleComparator();
        mainGui.redraw();
    }

    public void showAll() {
        archive.showAll();
        mainGui.redraw();
    }

    public void showStudents() {
        archive.filteredStudents();
        mainGui.redraw();
    }

    public void showAthletes() {
        archive.filteredAthletes();
        mainGui.redraw();
    }

    public MainGui getMainGui() {
        return mainGui;
    }
}
