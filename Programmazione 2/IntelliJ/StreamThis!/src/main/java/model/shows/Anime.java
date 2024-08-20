package model.shows;

import model.AbstractShow;

public class Anime extends AbstractShow {
    private String dubbing;

    public Anime(String title, int year, String language, double basePrice, String dubbing) {
        super(title, year, language, basePrice);
        this.dubbing = dubbing;
    }

    public String completeInfo() {
        return super.completeInfo() + "\n" + "Sottotitoli: " + dubbing;
    }
}
