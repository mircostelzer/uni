package Model.Autos;

import Model.Auto;
import Model.Enums.TipoMotore;

/**
 * La classe Utilitaria rappresenta un'automobile di tipo utilitaria.
 * Estende la classe astratta Auto e implementa il metodo per calcolare uno sconto fisso sul prezzo base dell'auto.
 */
public class Utilitaria extends Auto {
    private static final double SCONTO_FISSO = 0.05; // Sconto fisso del 5%

    /**
     * Costruttore per la classe Utilitaria.
     *
     * @param modello          Il modello dell'auto
     * @param cilindrata       La cilindrata dell'auto
     * @param tipoMotore       Il tipo di motore dell'auto
     * @param annoCostruzione  L'anno di costruzione dell'auto
     * @param prezzoBase       Il prezzo base dell'auto
     * @param meseEsposizione  Il mese di esposizione dell'auto
     */
    public Utilitaria(String modello, String cilindrata, TipoMotore tipoMotore, String annoCostruzione, double prezzoBase, int meseEsposizione) {
        super(modello, cilindrata, tipoMotore, annoCostruzione, prezzoBase, meseEsposizione);
    }

    /**
     * Il metodo calcolaSconto() per le auto utilitarie applica uno sconto fisso del 5% sul prezzo base dell'auto.
     */
    @Override
    public void calcolaSconto() {
        double nuovoPrezzo = getPrezzoBase() - (getPrezzoBase() * SCONTO_FISSO); // Calcolo del nuovo prezzo dopo lo sconto
        setPrezzoVendita(nuovoPrezzo); // Impostazione del prezzo di vendita con lo sconto applicato
    }
}
