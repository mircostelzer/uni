package model.geralt;

import model.exceptions.AggiuntaException;
import model.functions.MyConsumer;
import model.mutations.abstracts.AbstractMutation;
import model.mutations.abstracts.CombatMutation;
import model.mutations.abstracts.PotionMutation;
import model.mutations.abstracts.SpellMutation;
import model.mutations.muts.EmptyMutation;
import java.util.ArrayList;

public class Geralt {
    public int level = 0;
    public  int str = 10;
    public  int vel = 10;
    public  int tol = 2;

    public ArrayList<Spell> spellist = new ArrayList<Spell>();

    private AbstractMutation cm= new EmptyMutation();
    private AbstractMutation sm= new EmptyMutation();
    private AbstractMutation pm= new EmptyMutation();
    private AbstractMutation am= new EmptyMutation();

    public Geralt(){
        super();
    }

    public void applyModifier(MyConsumer<Geralt> c){
        c.accept(this);
    }

    public String toString(){
        return "Geralt: lvl: "+level+" str: "+str+" spells: "+spellist+" \n " +
                "muts: "+cm+"||"+sm+"||"+pm+"||"+am;
    }

    private void addCommonMutation(AbstractMutation toadd, AbstractMutation where, Runnable con) throws AggiuntaException{
        if (where.isEmpty()){
            con.run();
        }else if (this.am.isEmpty()){
            this.am = toadd;
        }else {
            throw new AggiuntaException();
        }
    }

    public void addCombatMutation(CombatMutation m) throws AggiuntaException {
        this.addCommonMutation(m, this.cm, () -> {this.cm = m;});
    }

    public void addSpellMutation(SpellMutation m) throws AggiuntaException{
        this.addCommonMutation(m, this.sm, () -> {this.sm = m;});
    }
    public void addPotionMutation(PotionMutation m) throws AggiuntaException{
        this.addCommonMutation(m, this.pm, () -> {this.pm = m;});
    }
    public void removeMutation(AbstractMutation m) {
        if (this.cm == m){
            cm = new EmptyMutation();
        }else if (this.sm == m){
            sm = new EmptyMutation();
        }else if (this.pm == m){
            pm = new EmptyMutation();
        }else if (this.am == m){
            am = new EmptyMutation();
        }else{
            throw new RuntimeException("wut");
        }
    }

    public AbstractMutation getCm() {
        return cm;
    }

    public AbstractMutation getSm() {
        return sm;
    }

    public AbstractMutation getPm() {
        return pm;
    }

    public AbstractMutation getAm() {
        return am;
    }
}
