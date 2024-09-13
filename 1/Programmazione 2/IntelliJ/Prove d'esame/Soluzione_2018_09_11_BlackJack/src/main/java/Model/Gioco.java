package Model;

import java.util.ArrayList;
import java.util.Random;

/**
 * La classe Gioco gestisce la logica del gioco di carte tra due giocatori.
 */
public class Gioco {
    private Mano mano1; // Mano del primo giocatore
    private Mano mano2; // Mano del secondo giocatore
    private Mazzo mazzo; // Mazzo di carte

    /**
     * Costruttore della classe Gioco.
     * Inizializza il mazzo, mescola le carte e distribuisce le mani iniziali ai giocatori.
     */
    public Gioco() {
        mazzo = new Mazzo();
        mazzo.mescola();

        ArrayList<Carta> m1 = new ArrayList<>();
        ArrayList<Carta> m2 = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            m1.add(mazzo.daiCarta());
            m2.add(mazzo.daiCarta());
        }

        mano1 = new Mano("PIPPO", m1);
        mano2 = new Mano("PLUTO", m2);

        System.out.println("MANI INIZIALI:");
        System.out.println(mano1.getGiocatore() + ": " + mano1.getCarte());
        System.out.println(mano2.getGiocatore() + ": " + mano2.getCarte());
        System.out.println("\nTURNO DI " + mano1.getGiocatore());
    }

    /**
     * Restituisce la mano del primo giocatore.
     *
     * @return La mano del primo giocatore
     */
    public Mano getMano1() {
        return mano1;
    }

    /**
     * Restituisce la mano del secondo giocatore.
     *
     * @return La mano del secondo giocatore
     */
    public Mano getMano2() {
        return mano2;
    }

    /**
     * Esegue l'azione di pescare una carta dall'avversario e aggiungerla alla mano del giocatore corrente.
     *
     * @param giocatoreCorrente Il giocatore corrente che pesca una carta
     * @param avversario Il giocatore avversario che subisce la pesca
     */
    public void pescaDallAvversario(Mano giocatoreCorrente, Mano avversario){
        Random r = new Random();
        int cardIndex = r.nextInt(avversario.getCarte().size());

        Carta c = avversario.getCarte().get(cardIndex);
        giocatoreCorrente.aggiungiCarta(c);

        avversario.rimuoviCarta(cardIndex);
    }

    /**
     * Scarta le coppie di carte con lo stesso valore dalla mano specificata.
     *
     * @param mano La mano in cui cercare e scartare le coppie
     * @return true se almeno una coppia è stata scartata, altrimenti false
     */
    public boolean scartaCoppie(Mano mano){
        ArrayList<Carta> m = mano.getCarte();
        boolean ret = false;

        int c1 = 0;
        int c2 = 0;
        int c3 = 0;
        int c4 = 0;

        for (Carta carta : m) {
            switch (carta.getValore()) {
                case 1:
                    c1++;
                    break;
                case 2:
                    c2++;
                    break;
                case 3:
                    c3++;
                    break;
                case 4:
                    c4++;
                    break;
            }
        }

        if(c1 > 1){
            removeAllElementsWithValue(mano, 1);
            ret = true;
        }
        if(c2 > 1){
            removeAllElementsWithValue(mano, 2);
            ret = true;
        }
        if(c3 > 1){
            removeAllElementsWithValue(mano, 3);
            ret = true;
        }
        if(c4 > 1){
            removeAllElementsWithValue(mano, 4);
            ret = true;
        }

        return ret;
    }

    /**
     * Pesca una carta dal mazzo e la aggiunge alla mano specificata.
     *
     * @param mano La mano in cui aggiungere la carta pescata
     */
    public void pescaDalMazzo(Mano mano){
        Carta c = mazzo.daiCarta();
        mano.aggiungiCarta(c);
    }

    /**
     * Rimuove tutti gli elementi della mano specificata che hanno il valore speciticato.
     *
     * @param mano La mano in cui rimuovere gli elementi
     * @param value Valore delle carte da rimuovere
     */
    private void removeAllElementsWithValue(Mano mano, int value){
        ArrayList<Carta> carteDaRimuovere = new ArrayList<>();

        for (int i = 0; i < mano.getCarte().size(); i++) {
            Carta carta = mano.getCarte().get(i);
            if (carta.getValore() == value) {
                carteDaRimuovere.add(carta);
            }
        }

        for (int i = carteDaRimuovere.size() - 1; i >= 0; i--) {
            Carta carta = carteDaRimuovere.get(i);
            int index = mano.getCarte().indexOf(carta);
            mano.rimuoviCarta(index);
        }
    }

    //non usato
    private boolean equals(Carta a, Carta b){
        return a.getValore() == b.getValore();
    }
}
