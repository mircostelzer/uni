package Model.Autos;

import Model.Enums.Accessori;
import Model.Auto;
import Model.Enums.TipoMotore;

import java.util.ArrayList;

/**
 * La classe Sportiva rappresenta un'automobile di tipo sportivo.
 * Estende la classe astratta Auto e gestisce gli accessori disponibili per l'auto.
 */
public class Sportiva extends Auto {
    private ArrayList<Accessori> accessori; // Lista degli accessori disponibili per l'auto

    /**
     * Costruttore per la classe Sportiva.
     *
     * @param modello          Il modello dell'auto
     * @param cilindrata       La cilindrata dell'auto
     * @param tipoMotore       Il tipo di motore dell'auto
     * @param annoCostruzione  L'anno di costruzione dell'auto
     * @param prezzoBase       Il prezzo base dell'auto
     * @param meseEsposizione  Il mese di esposizione dell'auto
     * @param accessori        Gli accessori disponibili per l'auto
     */
    public Sportiva(String modello, String cilindrata, TipoMotore tipoMotore, String annoCostruzione, double prezzoBase, int meseEsposizione, ArrayList<Accessori> accessori) {
        super(modello, cilindrata, tipoMotore, annoCostruzione, prezzoBase, meseEsposizione);
        this.accessori = new ArrayList<>(accessori);
    }

    /**
     * Il metodo calcolaSconto() per le auto sportive imposta il prezzo di vendita al prezzo base senza applicare sconti.
     */
    @Override
    public void calcolaSconto() {
        setPrezzoVendita(getPrezzoBase());
    }

    /**
     * Restituisce una rappresentazione testuale dell'auto sportiva, includendo anche gli accessori disponibili.
     *
     * @return Una stringa rappresentante l'auto sportiva
     */
    @Override
    public String toString() {
        return super.toString() + "\naccessori in offerta= " + accessori.toString();
    }
}
