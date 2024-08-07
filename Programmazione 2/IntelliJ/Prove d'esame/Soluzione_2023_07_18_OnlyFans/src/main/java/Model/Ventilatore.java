package Model;

import Controller.MainGUI;
import Model.Ventilatori.Soffitto;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

/**
 * Classe astratta che rappresenta un ventilatore.
 */
public abstract class Ventilatore extends Circle {
    private String marca;
    private int costo;
    private Alimentazione alimentazione;
    private MainGUI mg;

    /**
     * Costruttore per creare un ventilatore.
     *
     * @param marca La marca del ventilatore.
     * @param alimentazione Il tipo di alimentazione del ventilatore.
     * @param mg L'istanza di MainGUI.
     * @throws Exception Se l'alimentazione per il ventilatore a soffitto è meccanica.
     */
    public Ventilatore(String marca, Alimentazione alimentazione, MainGUI mg) throws Exception {
        super(25);
        this.mg = mg;
        setFill(Color.BLUE);
        setStroke(Color.BLACK);
        setStrokeWidth(4);
        costo = 10;
        this.marca = marca;
        if (this instanceof Soffitto) {
            if (alimentazione == Alimentazione.Meccanico)
                throw new Exception("L'alimentazione per ventilatore a soffitto non può essere meccanica");
        }
        this.alimentazione = alimentazione;
        calcolaCosto();
        impostaAzione();
    }

    /**
     * Imposta l'azione da eseguire quando il ventilatore viene cliccato.
     */
    private void impostaAzione() {
        setOnMouseClicked(event -> {
            // se non è già abbonato e se posso permettermelo
            if (!mg.getAbbonamenti().isPresente(this)) {
                setFill(Color.GREY);
                mg.getAbbonamenti().add(this);
                mg.getStatsPane().aggiornaSpesaMensile(costo);
            } else {
                rimuoviVentilatore();
            }
            mg.aggiornaCostosi();
        });
    }

    /**
     * Rimuove il ventilatore dalla lista degli abbonamenti.
     */
    public void rimuoviVentilatore() {
        setFill(Color.BLUE);
        mg.getAbbonamenti().remove(this);
        mg.getStatsPane().aggiornaSpesaMensile(-costo);
    }

    /**
     * Imposta il colore del contorno del ventilatore.
     *
     * @param color Il colore da impostare.
     */
    public void impostaStroke(Color color) {
        setStroke(color);
        setStrokeWidth(4);
    }

    /**
     * Metodo astratto per calcolare il costo del ventilatore.
     */
    public abstract void calcolaCosto();

    /**
     * Restituisce l'aumento del costo in base al tipo di alimentazione.
     *
     * @return L'aumento del costo.
     */
    public int getAumentoAlimentazione() {
        int ret = 0;
        if (alimentazione == Alimentazione.Batteria)
            ret = 3;
        else if (alimentazione == Alimentazione.Meccanico)
            ret = 1;
        else if (alimentazione == Alimentazione.Presa)
            ret = 2;
        return ret;
    }

    /**
     * Restituisce il costo del ventilatore.
     *
     * @return Il costo del ventilatore.
     */
    public int getCosto() {
        return costo;
    }

    /**
     * Imposta il costo del ventilatore.
     *
     * @param costo Il nuovo costo del ventilatore.
     */
    public void setCosto(int costo) {
        this.costo = costo;
    }

    /**
     * Restituisce una rappresentazione in stringa del ventilatore.
     *
     * @return Stringa che rappresenta il ventilatore.
     */
    @Override
    public String toString() {
        return  marca + "\n" +
                "Tipo: " + getClass().getSimpleName() + " Alimentazione: " + alimentazione.toString() + "\n" +
                "Costo: " + costo;
    }
}
