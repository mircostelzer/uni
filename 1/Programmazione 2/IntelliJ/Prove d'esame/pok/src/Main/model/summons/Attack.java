package Main.model.summons;

import Main.model.energies.Energy;
import Main.model.exceptions.WrongEnergiesException;
import java.util.ArrayList;

public class Attack {

    private String name;
    private int requiredEnergy;
    private Energy energy;
    private int damage;
    private Evocazione ev;

    public Attack(String n, int re, Energy e, int d){
        this.name = n;
        this.requiredEnergy = re;
        this.energy = e;
        this.damage = d;
    }
    protected void setEv(Evocazione e){
        this.ev = e;
    }
    public Energy getEnergy(){
        return this.energy;
    }

    public void applyto(Evocazione target) throws WrongEnergiesException {
        if ( ! this.soddisfatto(ev.getAllEnergies()) ){
            throw new WrongEnergiesException();
        }
        int dam = this.damage;
        if (target.getEnergyType().isNegation(this.energy) ){
            dam*=2;
        }
        target.applydamage(dam);
    }

    // prendo le energie che ha l'evocazione come parametro
    // creo i miei requirements 'myenergies'
    // rimuovo tutte le energie che ha l'evocazione':
    //  nota: usa equals
    // se i miei requirements sono vuoti, allora sono soddisfatto
    private boolean soddisfatto(ArrayList<Energy> energie){
        ArrayList<Energy> myenergies = new ArrayList<>();
        for (int i = 0 ; i < this.requiredEnergy ; i++){
            myenergies.add(i,this.energy);
        }
        for (Energy e:energie) {
            myenergies.remove(e);
        }
        return myenergies.isEmpty();
    }

    public String getDescription() {
        return this.name+" ("+this.requiredEnergy+")"
                +"\n"+this.damage+" danni";
    }
}
