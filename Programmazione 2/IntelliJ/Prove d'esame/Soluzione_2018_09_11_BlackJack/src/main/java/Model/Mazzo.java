package Model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Mazzo extends ArrayList<Carta>{

    public Mazzo() {
        super();

        for(int i = 1; i < 5; i++){
            add(new Carta(i, Semi.CUORI));
            add(new Carta(i, Semi.QUADRI));
            add(new Carta(i, Semi.FIORI));
            add(new Carta(i, Semi.PICCHE));
        }

        add(new Carta(0, Semi.J));
    }

    private void sortMazzo(){
        sort(Comparator.comparingInt(Carta :: getValore).thenComparing(Carta :: getSeme));
    }

    public void mescola(){
        Collections.shuffle(this);
    }

    public Carta daiCarta(){
        Carta c = get(0);
        remove(0);
        return c;
    }

    public static void main(String[] args) {
        Mazzo m = new Mazzo();
        m.mescola();
        System.out.println(m);
        m.sortMazzo();
        System.out.println(m);
    }
}
