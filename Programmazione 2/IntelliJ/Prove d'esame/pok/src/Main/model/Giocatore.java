package Main.model;

import Main.model.energies.Energy;
import Main.model.exceptions.GameOverException;
import Main.model.exceptions.IncompatibleEnergyException;
import Main.model.exceptions.WrongEnergiesException;
import Main.model.summons.Evocazione;
import java.util.ArrayList;

public class Giocatore {

    private int id;
    private Giocatore altro;
    private ArrayList<Evocazione> evocazioni;
    private ArrayList<Energy> energie;

    public Giocatore(int i, ArrayList<Evocazione> e, ArrayList<Energy> en){
        this.id = i;
        this.evocazioni = e;
        this.energie = en;
    }
    public void setAltroGiocatore(Giocatore a){
        this.altro = a;
    }
    public ArrayList<Energy> getEnergie() {
        return energie;
    }
    public ArrayList<Evocazione> getEvocazioni(){
        return this.evocazioni;
    }

    public Evocazione getEvocazioneAttiva(){
        return this.evocazioni.get(0);
    }
    public void assegnaEnergia(int i) throws IncompatibleEnergyException{
        Energy e = this.energie.remove(i);
        try {
            this.getEvocazioneAttiva().assignEnergy(e);
        } catch (IncompatibleEnergyException ex) {
            this.energie.add(e);
            throw new IncompatibleEnergyException();
        }
    }
    public void attacca() throws WrongEnergiesException, GameOverException {
        this.getEvocazioneAttiva().attack(altro.getEvocazioni());
        try {
            altro.checkdeath();
        } catch (GameOverException e){
            // cleanup my memory
            throw e;
        }
    }
    public void checkdeath() throws GameOverException {
        for (int i = 0 ; i < this.evocazioni.size() ; i++){
            Evocazione e = this.evocazioni.get(i);
            if (e.isdead()){
                this.removeEvocazione(e);
            }
        }
    }
    private void removeEvocazione(Evocazione e) throws GameOverException {
        this.evocazioni.remove(e);
        if (this.is_sconfitto()){
            // cleanup my memory
            throw new GameOverException();
        }
    }
    private boolean is_sconfitto(){
        return this.evocazioni.size() == 0;
    }
}
