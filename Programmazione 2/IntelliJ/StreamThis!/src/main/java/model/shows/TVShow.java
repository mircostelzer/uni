package model.shows;

import model.AbstractShow;

public class TVShow extends AbstractShow {
    private int seasonNumber;
    private int selectedSeasons;

    public TVShow(String title, int year, String language, double basePrice, int seasonNumber) {
        super(title, year, language, basePrice);
        this.seasonNumber = seasonNumber;
        this.selectedSeasons = 0;
        this.price = 0;
    }

    public void selectSeason() {
        if (selectedSeasons < seasonNumber) {
            selectedSeasons++;
        }
        this.setPrice();
    }

    public int getSeasonNumber() {
        return seasonNumber;
    }

    protected void setPrice() {
        super.setPrice();
        if (selectedSeasons == seasonNumber) {
            price = basePrice*seasonNumber*0.5;
        } else if (selectedSeasons > 1) {
            price = basePrice*selectedSeasons*0.75;
        } else {
            price = basePrice;
        }
    }

    public void reset() {
        price = 0;
        selectedSeasons = 0;
    }

}
