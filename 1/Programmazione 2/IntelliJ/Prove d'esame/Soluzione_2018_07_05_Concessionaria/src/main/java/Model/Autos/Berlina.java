package Model.Autos;

import Model.Auto;
import Model.Enums.TipoMotore;

import java.util.Calendar;

/**
 * La classe Berlina rappresenta un'automobile di tipo berlina.
 * Estende la classe astratta Auto e implementa il metodo per calcolare lo sconto basato sul mese di esposizione dell'auto.
 */
public class Berlina extends Auto {

    /**
     * Costruttore per la classe Berlina.
     *
     * @param modello          Il modello dell'auto
     * @param cilindrata       La cilindrata dell'auto
     * @param tipoMotore       Il tipo di motore dell'auto
     * @param annoCostruzione  L'anno di costruzione dell'auto
     * @param prezzoBase       Il prezzo base dell'auto
     * @param meseEsposizione  Il mese di esposizione dell'auto
     */
    public Berlina(String modello, String cilindrata, TipoMotore tipoMotore, String annoCostruzione, double prezzoBase, int meseEsposizione) {
        super(modello, cilindrata, tipoMotore, annoCostruzione, prezzoBase, meseEsposizione);
    }

    /**
     * Calcola lo sconto per l'auto berlina basato sul mese di esposizione.
     * Se l'auto è esposta da meno di 5 mesi, lo sconto aumenta gradualmente dell'1%.
     * Se l'auto è esposta da più di 5 mesi, lo sconto massimo è del 5%.
     */
    @Override
    public void calcolaSconto() {
        int meseCorrente = Calendar.getInstance().get(Calendar.MONTH) + 1;
        int differenzaMesi = getMeseEsposizione() - meseCorrente;

        double sconto = 0.01;

        if (differenzaMesi <= 0)
            sconto = 0;
        if (differenzaMesi < 5)
            sconto *= differenzaMesi;
        else
            sconto = 0.05;

        double nuovoPrezzo = getPrezzoBase() - (getPrezzoBase() * sconto);

        setPrezzoVendita(nuovoPrezzo);
    }
}
