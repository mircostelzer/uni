package Model;

import Model.Enums.TipoMotore;

/**
 * La classe astratta Auto rappresenta un'automobile generica.
 * Fornisce i metodi per gestire le informazioni relative all'automobile come modello, cilindrata, tipo di motore, anno di costruzione e prezzi.
 */
public abstract class Auto {
    private static int ID = 0; // Variabile statica per generare l'ID univoco per ogni auto

    private int car_ID; // ID univoco dell'auto
    private String modello; // Modello dell'auto
    private String cilindrata; // Cilindrata dell'auto
    private TipoMotore tipoMotore; // Tipo di motore dell'auto
    private String annoCostruzione; // Anno di costruzione dell'auto
    private double prezzoBase; // Prezzo base dell'auto
    private int meseEsposizione; // Mese di esposizione dell'auto
    private double prezzoVendita; // Prezzo di vendita dell'auto

    /**
     * Costruttore per la classe Auto.
     *
     * @param modello          Il modello dell'auto
     * @param cilindrata       La cilindrata dell'auto
     * @param tipoMotore       Il tipo di motore dell'auto
     * @param annoCostruzione  L'anno di costruzione dell'auto
     * @param prezzoBase       Il prezzo base dell'auto
     * @param meseEsposizione  Il mese di esposizione dell'auto
     */
    public Auto(String modello, String cilindrata, TipoMotore tipoMotore, String annoCostruzione, double prezzoBase, int meseEsposizione) {
        ID++;
        car_ID = ID;
        this.modello = modello;
        this.cilindrata = cilindrata;
        this.tipoMotore = tipoMotore;
        this.annoCostruzione = annoCostruzione;
        this.prezzoBase = prezzoBase;
        this.meseEsposizione = meseEsposizione;
        calcolaSconto(); // Calcola lo sconto in base alle caratteristiche dell'auto
        scontaIbride(); // Applica uno sconto aggiuntivo per le auto ibride
    }

    /**
     * Metodo astratto per calcolare lo sconto dell'auto.
     * Deve essere implementato dalle sottoclassi.
     */
    public abstract void calcolaSconto();

    /**
     * Restituisce l'ID univoco dell'auto.
     *
     * @return L'ID univoco dell'auto
     */
    public int getCar_ID() {
        return car_ID;
    }

    /**
     * Restituisce il mese di esposizione dell'auto.
     *
     * @return Il mese di esposizione dell'auto
     */
    public int getMeseEsposizione() {
        return meseEsposizione;
    }

    /**
     * Restituisce l'anno di costruzione dell'auto.
     *
     * @return L'anno di costruzione dell'auto
     */
    public String getAnnoCostruzione() {
        return annoCostruzione;
    }

    /**
     * Restituisce il prezzo base dell'auto.
     *
     * @return Il prezzo base dell'auto
     */
    public double getPrezzoBase() {
        return prezzoBase;
    }

    /**
     * Imposta il prezzo di vendita dell'auto.
     *
     * @param prezzoVendita Il prezzo di vendita dell'auto
     */
    public void setPrezzoVendita(double prezzoVendita) {
        this.prezzoVendita = prezzoVendita;
    }

    /**
     * Metodo privato per applicare uno sconto aggiuntivo alle auto ibride.
     */
    private void scontaIbride(){
        if(tipoMotore.equals(TipoMotore.IBRIDO))
            prezzoVendita -= 5000; // Sconto aggiuntivo di 5000 per le auto ibride
    }

    /**
     * Restituisce una rappresentazione testuale dell'auto.
     *
     * @return Una stringa rappresentante l'auto
     */
    @Override
    public String toString() {
        return "id=" + car_ID + "\n" +
                "tipologia=" + getClass().getSimpleName() + "\n" +
                "modello=" + modello + "\n" +
                "cilindrata=" + cilindrata + "\n" +
                "motore=" + tipoMotore + "\n" +
                "anno=" + annoCostruzione + "\n" +
                "prezzo base=" + prezzoBase + "\n" +
                "prezzo vendita=" + prezzoVendita + "\n" +
                "esposto=" + meseEsposizione;
    }
}
