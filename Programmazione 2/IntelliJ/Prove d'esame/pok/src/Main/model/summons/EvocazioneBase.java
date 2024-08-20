package Main.model.summons;

import Main.model.energies.Energy;
import Main.model.exceptions.IncompatibleEnergyException;
import Main.model.exceptions.WrongEnergiesException;
import javafx.scene.paint.Color;
import java.util.ArrayList;

public class EvocazioneBase implements Evocazione{

    protected String name;
    protected int pvmax;
    protected int pvattuali;
    protected Energy type;
    protected Attack att;
    protected ArrayList<Energy> assignedEnergies;

    public EvocazioneBase(String n, int p, Energy t, Attack a) throws IncompatibleEnergyException {
        this.name = n;
        this.pvmax = p;
        this.pvattuali = this.pvmax;
        this.type = t;
        this.att = a;

        if (!a.getEnergy().equals(this.type)){
            throw new IncompatibleEnergyException();
        }
        this.att.setEv(this);

        this.assignedEnergies = new ArrayList<>();
    }

    public void attack(ArrayList<Evocazione> target) throws WrongEnergiesException {
        this.attack(target.get(0));
    }
    protected void attack(Evocazione t) throws WrongEnergiesException {
        this.att.applyto(t);
    }
    public void applydamage(int d) {
        this.pvattuali -= d;
    }
    public Energy getEnergyType() {
        return this.type;
    }
    public ArrayList<Energy> getAllEnergies() {
        return this.assignedEnergies;
    }
    public boolean isdead() {
        return this.pvattuali<=0;
    }

    public void assignEnergy(Energy e) throws IncompatibleEnergyException {
        if (! e.equals(this.type) ){
            throw new IncompatibleEnergyException();
        }
        this.assignedEnergies.add(e);
    }

    public Color getBorderColor() {
        return this.type.getColor();
    }

    public String getFirstLine() {
        return this.name;
    }
    public String getSecondLine() {
        return this.pvattuali+"/"+this.pvmax+" PV";
    }
    public String getThirdLine() {
        return "Energie: "+this.assignedEnergies.size();
    }
    public String getFourthLine() {
        return this.att.getDescription()+" "+this.getTargets();
    }
    protected String getTargets(){
        return "";
    }
}
