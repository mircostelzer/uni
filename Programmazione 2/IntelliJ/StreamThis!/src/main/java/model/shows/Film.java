package model.shows;

public class Film {
    protected String title;
    protected int year;
    protected String language;
    protected double basePrice;
    protected double price;

    public Film(String title, int year, String language, double basePrice) {
        this.title = title;
        this.year = year;
        this.language = language;
        this.basePrice = basePrice;
        setPrice();
    }

    public String getTitle() {
        return title;
    }

    public int getYear() {
        return year;
    }

    public double getBasePrice() {
        return basePrice;
    }

    public double getPrice() {
        return price;
    }

    public String completeInfo() {
        return "Titolo: " + title + "\n" + "Anno: " + year + "\n" + "Lingua: " + language + "\n" + "Prezzo base: " + basePrice;
    }

    public String shortInfo() {
        return "(" + title + " '" + (year%100) + ")";
    }

    protected void setPrice() {
        if (year < 2015) {
            price = basePrice * 0.90;
        } else {
            price = basePrice;
        }
    }
}
