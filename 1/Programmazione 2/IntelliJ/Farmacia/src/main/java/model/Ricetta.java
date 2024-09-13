package model;

import model.exceptions.ExpiredException;

import java.util.Date;

public class Ricetta{
    private ConRicetta medicina;
    private ExpirationDate expirationDate;
    private int counter;
    private boolean isSelected;

    public Ricetta(ConRicetta medicina, ExpirationDate expirationDate){
        this.medicina = medicina;
        this.expirationDate = expirationDate;
        this.counter = 0;
        this.isSelected = false;
    }

    public ExpirationDate getExpirationDate(){
        return expirationDate;
    }

    public int getCounter() {
        return counter;
    }

    public boolean isSelected() {
        return isSelected;
    }

    public void select() {
        this.isSelected = true;
    }

    public void useRicetta() {
        this.counter++;
        this.isSelected = false;
    }

    private String selectText() {
        if (this.isSelected) {
            return "\n(selezionata)";
        }
        return "";
    }

    public String toString() {
        return "Ricetta per: " + medicina.getName() + "\n" + expirationDate.toString() + selectText();
    }

}

