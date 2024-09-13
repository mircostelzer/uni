package Model.Records;

import Model.Record;

/**
 * Questa classe rappresenta un record di un'automobile.
 * Estende la classe astratta Record e ha tre campi: marca, modello e prezzo.
 */
public class Automobile extends Record {

    /**
     * Costruttore per creare un nuovo record di un'automobile.
     *
     * @param marca   La marca dell'automobile.
     * @param modello Il modello dell'automobile.
     * @param prezzo  Il prezzo dell'automobile.
     */
    public Automobile(String marca, String modello, Integer prezzo) {
        super(marca, modello, prezzo);
    }
}
