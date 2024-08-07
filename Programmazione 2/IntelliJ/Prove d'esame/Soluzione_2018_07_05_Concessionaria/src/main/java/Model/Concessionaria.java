package Model;

import Model.Autos.Berlina;
import Model.Autos.Sportiva;
import Model.Autos.Utilitaria;
import Model.Enums.Accessori;
import Model.Enums.TipoMotore;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

/**
 * La classe Concessionaria rappresenta una concessionaria di automobili.
 * Gestisce un elenco di automobili e fornisce metodi per ottenere e ordinare le automobili.
 */
public class Concessionaria {
    private ArrayList<Auto> automobili; // Lista delle automobili presenti in concessionaria
    private boolean isSortedByID; // Flag che indica se l'elenco delle automobili è ordinato per ID

    /**
     * Costruttore per la classe Concessionaria.
     * Crea una nuova istanza di Concessionaria e popola l'elenco delle automobili con esempi di auto di diversi tipi.
     * L'elenco delle automobili viene ordinato inizialmente per ID.
     */
    public Concessionaria() {
        isSortedByID = true;

        automobili = new ArrayList<>();

        automobili.add(new Berlina("B1", "2000", TipoMotore.BENZINA, "2016", 20000, 2));
        automobili.add(new Berlina("B2", "2000", TipoMotore.DIESEL, "2018", 30000, 6));
        automobili.add(new Berlina("B3", "2000", TipoMotore.IBRIDO, "2017", 35000, 4));
        automobili.add(new Utilitaria("U1", "1000", TipoMotore.BENZINA, "2018", 10000, 1));
        automobili.add(new Utilitaria("U2", "1300", TipoMotore.IBRIDO, "2014", 28000, 2));
        automobili.add(new Utilitaria("U3", "1200", TipoMotore.DIESEL, "2016", 12000, 6));
        automobili.add(new Sportiva("S1", "3000", TipoMotore.BENZINA, "2015", 50000, 3, new ArrayList<>(Arrays.asList(Accessori.SPOILER, Accessori.CAMBIO_AUTOMATICO))));
        automobili.add(new Sportiva("S2", "2800", TipoMotore.BENZINA, "2018", 30000, 6, new ArrayList<>(Arrays.asList(Accessori.TETTO_A_SCOMPARSA, Accessori.SEDILI_IN_PELLE))));
        automobili.add(new Sportiva("S3", "3000", TipoMotore.BENZINA, "2013", 65000, 5, new ArrayList<>(Arrays.asList(Accessori.CROMATURE, Accessori.VOLANTE_ERGONOMICO))));

        sortAutomobili();
    }

    /**
     * Restituisce un valore booleano che indica se l'elenco delle automobili è ordinato per ID.
     *
     * @return true se l'elenco delle automobili è ordinato per ID, altrimenti false
     */
    public boolean isSortedByID() {
        return isSortedByID;
    }

    /**
     * Restituisce l'elenco delle automobili presenti in concessionaria.
     *
     * @return ArrayList di automobili
     */
    public ArrayList<Auto> getAutomobili() {
        return automobili;
    }

    /**
     * Ordina l'elenco delle automobili in base al criterio specificato: per ID o per mese di esposizione, anno di costruzione e ID.
     */
    public void sortAutomobili(){
        if(isSortedByID)
            automobili.sort(Comparator.comparing(Auto :: getCar_ID));
        else
            automobili.sort(Comparator.comparing(Auto :: getMeseEsposizione).thenComparing(Auto :: getAnnoCostruzione).thenComparingInt(Auto :: getCar_ID));

        changeSorting();
    }

    /**
     * Inverte l'ordinamento delle automobili da ID a un altro criterio di ordinamento e viceversa.
     */
    private void changeSorting(){
        isSortedByID = !isSortedByID;
    }
}
